FROM openjdk:8
ADD target/springJar-8.jar springJar-8.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "springJar-8.jar"]
