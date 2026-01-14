package proj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class crud extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private JTextField nameField, emailField, lrnField, gradeField;
    private ArrayList<Student> students = new ArrayList<>();

    public crud() {
        setTitle("Student Record System - CRUD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLayout(new BorderLayout(10, 10));

        // ==== Form Panel ====
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        lrnField = new JTextField(20);
        gradeField = new JTextField(20);

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        // Row 0: Name
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Row 1: Email
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);

        // Row 2: LRN
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("LRN:"), gbc);
        gbc.gridx = 1;
        formPanel.add(lrnField, gbc);

        // Row 3: Grade/Section
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Grade/Section:"), gbc);
        gbc.gridx = 1;
        formPanel.add(gradeField, gbc);

        // Row 4: Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        // ==== Table ====
        model = new DefaultTableModel(new Object[]{"Name", "Email", "LRN", "Grade/Section"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // ==== Event Handlers ====
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String lrn = lrnField.getText().trim();
            String grade = gradeField.getText().trim();

            if (name.isEmpty() || email.isEmpty() || lrn.isEmpty() || grade.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            Student student = new Student(name, email, lrn, grade);
            students.add(student);
            model.addRow(new Object[]{name, email, lrn, grade});
            clearFields();
        });

        updateButton.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected == -1) {
                JOptionPane.showMessageDialog(this, "Select a record to update.");
                return;
            }

            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String lrn = lrnField.getText().trim();
            String grade = gradeField.getText().trim();

            if (name.isEmpty() || email.isEmpty() || lrn.isEmpty() || grade.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            Student student = new Student(name, email, lrn, grade);
            students.set(selected, student);
            model.setValueAt(name, selected, 0);
            model.setValueAt(email, selected, 1);
            model.setValueAt(lrn, selected, 2);
            model.setValueAt(grade, selected, 3);
            clearFields();
        });

        deleteButton.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected == -1) {
                JOptionPane.showMessageDialog(this, "Select a record to delete.");
                return;
            }

            students.remove(selected);
            model.removeRow(selected);
            clearFields();
        });

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selected = table.getSelectedRow();
                if (selected != -1) {
                    nameField.setText(model.getValueAt(selected, 0).toString());
                    emailField.setText(model.getValueAt(selected, 1).toString());
                    lrnField.setText(model.getValueAt(selected, 2).toString());
                    gradeField.setText(model.getValueAt(selected, 3).toString());
                }
            }
        });
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        lrnField.setText("");
        gradeField.setText("");
    }

    // Student class
    class Student {
        String name, email, lrn, grade;

        public Student(String name, String email, String lrn, String grade) {
            this.name = name;
            this.email = email;
            this.lrn = lrn;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new crud().setVisible(true));
    }
}
