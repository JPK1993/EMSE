public class Question {
    private String question;
    private boolean enableFormatting;

    public Question(String question, boolean enableFormatting) {
        this.question = question;
        this.enableFormatting = enableFormatting;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isEnableFormatting() {
        return enableFormatting;
    }
}

