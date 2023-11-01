FROM maven:3.8.5-openjdk-17 as builder
COPY JavaCourseWork/src /tmp/src
COPY JavaCourseWork/pom.xml /tmp/pom.xml
RUN cd /tmp && \
  mvn clean package

FROM openjdk:11.0.11-jre-slim
COPY --from=builder /tmp/target/course-work-1.0.jar /app/app.jar
CMD java -jar /app/app.jar