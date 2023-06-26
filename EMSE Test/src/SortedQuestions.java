import java.util.ArrayList;
import java.util.List;

public class SortedQuestions {
	
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

       // questions.add(new Question("FRAGE", true/false für Syntax Highlighting, true/false für Einrückung));
        
        //Fragen eingerückt mit Highlighting:
        
        questions.add(new Question //2
        		("int x = 10;\r\n"
        				+ "if (x > 5) {\r\n"
        				+ "    System.out.println(\"x is greater than 5\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"x is less than or equal to 5\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, true));
        
        
        //Fragen eingerückt ohne Highlighting:
        
        questions.add(new Question //2
        		("int num = 15;\r\n"
        				+ "if (num < 10) {\r\n"
        				+ "    System.out.println(\"The number is less than 10\");\r\n"
        				+ "} else if (num > 20) {\r\n"
        				+ "    System.out.println(\"The number is greater than 20\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, false, true));
        
        //Fragen nicht eingerückt mit Highlighting:
        
        questions.add(new Question //2
        		("int score = 80;\r\n"
        				+ "if (score >= 90) {\r\n"
        				+ "System.out.println(\"Excellent!\");\r\n"
        				+ "}else {\r\n"
        				+ "System.out.println(\"Good job!\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, false));
        
        //Fragen nicht eingerückt ohne Highlighting:
        
        questions.add(new Question //2
        		("boolean isRaining = false;\r\n"
        				+ "if (isRaining) {\r\n"
        				+ "System.out.println(\"It's raining\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"It's not raining\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, false, false));
        
        
        	
        		
        
        	
        	
        
        
        
       
        	
        	
        	
        
        
        
        
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
    
    //Wörter 'if' und 'else' zählen um korrekte Antworten zu berechnen 
    
    
//    public static int countKeywords(String questionText) {
//        int count = 0;
//        String lowercaseText = questionText.toLowerCase();
//        String[] words = lowercaseText.split("\\W+");
//        
//        for (String word : words) {
//            if (word.equals("if") || word.equals("else")) {
//                count++;
//            }
//        }
//        
//        return count;
//    }
    
    
    //if, else, und if else Statements zählen, um korrekte Antworten zu berechnen
    
    public static int countKeywords(String questionText) {
        int count = 0;
        String lowercaseText = questionText.toLowerCase();
        
        // Replace all instances of "if else" with a unique keyword ("ifelse")
        String modifiedText = lowercaseText.replaceAll("else if", "elseif");
        
        String[] words = modifiedText.split("\\W+");
        
        for (String word : words) {
            if (word.equals("if") || word.equals("else") || word.equals("elseif")) {
                count++;
            }
        }
        
        return count;
    }

    
    
    
    


    
    
}
