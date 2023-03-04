class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords = {};
    SpamAnalyzer(String[] keywords){
        this.keywords = keywords;
    }
    public String[] getKeywords() {
        return keywords;
    }
    public Label getLabel() {
        return Label.SPAM;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords = {":(", "=(", ":|"};
    public String[] getKeywords() { return keywords; }
    public Label getLabel() { return Label.NEGATIVE_TEXT; }
}

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;
    TooLongTextAnalyzer(int maxLength){
        this.maxLength = maxLength;
    }

    public Label processText(String text) {
        if (text.length() > maxLength){
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}