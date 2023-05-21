import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CodeReviewStudy {
	private static List<String> questions = new ArrayList<>();
	private static List<Long> times = new ArrayList<>();
	private static int currentIndex = 0;

	public static void main(String[] args) {
		// Add your questions to the 'questions' list
		questions.add("Which programming language is your favorite?");
		questions.add("What is your preferred IDE?");
		questions.add("How often do you use version control?");

		// Create the GUI frame
		JFrame frame = new JFrame("Code Review Study");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0, 1)); // Use GridLayout with 1 column

		// Create the question label
		JLabel questionLabel = new JLabel();
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center-align the text
		frame.getContentPane().add(questionLabel);

		// Create the buttons
		JButton javaButton = new JButton("Java");
		JButton pythonButton = new JButton("Python");
		JButton csharpButton = new JButton("C#");

		// Create the button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3)); // Use GridLayout with 3 columns
		buttonPanel.add(javaButton);
		buttonPanel.add(pythonButton);
		buttonPanel.add(csharpButton);
		frame.getContentPane().add(buttonPanel);

		// Add button listeners
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stopTimer();
				JButton sourceButton = (JButton) e.getSource();
				recordTime();
				JOptionPane.showMessageDialog(null, "You selected: " + sourceButton.getText());
				currentIndex++;
				if (currentIndex < questions.size()) {
					displayNextQuestion(questionLabel);
				} else {
					exportToCSV();
					frame.dispose();
				}
			}
		};
		javaButton.addActionListener(buttonListener);
		pythonButton.addActionListener(buttonListener);
		csharpButton.addActionListener(buttonListener);

		// Set frame properties and display it
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Display the first question
		displayNextQuestion(questionLabel);
	}

	private static void displayNextQuestion(JLabel questionLabel) {
		questionLabel.setText("<html><font color='blue'><b>" + questions.get(currentIndex) + "</b></font></html>");
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
