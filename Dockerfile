FROM eclipse-temurin:17-jdk-jammy
FROM maven:3.8.6


COPY .mvn/ .mvn/

ADD pom.xml /tmp/build/
RUN cd /tmp/build && mvn -q dependency:resolve
ADD src /tmp/build/src
# Створіть програму
RUN cd /tmp/build && mvn -q -DskipTests=true package \
# Копіювати результат компіляції у вказаний каталог
&& mv target/*.jar /app.jar \
# Очистити сліди компіляції
&& cd / && rm -rf /tmp/build
VOLUME /tmp
#VOLUME - ./log-directory:/var/lib/postgresql/data
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
#https://hub.docker.com/_/postgres
#prepare: docker run --detach --name my-postgres-server --env POSTGRES_PASSWORD=rere56re --publish 5432:5432 postgres:latest
#run: docker run -tp  8080:8080 springindocker
