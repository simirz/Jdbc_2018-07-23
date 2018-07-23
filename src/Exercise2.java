import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2 {
    //SELECT * FROM students WHERE

    public static void main(String[] args) {
        Connection connection = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite studento id: ");
        String id = sc.nextLine();
        System.out.println("Iveskite studento vardą: ");
        String name = sc.nextLine();
        System.out.println("Iveskite studento pavarde: ");
        String surname = sc.nextLine();
        System.out.println("Iveskite studento telefono numeri: ");
        String phone = sc.nextLine();
        System.out.println("Iveskite studento email: ");
        String email = sc.nextLine();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kcs", "root", "");
        } catch (SQLException e) {
            System.out.println("Ivyko klaida " + e);
        }
        if (connection != null) {
            System.out.println("Prisijungeme!");
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE students SET Name = '"+name+"', surname= '"+surname+"', " +
                                "phone=  '"+phone+"', email=  '"+email+"' where id = " + id);

            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }
}


