# Parceiros Backend

Esta é uma API REST desenvolvida em Java com Spring Boot para gerenciar o cadastro de parceiros de negócios e consultar dados de Cadastro Nacional de Pessoa Jurídica (CNPJ) diretamente na base da Receita Federal.

## 🚀 Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

- **Java 17** (com **Records** para transferência de dados imutável)
- **Spring Boot 3.5.4**
- **Maven** (Gerenciamento de dependências e build)
- **Spring Data JPA & Hibernate** (Mapeamento Objeto-Relacional e criação automática de tabelas)
- **MySQL** (Banco de Dados Relacional)
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
   - Salva o registro no banco de dados MySQL.

## 📋 Pré-requisitos

Para rodar o projeto localmente, você vai precisar de:

- **Java 17** (JDK) instalado na sua máquina
- **Git** para clonar o repositório
- Um banco de dados **MySQL** rodando localmente (ou em container Docker)
- Sua IDE favorita (IntelliJ IDEA, Eclipse, VS Code ou Spring Tool Suite)

## 🔧 Configuração e Instalação

### 1. Configure o Banco de Dados

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

*Se o seu usuário/senha do MySQL forem diferentes, lembre-se de alterar as propriedades `spring.datasource.username` e `spring.datasource.password` no arquivo `src/main/resources/application.properties` antes de rodar o projeto.*

### 2. Clone o Repositório

```bash
git clone <url-do-repositorio>
cd Desafio_Backend_Java-main
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
  "nome": "Empresa Parceira LTDA",
  "cnpj": "27865757000102",
  "email": "contato@empresa.com.br",
  "telefone": "11999999999"
  // Adicione os demais campos conforme esperado pela sua classe ParceiroDto
}
```

## ☁️ Deploy (Hospedagem na Nuvem)

O projeto já contém um arquivo `Dockerfile` na raiz, configurado com build *multi-stage* do Maven, o que o torna pronto para deploy em serviços baseados em Container (como **Render, Railway, Fly.io**).

**Para realizar o deploy no [Render.com](https://render.com/):**
1. Crie um novo **Web Service**.
2. Conecte o seu repositório do GitHub.
3. O Render detectará automaticamente o ambiente como **Docker**.
4. Crie uma instância de Banco de Dados MySQL na mesma plataforma (ou use um servidor externo).
5. Nos *Settings* do *Web Service*, na aba **Environment Variables**, adicione as seguintes variáveis de ambiente apontando para o seu banco de produção (Isso vai substituir automaticamente as credenciais locais descritas no *application.properties* quando seu app estiver na web):
   - `SPRING_DATASOURCE_URL` (Ex: `jdbc:mysql://nome-do-host..`)
   - `SPRING_DATASOURCE_USERNAME`
   - `SPRING_DATASOURCE_PASSWORD`

## ✒️ Autores

- **Luiz Eduardo** - [LinkedIn](https://www.linkedin.com/in/luiz-eduardosc/)
