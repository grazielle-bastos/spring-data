# Documentação do Projeto Spring Boot - API de Clubes e Atletas

## 1. Objetivo

Criar uma API REST para gerenciar clubes e atletas, usando Java, Spring Boot, JPA e MySQL.

---

## 2. Passos de Construção

### 2.1. Criação do Projeto

1. Acesse o [Spring Initializr](https://start.spring.io/) ou use o assistente da sua IDE.


2. Configure:
   - Project: Maven Project
   - Language: Java
   - Spring Boot: versão estável mais recente
   - Group: com.seuprojeto
   - Artifact: clubes-atletas
   - Name: clubes-atletas
   - Packaging: Jar
   - Java: 17+


3. Adicione as dependências:
   - Spring Web
   - Spring Data JPA
   - MySQL Driver


4. Clique em "Generate" para baixar o projeto ou finalize pela IDE.


5. Extraia e abra o projeto na sua IDE. para gerar um projeto com as dependências:
   - Spring Web
   - Spring Data JPA
   - MySQL Driver

### 2.2. Configuração do Banco de Dados


1. Crie um banco de dados no MySQL, por exemplo: clubesdb.

No arquivo `src/main/resources/application.properties`, configure a conexão com o MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seubanco
spring.datasource.username=${username}
spring.datasource.password=${password}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Use variáveis de ambiente para esconder usuário e senha.



### 2.3. Criação das Entidades

- Crie as classes `TimesEntities` e `AtletasEntities` no pacote `entities`.
- Anote com `@Entity` para o JPA mapear para tabelas do banco.

### 2.4. Criação dos Repositórios

- Crie interfaces que estendem `JpaRepository` para cada entidade:
    - `TimesRepository`
    - `AtletasRepository`

### 2.5. Criação dos DTOs

- Crie classes DTO para entrada e saída de dados:
    - `CadastroTimeDTO`, `CadastroAtletaDTO` (entrada)
    - `TimeResponseDTO`, `AtletaResponseDTO` (saída)

### 2.6. Criação do Service

- Crie a classe `ClubeService` com a anotação `@Service`.
- Implemente métodos para cadastrar e listar times/atletas.
- Use `@Transactional` nos métodos de escrita, que alteram dados.

### 2.7. Criação do Controller

- Crie um controller REST (`ClubeController`) com @RestController e implemente endpoints para:
    - Cadastrar time (POST /times)
    - Cadastrar atleta (POST /atletas)
    - Listar times (GET /times)
    - Listar atletas (GET /atletas)

### 2.8. Testes

1. Rode a aplicação (mvn spring-boot:run ou pelo botão da IDE).
2. Use Postman, Insomnia ou Swagger para testar os endpoints.

---

## 3. Conceitos Envolvidos

- **Spring Boot:** Framework para criar aplicações Java rapidamente.
- **JPA:** Abstração para persistência de dados em banco relacional.
- **DTO:** Objeto para transferir dados entre camadas.
- **Repository:** Interface para operações no banco.
- **Service:** Camada de regras de negócio.
- **Controller:** Camada que expõe a API REST.

---

## 4. Próximos Passos

- Implementar endpoints de atualização e remoção **Update** e **Delete** para completar o CRUD.
- Adicionar validações com @Valid e tratamento de erros.