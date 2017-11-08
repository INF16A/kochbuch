FROM openjdk:8
COPY ./target/kochbuch.jar /usr/src/kochbuch/kochbuch.jar
WORKDIR /usr/src/kochbuch
EXPOSE 8080
CMD ["java", "-jar", "kochbuch.jar", "--mysql-host=db"]