abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract protected String[] getKeywords();
    abstract protected Label getLabel();
    private String text;
    public Label processText(String text){
        for (String keyword : getKeywords()){
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}
