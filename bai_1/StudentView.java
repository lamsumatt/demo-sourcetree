package tuan_2.bai_1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class StudentView extends JFrame {
    private JTextField firstName;
    private JTextField lastName;
    private JTextField contact;
    private JTextArea address;
    private JTextField qualification;
    private JTextField special;
    private JTextField enroll;
    private JTextField hobby;
    private JTextField sport;
    private JButton btnSave;
    private JButton btnReset;
    private JButton btnExit;

    public StudentView() {
        setTitle("Student Registration");
        JLabel labelTieuDe = new JLabel("Student Registration");
        labelTieuDe.setBounds(10, 0, 150, 20);
        labelTieuDe.setHorizontalAlignment(JLabel.CENTER);
        add(labelTieuDe);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        add(mainPanel);

        // Personal Details Panel
        JPanel personalDetailsPanel = new JPanel();
        personalDetailsPanel.setLayout(new GridLayout(4, 2, 10, 5));
        personalDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Personal Details"));
        mainPanel.add(personalDetailsPanel);
        personalDetailsPanel.setBounds(20, 10, 380, 140);

        JLabel labelFirstName = new JLabel("First Name:");
        firstName = new JTextField();
        JLabel labelLastName = new JLabel("Last name:");
        lastName = new JTextField();
        JLabel labelContact = new JLabel("Contact:");
        contact = new JTextField();
        JLabel labelAdress = new JLabel("Address:");
        address = new JTextArea();
        JScrollPane addressScrollPane = new JScrollPane(address);

        personalDetailsPanel.add(labelFirstName);
        personalDetailsPanel.add(firstName);
        personalDetailsPanel.add(labelLastName);
        personalDetailsPanel.add(lastName);
        personalDetailsPanel.add(labelContact);
        personalDetailsPanel.add(contact);
        personalDetailsPanel.add(labelAdress);
        personalDetailsPanel.add(addressScrollPane);

        // Academic Details Panel
        JPanel academicDetailsPanel = new JPanel();
        academicDetailsPanel.setLayout(new GridLayout(3, 2, 10, 5));
        academicDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Academic Details"));
        mainPanel.add(academicDetailsPanel);
        academicDetailsPanel.setBounds(20, 160, 380, 110);

        JLabel labelQualify = new JLabel("Highest Qualification:");
        qualification = new JTextField();
        JLabel labelSpecial = new JLabel("Specialization:");
        special = new JTextField();
        JLabel labelEnroll = new JLabel("Enrolled For:");
        enroll = new JTextField();

        academicDetailsPanel.add(labelQualify);
        academicDetailsPanel.add(qualification);
        academicDetailsPanel.add(labelSpecial);
        academicDetailsPanel.add(special);
        academicDetailsPanel.add(labelEnroll);
        academicDetailsPanel.add(enroll);

        // Extracurricular Details Panel
        JPanel extracurricularDetailsPanel = new JPanel();
        extracurricularDetailsPanel.setLayout(new GridLayout(2, 2, 10, 5));
        extracurricularDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Extracurricular Details"));
        mainPanel.add(extracurricularDetailsPanel);
        extracurricularDetailsPanel.setBounds(20, 280, 380, 90);

        JLabel labelHobby = new JLabel("Hobbies:");
        hobby = new JTextField();
        JLabel labelSport = new JLabel("Sports:");
        sport = new JTextField();

        extracurricularDetailsPanel.add(labelHobby);
        extracurricularDetailsPanel.add(hobby);
        extracurricularDetailsPanel.add(labelSport);
        extracurricularDetailsPanel.add(sport);

        // Buttons
        btnSave = new JButton("Save");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");

        mainPanel.add(btnSave);
        mainPanel.add(btnReset);
        mainPanel.add(btnExit);

        btnSave.setBounds(40, 400, 80, 30);
        btnReset.setBounds(130, 400, 80, 30);
        btnExit.setBounds(220, 400, 80, 30);

        // Reset Button ActionListener
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                resetFields();
            }
        });

        // Exit Button ActionListener
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.exit(0);
            }
        });

        // Save Button ActionListener
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveStudent();
            }
        });

        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void resetFields() {
        firstName.setText("");
        lastName.setText("");
        contact.setText("");
        address.setText("");
        qualification.setText("");
        special.setText("");
        enroll.setText("");
        hobby.setText("");
        sport.setText("");
    }

    private void saveStudent() {
        // Retrieve data from text fields
        String fName = firstName.getText();
        String lName = lastName.getText();
        String cont = contact.getText();
        String addr = address.getText();
        String qual = qualification.getText();
        String spec = special.getText();
        String enrollFor = enroll.getText();
        String hobbies = hobby.getText();
        String sports = sport.getText();

        // Perform validation, for example, checking if required fields are filled
        if (fName.isEmpty() || lName.isEmpty() || cont.isEmpty() || addr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all personal details fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Here you can perform further processing like saving to a database or printing the details
        // For demonstration, let's just display the information in a dialog box
        String message = "Name: " + fName + " " + lName + "\nContact: " + cont + "\nAddress: " + addr +
                "\nQualification: " + qual + "\nSpecialization: " + spec + "\nEnrolled For: " + enrollFor +
                "\nHobbies: " + hobbies + "\nSports: " + sports;

        JOptionPane.showMessageDialog(this, message, "Student Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentView();
            }
        });
    }
}
