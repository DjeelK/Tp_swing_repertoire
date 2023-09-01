package org.example.main;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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

        // Buttons
        ImageIcon originalIcon1 = new ImageIcon("C:\\Users\\Administrateur\\Documents\\M2i_EXO\\SWING\\tp_swing_card_agent\\src\\main\\java\\org\\example\\asset\\add.png");
        ImageIcon originalIcon2 = new ImageIcon("C:\\Users\\Administrateur\\Documents\\M2i_EXO\\SWING\\tp_swing_card_agent\\src\\main\\java\\org\\example\\asset\\save.png");
        ImageIcon originalIcon3 = new ImageIcon("C:\\Users\\Administrateur\\Documents\\M2i_EXO\\SWING\\tp_swing_card_agent\\src\\main\\java\\org\\example\\asset\\update.png");
        ImageIcon originalIcon4 = new ImageIcon("C:\\Users\\Administrateur\\Documents\\M2i_EXO\\SWING\\tp_swing_card_agent\\src\\main\\java\\org\\example\\asset\\delete1.png");
        ImageIcon originalIcon5 = new ImageIcon("C:\\Users\\Administrateur\\Documents\\M2i_EXO\\SWING\\tp_swing_card_agent\\src\\main\\java\\org\\example\\asset\\clear1.png");
        ImageIcon originalIcon6 = new ImageIcon("C:\\Users\\Administrateur\\Documents\\M2i_EXO\\SWING\\tp_swing_card_agent\\src\\main\\java\\org\\example\\asset\\printer.png");

        ImageIcon resizedIcon1= resizeIcon(originalIcon1, 25, 25);
        ImageIcon resizedIcon2 = resizeIcon(originalIcon2, 25, 25);
        ImageIcon resizedIcon3 = resizeIcon(originalIcon3, 25, 25);
        ImageIcon resizedIcon4 = resizeIcon(originalIcon4, 25, 25);
        ImageIcon resizedIcon5 = resizeIcon(originalIcon5, 25, 25);
        ImageIcon resizedIcon6 = resizeIcon(originalIcon6, 25, 25);

        btnNew = new JButton("New",resizedIcon1);
        btnSave = new JButton("Save",resizedIcon2);
        btnUpdate = new JButton("Update",resizedIcon3);
        btnDelete = new JButton("Delete",resizedIcon4);
        btnClear = new JButton("Clear",resizedIcon5);
        btnPrint = new JButton("Print",resizedIcon6);

        JPanel buttonPanel = new JPanel();
        gbc.gridx = 1;
        gbc.gridy = 8;
        leftPanel.add(buttonPanel, gbc);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(btnNew);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnPrint);

        gbc.gridx = 1;
        gbc.gridy = 8;
        leftPanel.add(buttonPanel,gbc);

        // Search field
        txtSearch = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 8;
        leftPanel.add(txtSearch, gbc);

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

        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(uploadPanel, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        // Middle panel for search and buttons
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcMiddle = new GridBagConstraints();
        gbcMiddle.insets = new Insets(10, 10, 10, 10);


        // Add middlePanel to topPanel
        topPanel.add(middlePanel, BorderLayout.CENTER);
        contentPane.add(topPanel, BorderLayout.NORTH);
    }

    private static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, width, height, null);
        g2.dispose();
        return new ImageIcon(resizedImg);
    }
}
