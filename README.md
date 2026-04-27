# graphql-sample

`graphql-sample`은 `user`, `post` 도메인을 제공하는 GraphQL BFF 서버입니다.

이미지 파일 자체는 이 프로젝트가 저장하지 않습니다. 프로필 이미지는 별도 `grpc-sample` 이미지 서버가 관리하고, 이 프로젝트는 `profileImageId`를 저장하거나 검증할 때만 gRPC로 이미지 서버를 호출합니다.

## 기술 스택

- Spring Boot
- Spring for GraphQL
- Spring Data JPA
- PostgreSQL
- gRPC Client

## 역할

- `user` CRUD
- `post` CRUD
- GraphQL 스키마 제공
- `profileImageId` 유효성 검증
- `deleteUser` 시 이미지 서버에 삭제 요청

## 프로젝트 구조

```text
src/main/java/com/example/graphqlsample
├── common
├── image
│   ├── config
│   ├── graphql
│   └── service
├── post
│   ├── domain
│   ├── graphql
│   ├── repository
│   └── service
└── user
    ├── domain
    ├── graphql
    ├── repository
    └── service
```

## 실행 전 준비

### 1. PostgreSQL 실행

이 프로젝트는 로컬 PostgreSQL `5433` 포트를 사용합니다.

```bash
docker compose up -d
```

기본 설정:

- DB: `demo`
- User: `root`
- Password: `root`

### 2. gRPC 이미지 서버 실행

`profileImageId` 검증과 이미지 삭제는 `grpc-sample` 서버를 호출합니다.

기본 gRPC 주소:

- `localhost:9090`

## 실행

기본 포트는 `8080`입니다.

```bash
./gradlew bootRun
```

`grpc-sample`도 HTTP `8080`을 사용할 수 있어서, 두 서버를 같이 띄울 때는 GraphQL 서버를 다른 포트로 실행하는 것을 권장합니다.

예시:

```bash
./gradlew bootRun --args='--server.port=8082'
```

## GraphQL 엔드포인트

- GraphQL: `POST /graphql`
- GraphiQL: `/graphiql`

예시:

```text
http://localhost:8082/graphql
```

## 주요 흐름

### 1. 유저 생성

1. 클라이언트가 이미지 서버에 파일 업로드
2. 이미지 서버가 `imageId` 반환
3. 클라이언트가 `createUser(profileImageId)` 호출
4. GraphQL 서버가 gRPC로 이미지 존재 여부 검증
5. 검증 성공 시 유저 저장

### 2. 유저 삭제

1. `deleteUser(id)` 호출
2. GraphQL 서버가 유저 조회
3. `profileImageId`가 있으면 gRPC로 이미지 삭제 요청
4. 유저의 게시글 삭제
5. 유저 삭제

## 스키마 개요

### Query

- `users`
- `user(id)`
- `posts`
- `post(id)`
- `imageMetadata(imageId)`

### Mutation

- `createUser`
- `updateUser`
- `deleteUser`
- `createPost`
- `updatePost`
- `deletePost`

## 테스트

```bash
./gradlew test
```

## 함께 사용하는 프로젝트

- 이미지 업로드/다운로드 및 메타데이터 서버: `grpc-sample`

