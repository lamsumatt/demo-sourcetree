package tuan_2.bai_1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class StudentController {
    public static void saveStudentToFile(String fName, String lName, String cont, String addr, String qual, String spec, String enrollFor, String hobbies, String sports) {
        // Kiểm tra nếu có thông tin cần thiết
        if (fName.isEmpty() || lName.isEmpty() || cont.isEmpty() || addr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all personal details fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tạo đối tượng BufferedWriter để ghi vào tệp văn bản
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("student_info.txt", true))) {
            // Ghi thông tin sinh viên vào tệp
            writer.write("Name: " + fName + " " + lName + "\n");
            writer.write("Contact: " + cont + "\n");
            writer.write("Address: " + addr + "\n");
            writer.write("Qualification: " + qual + "\n");
            writer.write("Specialization: " + spec + "\n");
            writer.write("Enrolled For: " + enrollFor + "\n");
            writer.write("Hobbies: " + hobbies + "\n");
            writer.write("Sports: " + sports + "\n");
            writer.write("---------------------------------\n");
            JOptionPane.showMessageDialog(null, "Student information saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error occurred while saving student information.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
