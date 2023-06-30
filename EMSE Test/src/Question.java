public class Question {
    private String question;
    private boolean enableFormatting;
    private String answer = "0";
    private int lineCount;
    private boolean indented;

    //Beim erzeugen des Objekts weden Antwort und Linecount automatisch berechnet, Indentation muss manuell gesetzt und durchgeführt werden!
    //Der indentation-wert im Objekt dient also nur zur statistischen Auswertung

    public Question(String question, boolean enableFormatting, boolean indented) {
        this.question = question;
        this.enableFormatting = enableFormatting;
        this.indented = indented;
    }
    
    //Getter + Setter:
    
    //Question: Frage-String
    
    public void setQuestions(String question) {
    	this.question = question;
    }
    
    public String getQuestion() {
        return question;
    }
    
    //Highlighting: Flag für das automatische Highlighting (an oder aus) durch RSyntaxTextArea
    
    public void setEnableFormatting(boolean enableFormatting) {
    	this.enableFormatting = enableFormatting;
    }

    public boolean isEnableFormatting() {
        return enableFormatting;
    }
    
    //Answer: Antwort zur Frage (zwischen 0 und 9) Wird automatisch für alle Fragen berechnet und in die Variable eingetragen.
    
    public void setAnswer(String answer) {
    	this.answer = answer;
    }
    
    public String getAnswer() {
    	return answer;
    }
    
    //LineCount: Zeilenanzahl des Code-Bruchstücks der Fragestellung. Wird automatisch für alle Fragen berechnet und ins Objekt eingetragen.
    
    public int getLineCount() {
    	return lineCount;
    }
    
    public void setLineCount(int lineCount) {
    	this.lineCount = lineCount;
    }
    
    //Indentation: Flag zum anzeigen der Einrückung zur späteren statistischen Auswertung. Muss von Hand gesetzt werden.
    
    
    public boolean getindented() {
    	return indented;
    }
    
    public void setindented(boolean indented) {
    	this.indented = indented;
    }
    
}

