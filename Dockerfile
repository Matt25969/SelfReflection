FROM maven:latest as maven-build
WORKDIR /build
COPY . .
RUN mvn clean package
FROM java:8
WORKDIR /opt/website
COPY --from=maven-build /build/target/SelfReflection-0.1.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
