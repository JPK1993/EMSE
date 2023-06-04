public class Question {
    private String question;
    private boolean enableFormatting;
    private String answer;

    public Question(String question, boolean enableFormatting, String answer) {
        this.question = question;
        this.enableFormatting = enableFormatting;
        this.answer = answer;
    }

    public String getQuestion() {
    	
        return question;
    }

    public boolean isEnableFormatting() {
        return enableFormatting;
    }
    
    public String getAnswer() {
    	return answer;
    }
    
}

