FROM gradle:8.10.1-jdk21 AS build

# Copiar os arquivos do projeto
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Verificar os arquivos no diretório
RUN ls -la

# Rodar o build usando Gradle
RUN gradle build --no-daemon

FROM openjdk:21-jdk-slim

# Expor a porta 8080
EXPOSE 8080

WORKDIR /app

# Copiar o JAR gerado no estágio de build
COPY --from=build /home/gradle/src/build/libs/*.jar /app/gs-spring-energy-java-api.jar

# Criar um usuário e grupo não-root para rodar a aplicação
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup
USER appuser

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "/app/gs-spring-energy-java-api.jar"]
