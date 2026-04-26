package com.example.graphqlsample.common.exception;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import jakarta.validation.ConstraintViolationException;
import org.jspecify.annotations.NonNull;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GraphqlExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(@NonNull Throwable ex, @NonNull DataFetchingEnvironment env) {
        if (ex instanceof ConstraintViolationException exception) {
            String message = exception.getConstraintViolations().stream()
                    .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                    .distinct()
                    .collect(Collectors.joining(", "));

            return GraphqlErrorBuilder.newError(env)
                    .message(message)
                    .errorType(graphql.ErrorType.ValidationError)
                    .build();
        }

        if (ex instanceof NotFoundException exception) {
            return GraphqlErrorBuilder.newError(env)
                    .message(exception.getMessage())
                    .errorType(graphql.ErrorType.DataFetchingException)
                    .build();
        }

        if (ex instanceof StatusRuntimeException exception) {
            Status.Code code = exception.getStatus().getCode();
            String message = exception.getStatus().getDescription();

            if (code == Status.Code.INVALID_ARGUMENT) {
                return GraphqlErrorBuilder.newError(env)
                        .message(message == null ? "잘못된 요청입니다." : message)
                        .errorType(graphql.ErrorType.ValidationError)
                        .build();
            }

            if (code == Status.Code.NOT_FOUND) {
                return GraphqlErrorBuilder.newError(env)
                        .message(message == null ? "대상을 찾을 수 없습니다." : message)
                        .errorType(graphql.ErrorType.DataFetchingException)
                        .build();
            }
        }

        return null;
    }
}
