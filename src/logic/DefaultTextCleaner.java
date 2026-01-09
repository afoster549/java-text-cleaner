package logic;

public class DefaultTextCleaner implements TextCleaner {
    @Override
    public String clean(String input) {
        if (input == null) return "";
        
        String text = input.replaceAll("(?m)^Highlight . Page \\d+.*$", "");
        
        text = text.replaceAll("\\n{3,}", "\n\n");
        
        return text.trim();
    }
}