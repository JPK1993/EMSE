import java.util.ArrayList;
import java.util.List;

public class EMSEQuestions {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

       // questions.add(new Question("FRAGE", true/false für Syntax Highlighting, "ANTWORT"));
        
        questions.add(new Question("int countIf = 0;\r\n"
        		+ "int countElse = 0;\r\n"
        		+ "\r\n"
        		+ "for (int i = 0; i < 10; i++) {\r\n"
        		+ "    if (i % 2 == 0) {\r\n"
        		+ "        countIf++;\r\n"
        		+ "    } else {\r\n"
        		+ "        countElse++;\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "System.out.println(\"Count of 'if': \" + countIf);\r\n"
        		+ "System.out.println(\"Count of 'else': \" + countElse);\r\n"
        		+ "", true, "3"));
    
        questions.add(new Question("int countIf = 0;\r\n"
        		+ "int countElse = 0;\r\n"
        		+ "\r\n"
        		+ "for (int i = 0; i < 10; i++) {\r\n"
        		+ "    if (i % 2 == 0) {\r\n"
        		+ "        countIf++;\r\n"
        		+ "    } else {\r\n"
        		+ "        countElse++;\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "System.out.println(\"Count of 'if': \" + countIf);\r\n"
        		+ "System.out.println(\"Count of 'else': \" + countElse);\r\n"
        		+ "", false, "3"));
       
        
        return questions;
    }
}
