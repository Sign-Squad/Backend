# Fase de construcción
FROM ubuntu:latest as build
RUN apt-get update
RUN apt-get install openjdk-21-jdk maven -y

# Copiar los archivos del proyecto al contenedor
COPY . .

# Compilar el proyecto
RUN ./mvnw clean package -DskipTests

# Fase de ejecución
FROM openjdk:21-jdk-slim
EXPOSE 8080

# Copiar el archivo JAR generado en la fase de construcción
COPY --from=build /target/SignLingo_Backend-0.0.1-SNAPSHOT.jar app.jar

# Comando de entrada para ejecutar el archivo JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
