import java.util.ArrayList;
import java.util.List;

public class EMSEQuestions {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("public class HelloWorld {\r\n"
                + "    public static void main(String[] args) {\r\n"
                + "        System.out.println(\"Hello, World!\");\r\n"
                + "    }\r\n"
                + "}\r\n"
                + "", true));

        questions.add(new Question("public class Foo {\r\n"
                + "    public static void main(String[] args) {\r\n"
                + "        int x = 5;\r\n"
                + "        int y = 10;\r\n"
                + "        int sum = x + y;\r\n"
                + "        System.out.println(\"Sum: \" + sum);\r\n"
                + "    }\r\n"
                + "}\r\n"
                + "", false));

        questions.add(new Question("public class Bar {\r\n"
                + "    public static void main(String[] args) {\r\n"
                + "        String message = \"Hello, World!\";\r\n"
                + "        System.out.println(message);\r\n"
                + "    }\r\n"
                + "}\r\n"
                + "", true));

        return questions;
    }

    public static List<String> getAnswers() {
        List<String> answers = new ArrayList<>();

        answers.add("5");
        answers.add("7");
        answers.add("3");

        return answers;
    }
}
