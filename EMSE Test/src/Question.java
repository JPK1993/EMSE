public class Question {
    private String question;
    private boolean enableFormatting;
    private String answer = "0";
    private int lineCount;
    private int textSize;
    private boolean indented;

//    public Question(String question, boolean enableFormatting, String answer) {
//        this.question = question;
//        this.enableFormatting = enableFormatting;
//        this.answer = answer;
//    }
    
    public Question(String question, boolean enableFormatting, boolean indented) {
        this.question = question;
        this.enableFormatting = enableFormatting;
        this.indented = indented;
    }
    

    public String getQuestion() {
    	
        return question;
    }

    public boolean isEnableFormatting() {
        return enableFormatting;
    }
    
    public void setAnswer(String answer) {
    	this.answer = answer;
    }
    
    public String getAnswer() {
    	return answer;
    }
    
    public int getLineCount() {
    	return lineCount;
    }
    
    public void setLineCount(int lineCount) {
    	this.lineCount = lineCount;
    }
    
    public int gettextSize() {
    	return textSize;
    }
    
    public void settextSize(int textSize) {
    	this.textSize = textSize;
    }
    
    public boolean getindented() {
    	return indented;
    }
    
    public void setindented(boolean indented) {
    	this.indented = indented;
    }
    
}

