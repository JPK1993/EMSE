import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EMSEStudieInput {
    private static List<String> questions = new ArrayList<>();
    private static List<String> answers = new ArrayList<>();
    private static List<Double> times = new ArrayList<>();
    private static int currentIndex = 0;
    private static JFrame mainFrame;
    private static JFrame questionFrame;
    private static JTextArea questionTextArea; // Modified: Declare as instance variable
    private static JPanel resultPanel;
    private static JButton startButton;
    private static JButton nextButton;
    private static long startTime;
    private static boolean inputRecorded = false;

    public static void main(String[] args) {
        // Fragen und Antworten zur Liste hinzufügen
        questions.add("Frage 1");
        answers.add("5");

        questions.add("Frage 2");
        answers.add("7");

        questions.add("Frage 3");
        answers.add("3");

        // Hauptframe erstellen
        mainFrame = new JFrame("EMSE Studie");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // Textbereich für Anweisungen
        JTextArea instructionsArea = new JTextArea();
        instructionsArea.setEditable(false);
        instructionsArea.setText("Die Studie zum Thema Syntax-Highlighting beginnt in Kürze."
                + "\n \n Es werden Ihnen zufällige Code-Bruchstücke mit oder ohne Syntax-Highlighting gezeigt."
                + "\n \n Bitte zählen Sie (FEHLT NOCH) und geben Sie Ihre Antwort durch das Drücken einer Zahl zwischen 0 und 9 ein."
                + "\n \n Sobald eine Zahl gedrückt wurde, wird die Zeit gestoppt und der Weiter-Button aktiviert, mit dem Sie per Mausklick zur nächsten Frage springen können."
                + "\n \n Es werden nur korrekte Antworten gewertet, um die durchschnittliche, benötigte Zeit zum richtigen Beantworten der Fragen auszuwerten."
                + "\n \n Um zu beginnen, klicken Sie bitte auf 'Start'.");
        instructionsArea.setLineWrap(true);
        instructionsArea.setFont(new Font("Arial", Font.PLAIN, 20)); // Schriftgröße für Instruction-Area 
        instructionsArea.setWrapStyleWord(true);
        mainFrame.add(instructionsArea, BorderLayout.CENTER);

        // Start-Button
        startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setPreferredSize(new Dimension(200, 100)); // Set the size of the start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                openQuestionFrame();
            }
        });
        mainFrame.add(startButton, BorderLayout.SOUTH);

        // Hauptframe anzeigen
        mainFrame.setSize(1000, 1000);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private static void openQuestionFrame() {
        // Frage-Frame erstellen
        questionFrame = new JFrame("EMSE Studie - Frage");
        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionFrame.setLayout(new GridLayout(0, 1));

        // Label für Frage erstellen
        questionTextArea = new JTextArea(); // Modified: Assign to instance variable
        questionTextArea.setEditable(false);
        questionTextArea.setLineWrap(true);
        questionTextArea.setWrapStyleWord(true);
        questionTextArea.setFont(new Font("Arial", Font.BOLD, 20)); // Schriftgröße für Fragen
        questionFrame.getContentPane().add(questionTextArea);

        // Antwort-Textfeld
        JTextField answerTextField = new JTextField();
        answerTextField.setHorizontalAlignment(SwingConstants.CENTER);
        answerTextField.setFont(new Font("Arial", Font.BOLD, 20));
        answerTextField.setPreferredSize(new Dimension(200, 100)); // Set the size of the answer input field
        answerTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char inputChar = e.getKeyChar();
                if (Character.isDigit(inputChar) && !inputRecorded) {
                    String answer = String.valueOf(inputChar);
                    stopTimerAndProceed(answer);
                    inputRecorded = true;
                }
            }
        });
        questionFrame.getContentPane().add(answerTextField);

        // Weiter-Button
        nextButton = new JButton("Weiter");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
        nextButton.setPreferredSize(new Dimension(200, 100)); // Set the size of the next button
        nextButton.setEnabled(false);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex++;
                if (currentIndex < questions.size()) {
                    displayNextQuestion();
                } else {
                    exportToCSV();
                    questionFrame.dispose();
                }
            }
        });
        questionFrame.getContentPane().add(nextButton);

        // Ergebnis Anordnung
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(0, 1));
        questionFrame.getContentPane().add(resultPanel);

        // Frage-Frame anzeigen
        questionFrame.setSize(1000, 1000);
        questionFrame.setLocationRelativeTo(null);
        questionFrame.setVisible(true);

        // Erste Frage anzeigen
        displayNextQuestion();
    }

    private static void displayNextQuestion() {
        inputRecorded = false; // Reset input flag
        // Ergebnis löschen
        if (resultPanel != null) {
            resultPanel.removeAll();
        }

        // Frage anzeigen
        String question = questions.get(currentIndex);
        questionTextArea.setText(question); // Modified: Use questionTextArea

        // Antwort-Textfeld aktivieren
        JTextField answerTextField = (JTextField) questionFrame.getContentPane().getComponent(1);
        answerTextField.setEnabled(true);
        answerTextField.requestFocus();
        answerTextField.setText("");

        // Neuaufbau der Oberfläche um Änderungen leichter sichtbar zu machen
        questionFrame.revalidate();
        questionFrame.repaint();

        // Startzeit setzen
        startTime = System.currentTimeMillis();
    }

    private static void stopTimerAndProceed(String answer) {
        String correctAnswer = answers.get(currentIndex);
        if (answer.equals(correctAnswer)) {
            recordTime();
        }
        nextButton.setEnabled(true);
        nextButton.requestFocus();
    }

    // Zeit aufzeichnen
    private static void recordTime() {
        long endTime = System.currentTimeMillis();
        double elapsedTimeSeconds = (endTime - startTime) / 1000.0;
        times.add(elapsedTimeSeconds);
    }

    // Aufzeichnung in CSV speichern
    private static void exportToCSV() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        
        // Create a formatter to format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        
        // Format the date and time as a string
        String timestamp = now.format(formatter);

        // Create the CSV file name with the timestamp
        String csvFile = "recorded_times_" + timestamp + ".csv";
        
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (int i = 0; i < Math.min(questions.size(), times.size()); i++) {
                String question = questions.get(i);
                double time = times.get(i);
                writer.append(stripHtmlTags(question)).append(",").append(String.valueOf(time)).append("\n");
            }
            System.out.println("CSV file has been created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // HTML-Code aus Fragestellung entfernen vor dem Speichern
    private static String stripHtmlTags(String html) {
        return html.replaceAll("\\<.*?\\>", "");
    }
}
