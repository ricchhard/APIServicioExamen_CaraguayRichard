# Usa la imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Define el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR del directorio target al contenedor
COPY target/examen-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8004 para el microservicio
EXPOSE 8004

# Define el comando de inicio para el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]
