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
        
        questions.add(new Question //3
        		("int x = 10;\r\n"
        				+ "if (x > 5) {\r\n"
        				+ "    System.out.println(\"x is greater than 5\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"x is less than or equal to 5\");\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (x > 10) {\r\n"
        				+ "    System.out.println(\"x is greater than 10\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, true));
        
        questions.add(new Question //4
        		("int x = 10;\r\n"
        				+ "if (x > 5) {\r\n"
        				+ "    System.out.println(\"x is greater than 5\");\r\n"
        				+ "} else if (x == 5) {\r\n"
        				+ "    System.out.println(\"x is equal to 5\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"x is less than 5\");\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (x > 10) {\r\n"
        				+ "    System.out.println(\"x is greater than 10\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, true));
        
        questions.add(new Question //5
        		("int x = 10;\r\n"
        				+ "if (x > 5) {\r\n"
        				+ "    System.out.println(\"x is greater than 5\");\r\n"
        				+ "} else if (x == 5) {\r\n"
        				+ "    System.out.println(\"x is equal to 5\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"x is less than 5\");\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (x > 10) {\r\n"
        				+ "    System.out.println(\"x is greater than 10\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"x is less than or equal to 10\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, true));
        
        
        questions.add(new Question //6
        		("int x = 10;\r\n"
        				+ "if (x > 5) {\r\n"
        				+ "    System.out.println(\"x is greater than 5\");\r\n"
        				+ "} else if (x == 5) {\r\n"
        				+ "    System.out.println(\"x is equal to 5\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"x is less than 5\");\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (x > 10) {\r\n"
        				+ "    System.out.println(\"x is greater than 10\");\r\n"
        				+ "} else if (x == 10) {\r\n"
        				+ "    System.out.println(\"x is equal to 10\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"x is less than 10\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, true));
        
        
        questions.add(new Question //7
        		("int score = 75;\r\n"
        				+ "if (score >= 90) {\r\n"
        				+ "    System.out.println(\"Excellent!\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"Keep working hard!\");\r\n"
        				+ "\r\n"
        				+ "    if (score >= 80) {\r\n"
        				+ "        System.out.println(\"Good job!\");\r\n"
        				+ "    } else {\r\n"
        				+ "        System.out.println(\"You need improvement!\");\r\n"
        				+ "\r\n"
        				+ "        if (score >= 70) {\r\n"
        				+ "            System.out.println(\"Keep practicing!\");\r\n"
        				+ "        }\r\n"
        				+ "    }\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (score < 60) {\r\n"
        				+ "    System.out.println(\"You failed!\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"You passed!\");\r\n"
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
        
        questions.add(new Question //3
        		("int score = 75;\r\n"
        				+ "if (score >= 90) {\r\n"
        				+ "    System.out.println(\"Excellent!\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"Keep working hard!\");\r\n"
        				+ "\r\n"
        				+ "    if (score >= 80) {\r\n"
        				+ "        System.out.println(\"Good job!\");\r\n"
        				+ "    }\r\n"
        				+ "}\r\n"
        				+ ""
        		, false, true));
        
        questions.add(new Question //4
        		("int score = 75;\r\n"
        				+ "if (score >= 90) {\r\n"
        				+ "    System.out.println(\"Excellent!\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"Keep working hard!\");\r\n"
        				+ "\r\n"
        				+ "    if (score >= 70) {\r\n"
        				+ "        System.out.println(\"Good job!\");\r\n"
        				+ "    }\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (score < 60) {\r\n"
        				+ "    System.out.println(\"You need improvement!\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, false, true));
        
        questions.add(new Question //5
        		("int score = 75;\r\n"
        				+ "if (score >= 90) {\r\n"
        				+ "    System.out.println(\"Excellent!\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"Keep working hard!\");\r\n"
        				+ "\r\n"
        				+ "    if (score >= 70) {\r\n"
        				+ "        System.out.println(\"Good job!\");\r\n"
        				+ "    } else if (score >= 60) {\r\n"
        				+ "        System.out.println(\"Fair!\");\r\n"
        				+ "    }\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (score < 60) {\r\n"
        				+ "    System.out.println(\"You need improvement!\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"Very good!\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, false, true));
        
        
        questions.add(new Question //6
        		("int score = 75;\r\n"
        				+ "if (score >= 90) {\r\n"
        				+ "    System.out.println(\"Excellent!\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"Keep working hard!\");\r\n"
        				+ "\r\n"
        				+ "    if (score >= 70) {\r\n"
        				+ "        System.out.println(\"Good job!\");\r\n"
        				+ "    } else if (score >= 60) {\r\n"
        				+ "        System.out.println(\"Fair!\");\r\n"
        				+ "    }\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (score < 60) {\r\n"
        				+ "    System.out.println(\"You need improvement!\");\r\n"
        				+ "} else if (score >= 80) {\r\n"
        				+ "    System.out.println(\"Very good!\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, false, true));
        
        
        questions.add(new Question //7
        		("int num = 7;\r\n"
        				+ "if (num % 2 == 0) {\r\n"
        				+ "    System.out.println(\"The number is even\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"The number is odd\");\r\n"
        				+ "\r\n"
        				+ "    if (num % 3 == 0) {\r\n"
        				+ "        System.out.println(\"The number is divisible by 3\");\r\n"
        				+ "    } else {\r\n"
        				+ "        System.out.println(\"The number is not divisible by 3\");\r\n"
        				+ "\r\n"
        				+ "        if (num % 5 == 0) {\r\n"
        				+ "            System.out.println(\"The number is divisible by 5\");\r\n"
        				+ "        }\r\n"
        				+ "    }\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (num < 0) {\r\n"
        				+ "    System.out.println(\"The number is negative\");\r\n"
        				+ "} else {\r\n"
        				+ "    System.out.println(\"The number is non-negative\");\r\n"
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
        
        questions.add(new Question //3
        		("int num = 7;\r\n"
        				+ "if (num % 2 == 0) {\r\n"
        				+ "System.out.println(\"The number is even\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"The number is odd\");\r\n"
        				+ "\r\n"
        				+ "if (num % 3 == 0) {\r\n"
        				+ "System.out.println(\"The number is divisible by 3\");\r\n"
        				+ "}\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, false));
        
        questions.add(new Question //4
        		("int x = 10;\r\n"
        				+ "if (x > 5) {\r\n"
        				+ "System.out.println(\"x is greater than 5\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"x is less than or equal to 5\");\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (x == 10) {\r\n"
        				+ "System.out.println(\"x is equal to 10\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"x is not equal to 10\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, false));
        
        
        questions.add(new Question //5
        		("int num = 7;\r\n"
        				+ "if (num % 2 == 0) {\r\n"
        				+ "System.out.println(\"The number is even\");\r\n"
        				+ "} else if (num % 3 == 0) {\r\n"
        				+ "System.out.println(\"The number is divisible by 3\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"The number is not divisible by 2 or 3\");\r\n"
        				+ "\r\n"
        				+ "if (num % 5 == 0) {\r\n"
        				+ "System.out.println(\"The number is divisible by 5\");\r\n"
        				+ "}\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (num % 4 == 0) {\r\n"
        				+ "System.out.println(\"The number is divisible by 4\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, false));
        
        
        questions.add(new Question //6
        		("int num = 7;\r\n"
        				+ "if (num % 2 == 0) {\r\n"
        				+ "System.out.println(\"The number is even\");\r\n"
        				+ "} else if (num % 3 == 0) {\r\n"
        				+ "System.out.println(\"The number is divisible by 3\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"The number is not divisible by 2 or 3\");\r\n"
        				+ "\r\n"
        				+ "if (num % 5 == 0) {\r\n"
        				+ "System.out.println(\"The number is divisible by 5\");\r\n"
        				+ "} else if (num % 7 == 0) {\r\n"
        				+ "System.out.println(\"The number is divisible by 7\");\r\n"
        				+ "}\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (num % 4 == 0) {\r\n"
        				+ "System.out.println(\"The number is divisible by 4\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, true, false));
        
        questions.add(new Question //7
        		("int x = 10;\r\n"
        				+ "int y = 5;\r\n"
        				+ "\r\n"
        				+ "if (x > y) {\r\n"
        				+ "System.out.println(\"x is greater than y.\");\r\n"
        				+ "} else if (x < y) {\r\n"
        				+ "System.out.println(\"x is less than y.\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"x is equal to y.\");\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (x % 2 == 0) {\r\n"
        				+ "System.out.println(\"x is even.\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"x is odd.\");\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (y > 0) {\r\n"
        				+ "System.out.println(\"y is positive.\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"y is zero or negative.\");\r\n"
        				+ "}"
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
        
        questions.add(new Question //3
        		("int age = 25;\r\n"
        				+ "if (age < 18) {\r\n"
        				+ "System.out.println(\"You are a minor\");\r\n"
        				+ "} else if (age >= 18 && age < 65) {\r\n"
        				+ "System.out.println(\"You are an adult\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"You are a senior citizen\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, false, false));
        
        questions.add(new Question //4
        		("int x = 10;\r\n"
        				+ "if (x > 5) {\r\n"
        				+ "System.out.println(\"x is greater than 5\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"x is less than or equal to 5\");\r\n"
        				+ "\r\n"
        				+ "if (x == 5) {\r\n"
        				+ "System.out.println(\"x is equal to 5\");\r\n"
        				+ "}\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (x > 10) {\r\n"
        				+ "System.out.println(\"x is greater than 10\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, false, false));
        
        
        questions.add(new Question //5
        		("int age = 25;\r\n"
        				+ "if (age < 18) {\r\n"
        				+ "System.out.println(\"You are a minor\");\r\n"
        				+ "} else if (age >= 18 && age < 30) {\r\n"
        				+ "System.out.println(\"You are a young adult\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"You are not a minor or a young adult\");\r\n"
        				+ "\r\n"
        				+ "if (age >= 30 && age < 60) {\r\n"
        				+ "System.out.println(\"You are an adult\");\r\n"
        				+ "}\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (age >= 60) {\r\n"
        				+ "System.out.println(\"You are a senior citizen\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"You are not a senior citizen\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, false, false));
        
        
        questions.add(new Question //6
        		("int age = 25;\r\n"
        				+ "if (age < 18) {\r\n"
        				+ "System.out.println(\"You are a minor\");\r\n"
        				+ "} else if (age >= 18 && age < 30) {\r\n"
        				+ "System.out.println(\"You are a young adult\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"You are not a minor or a young adult\");\r\n"
        				+ "\r\n"
        				+ "if (age >= 30 && age < 60) {\r\n"
        				+ "System.out.println(\"You are an adult\");\r\n"
        				+ "} else if (age >= 60 && age < 80) {\r\n"
        				+ "System.out.println(\"You are a senior citizen\");\r\n"
        				+ "}\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (age >= 80) {\r\n"
        				+ "System.out.println(\"You are in your golden years\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"You are not in your golden years\");\r\n"
        				+ "}\r\n"
        				+ ""
        		, false, false));
        
        
        questions.add(new Question //7
        		("int num = 42;\r\n"
        				+ "\r\n"
        				+ "if (num > 0) {\r\n"
        				+ "System.out.println(\"The number is positive.\");\r\n"
        				+ "} else if (num < 0) {\r\n"
        				+ "System.out.println(\"The number is negative.\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"The number is zero.\");\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (num % 2 == 0) {\r\n"
        				+ "System.out.println(\"The number is even.\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"The number is odd.\");\r\n"
        				+ "}\r\n"
        				+ "\r\n"
        				+ "if (num > 100) {\r\n"
        				+ "System.out.println(\"The number is greater than 100.\");\r\n"
        				+ "} else if (num < 100) {\r\n"
        				+ "System.out.println(\"The number is less than 100.\");\r\n"
        				+ "} else {\r\n"
        				+ "System.out.println(\"The number is equal to 100.\");\r\n"
        				+ "}"
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
