FROM openjdk:16-jdk-alpine as cinema-backend-dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

FROM openjdk:16-jdk-alpine as cinema-backend-builder
COPY src ./src
COPY --from=cinema-backend-dependencies /root/.m2 /root/.m2
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw package -DskipTests

FROM openjdk:16-jdk-alpine as cinema-backend-runner
RUN apk add --no-cache --upgrade bash

WORKDIR /app
COPY ./wait-for-it.sh ./wait-for-it.sh
COPY --from=cinema-backend-builder target/*.jar ./app.jar
CMD [ "./wait-for-it.sh", "cinema-db:3306", "--timeout=30", "--", "java", "-jar", "app.jar" ]
