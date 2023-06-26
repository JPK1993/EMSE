import java.util.ArrayList;
import java.util.List;

public class SortedQuestions {
	
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

       // questions.add(new Question("FRAGE", true/false für Syntax Highlighting, true/false für Einrückung));
        
        //Fragen eingerückt mit Highlighting:
        
        questions.add(new Question
        		("int x = 10;\r\n"
        				+ "if (x > 0) {\r\n"
        				+ "    System.out.println(\"x is positive\");\r\n"
        				+ "} else if (x < 0) {\r\n"
        				+ "    System.out.println(\"x is negative\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, true));
        
        
        //Fragen eingerückt ohne Highlighting:
        
        //Fragen nicht eingerückt mit Highlighting:
        
        //Fragen nicht eingerückt ohne Highlighting:
        
        
        	
        		
        
        	
        	
        
        
        
       
        	
        	
        	
        
        
        
        
        //Aufruf der Zählmethoden für Antwortgenerierung und Zeilenzahl
        
        
        for (Question question: questions) {
        	int lineCount = countLines(question.getQuestion());
        	question.setLineCount(lineCount);
        }
        
        
        for (Question question : questions) {
            int count = countKeywords(question.getQuestion());           
            question.setAnswer(String.valueOf(count));
        }
        
        
        return questions;
    }
    
    //Zeilen der Fragen zählen zu statistischen Zwecken
    
    private static int countLines(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        
        String[] lines = text.split("\r\n|\r|\n");
        return lines.length;
    }
    
    //Wörter 'if' und 'else' zählen um korrekte Antworten zu berechnen (testweise)
    
    
    public static int countKeywords(String questionText) {
        int count = 0;
        String lowercaseText = questionText.toLowerCase();
        String[] words = lowercaseText.split("\\W+");
        
        for (String word : words) {
            if (word.equals("if") || word.equals("else")) {
                count++;
            }
        }
        
        return count;
    }


    
    
}
