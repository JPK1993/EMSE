import java.util.ArrayList;
import java.util.List;

public class SortedQuestions {
	
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

       // questions.add(new Question("FRAGE", true/false f�r Syntax Highlighting, true/false f�r Einr�ckung));
        
        //Fragen einger�ckt mit Highlighting:
        
        questions.add(new Question
        		("int x = 10;\r\n"
        				+ "if (x > 0) {\r\n"
        				+ "    System.out.println(\"x is positive\");\r\n"
        				+ "} else if (x < 0) {\r\n"
        				+ "    System.out.println(\"x is negative\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, true));
        
        
        //Fragen einger�ckt ohne Highlighting:
        
        //Fragen nicht einger�ckt mit Highlighting:
        
        //Fragen nicht einger�ckt ohne Highlighting:
        
        
        	
        		
        
        	
        	
        
        
        
       
        	
        	
        	
        
        
        
        
        //Aufruf der Z�hlmethoden f�r Antwortgenerierung und Zeilenzahl
        
        
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
    
    //Zeilen der Fragen z�hlen zu statistischen Zwecken
    
    private static int countLines(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        
        String[] lines = text.split("\r\n|\r|\n");
        return lines.length;
    }
    
    //W�rter 'if' und 'else' z�hlen um korrekte Antworten zu berechnen (testweise)
    
    
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
