# 基于官方的 Maven 镜像进行构建
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 使用轻量级的 JRE 镜像来运行 Spring Boot 应用
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/eureka-server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
