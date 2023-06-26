import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
//import java.text.DecimalFormat;
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
    private static JCheckBox testBox;
    private static long startTime;
    private static boolean inputRecorded = false;

    public static void main(String[] args) {
    	
    	//Fragen aus EMSEQuestions.java importieren
    	
      //questions = TestQuestions.getQuestions();		//Testfragen
      questions = SortedQuestions.getQuestions();		//Richtige Fragen
        
     // Fragen zuf�llig durcheinander w�rfeln (Kann auskommentiert werden)
         Collections.shuffle(questions);

        // Hauptframe erstellen (Erste Seite)
        
        mainFrame = new JFrame("EMSE Studie");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());					//Border-Layout festlegen f�r Main Frame

        // Textbereich f�r Anweisungen
        
        JTextArea instructionsArea = new JTextArea();
        instructionsArea.setEditable(false);
        instructionsArea.setText("Die Studie zum Thema Syntax-Highlighting beginnt in K�rze."
                + "\n \nEs werden Ihnen zuf�llige Code-Bruchst�cke mit oder ohne Syntax-Highlighting, sowie mit oder ohne Einr�ckung gezeigt. Insgesamt gibt es also 4 verschiedene Arten von Fragen."
                + "\n \nAufgabe ist es, die Anzahl der Begriffe \"if\", \"else\" und \"if else\" zu z�hlen."
                + "\n \nEin \"if\" Statement z�hlt also als 1, ein \"else\" Statement z�hlt als 1, und ein \"else if\" Statement z�hlt ebenfalls als 1."
                + "\n \nBitte geben Sie Ihre Antwort durch das Dr�cken einer Zahl zwischen 0 und 9 auf der Tastatur ein."
                + "\n \nSobald eine Zahl gedr�ckt wurde, wird die Zeit gestoppt und der Weiter-Button aktiviert, mit dem Sie per Mausklick zur n�chsten Frage springen k�nnen. Nach Anklicken des Weiter-Buttons l�uft die Zeitmessung erneut, bis eine Antwort auf die n�chste Frage eingegeben wurde."
                + "\n \n�nderungen am eingegebenen Ergebnis sind nachtr�glich nicht m�glich."
                + "\n \nAbsolvieren Sie die Studie zum ersten mal, k�nnen Sie \"Testdurchlauf\" ankreuzen, um ein Gef�hl f�r den Ablauf und die Art der gestellten Fragen zu bekommen. Ihnen werden dann zuf�llige Fragen aus einem anderen Fragenkatalog pr�sentiert, die nicht Teil des gewerteten Durchlaufs sind."
                + "\n \nBitte legen sie eine Hand auf die Tastatur und die andere auf die Maus, um die Eingabeverz�gerung m�glichst klein zu halten."
                + "\n \nUm zu beginnen, w�hlen Sie bitte aus ob Sie einen Testdurchlauf durchf�hren m�chten oder nicht. Klicken Sie dann bitte auf 'Start'.");
        instructionsArea.setLineWrap(true);
        instructionsArea.setFont(new Font("Arial", Font.PLAIN, 20)); // Schriftgr��e f�r Instruction-Area
        instructionsArea.setWrapStyleWord(true);
        instructionsArea.setPreferredSize(new Dimension(1000,800));
        
        mainFrame.add(instructionsArea, BorderLayout.NORTH); //Instruction Area zum Main Frame hinzuf�gen
        
        //Checkbox f�r Testdurchlauf
        
        testBox = new JCheckBox("Testdurchlauf");
        testBox.setFont(new Font("Arial", Font.BOLD, 25));
        testBox.setPreferredSize(new Dimension(1000,100));
        
        testBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				questions = TestQuestions.getQuestions();  //Wenn die Checkbox angekreuzt ist, werden Testfragen anstelle der richtigen Fragen gezeigt
			}
        });
        
        mainFrame.add(testBox,BorderLayout.CENTER);
        
        
        // Start-Button
        
        startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.BOLD, 25)); //Schriftformat
        startButton.setPreferredSize(new Dimension(1000, 100)); //Buttongr��e
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                openQuestionFrame();              
            }
        });
        mainFrame.add(startButton, BorderLayout.SOUTH); //Start Button zum Main Frame hinzuf�gen

        // Hauptframe formatieren und anzeigen
        
        mainFrame.setSize(1000, 1000); //Gr��e des Hauptframes mit Instruction Area und Weiter-Button (HxB)
        mainFrame.setLocationRelativeTo(null); //Position
        mainFrame.setVisible(true); //Sichtbarkeit
    }

    private static void openQuestionFrame() {
        // Frage-Frame erstellen
        questionFrame = new JFrame("EMSE Studie - Frage");
        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionFrame.setLayout(new BorderLayout());

        // Textbereich f�r Frage erstellen
        questionTextArea = new RSyntaxTextArea();
        questionTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        questionTextArea.setCodeFoldingEnabled(false);
        questionTextArea.setEditable(false);
        questionTextArea.setPreferredSize(new Dimension(1000,800));
        questionTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        questionFrame.getContentPane().add(questionTextArea, BorderLayout.NORTH); // Textarea zum Question Frame hinzuf�gen

        // Antwort-Textfeld
        JTextField answerTextField = new JTextField();
        answerTextField.setHorizontalAlignment(SwingConstants.CENTER);
        answerTextField.setFont(new Font("Arial", Font.BOLD, 20));
        //answerTextField.setPreferredSize(new Dimension(1000, 150)); // Center nimmt immer den restlichen verf�gbaren Platz ein!
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
        questionFrame.getContentPane().add(answerTextField, BorderLayout.CENTER); // Antwortfeld zum Question Frame hinzuf�gen

        // Weiter-Button
        nextButton = new JButton("Weiter");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));	//Schriftformatierung
        nextButton.setPreferredSize(new Dimension(1000, 80)); 	//Gr��e des Buttons
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
                nextButton.setEnabled(false);
            }
        });
        questionFrame.getContentPane().add(nextButton, BorderLayout.SOUTH); // Next Button zum Questionframe hinzuf�gen

        // Frage-Frame formatieren und anzeigen
        questionFrame.setSize(1000, 1000); // Gesamtgr��e
        questionFrame.setLocationRelativeTo(null); //Position
        questionFrame.setVisible(true); //Sichtbar

        // Erste Frage anzeigen
        displayNextQuestion();
    }

    
    private static void displayNextQuestion() {
       
        // Ergebnisfeld leeren
        if (resultPanel != null) {
            resultPanel.removeAll();
        }
        
        
        // Frage anzeigen
       
        Question currentQuestion = questions.get(currentIndex);
        questionTextArea.setText(currentQuestion.getQuestion()); //Text aus der Frage holen
        questionTextArea.setSyntaxEditingStyle(currentQuestion.isEnableFormatting() ? SyntaxConstants.SYNTAX_STYLE_JAVA : null); // Information, ob Highlighting eingeschaltet werden soll aus der Frage holen

        // Antwort-Textfeld aktivieren
        
        JTextField answerTextField = (JTextField) questionFrame.getContentPane().getComponent(1);
        answerTextField.setEnabled(true);
        answerTextField.requestFocus();
        answerTextField.setText("");
        
        // Neuaufbau der Oberfl�che um �nderungen leichter sichtbar zu machen
        
        questionFrame.revalidate();
        questionFrame.repaint();
  
        // Startzeit setzen
        
        startTime = System.currentTimeMillis();
        
        //Input-Flag zur�cksetzen
        
        inputRecorded = false;
        
        //"Weiter" Button ausschalten bis Antwort eingegeben wurde
        
        nextButton.setEnabled(false);
        
        
    }
    
    // Timer anhalten und auf richtige Antwort pr�fen

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
        	
        	// Erste Zeile (�berschrift)
        	
            writer.append("Highlighting,Time,LineCount,Indentation,CorrectAnswer,Position\n");
            
            //Zeilen mit Messwerten
        	
            for (int i = 0; i < Math.min(questions.size(), times.size()); i++) {
            	boolean enableFormatting = questions.get(i).isEnableFormatting();
                double time = times.get(i);
                int lineCount = questions.get(i).getLineCount();
                boolean indented = questions.get(i).getindented();    
                String answer = questions.get(i).getAnswer();
                writer.append(String.valueOf(enableFormatting)).append(",").append(String.valueOf(time)).append(",").append(String.valueOf(lineCount)).append(",").append(String.valueOf(indented)).append(",").append(String.valueOf(answer)).append(",").append(String.valueOf(i+1)).append("\n");         

            }
            System.out.println("CSV Datei erstellt!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
