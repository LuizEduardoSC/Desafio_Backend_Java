# Estágio de build: Compilar o projeto com Maven
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copia os arquivos do Maven e faz o download das dependências (cache)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Dá permissão de execução para o mvnw
RUN chmod +x mvnw

# Baixa as dependências do maven
RUN ./mvnw dependency:go-offline

# Copia o código fonte do projeto
COPY src src

# Compila o projeto pulando os testes para ser mais rápido no deploy
RUN ./mvnw package -DskipTests

# Estágio de execução: Rodar o projeto compilado
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia o arquivo .jar gerado no passo de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta que o Spring Boot vai rodar (padrão 8080)
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
