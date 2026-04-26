package com.example.graphqlsample.common.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import jakarta.validation.ConstraintViolation;
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

        return null;
    }
}
