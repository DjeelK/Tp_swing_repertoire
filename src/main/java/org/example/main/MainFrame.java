package org.example.main;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel contentPane;
    private JTextField txtEmployeeID, txtName, txtAge, txtBloodGroup, txtContactNo;
    private JRadioButton radioMale, radioFemale;
    private JComboBox<String> comboQualification;
    private JCalendar calendarStartDate;
    private JTextArea txtAddress;
    private JButton btnUploadImage;
    private JLabel lblUploadedImage;
    private JTextField txtSearch;
    private JButton btnNew, btnSave, btnUpdate, btnDelete, btnClear, btnPrint;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setTitle("Main Frame");
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel topPanel = new JPanel(); // Contains employee details
        topPanel.setLayout(new BorderLayout());

// Left side with employee details
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // EmployeeID
        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(new JLabel("EmployeeID :"), gbc);
        txtEmployeeID = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        leftPanel.add(txtEmployeeID, gbc);

        // Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        leftPanel.add(new JLabel("Name :"), gbc);
        txtName = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        leftPanel.add(txtName, gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 2;
        leftPanel.add(new JLabel("Gender :"), gbc);
        radioMale = new JRadioButton("Male");
        radioFemale = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);
        JPanel genderPanel = new JPanel();
        genderPanel.add(radioMale);
        genderPanel.add(radioFemale);
        gbc.gridx = 1;
        gbc.gridy = 2;
        leftPanel.add(genderPanel, gbc);

        // Age
        gbc.gridx = 0;
        gbc.gridy = 3;
        leftPanel.add(new JLabel("Age :"), gbc);
        txtAge = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        leftPanel.add(txtAge, gbc);

        // BloodGroup
        gbc.gridx = 0;
        gbc.gridy = 4;
        leftPanel.add(new JLabel("BloodGroup :"), gbc);
        txtBloodGroup = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 4;
        leftPanel.add(txtBloodGroup, gbc);

        //ContactNo
        gbc.gridx = 0;
        gbc.gridy = 5;
        leftPanel.add(new JLabel("ContactNo :"), gbc);
        txtContactNo = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 5;
        leftPanel.add(txtContactNo, gbc);

        // Qualification
        gbc.gridx = 0;
        gbc.gridy = 6;
        leftPanel.add(new JLabel("Qualification :"), gbc);
        String[] qualifications = {"BTS", "BAC", "CAP", "MAST", "LICENCE", "DOCTORAT", "STAGIAIRE"};
        comboQualification = new JComboBox<>(qualifications);
        gbc.gridx = 1;
        gbc.gridy = 6;
        leftPanel.add(comboQualification, gbc);

        // Start date
        gbc.gridx = 0;
        gbc.gridy = 7;
        leftPanel.add(new JLabel("Start Date :"), gbc);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 7;
        leftPanel.add(dateChooser, gbc);
        JPanel uploadPanel = new JPanel();
        //Address
        gbc.gridx = 2;
        gbc.gridy = 0;
        leftPanel.add(new JLabel("Address :"), gbc);
        txtAddress = new JTextArea(5, 18);
        txtAddress.setBorder(BorderFactory.createEmptyBorder());
        gbc.gridx = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        leftPanel.add(new JScrollPane(txtAddress), gbc);
        gbc.gridheight = 1;

        //Image Upload Button
        btnUploadImage = new JButton("Upload Image");
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        leftPanel.add(btnUploadImage, gbc);
        gbc.gridwidth = 1;

        // Create a panel for uploaded image
        JPanel imagePanel = new JPanel();
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        imagePanel.setPreferredSize(new Dimension(200, 200));
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 4;
        leftPanel.add(imagePanel, gbc);
        gbc.gridwidth = 10;
        gbc.gridheight = 10;

        // Add leftPanel to topPanel
        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(uploadPanel, BorderLayout.CENTER);



        JPanel bottomPanel = new JPanel();


        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
    }
}
