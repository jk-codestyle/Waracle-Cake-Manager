FROM maven:3.6.3-openjdk-11 AS builder
RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn clean install

FROM openjdk:11
RUN mkdir /app
WORKDIR /app
COPY --from=builder /app/target/backend.jar /app
EXPOSE 8071
ENTRYPOINT ["java", "-jar", "/app/backend.jar"]