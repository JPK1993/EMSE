import java.util.ArrayList;
import java.util.List;

public class EMSEQuestions {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

       // questions.add(new Question("FRAGE", true, "ANTWORT"));
        
        questions.add(new Question("// Syntax Highlighting Enabled\r\n"
        		+ "int count = 0;\r\n"
        		+ "for (int i = 0; i < 10; i++) {\r\n"
        		+ "    if (i % 2 == 0) {\r\n"
        		+ "        count++;\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "System.out.println(\"Count of even numbers: \" + count);\r\n"
        		+ "", true, "3"));
    
        questions.add(new Question("// Syntax Highlighting Disabled\r\n"
        		+ "int count = 0;\r\n"
        		+ "for (int i = 0; i < 10; i++) {\r\n"
        		+ "    if (i % 2 == 0) {\r\n"
        		+ "        count++;\r\n"
        		+ "    }\r\n"
        		+ "}\r\n"
        		+ "System.out.println(\"Count of even numbers: \" + count);\r\n"
        		+ "", false, "3"));
        
    
        return questions;
    }

//    public static List<String> getAnswers() {
//        List<String> answers = new ArrayList<>();
//        
//        //answers.add("1");
//
//        answers.add("2");
//        answers.add("2");
//       
//        return answers;
//    }
}
