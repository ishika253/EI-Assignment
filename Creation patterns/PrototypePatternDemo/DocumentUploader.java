import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class DocumentUploader extends JFrame {
    private JTextArea originalTextArea;
    private JTextArea clonedTextArea;
    private JButton uploadButton, cloneButton;

    public DocumentUploader() {
        setTitle("Document Cloning System");

        // Original document area
        originalTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane1 = new JScrollPane(originalTextArea);
        originalTextArea.setEditable(false);

        // Cloned document area
        clonedTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane2 = new JScrollPane(clonedTextArea);
        clonedTextArea.setEditable(false);

        // Buttons for upload and clone actions
        uploadButton = new JButton("Upload Document");
        cloneButton = new JButton("Clone Document");

        // Panel for arranging components
        JPanel panel = new JPanel();
        panel.add(uploadButton);
        panel.add(cloneButton);
        panel.add(scrollPane1);
        panel.add(scrollPane2);

        // Add action listeners to buttons
        uploadButton.addActionListener(new UploadButtonListener());
        cloneButton.addActionListener(new CloneButtonListener());

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    // Action listener for uploading a document
    class UploadButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    originalTextArea.read(reader, null);  // Display file content in original document area
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Action listener for cloning the document
    class CloneButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String originalContent = originalTextArea.getText();
            if (!originalContent.isEmpty()) {
                // Cloning the content (you can modify this logic)
                String clonedContent = originalContent + "\n\n(Cloned Document)";
                clonedTextArea.setText(clonedContent);  // Display cloned content in cloned document area
            }
        }
    }

    public static void main(String[] args) {
        new DocumentUploader();
    }
}
