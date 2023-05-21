import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class EMSEStudie {
    private static List<String> questions = new ArrayList<>();
    private static List<List<String>> options = new ArrayList<>();
    private static List<Double> times = new ArrayList<>();
    private static List<String> selectedAnswers = new ArrayList<>();
    private static int currentIndex = 0;
    private static JFrame frame;
    private static JLabel questionLabel;
    private static JLabel answerLabel;
    private static JButton nextButton;
    private static JPanel buttonPanel;
    private static JPanel resultPanel;

    public static void main(String[] args) {
        // Add your questions and options to the respective lists
        questions.add("<html><font color='blue'><b>Which programming language is your favorite?</b></font></html>");
        List<String> options1 = new ArrayList<>();
        options1.add("Java");
        options1.add("Python");
        options1.add("C");
        options.add(options1);

        questions.add("<html><font color='green'>What is your preferred IDE?</font></html>");
        List<String> options2 = new ArrayList<>();
        options2.add("Eclipse");
        options2.add("IntelliJ IDEA");
        options2.add("Visual Studio");
        options.add(options2);

        questions.add("<html><font color='red'><i>How often do you use version control?</i></font></html>");
        List<String> options3 = new ArrayList<>();
        options3.add("Frequently");
        options3.add("Sometimes");
        options3.add("Rarely");
        options3.add("Never");
        options.add(options3);

        // Create the GUI frame
        frame = new JFrame("EMSE Study");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1)); // Use GridLayout with 1 column

        // Create the question label
        questionLabel = new JLabel();
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center-align the text
        frame.getContentPane().add(questionLabel);

        // Create the result panel
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(0, 1)); // Use GridLayout with 1 column
        frame.getContentPane().add(resultPanel);

        // Create the button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1)); // Use GridLayout with 1 column
        frame.getContentPane().add(buttonPanel);

        // Create the next button
        nextButton = new JButton("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordTime();
                currentIndex++;
                if (currentIndex < questions.size()) {
                    displayNextQuestion();
                } else {
                    exportToCSV();
                    frame.dispose();
                }
            }
        });
        frame.getContentPane().add(nextButton);

        // Set frame properties and display it
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Display the first question
        displayNextQuestion();
    }

    private static void displayNextQuestion() {
        // Clear the result panel
        resultPanel.removeAll();

        // Clear the button panel
        buttonPanel.removeAll();

        // Get the current question and options
        String question = questions.get(currentIndex);
        List<String> optionList = options.get(currentIndex);

        // Set the question label text
        questionLabel.setText(question);
        
     // Assign the start time
        startTime = System.currentTimeMillis();

        // Create the buttons based on the options
        for (String option : optionList) {
            JButton button = new JButton(option);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton sourceButton = (JButton) e.getSource();
                    selectedAnswers.add(currentIndex, sourceButton.getText());
                    recordTime();
                    answerLabel = new JLabel(sourceButton.getText() + " (Time: " + formatTime(times.get(currentIndex)) + " sec)");
                    resultPanel.add(answerLabel);
                    nextButton.setEnabled(true);
                    frame.revalidate();
                    frame.repaint();
                    disableButtons();
                }
            });
            button.setFont(button.getFont().deriveFont(16f)); // Set the button font size to 16 pixels
            buttonPanel.add(button);
        }

        // Repaint the frame to reflect the changes
        frame.revalidate();
        frame.repaint();
    }

    private static void recordTime() {
        long endTime = System.currentTimeMillis();
        double elapsedTimeSeconds = (endTime - startTime) / 1000.0;
        times.add(elapsedTimeSeconds);
    }




    private static void exportToCSV() {
        String csvFile = "recorded_times.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (int i = 0; i < questions.size(); i++) {
                String question = questions.get(i);
                double time = times.get(i);
                String selectedAnswer = selectedAnswers.get(i);
                writer.append(question).append(",").append(String.valueOf(time)).append(",").append(selectedAnswer).append("\n");
            }
            System.out.println("CSV file has been created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long startTime;

  
    private static void disableButtons() {
        Component[] components = buttonPanel.getComponents();
        for (Component component : components) {
            component.setEnabled(false);
        }
    }

    private static String formatTime(double timeInSeconds) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(timeInSeconds);
    }

    


}
