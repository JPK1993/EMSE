import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EMSEStudie {
    private static List<String> questions = new ArrayList<>();
    private static List<List<String>> options = new ArrayList<>();
    private static List<Long> times = new ArrayList<>();
    private static int currentIndex = 0;
    private static JFrame frame;

    public static void main(String[] args) {
        // Add your questions and options to the respective lists
        questions.add("<html><font color='blue'><b>Which programming language is your favorite?</b></font></html>");
        List<String> options1 = new ArrayList<>();
        options1.add("Java");
        options1.add("Python");
        options1.add("C#");
        options.add(options1);

        questions.add("<html><font color='green'>What is your preferred IDE?</font></html>");
        List<String> options2 = new ArrayList<>();
        options2.add("Eclipse");
        options2.add("IntelliJ IDEA");
        options2.add("Visual Studio");
        options2.add("Other");
        options.add(options2);

        questions.add("<html><font color='red'><i>How often do you use version control?</i></font></html>");
        List<String> options3 = new ArrayList<>();
        options3.add("Frequently");
        options3.add("Sometimes");
        options3.add("Rarely");
        options3.add("Never");
        options.add(options3);

        // Create the GUI frame
        frame = new JFrame("Code Review Study");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1)); // Use GridLayout with 1 column

        // Create the question label
        JLabel questionLabel = new JLabel();
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center-align the text
        frame.getContentPane().add(questionLabel);

        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1)); // Use GridLayout with 1 column
        frame.getContentPane().add(buttonPanel);

        // Set frame properties and display it
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Display the first question
        displayNextQuestion(questionLabel, buttonPanel);
    }

    private static void displayNextQuestion(JLabel questionLabel, JPanel buttonPanel) {
        // Clear the button panel
        buttonPanel.removeAll();

        // Get the current question and options
        String question = questions.get(currentIndex);
        List<String> optionList = options.get(currentIndex);

        // Set the question label text
        questionLabel.setText(question);

        // Create the buttons based on the options
        for (String option : optionList) {
            JButton button = new JButton(option);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopTimer();
                    JButton sourceButton = (JButton) e.getSource();
                    recordTime();
                    JOptionPane.showMessageDialog(null, "You selected: " + sourceButton.getText());
                    currentIndex++;
                    if (currentIndex < questions.size()) {
                        displayNextQuestion(questionLabel, buttonPanel);
                    } else {
                        exportToCSV();
                        frame.dispose();
                    }
                }
            });
            buttonPanel.add(button);
        }

        // Repaint the frame to reflect the changes
        frame.revalidate();
        frame.repaint();
    }

    private static void recordTime() {
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        times.add(elapsedTime);
    }

    private static void exportToCSV() {
        String csvFile = "recorded_times.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (int i = 0; i < questions.size(); i++) {
                String question = questions.get(i);
                long time = times.get(i);
                writer.append(question).append(",").append(String.valueOf(time)).append("\n");
            }
            System.out.println("CSV file has been created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long startTime;

    private static void startTimer() {
        startTime = System.currentTimeMillis();
    }

    private static void stopTimer() {
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        JOptionPane.showMessageDialog(null, "Elapsed time: " + elapsedTime + " milliseconds");
    }
}
