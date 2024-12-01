import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class StudentManagementGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Management");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField(20);
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        JLabel birthDateLabel = new JLabel("Birth Date (YYYY-MM-DD):");
        JTextField birthDateField = new JTextField(20);
        JLabel nationalIdLabel = new JLabel("National ID:");
        JTextField nationalIdField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JLabel departmentIdLabel = new JLabel("Department ID:");
        JTextField departmentIdField = new JTextField(20);
        JLabel yearLabel = new JLabel("Year:");
        JTextField yearField = new JTextField(20);
        JButton addButton = new JButton("Add Student");

        // إضافة المكونات إلى لوحة
        JPanel panel = new JPanel();
        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(nationalIdLabel);
        panel.add(nationalIdField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(departmentIdLabel);
        panel.add(departmentIdField);
        panel.add(yearLabel);
        panel.add(yearField);
        panel.add(addButton);


        frame.add(panel);
        frame.setVisible(true);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int studentId = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    Date birthDate = Date.valueOf(birthDateField.getText());
                    String nationalId = nationalIdField.getText();
                    String email = emailField.getText();
                    int departmentId = Integer.parseInt(departmentIdField.getText());
                    int year = Integer.parseInt(yearField.getText());


                    StudentOperations operations = new StudentOperations();
                    operations.addStudent(studentId, name, birthDate, nationalId, email, departmentId, year);


                    JOptionPane.showMessageDialog(frame, "Student added successfully!");
                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
