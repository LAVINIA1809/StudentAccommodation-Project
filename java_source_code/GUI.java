package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.text.Format;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JFrame mainFrame;
    private JPanel mainPanel, inputPanel;
    private JPanel applyPanel;
    private JPanel checkPanel;
    private JPanel adminPanel;
    private JLabel firstNameLabel, lastNameLabel, studentIDLabel, studentIDLabel1, genderLabel, averageGradeLabel,  emailLabel, phoneLabel, facultyLabel, dormLabel1, dormLabel2, dormLabel3, dormLabel4, dormLabel5, dormLabel6;
    private JLabel adminUsernameLabel, passwordLabel;
    private JLabel titleLabel;
    private JTextField firstNameField, lastNameField, studentIDField, studentIDField1, averageGradeField, emailField, phoneField;
    private JTextField adminUsernameField;
    private JPasswordField passwordField;
    private JComboBox<String> facultyBox, dormBox1, dormBox2, dormBox3, dormBox4, dormBox5, dormBox6, genderBox;
    private JButton submitButton;
    private JButton backButton;
    private String[] genders = {null, "Female", "Male"};
    private String[] faculties = {null, "Faculty of Biology",
            "Faculty of Chemistry",
            "Faculty of Computer Science",
            "Faculty of Economics and Business Administration",
            "Faculty of Geography and Geology",
            "Faculty of History",
            "Faculty of Law",
            "Faculty of Letters",
            "Faculty of Mathematics",
            "Faculty of Orthodox Theology",
            "Faculty of Philosophy and Social-Political Sciences",
            "Faculty of Physical Education and Sport",
            "Faculty of Physics",
            "Faculty of Psychology and Educational Sciences",
            "Faculty of Roman-Catholic Theology"};
    private String[] dorms = {null, "Akademos", "Gaudeaumus", "C1-C2-C3", "C6-C7-C8", "Bunavestire", "C11-C12-C13"};

    public GUI() {

        mainFrame = new JFrame("GUI");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        //mainPanel.setLayout(new CardLayout());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.pink);

        createApplyPanel();
        createCheckPanel();
        createAdminPanel();

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(createOptionsPanel(), BorderLayout.CENTER);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });

        mainPanel.add(createOptionsPanel(), BorderLayout.CENTER);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setSize(600, 700);
        mainFrame.setLocationRelativeTo(null);
    }

    private JPanel createOptionsPanel() {

        JPanel optionsPanel = new JPanel(new GridBagLayout());
        optionsPanel.setBackground(Color.PINK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 0, 10, 0);

        JButton applyButton = new JButton("Apply to a dorm");
        JButton checkButton = new JButton("Check assigned dorm");
        JButton adminButton = new JButton("Administrator");

        optionsPanel.add(applyButton, gbc);
        optionsPanel.add(checkButton, gbc);
        optionsPanel.add(adminButton, gbc);

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(applyPanel, BorderLayout.CENTER);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(checkPanel, BorderLayout.CENTER);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(adminPanel, BorderLayout.CENTER);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });

        return optionsPanel;
    }

    private void createApplyPanel() {

        applyPanel = new JPanel(new BorderLayout());
        applyPanel.setBackground(Color.PINK);
        applyPanel.setOpaque(true);

        JPanel formApplyPanel = new JPanel(new GridLayout(16, 2, 10, 10));
        formApplyPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 10, 20));

        formApplyPanel.setBackground(Color.PINK);
        formApplyPanel.setOpaque(true);

        titleLabel = new JLabel("Student registration");

        firstNameLabel = new JLabel("First Name");
        firstNameField = new JTextField();

        lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();

        studentIDLabel = new JLabel("Student ID:");
        studentIDField = new JTextField();

        averageGradeLabel = new JLabel("Average Grade:");
        averageGradeField = new JTextField();

        genderLabel = new JLabel("Gender:");
        genderBox = new JComboBox<>(genders);

        emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        phoneLabel = new JLabel("Phone Number:");
        phoneField = new JTextField();

        facultyLabel = new JLabel("Faculty:");
        facultyBox = new JComboBox<>(faculties);

        dormLabel1 = new JLabel("Preference 1:");
        dormBox1 = new JComboBox<>(dorms);

        dormLabel2 = new JLabel("Preference 2:");
        dormBox2 = new JComboBox<>(dorms);

        dormLabel3 = new JLabel("Preference 3:");
        dormBox3 = new JComboBox<>(dorms);

        dormLabel4 = new JLabel("Preference 4:");
        dormBox4 = new JComboBox<>(dorms);

        dormLabel5 = new JLabel("Preference 5:");
        dormBox5 = new JComboBox<>(dorms);

        dormLabel6 = new JLabel("Preference 6:");
        dormBox6 = new JComboBox<>(dorms);

        /*
        firstNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lastNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        studentIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        phoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        facultyLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        dormLabel1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        dormLabel2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        dormLabel3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        dormLabel4.setFont(new Font("Times New Roman", Font.BOLD, 15));
        dormLabel5.setFont(new Font("Times New Roman", Font.BOLD, 15));
        dormLabel6.setFont(new Font("Times New Roman", Font.BOLD, 15));
        */

        //formApplyPanel.add(titleLabel);

        formApplyPanel.add(firstNameLabel);
        formApplyPanel.add(firstNameField);
        formApplyPanel.add(lastNameLabel);
        formApplyPanel.add(lastNameField);
        formApplyPanel.add(studentIDLabel);
        formApplyPanel.add(studentIDField);
        formApplyPanel.add(averageGradeLabel);
        formApplyPanel.add(averageGradeField);
        formApplyPanel.add(genderLabel);
        formApplyPanel.add(genderBox);
        formApplyPanel.add(emailLabel);
        formApplyPanel.add(emailField);
        formApplyPanel.add(phoneLabel);
        formApplyPanel.add(phoneField);
        formApplyPanel.add(facultyLabel);
        formApplyPanel.add(facultyBox);
        formApplyPanel.add(dormLabel1);
        formApplyPanel.add(dormBox1);
        formApplyPanel.add(dormLabel2);
        formApplyPanel.add(dormBox2);
        formApplyPanel.add(dormLabel3);
        formApplyPanel.add(dormBox3);
        formApplyPanel.add(dormLabel4);
        formApplyPanel.add(dormBox4);
        formApplyPanel.add(dormLabel5);
        formApplyPanel.add(dormBox5);
        formApplyPanel.add(dormLabel6);
        formApplyPanel.add(dormBox6);

        JButton submitButton = new JButton("Apply");
//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
        /*
        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitPanel.add(submitButton);
        applyPanel.add(submitPanel);
        */

        submitButton.addActionListener(e -> {

            String successMessage = "Form successfully submitted";
            StringBuilder errorMessage = new StringBuilder();
            boolean isValidForm = true;

            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            if (!firstName.matches("^[a-zA-Z]+$") || !lastName.matches("^[a-zA-Z]+$")) {
                errorMessage.append("Invalid name format!\n");
                isValidForm = false;
            }

            String studentID = studentIDField.getText();
            if (!studentID.matches( "^N\\d{3}[A-Za-z]{2}\\d$")) {
                errorMessage.append("Invalid studentID format!\n");
                isValidForm = false;
            }

            double averageGrade = 0;
            String averageGradeText = averageGradeField.getText();
            try {
                averageGrade = Double.parseDouble(averageGradeText);
            } catch (NumberFormatException n) {
                errorMessage.append("Invalid average grade format! It should be a numeric value!\n");
                isValidForm = false;
            }

            String email = emailField.getText();
            if (!email.matches("^[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@gmail\\.com$")) {
                errorMessage.append("Invalid email format!\n");
                isValidForm = false;
            }

            String phone = phoneField.getText();

            if (!phone.matches("^07\\d{8}$")) {
                errorMessage.append("Invalid phone number!\n");
                isValidForm = false;
            }

            String faculty = (String) facultyBox.getSelectedItem();
            if(faculty == null)
            {
                errorMessage.append("Faculty must be selected!\n");
                isValidForm = false;
            }

            String gender = (String) genderBox.getSelectedItem();
            if(gender == null)
            {
                errorMessage.append("Gender must be selected!\n");
                isValidForm = false;
            }

            ArrayList<String> preferences = new ArrayList<>();
            String preference1 = (String) dormBox1.getSelectedItem();
            if(preference1 == null)
            {
                errorMessage.append("Preference 1 must be selected!\n");
                isValidForm = false;
            }
            else preferences.add(preference1);

            String preference2 = (String) dormBox2.getSelectedItem();
            if(preference2 == null)
            {
                errorMessage.append("Preference 2 must be selected!\n");
                isValidForm = false;
            }
            else preferences.add(preference2);

            String preference3 = (String) dormBox3.getSelectedItem();
            if(preference3 == null)
            {
                errorMessage.append("Preference 3 must be selected!\n");
                isValidForm = false;
            }
            else preferences.add(preference3);

            String preference4 = (String) dormBox4.getSelectedItem();
            if(preference4 == null)
            {
                errorMessage.append("Preference 4 must be selected!\n");
                isValidForm = false;
            }
            else preferences.add(preference4);

            String preference5 = (String) dormBox5.getSelectedItem();
            if(preference5 == null)
            {
                errorMessage.append("Preference 5 must be selected!\n");
                isValidForm = false;
            }
            else preferences.add(preference5);

            String preference6 = (String) dormBox6.getSelectedItem();
            if(preference6 == null)
            {
                errorMessage.append("Preference 6 must be selected!\n");
                isValidForm = false;
            }
            else preferences.add(preference6);

            if(preferences.size() == 6) {
                for (int i = 0; i < preferences.size() - 1; i++) {
                    String iPreference = preferences.get(i);
                    for (int j = i + 1; j < preferences.size(); j++) {
                        String jPreference = preferences.get(j);
                        if (iPreference.equals(jPreference)) {
                            errorMessage.append("Invalid preference option! Each preference should be different.");
                            isValidForm = false;
                        }
                    }
                }
            }


            if(isValidForm)
            {
                JOptionPane.showMessageDialog(GUI.this, successMessage);
                try {
                    StudentRegistration.registerStudent(studentID, faculty, firstName, lastName, averageGrade, email, phone, gender,
                            preference1, preference2, preference3, preference4, preference5, preference6);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else JOptionPane.showMessageDialog(GUI.this, errorMessage);
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(createOptionsPanel(), BorderLayout.CENTER);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });

        formApplyPanel.add(submitButton);
        applyPanel.add(formApplyPanel, BorderLayout.CENTER);
        applyPanel.add(backButton, BorderLayout.SOUTH);
    }

    private void createCheckPanel() {

        //Color c1 = new Color(137-207-240);

        checkPanel = new JPanel(new BorderLayout());
        checkPanel.setBackground(Color.PINK);
        //checkPanel.setBackground(c1);

        checkPanel.setOpaque(true);

        JPanel formCheckPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        formCheckPanel.setBorder(BorderFactory.createEmptyBorder(300, 70, 300, 70));

        formCheckPanel.setBackground(Color.PINK);
        //formCheckPanel.setBackground(c1);
        formCheckPanel.setOpaque(true);

        studentIDLabel1 = new JLabel("Student ID:");
        studentIDField1 = new JTextField();

        formCheckPanel.add(studentIDLabel1);
        formCheckPanel.add(studentIDField1);


        JButton submitButton = new JButton("Submit");
        //submitButton.setBounds(550, 600, submitButton.getPreferredSize().width, submitButton.getPreferredSize().height);

        /*
        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitPanel.add(submitButton);
        checkPanel.add(submitPanel);
        */

        formCheckPanel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = studentIDField1.getText();
                String message = null;
                try {
                    message = CheckAssignation.studentDormAssignation(studentId);
                    JOptionPane.showMessageDialog(GUI.this, message);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(createOptionsPanel(), BorderLayout.CENTER);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });

        checkPanel.add(formCheckPanel, BorderLayout.CENTER);
        checkPanel.add(backButton, BorderLayout.SOUTH);
    }

    private void createAdminPanel() {

        //Color c1 = new Color(137-207-240);
        adminPanel = new JPanel(new BorderLayout());
        adminPanel.setBackground(Color.PINK);
        //adminPanel.setBackground(c1);

        adminPanel.setOpaque(true);

        JPanel formAdminPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formAdminPanel.setBorder(BorderFactory.createEmptyBorder(250, 70, 250, 70));

        formAdminPanel.setBackground(Color.PINK);
        //formAdminPanel.setBackground(c1);
        formAdminPanel.setOpaque(true);

        adminUsernameLabel = new JLabel("Username:");
        adminUsernameField = new JTextField();

        formAdminPanel.add(adminUsernameLabel);
        formAdminPanel.add(adminUsernameField);

        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        formAdminPanel.add(passwordLabel);
        formAdminPanel.add(passwordField);

        JButton submitButton = new JButton("Submit");
        JButton assignButton = new JButton("Assign Students");
        assignButton.setVisible(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = adminUsernameField.getText();
                String password = passwordField.getText();
                if(password.equals("admin") && username.equals("admin"))  assignButton.setVisible(true);
            }
        });

        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String message = "Students assignation completed";
                    StudentRepartition.studentAssignation();
                    JOptionPane.showMessageDialog(GUI.this, message);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        /*
        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitPanel.add(submitButton);
        adminPanel.add(submitPanel);
        */

        formAdminPanel.add(submitButton);
        formAdminPanel.add(assignButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(createOptionsPanel(), BorderLayout.CENTER);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });

        adminPanel.add(formAdminPanel, BorderLayout.CENTER);
        adminPanel.add(backButton, BorderLayout.SOUTH);
    }


    private void setComponentBackground(Component component, Color color) {
        component.setBackground(color);
        if (component instanceof Container) {
            Component[] components = ((Container) component).getComponents();
            for (Component child : components) {
                setComponentBackground(child, color);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}
