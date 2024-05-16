import java.sql.*;

public class CRUDExample {

    private static final String URL = "jdbc:mysql://localhost:3306/bancojava";
    private static final String USER = "root";
    private static final String PASSWORD = "root123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String createTableQuery = "CREATE TABLE IF NOT EXISTS exemplo (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255))";
            statement.executeUpdate(createTableQuery);

            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir novo registro");
            System.out.println("2. Ler todos os registros");
            System.out.println("3. Atualizar um registro");
            System.out.println("4. Deletar um registro");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: 
                    System.out.println("Digite o nome a ser inserido:");
                    String novoNome = scanner.next();
                    String insertQuery = "INSERT INTO exemplo (nome) VALUES (?)";
                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                    insertStatement.setString(1, novoNome);
                    insertStatement.executeUpdate();
                    System.out.println("Registro inserido com sucesso.");
                    break;
                case 2: 
                    String selectQuery = "SELECT * FROM exemplo";
                    ResultSet resultSet = statement.executeQuery(selectQuery);
                    System.out.println("Registros encontrados:");
                    while (resultSet.next()) {
                        System.out.println("ID: " + resultSet.getInt("id") + ", Nome: " + resultSet.getString("nome"));
                    }
                    break;
                case 3: 
                    System.out.println("Digite o ID do registro a ser atualizado:");
                    int idAtualizar = scanner.nextInt();
                    System.out.println("Digite o novo nome:");
                    String novoNomeAtualizado = scanner.next();
                    String updateQuery = "UPDATE exemplo SET nome = ? WHERE id = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setString(1, novoNomeAtualizado);
                    updateStatement.setInt(2, idAtualizar);
                    int rowsUpdated = updateStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Registro atualizado com sucesso.");
                    } else {
                        System.out.println("Nenhum registro atualizado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o ID do registro a ser deletado:");
                    int idDeletar = scanner.nextInt();
                    String deleteQuery = "DELETE FROM exemplo WHERE id = ?";
                    PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                    deleteStatement.setInt(1, idDeletar);
                    int rowsDeleted = deleteStatement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Registro deletado com sucesso.");
                    } else {
                        System.out.println("Nenhum registro deletado.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            statement.close();
            connection.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
