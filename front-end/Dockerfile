FROM maven:3.6.3-openjdk-11 AS builder
RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn clean install

FROM openjdk:11
RUN mkdir /app
WORKDIR /app
COPY --from=builder /app/target/frontend.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/frontend.jar"]

#FROM openjdk:11
#ADD target/front.jar front.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "front.jar"]