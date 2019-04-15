package pl.sda.db;

import java.sql.*;

public class jdbcMain2 {

    public static final String URL = "jdbc:mysql://localhost:3306/person?serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "41karol";
    public static final String SQL = "select*from zadanie where imie=?";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1,"Piotr");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String firstName =resultSet.getString("imie");
                String secondName = resultSet.getString("nazwisko");
                int age = resultSet.getInt("wiek");

                System.out.println("dane z bazy \n"+firstName+" "+ secondName+" "+age);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
