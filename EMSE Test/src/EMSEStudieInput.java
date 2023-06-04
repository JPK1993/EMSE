import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

public class EMSEStudieInput {
    private static List<Question> questions = new ArrayList<>();
    private static List<Double> times = new ArrayList<>();
    private static int currentIndex = 0;
    private static JFrame mainFrame;
    private static JFrame questionFrame;
    private static RSyntaxTextArea questionTextArea;
    private static JPanel resultPanel;
    private static JButton startButton;
    private static JButton nextButton;
    private static long startTime;
    private static boolean inputRecorded = false;

    public static void main(String[] args) {
    	
    	//Fragen aus EMSEQuestions.java importieren
    	
        questions = EMSEQuestions.getQuestions();

        // Hauptframe erstellen (Erste Seite)
        
        mainFrame = new JFrame("EMSE Studie");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());					//Border-Layout festlegen für Main Frame

        // Textbereich für Anweisungen
        
        JTextArea instructionsArea = new JTextArea();
        instructionsArea.setEditable(false);
        instructionsArea.setText("Die Studie zum Thema Syntax-Highlighting beginnt in Kürze."
                + "\n \nEs werden Ihnen zufällige Code-Bruchstücke mit oder ohne Syntax-Highlighting gezeigt."
                + "\n \nAufgabe ist es, die Anzahl der IF- und ELSE-Statements innerhalb des gezeigten Codes zu zählen."
                + "\n \nBitte geben Sie Ihre Antwort durch das Drücken einer Zahl zwischen 0 und 9 ein."
                + "\n \nSobald eine Zahl gedrückt wurde, wird die Zeit gestoppt und der Weiter-Button aktiviert, mit dem Sie per Mausklick zur nächsten Frage springen können."
                + "\n \nÄnderungen am eigegebenen Ergebnis sind nachträglich nicht möglich."
                + "\n \nEs werden nur korrekte Antworten gewertet, um die durchschnittliche, benötigte Zeit zum richtigen Beantworten der Fragen mit oder ohne Syntax-Highlighting auszuwerten."
                + "\n \nUm zu beginnen, klicken Sie bitte auf 'Start'.");
        instructionsArea.setLineWrap(true);
        instructionsArea.setFont(new Font("Arial", Font.PLAIN, 20)); // Schriftgröße für Instruction-Area
        instructionsArea.setWrapStyleWord(true);
        
        mainFrame.add(instructionsArea, BorderLayout.CENTER); //Instruction Area zum Main Frame hinzufügen

        // Start-Button
        
        startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.BOLD, 20)); //Schriftformat
        startButton.setPreferredSize(new Dimension(1000, 50)); //Buttongröße
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                openQuestionFrame();
            }
        });
        mainFrame.add(startButton, BorderLayout.SOUTH); //Start Button zum Main Frame hinzufügen

        // Hauptframe formatieren und anzeigen
        
        mainFrame.setSize(1000, 1000); //Größe des Hauptframes mit Instruction Area und Weiter-Button (HxB)
        mainFrame.setLocationRelativeTo(null); //Position
        mainFrame.setVisible(true); //Sichtbarkeit
    }

    
//    private static void openQuestionFrame() {
//        // Frage-Frame erstellen
//        questionFrame = new JFrame("EMSE Studie - Frage");
//        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        questionFrame.setLayout(new GridLayout(0, 1));	//Grid Layout Festlegen für Question Frame
//        
//
//        // Textbereich für Frage erstellen
//        questionTextArea = new RSyntaxTextArea();
//        questionTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
//        questionTextArea.setCodeFoldingEnabled(false);
//        questionTextArea.setEditable(false);
//        questionTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
//
//       
//        questionFrame.getContentPane().add(questionTextArea); // Textarea zum Question Frame hinzufügen
//     
//        // Antwort-Textfeld
//        JTextField answerTextField = new JTextField();
//        answerTextField.setHorizontalAlignment(SwingConstants.CENTER);
//        answerTextField.setFont(new Font("Arial", Font.BOLD, 20));
//        answerTextField.setPreferredSize(new Dimension(200, 30)); // Set the size of the answer input field
//        answerTextField.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                char inputChar = e.getKeyChar();
//                if (Character.isDigit(inputChar) && !inputRecorded) {
//                    String answer = String.valueOf(inputChar);
//                    stopTimerAndProceed(answer);
//                    inputRecorded = true;
//                }
//            }
//        });
//        questionFrame.getContentPane().add(answerTextField); //Antwortfeld zum Question Frame hinzufügen
//
//        // Weiter-Button
//        nextButton = new JButton("Weiter");
//        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
//        nextButton.setPreferredSize(new Dimension(200, 30)); // Set the size of the next button
//        nextButton.setEnabled(false);
//        nextButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                currentIndex++;
//                if (currentIndex < questions.size()) {
//                    displayNextQuestion();
//                } else {
//                    exportToCSV();
//                    questionFrame.dispose();
//                }
//            }
//        });
//        questionFrame.getContentPane().add(nextButton); //Next Button zum Question Frame hinzufügen
//
//       
//        // Frage-Frame formatieren und anzeigen
//        questionFrame.setSize(1000, 1000); //Gesamtgröße
//        questionFrame.setLocationRelativeTo(null);
//        questionFrame.setVisible(true);
//
//        // Erste Frage anzeigen
//        displayNextQuestion();
//    }
    
    
//    private static void openQuestionFrame() {
//        // Frage-Frame erstellen
//        questionFrame = new JFrame("EMSE Studie - Frage");
//        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        questionFrame.setLayout(new BoxLayout(questionFrame.getContentPane(), BoxLayout.Y_AXIS));
//
//        // Textbereich für Frage erstellen
//        questionTextArea = new RSyntaxTextArea();
//        questionTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
//        questionTextArea.setCodeFoldingEnabled(false);
//        questionTextArea.setEditable(false);
//        questionTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
//
//        questionFrame.getContentPane().add(questionTextArea); // Textarea zum Question Frame hinzufügen
//
//        // Antwort-Textfeld
//        JTextField answerTextField = new JTextField();
//        answerTextField.setHorizontalAlignment(SwingConstants.CENTER);
//        answerTextField.setFont(new Font("Arial", Font.BOLD, 20));
//        answerTextField.setPreferredSize(new Dimension(200, 30)); // Set the size of the answer input field
//        answerTextField.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                char inputChar = e.getKeyChar();
//                if (Character.isDigit(inputChar) && !inputRecorded) {
//                    String answer = String.valueOf(inputChar);
//                    stopTimerAndProceed(answer);
//                    inputRecorded = true;
//                }
//            }
//        });
//        questionFrame.getContentPane().add(answerTextField); // Antwortfeld zum Question Frame hinzufügen
//
//        // Weiter-Button
//        nextButton = new JButton("Weiter");
//        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
//        nextButton.setPreferredSize(new Dimension(200, 30)); // Set the size of the next button
//        nextButton.setEnabled(false);
//        nextButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                currentIndex++;
//                if (currentIndex < questions.size()) {
//                    displayNextQuestion();
//                } else {
//                    exportToCSV();
//                    questionFrame.dispose();
//                }
//            }
//        });
//        questionFrame.getContentPane().add(nextButton); // Next Button zum Question Frame hinzufügen
//
//        // Frage-Frame formatieren und anzeigen
//        questionFrame.pack();
//        questionFrame.setSize(1000, 1000); //Gesamtgöße
//        questionFrame.setLocationRelativeTo(null);
//        questionFrame.setVisible(true);
//
//        // Erste Frage anzeigen
//        displayNextQuestion();
//    }
    
    
    private static void openQuestionFrame() {
        // Frage-Frame erstellen
        questionFrame = new JFrame("EMSE Studie - Frage");
        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionFrame.setLayout(new BorderLayout());

        // Textbereich für Frage erstellen
        questionTextArea = new RSyntaxTextArea();
        questionTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        questionTextArea.setCodeFoldingEnabled(false);
        questionTextArea.setEditable(false);
        questionTextArea.setPreferredSize(new Dimension(1000,800));
        questionTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        questionFrame.getContentPane().add(questionTextArea, BorderLayout.NORTH); // Textarea zum Question Frame hinzufügen

        // Antwort-Textfeld
        JTextField answerTextField = new JTextField();
        answerTextField.setHorizontalAlignment(SwingConstants.CENTER);
        answerTextField.setFont(new Font("Arial", Font.BOLD, 20));
        //answerTextField.setPreferredSize(new Dimension(1000, 150)); // Center nimmt immer den restlichen verfügbaren Platz ein!
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
        questionFrame.getContentPane().add(answerTextField, BorderLayout.CENTER); // Antwortfeld zum Question Frame hinzufügen

        // Weiter-Button
        nextButton = new JButton("Weiter");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));	//Schriftformatierung
        nextButton.setPreferredSize(new Dimension(1000, 80)); 	//Größe des Buttons
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
        questionFrame.getContentPane().add(nextButton, BorderLayout.SOUTH); // Next Button zum Question Frame hinzufügen

        // Frage-Frame formatieren und anzeigen
        questionFrame.setSize(1000, 1000); // Gesamtgröße
        questionFrame.setLocationRelativeTo(null); //Position
        questionFrame.setVisible(true); //Sichtbar

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
        
        // Fragen zufällig durcheinander würfeln (Kann auskommentiert werden)
        // Collections.shuffle(questions);
        
        Question currentQuestion = questions.get(currentIndex);
        questionTextArea.setText(currentQuestion.getQuestion());
        questionTextArea.setSyntaxEditingStyle(currentQuestion.isEnableFormatting() ? SyntaxConstants.SYNTAX_STYLE_JAVA : null);

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
    
    // Timer anhalten und auf richtige Antwort prüfen

    private static void stopTimerAndProceed(String answer) {
        Question currentQuestion = questions.get(currentIndex);
        String correctAnswer = currentQuestion.getAnswer();
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
    	
        // Datum und Zeit
        LocalDateTime now = LocalDateTime.now();

        // Datum und Zeit formatieren
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

        // Datum und Zeit in String
        String timestamp = now.format(formatter);

        // CSV Dateiname mit Zeitstempel
        String csvFile = "recorded_times_" + timestamp + ".csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
        	
        	// Erste Zeile (überschrift)
        	
            writer.append("Highlighting,Time\n");
            
            //Zeilen mit Messwerten
        	
            for (int i = 0; i < Math.min(questions.size(), times.size()); i++) {
                boolean enableFormatting = questions.get(i).isEnableFormatting();
                double time = times.get(i);
                writer.append(String.valueOf(enableFormatting)).append(",").append(String.valueOf(time)).append("\n");
            }
            System.out.println("CSV Datei erstellt!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
