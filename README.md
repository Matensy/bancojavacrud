# Meu Projeto CRUD em Java com MySQL

Este é um projeto simples que demonstra a implementação das operações CRUD (Create, Read, Update, Delete) em um banco de dados MySQL utilizando Java.

## Funcionalidades

- Inserir novos registros no banco de dados.
- Ler todos os registros existentes no banco de dados.
- Atualizar registros existentes no banco de dados.
- Excluir registros existentes no banco de dados.

## Tecnologias Utilizadas

- Java
- MySQL
- JDBC (Java Database Connectivity)

## Como Usar

1. Certifique-se de ter o MySQL instalado na sua máquina.
2. Clone este repositório.
3. Importe o projeto para a sua IDE Java preferida.
4. Certifique-se de que o driver JDBC do MySQL está no classpath do seu projeto.
5. Configure as informações de conexão com o banco de dados no arquivo `CRUDExample.java`.
6. Execute o programa `CRUDExample.java`.
7. Siga as instruções no terminal para interagir com o CRUD.

## Exemplo de Uso

```java
// Exemplo de inserção de um novo registro
String insertQuery = "INSERT INTO exemplo (nome) VALUES ('Novo Registro')";
statement.executeUpdate(insertQuery);

// Exemplo de leitura de todos os registros
String selectQuery = "SELECT * FROM exemplo";
ResultSet resultSet = statement.executeQuery(selectQuery);
while (resultSet.next()) {
    System.out.println("ID: " + resultSet.getInt("id") + ", Nome: " + resultSet.getString("nome"));
}
