# Parceiros Backend

Esta é uma API REST desenvolvida em Java com Spring Boot para gerenciar o cadastro de parceiros de negócios e consultar dados de Cadastro Nacional de Pessoa Jurídica (CNPJ) diretamente na base da Receita Federal.

## 🚀 Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

- **Java 21** (com **Records** para transferência de dados imutável)
- **Spring Boot 3.5.4**
- **Maven** (Gerenciamento de dependências e build)
- **Spring Data JPA & Hibernate** (Mapeamento Objeto-Relacional e criação automática de tabelas)
- **MySQL** (Banco de Dados para Desenvolvimento Local)
- **PostgreSQL** (Banco de Dados para Produção/Render)
- **Spring Boot Starter Validation** (Validação de dados Jakarta)
- **Integração com API Externa** (via `java.net.http.HttpClient` para a ReceitaWS)
- **Docker** (Configurado para deploy conteinerizado)

## ⚙️ Funcionalidades

A API possui dois recursos principais:

1. **Consulta de CNPJ** (`GET /api/cnpj/{cnpj}`)
   - Consulta informações de uma empresa na API pública da Receita Federal (ReceitaWS).
   - Retorna os dados da empresa (Razão Social, Nome Fantasia, Endereço, Situação, etc) em formato JSON.

2. **Cadastro de Parceiros** (`POST /api/parceiros`)
   - Recebe os dados de um parceiro para cadastro.
   - Valida as regras de negócio e a integridade dos campos enviados.
   - Salva o registro no banco de dados (MySQL local ou PostgreSQL em nuvem).

## 📋 Pré-requisitos

Para rodar o projeto localmente, você vai precisar de:

- **Java 21+** (JDK) instalado na sua máquina
- **Git** para clonar o repositório
- Um banco de dados **MySQL** rodando localmente (ou em container Docker)
- Sua IDE favorita (IntelliJ IDEA, Eclipse, VS Code ou Spring Tool Suite)

## 🔧 Configuração e Instalação

### 1. Configure o Banco de Dados Local (MySQL)

Crie um banco de dados no seu servidor MySQL local chamado `db_parceiros`. 
Você pode usar o seguinte comando SQL:

```sql
CREATE DATABASE db_parceiros;
```

As configurações padrão do banco de dados na aplicação (`application.properties`) assumem as seguintes credenciais locais:
- **Host**: localhost
- **Porta**: 3306
- **Usuário**: root
- **Senha**: root

A aplicação utiliza variáveis de ambiente com valores padrão, permitindo que você altere as credenciais sem modificar o código-fonte.

### 2. Clone o Repositório

```bash
git clone https://github.com/LuizEduardoSC/Desafio_Backend_Java.git
cd Desafio_Backend_Java
```

### 3. Compile e Baixe as Dependências

Na raiz do projeto (onde o arquivo `pom.xml` está localizado), rode o comando Maven:

```bash
./mvnw clean install
```
*(No Windows, use `mvnw.cmd clean install`)*

### 4. Execute a Aplicação

Para iniciar o servidor, rode o seguinte comando:

```bash
./mvnw spring-boot:run
```
*(No Windows, use `mvnw.cmd spring-boot:run`)*

A aplicação irá iniciar na porta padrão `8080`.

## 📌 Exemplos de Uso (Endpoints)

### Consultar um CNPJ
**Requisição:**
```http
GET http://localhost:8080/api/cnpj/27865757000102
```

### Cadastrar um Parceiro
**Requisição:**
```http
POST http://localhost:8080/api/parceiros
Content-Type: application/json

{
  "nome_fantasia": "Empresa Parceira LTDA",
  "razao_social": "EMPRESA PARCEIRA SERVICOS LTDA",
  "cpf_cnpj": "27865757000102",
  "email": "contato@empresa.com.br",
  "telefone": "11999999999",
  "celular": "11988888888",
  "cep": "01001000",
  "logradouro": "Praça da Sé",
  "numero": "100",
  "bairro": "Sé",
  "municipio": "São Paulo",
  "uf": "SP",
  "personalidade": "JURIDICA",
  "categoria": "SERVICOS",
  "segmento": "TECNOLOGIA",
  "tipo_parceiro": "FORNECEDOR"
}
```

## ☁️ Deploy e API em Produção

A aplicação está hospedada no [Render.com](https://render.com/) utilizando Docker e um banco de dados PostgreSQL.

### 🔗 API Live
Você pode testar a aplicação rodando na nuvem através do link:
👉 [https://parceiros-backend-api.onrender.com/api/cnpj/27865757000102](https://parceiros-backend-api.onrender.com/api/cnpj/27865757000102)

### Configuração de Deploy (Render)
Para replicar o deploy, configure as seguintes **Environment Variables** no seu Web Service:
- `SPRING_DATASOURCE_URL`: `jdbc:postgresql://HOST_DO_BANCO:5432/db_parceiros`
- `SPRING_DATASOURCE_USERNAME`: Seu usuário do Postgres
- `SPRING_DATASOURCE_PASSWORD`: Sua senha do Postgres

## ✒️ Autores

- **Luiz Eduardo** - [LinkedIn](https://www.linkedin.com/in/luiz-eduardosc/)
