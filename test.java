package proj;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class test {

    private JFrame frame;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JComboBox<Integer> ageCombo;

    private JRadioButton maleButton;
    private JRadioButton femaleButton;

    private JRadioButton freeButton;
    private JRadioButton premiumButton;

    private JTextArea messageArea;

    private JLabel lblTitle, lblFN, lblLN, lblUN, lblPW, lblSex, lblAge, lblSub;
    private JButton btnSignIn;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                test window = new test();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public test() {
        initialize();
    }

    private void initialize() {

        frame = new JFrame("Codiefy Sign In");
        frame.setSize(650, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        // Create components first
        createComponents();
        createEvents();

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(lblTitle)
                .addGroup(
                    layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblFN)
                            .addComponent(firstNameField)
                            .addComponent(lblUN)
                            .addComponent(usernameField)
                            .addComponent(lblSex)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(maleButton)
                                .addGap(10)
                                .addComponent(femaleButton))
                            .addComponent(lblSub)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(freeButton)
                                .addGap(10)
                                .addComponent(premiumButton))
                        )
                        .addGap(30)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblLN)
                            .addComponent(lastNameField)
                            .addComponent(lblPW)
                            .addComponent(passwordField)
                            .addComponent(lblAge)
                            .addComponent(ageCombo, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSignIn, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        )
                )
                .addComponent(scrollPane)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(lblTitle)
                .addGap(15)

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFN)
                    .addComponent(lblLN))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField)
                    .addComponent(lastNameField))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUN)
                    .addComponent(lblPW))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField)
                    .addComponent(passwordField))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSex)
                    .addComponent(lblAge))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(maleButton)
                    .addComponent(femaleButton)
                    .addComponent(ageCombo))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblSub)
                    .addComponent(btnSignIn))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(freeButton)
                    .addComponent(premiumButton))

                .addGap(15)
                .addComponent(scrollPane)
        );
    }

    private void createComponents() {

        lblTitle = new JLabel("Welcome to Codiefy!");
        lblTitle.setFont(lblTitle.getFont().deriveFont(18f));

        lblFN = new JLabel("First Name");
        lblLN = new JLabel("Last Name");
        lblUN = new JLabel("Username");
        lblPW = new JLabel("Password");
        lblSex = new JLabel("Sex");
        lblAge = new JLabel("Age");
        lblSub = new JLabel("Subscription");

        int fieldWidth = 230;
        int fieldHeight = 25;

        firstNameField = new JTextField();
        firstNameField.setPreferredSize(new java.awt.Dimension(fieldWidth, fieldHeight));

        lastNameField = new JTextField();
        lastNameField.setPreferredSize(new java.awt.Dimension(fieldWidth, fieldHeight));

        usernameField = new JTextField();
        usernameField.setPreferredSize(new java.awt.Dimension(fieldWidth, fieldHeight));

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new java.awt.Dimension(fieldWidth, fieldHeight));

        ageCombo = new JComboBox<>();
        for (int i = 13; i <= 60; i++) ageCombo.addItem(i);
        ageCombo.setPreferredSize(new java.awt.Dimension(80, 25));

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(maleButton);
        sexGroup.add(femaleButton);

        freeButton = new JRadioButton("Free");
        premiumButton = new JRadioButton("Premium");
        ButtonGroup subGroup = new ButtonGroup();
        subGroup.add(freeButton);
        subGroup.add(premiumButton);

        btnSignIn = new JButton("Sign In");

        messageArea = new JTextArea(5, 30);
        messageArea.setEditable(false);
        scrollPane = new JScrollPane(messageArea);
    }

    private void createEvents() {
        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String first = firstNameField.getText().trim();
                String last = lastNameField.getText().trim();
                String user = usernameField.getText().trim();
                String pass = new String(passwordField.getPassword());
                Integer age = (Integer) ageCombo.getSelectedItem();

                if (first.isEmpty() || last.isEmpty() || user.isEmpty() || pass.isEmpty() ||
                    (!maleButton.isSelected() && !femaleButton.isSelected()) ||
                    (!freeButton.isSelected() && !premiumButton.isSelected())) {

                    messageArea.setText("Please fill in all fields.");
                    return;
                }

                String sex = maleButton.isSelected() ? "Male" : "Female";
                String subscription = freeButton.isSelected() ? "Free" : "Premium";

                messageArea.setText(
                    "Welcome " + first + " " + last + "!\n" +
                    "Username: " + user + "\n" +
                    "Sex: " + sex + "\n" +
                    "Age: " + age + "\n" +
                    "Subscription: " + subscription
                );
            }
        });
    }
}
