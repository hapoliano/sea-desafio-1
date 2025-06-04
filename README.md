Desafio Backend

## 📋 Descrição

Este projeto é parte do processo seletivo, com foco na implementação de uma API Backend para gerenciamento de clientes, obedecendo regras específicas de validação, autenticação e persistência de dados.

---

### Backend (Serviço)
- Java 8+
- Spring Boot
- Spring Data JPA
- Springdoc OpenAPI
- Hibernate
- Maven
- JWT
- Swagger

## 📑 Documentação da API

Este projeto utiliza **Springdoc OpenAPI** para gerar automaticamente a documentação da API utilizando a interface do **Swagger**.

### ▶️ Acesso à documentação

Após executar o projeto, a documentação estará disponível no seguinte endereço:

- **Swagger UI:**  
  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## 🗄️ Banco de Dados

O projeto deverá utilizar **PostgreSQL** (ou outro relacional, conforme sua escolha), com persistência gerenciada via **JPA/Hibernate**.

Recomenda-se a seguinte configuração padrão no `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sea_desafio
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
