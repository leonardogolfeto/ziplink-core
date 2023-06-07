# Define a imagem base do Docker
FROM openjdk:17-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR da aplicação para o diretório de trabalho
COPY target/core-0.0.1-SNAPSHOT.jar /app

# Define a porta em que a aplicação será executada
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "core-0.0.1-SNAPSHOT.jar"]