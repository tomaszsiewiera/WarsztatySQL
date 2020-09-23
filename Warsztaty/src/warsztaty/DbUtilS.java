package warsztaty;

import java.sql.*;

public class DbUtilS {
    final String driver = "com.mysql.cj.jdbc.Driver";
    final String dbPath = "jdbc:mysql://localhost:3306/workshop2?serverTimezone=UTC&useSSL=false";
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public void DBConnection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(dbPath, "root", "coderslab");
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean dodajUzytkownika(String username, String email, String password) {
        String qery = "INSERT INTO users VALUES(null, ?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(qery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            System.out.println("Brak połączenia");
            return false;
        }
        return true;
    }

    public void closeConnection() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void listaUzytkowników() {
        StringBuilder stringBuilder = new StringBuilder();
        String qery = "SELECT * FROM users";
        try {
            ResultSet resultSet = statement.executeQuery(qery);
            int id;
            String username, email, password;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                username = resultSet.getString("username");
                email = resultSet.getString("email");
                password = resultSet.getString("password");
                stringBuilder.append(new UseR(id, username, email, password));
                stringBuilder.append("\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
    }

    public void znajdzUzytkownika(String id) {
        StringBuilder stringBuilder = new StringBuilder();
        String qery = "SELECT * FROM users WHERE id= " + id + "";
        try {
            ResultSet resultSet = statement.executeQuery(qery);
            int id_user;
            String username, email, password;
            while (resultSet.next()) {
                id_user = resultSet.getInt("id");
                username = resultSet.getString("username");
                email = resultSet.getString("email");
                password = resultSet.getString("password");
                stringBuilder.append(new UseR(id_user, username, email, password));
                stringBuilder.append("\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
    }

    public void usunUzytkownika(String id) {
        String qery = "DELETE FROM users WHERE id = " + id + " ";
        try {
            preparedStatement = connection.prepareStatement(qery);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("Nie udłaop się usunąć");
        }

    }

    public void aktualizacja(String id, String username, String email, String password) {
        String qery = "UPDATE users SET username= '" + username + "',email='" + email + "', password= '" + password + "' WHERE id = " + id + "";
        try {
            preparedStatement = connection.prepareStatement(qery);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("Nie udłaop się usunąć");
        }
    }
}