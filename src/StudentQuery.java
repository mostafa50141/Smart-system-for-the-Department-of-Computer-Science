import java.sql.*;

public class StudentQuery {
    public static void getAllStudents() {

        String query = "SELECT student_id, name, birth_date, national_id, email, department_id, year FROM Students";

        try (Connection conn = CONNECTION.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String nationalId = rs.getString("national_id");
                String email = rs.getString("email");
                int departmentId = rs.getInt("department_id");
                int year = rs.getInt("year");


                System.out.println("Student ID: " + studentId);
                System.out.println("Name: " + name);
                System.out.println("Birth Date: " + birthDate);
                System.out.println("National ID: " + nationalId);
                System.out.println("Email: " + email);
                System.out.println("Department ID: " + departmentId);
                System.out.println("Year: " + year);
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        getAllStudents();
    }
}

