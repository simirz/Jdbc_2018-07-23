import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs", "root", "");
        } catch (SQLException e) {
            System.out.println("Ivyko klaida " + e);
        }
        if (connection != null) {
            System.out.println("Prisijungeme!");
            System.out.println("Iveskite studento Id:"); //ties cia meta klaida bligai ivedus, todel:
            int id = 0;
            try {
                id = scanner.nextInt();
                try {
                    //statement reikalingas, kad butu galima ivykdyti uzklausa mysql serveryje
                    Statement st = connection.createStatement();

                    ResultSet resultSet = st.executeQuery("SELECT * from Students WHERE id =" + id);

                    resultSet.next();
                    System.out.println(resultSet.getString("name") + " " + resultSet.getString("surname")
                            + " " + resultSet.getString("phone") + " " + resultSet.getString("email"));

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (InputMismatchException e) {
                System.out.println("blogai");
            }
        }

    }
}