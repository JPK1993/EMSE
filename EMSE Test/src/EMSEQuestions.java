import java.util.ArrayList;
import java.util.List;

public class EMSEQuestions {
	
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

       // questions.add(new Question("FRAGE", true/false für Syntax Highlighting, "ANTWORT"));
        
        questions.add(new Question("int x = 15;\r\n"
        		+ "if (x % 2 == 0) {\r\n"
        		+ "    System.out.println(\"Even\");\r\n"
        		+ "    if (x > 10) {\r\n"
        		+ "        System.out.println(\"Greater than 10\");\r\n"
        		+ "        if (x % 3 == 0) {\r\n"
        		+ "            System.out.println(\"Divisible by 3\");\r\n"
        		+ "        }\r\n"
        		+ "    }\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Odd\");\r\n"
        		+ "    if (x < 10) {\r\n"
        		+ "        System.out.println(\"Less than 10\");\r\n"
        		+ "        if (x % 5 == 0) {\r\n"
        		+ "            System.out.println(\"Divisible by 5\");\r\n"
        		+ "        }\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "", true, "6"));
    
        questions.add(new Question("int num = -7;\r\n"
        		+ "if (num >= 0) {\r\n"
        		+ "    System.out.println(\"Positive or Zero\");\r\n"
        		+ "    if (num % 2 == 0) {\r\n"
        		+ "        System.out.println(\"Even\");\r\n"
        		+ "    } else {\r\n"
        		+ "        System.out.println(\"Odd\");\r\n"
        		+ "    }\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Negative\");\r\n"
        		+ "    if (num % 2 == 0) {\r\n"
        		+ "        System.out.println(\"Even\");\r\n"
        		+ "    } else {\r\n"
        		+ "        System.out.println(\"Odd\");\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "", false, "6"));
        
        questions.add(new Question("boolean isRaining = true;\r\n"
        		+ "if (isRaining) {\r\n"
        		+ "    System.out.println(\"Remember to take an umbrella!\");\r\n"
        		+ "    if (isRaining && temperature < 10) {\r\n"
        		+ "        System.out.println(\"It's cold outside. Wear a jacket too!\");\r\n"
        		+ "    }\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"No need for an umbrella.\");\r\n"
        		+ "}\r\n"
        		+ "", true, "3"));
        
        questions.add(new Question("int age = 20;\r\n"
        		+ "if (age < 13) {\r\n"
        		+ "    System.out.println(\"Child\");\r\n"
        		+ "    if (age >= 8) {\r\n"
        		+ "        System.out.println(\"Between 8 and 12\");\r\n"
        		+ "    }\r\n"
        		+ "} else if (age < 18) {\r\n"
        		+ "    System.out.println(\"Teenager\");\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Adult\");\r\n"
        		+ "    if (age >= 65) {\r\n"
        		+ "        System.out.println(\"Senior Citizen\");\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "", false, "6"));
        
        questions.add(new Question("int x = 10;\r\n"
        		+ "if (x > 0) {\r\n"
        		+ "    System.out.println(\"Positive\");\r\n"
        		+ "    if (x > 5) {\r\n"
        		+ "        System.out.println(\"Greater than 5\");\r\n"
        		+ "        if (x > 8) {\r\n"
        		+ "            System.out.println(\"Greater than 8\");\r\n"
        		+ "        }\r\n"
        		+ "    }\r\n"
        		+ "} else if (x < 0) {\r\n"
        		+ "    System.out.println(\"Negative\");\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Zero\");\r\n"
        		+ "}\r\n"
        		+ "", true, "6"));
        
        questions.add(new Question("int num1 = 5;\r\n"
        		+ "int num2 = 10;\r\n"
        		+ "if (num1 > num2) {\r\n"
        		+ "    System.out.println(\"num1 is greater\");\r\n"
        		+ "    if (num1 > 2 * num2) {\r\n"
        		+ "        System.out.println(\"num1 is significantly greater\");\r\n"
        		+ "    }\r\n"
        		+ "} else if (num2 > num1) {\r\n"
        		+ "    System.out.println(\"num2 is greater\");\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Both are equal\");\r\n"
        		+ "}\r\n"
        		+ "", false, "5"));
        
        questions.add(new Question("int score = 80;\r\n"
        		+ "if (score >= 90) {\r\n"
        		+ "    System.out.println(\"A Grade\");\r\n"
        		+ "} else if (score >= 80) {\r\n"
        		+ "    System.out.println(\"B Grade\");\r\n"
        		+ "    if (score >= 85) {\r\n"
        		+ "        System.out.println(\"Higher B Grade\");\r\n"
        		+ "    }\r\n"
        		+ "} else if (score >= 70) {\r\n"
        		+ "    System.out.println(\"C Grade\");\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Fail\");\r\n"
        		+ "}\r\n"
        		+ "", true, "7"));
        
        questions.add(new Question("int age = 25;\r\n"
        		+ "if (age >= 18) {\r\n"
        		+ "    System.out.println(\"Adult\");\r\n"
        		+ "    if (age >= 21) {\r\n"
        		+ "        System.out.println(\"Eligible to drink\");\r\n"
        		+ "    }\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Minor\");\r\n"
        		+ "    if (age >= 16) {\r\n"
        		+ "        System.out.println(\"Eligible for driving permit\");\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "", false, "4"));
        
        questions.add(new Question("int num = 10;\r\n"
        		+ "if (num % 2 == 0) {\r\n"
        		+ "    System.out.println(\"Even\");\r\n"
        		+ "    if (num > 10) {\r\n"
        		+ "        System.out.println(\"Greater than 10\");\r\n"
        		+ "    }\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Odd\");\r\n"
        		+ "    if (num < 10) {\r\n"
        		+ "        System.out.println(\"Less than 10\");\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "", true, "4"));
        
        questions.add(new Question("int x = 5;\r\n"
        		+ "if (x > 0) {\r\n"
        		+ "    System.out.println(\"Positive\");\r\n"
        		+ "    System.out.println(\"Number is greater than zero\");\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Non-positive\");\r\n"
        		+ "    System.out.println(\"Number is less than or equal to zero\");\r\n"
        		+ "}\r\n"
        		+ "3", false, "2"));
        
        questions.add(new Question("int x = 5;\r\n"
        		+ "if (x > 0) {\r\n"
        		+ "    System.out.println(\"Positive\");\r\n"
        		+ "    if (x > 5) {\r\n"
        		+ "        System.out.println(\"Greater than 5\");\r\n"
        		+ "    } else {\r\n"
        		+ "        System.out.println(\"Less than or equal to 5\");\r\n"
        		+ "    }\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Non-positive\");\r\n"
        		+ "}", true, "4"));
        
        questions.add(new Question("int num = 10;\r\n"
        		+ "if (num % 2 == 0) {\r\n"
        		+ "    System.out.println(\"Even\");\r\n"
        		+ "    if (num > 10) {\r\n"
        		+ "        System.out.println(\"Greater than 10\");\r\n"
        		+ "    } else if (num < 10) {\r\n"
        		+ "        System.out.println(\"Less than 10\");\r\n"
        		+ "    } else {\r\n"
        		+ "        System.out.println(\"Equal to 10\");\r\n"
        		+ "    }\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Odd\");\r\n"
        		+ "}\r\n"
        		+ "", false, "6"));
        
        questions.add(new Question("int age = 25;\r\n"
        		+ "if (age >= 18) {\r\n"
        		+ "    System.out.println(\"Adult\");\r\n"
        		+ "    if (age >= 21) {\r\n"
        		+ "        System.out.println(\"Eligible to drink\");\r\n"
        		+ "    } else {\r\n"
        		+ "        System.out.println(\"Not eligible to drink\");\r\n"
        		+ "    }\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Minor\");\r\n"
        		+ "}\r\n"
        		+ "", true, "4"));
        
        questions.add(new Question("int score = 80;\r\n"
        		+ "if (score >= 90) {\r\n"
        		+ "    System.out.println(\"A Grade\");\r\n"
        		+ "} else if (score >= 80) {\r\n"
        		+ "    System.out.println(\"B Grade\");\r\n"
        		+ "    if (score >= 85) {\r\n"
        		+ "        System.out.println(\"Higher B Grade\");\r\n"
        		+ "    } else {\r\n"
        		+ "        System.out.println(\"Lower B Grade\");\r\n"
        		+ "    }\r\n"
        		+ "} else if (score >= 70) {\r\n"
        		+ "    System.out.println(\"C Grade\");\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Fail\");\r\n"
        		+ "}\r\n"
        		+ "", false, "8"));
        
        questions.add(new Question("int num1 = 5;\r\n"
        		+ "int num2 = 10;\r\n"
        		+ "if (num1 > num2) {\r\n"
        		+ "    System.out.println(\"num1 is greater\");\r\n"
        		+ "} else if (num2 > num1) {\r\n"
        		+ "    System.out.println(\"num2 is greater\");\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Both are equal\");\r\n"
        		+ "}\r\n"
        		+ "if (num1 == num2) {\r\n"
        		+ "    System.out.println(\"Both are equal\");\r\n"
        		+ "}\r\n"
        		+ "", true, "5"));
        
        questions.add(new Question("int x = 10;\r\n"
        		+ "if (x > 0) {\r\n"
        		+ "    System.out.println(\"Positive\");\r\n"
        		+ "    if (x > 5) {\r\n"
        		+ "        System.out.println(\"Greater than 5\");\r\n"
        		+ "    } else {\r\n"
        		+ "        System.out.println(\"Less than or equal to 5\");\r\n"
        		+ "        if (x == 5) {\r\n"
        		+ "            System.out.println(\"Equal to 5\");\r\n"
        		+ "        }\r\n"
        		+ "    }\r\n"
        		+ "} else if (x < 0) {\r\n"
        		+ "    System.out.println(\"Negative\");\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Zero\");\r\n"
        		+ "}\r\n"
        		+ "", false, "7"));
        
        questions.add(new Question("int age = 20;\r\n"
        		+ "if (age < 13) {\r\n"
        		+ "    System.out.println(\"Child\");\r\n"
        		+ "} else if (age < 18) {\r\n"
        		+ "    System.out.println(\"Teenager\");\r\n"
        		+ "    if (age < 16) {\r\n"
        		+ "        System.out.println(\"Below driving age\");\r\n"
        		+ "    } else {\r\n"
        		+ "        System.out.println(\"Driving age\");\r\n"
        		+ "    }\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Adult\");\r\n"
        		+ "}\r\n"
        		+ "", true, "6"));
        
        questions.add(new Question("boolean isRaining = true;\r\n"
        		+ "if (isRaining) {\r\n"
        		+ "    System.out.println(\"Remember to take an umbrella!\");\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"No need for an umbrella.\");\r\n"
        		+ "    if (isSunny) {\r\n"
        		+ "        System.out.println(\"Wear sunscreen!\");\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "if (isWindy) {\r\n"
        		+ "    System.out.println(\"Hold onto your hat!\");\r\n"
        		+ "}\r\n"
        		+ "", false, "4"));
        
        questions.add(new Question("int num = -7;\r\n"
        		+ "if (num >= 0) {\r\n"
        		+ "    System.out.println(\"Positive or Zero\");\r\n"
        		+ "    if (num % 2 == 0) {\r\n"
        		+ "        System.out.println(\"Even\");\r\n"
        		+ "    } else {\r\n"
        		+ "        System.out.println(\"Odd\");\r\n"
        		+ "    }\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Negative\");\r\n"
        		+ "    if (num % 2 == 0) {\r\n"
        		+ "        System.out.println(\"Even\");\r\n"
        		+ "    } else {\r\n"
        		+ "        System.out.println(\"Odd\");\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "", true, "6"));
        
        questions.add(new Question("int x = 15;\r\n"
        		+ "if (x % 2 == 0) {\r\n"
        		+ "    System.out.println(\"Even\");\r\n"
        		+ "    if (x > 10) {\r\n"
        		+ "        System.out.println(\"Greater than 10\");\r\n"
        		+ "    } else {\r\n"
        		+ "        System.out.println(\"Less than or equal to 10\");\r\n"
        		+ "        if (x % 3 == 0) {\r\n"
        		+ "            System.out.println(\"Divisible by 3\");\r\n"
        		+ "        } else {\r\n"
        		+ "            System.out.println(\"Not divisible by 3\");\r\n"
        		+ "        }\r\n"
        		+ "    }\r\n"
        		+ "} else {\r\n"
        		+ "    System.out.println(\"Odd\");\r\n"
        		+ "    if (x < 10) {\r\n"
        		+ "        System.out.println(\"Less than 10\");\r\n"
        		+ "        if (x % 5 == 0) {\r\n"
        		+ "            System.out.println(\"Divisible by 5\");\r\n"
        		+ "        } else {\r\n"
        		+ "            System.out.println(\"Not divisible by 5\");\r\n"
        		+ "        }\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "", false, "9"));
        
        
        for (Question question: questions) {
        	int lineCount = countLines(question.getQuestion());
        	question.setLineCount(lineCount);
        }
        
        
//        for (Question question : questions) {
//            int ifCount = countOccurrences(question.getQuestion(), "if");
//            int elseCount = countOccurrences(question.getQuestion(), "else");
//            question.setAnswer(String.valueOf(ifCount) + String.valueOf(elseCount));
//        }
        
        
        return questions;
    }
    
    private static int countLines(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        
        String[] lines = text.split("\r\n|\r|\n");
        return lines.length;
    }
    
    
    private static int countOccurrences(String text, String word) {
        int count = 0;
        int index = 0;
        while (index != -1) {
            index = text.indexOf(word, index);
            if (index != -1) {
                count++;
                index += word.length();
            }
        }
        return count;
    }

    
    
}
