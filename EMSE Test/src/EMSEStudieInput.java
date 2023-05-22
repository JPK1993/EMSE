import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class EMSEStudieInput {
    private static List<String> questions = new ArrayList<>();
    private static List<String> answers = new ArrayList<>();
    private static List<Double> times = new ArrayList<>();
    private static int currentIndex = 0;
    private static JFrame mainFrame;
    private static JFrame questionFrame;
    private static JLabel questionLabel;
    private static JPanel resultPanel;
    private static JButton startButton;
    private static JButton nextButton;
    private static long startTime;

    public static void main(String[] args) {
        // Fragen und Antworten zur Liste hinzufügen
        questions.add("<html><font color='blue'><b>Welche ist deine Lieblings-Programmiersprache?</b></font></html>");
        answers.add(""); // Placeholder for answer

        questions.add("<html><font color='green'>Welcher ist dein favourisierter IDE für JAVA?</font></html>");
        answers.add(""); // Placeholder for answer

        questions.add("<html><font color='red'><i>Wie oft Programmierst du in deiner Freizeit?</i></font></html>");
        answers.add(""); // Placeholder for answer

        // Hauptframe erstellen
        mainFrame = new JFrame("EMSE Studie");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // Textbereich für Anweisungen
        JTextArea instructionsArea = new JTextArea();
        instructionsArea.setEditable(false);
        instructionsArea.setText("Der Test zum Thema Syntax-Highlighting beginnt in Kürze."
        						+ "\n \n Bitte geben sie Ihre Antwort im Textfeld ein und bestätigen Sie mit der ENTER-Taste."
        						+ "\n Anschließend können Sie durch klicken des WEITER-Buttons zur nächsten Frage springen."
        						+ "\n \n Um zu beginnen, klicken Sie bitte auf 'Start'.");
        instructionsArea.setLineWrap(true);
        instructionsArea.setWrapStyleWord(true);
        mainFrame.add(instructionsArea, BorderLayout.CENTER);

        // Start-Button
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                openQuestionFrame();
            }
        });
        mainFrame.add(startButton, BorderLayout.SOUTH);

        // Hauptframe anzeigen
        mainFrame.setSize(500, 400);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private static void openQuestionFrame() {
        // Frage-Frame erstellen
        questionFrame = new JFrame("EMSE Studie - Frage");
        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionFrame.setLayout(new GridLayout(0, 1));

        // Label für Frage erstellen
        questionLabel = new JLabel();
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionFrame.getContentPane().add(questionLabel);

        // Antwort-Textfeld
        JTextField answerTextField = new JTextField();
        answerTextField.setHorizontalAlignment(SwingConstants.CENTER);
        answerTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimerAndProceed(answerTextField);
            }
        });
        questionFrame.getContentPane().add(answerTextField);

        // Weiter-Button
        nextButton = new JButton("Weiter");
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
        questionFrame.setSize(500, 400);
        questionFrame.setLocationRelativeTo(null);
        questionFrame.setVisible(true);

        // Erste Frage anzeigen
        displayNextQuestion();
    }

    private static void displayNextQuestion() {
        // Ergebnis löschen
        if (resultPanel != null) {
            resultPanel.removeAll();
        }

        // Frage anzeigen
        String question = questions.get(currentIndex);
        questionLabel.setText(question);

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

    private static void stopTimerAndProceed(JTextField answerTextField) {
        recordTime();
        String answer = answerTextField.getText();
        answers.set(currentIndex, answer);
        answerTextField.setEnabled(false);
        nextButton.setEnabled(true);
        nextButton.requestFocus();
    }
    
    //Zeit aufzeichnen

    private static void recordTime() {
        long endTime = System.currentTimeMillis();
        double elapsedTimeSeconds = (endTime - startTime) / 1000.0;
        times.add(elapsedTimeSeconds);
    }
    
    //Aufzeichnung in CSV speichern

    private static void exportToCSV() {
        String csvFile = "recorded_times.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (int i = 0; i < questions.size(); i++) {
                String question = questions.get(i);
                double time = times.get(i);
                String answer = answers.get(i);
                writer.append(stripHtmlTags(question)).append(",").append(String.valueOf(time)).append(",").append(answer).append("\n");
            }
            System.out.println("CSV file has been created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //HTML-Code aus Fragestellung entfernen vor dem Speichern

    private static String stripHtmlTags(String html) {
        return html.replaceAll("\\<.*?\\>", "");
    }
}
