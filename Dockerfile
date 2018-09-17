FROM java:8
ADD /springJar-8.jar //
ENTRYPOINT ["java", "-jar", "/springJar-8.jar"]
