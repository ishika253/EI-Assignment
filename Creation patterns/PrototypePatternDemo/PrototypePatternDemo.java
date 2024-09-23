public class PrototypePatternDemo {
    public static void main(String[] args) {
        // Create the original document
        TextDocument originalDoc = new TextDocument("Original Document", "This is the original content.");
        System.out.println("Original Document:");
        originalDoc.printDetails();

        // Clone the document and make modifications
        TextDocument clonedDoc = (TextDocument) originalDoc.clone();
        clonedDoc.setTitle("Cloned Document");
        clonedDoc.setContent("This is the modified content of the cloned document.");

        // Display cloned document details
        System.out.println("\nCloned Document:");
        clonedDoc.printDetails();
    }
}
