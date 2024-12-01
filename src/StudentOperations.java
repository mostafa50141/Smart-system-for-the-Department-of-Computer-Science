import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class StudentOperations {


    public void addStudent(int studentId, String name, Date birthDate, String nationalId, String email, int departmentId, int year) {

        String query = "INSERT INTO Students (student_id, name, birth_date, national_id, email, department_id, year) " + "VALUES (51,'Mostafa Abdelaziz' , '2004-4-22' ,3040422301619,'ma6324@fayoum.edu.eg',1,3)";

        try (Connection connection = CONNECTION.getConnection()) {
            assert connection != null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, 51);
                preparedStatement.setString(2, "Mostafa Abdelaziz");
                preparedStatement.setDate(3, Date.valueOf("2004-04-22"));
                preparedStatement.setString(4, "3040422301619");
                preparedStatement.setString(5, "ma6324@fayoum.edu.eg");
                preparedStatement.setInt(6, 1);
                preparedStatement.setInt(7, 3);


                int rowsAffected = preparedStatement.executeUpdate();


                System.out.println(rowsAffected + " row(s) inserted.");

            }
        } catch (SQLException e) {
            System.out.println("Error inserting student: " + e.getMessage());
        }
    }
}

