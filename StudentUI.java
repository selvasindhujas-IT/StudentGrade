package StudentGrade;




import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentUI extends JFrame {

    JTextField nameField;
    JTextField mark1Field;
    JTextField mark2Field;
    JTextField mark3Field;
    JTextField mark4Field;
    JTextField mark5Field;

    JTextArea outputArea;

    JButton addButton;
    JButton clearButton;

    public StudentUI() {

        setTitle("Student Grade Manager");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Student Grade Manager", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Mark 1:"));
        mark1Field = new JTextField();
        panel.add(mark1Field);

        panel.add(new JLabel("Mark 2:"));
        mark2Field = new JTextField();
        panel.add(mark2Field);

        panel.add(new JLabel("Mark 3:"));
        mark3Field = new JTextField();
        panel.add(mark3Field);

        panel.add(new JLabel("Mark 4:"));
        mark4Field = new JTextField();
        panel.add(mark4Field);

        panel.add(new JLabel("Mark 5:"));
        mark5Field = new JTextField();
        panel.add(mark5Field);

        addButton = new JButton("Add Student");
        clearButton = new JButton("Clear");

        panel.add(addButton);
        panel.add(clearButton);

        add(panel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Student Details"));

        add(scrollPane, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String name = nameField.getText();

                    int m1 = Integer.parseInt(mark1Field.getText());
                    int m2 = Integer.parseInt(mark2Field.getText());
                    int m3 = Integer.parseInt(mark3Field.getText());
                    int m4 = Integer.parseInt(mark4Field.getText());
                    int m5 = Integer.parseInt(mark5Field.getText());

                    int total = m1 + m2 + m3 + m4 + m5;
                    double average = total / 5.0;

                    outputArea.append("Student Name : " + name + "\n");
                    outputArea.append("Marks : " + m1 + ", " + m2 + ", " + m3 + ", " + m4 + ", " + m5 + "\n");
                    outputArea.append("Total : " + total + "\n");
                    outputArea.append("Average : " + average + "\n");
                    outputArea.append("-----------------------------------\n");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Numbers");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nameField.setText("");
                mark1Field.setText("");
                mark2Field.setText("");
                mark3Field.setText("");
                mark4Field.setText("");
                mark5Field.setText("");
            }
        });
    }

    public static void main(String[] args) {

        StudentUI ui = new StudentUI();
        ui.setVisible(true);
    }
}



