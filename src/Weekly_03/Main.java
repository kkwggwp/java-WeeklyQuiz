package Weekly_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/test_db?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password ="0000";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB에 성공적으로 연결됨");

            String sql = "SELECT * FROM students WHERE age BETWEEN 30 AND 39";
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            System.out.println("+--------------------+-----+------------------------------+");
            System.out.println("| Name               | Age | Address                       ");
            System.out.println("+--------------------+-----+------------------------------+");

            while (resultSet.next()) {
                String column1 = resultSet.getString("name");
                int column2 = resultSet.getInt("age");
                String column3 = resultSet.getString("address");
                System.out.printf("| %-16s | %-3d | %-26s \n", column1, column2, column3);
            }
            System.out.println("+--------------------+-----+------------------------------+");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
                System.out.println("정상적으로 닫힘");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
