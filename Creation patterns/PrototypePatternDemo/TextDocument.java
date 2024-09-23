public class TextDocument implements Document {
    private String title;
    private String content;

    public TextDocument(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public Document clone() {
        try {
            return (TextDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Document Title: " + title);
        System.out.println("Content: " + content);
    }

    // Setter for content to allow modifying cloned content
    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
