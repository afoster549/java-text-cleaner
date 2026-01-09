package ui;

import logic.TextCleaner;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

public class MainWindow extends JFrame {
    private final TextCleaner textCleaner;
    private JTextArea inputArea;
    private JTextArea outputArea;

    public MainWindow(TextCleaner textCleaner) {
        this.textCleaner = textCleaner;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Text Cleaner");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout(10, 10));

        // Input Area
        inputArea = new JTextArea();
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        inputArea.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { performCleaning(); }
            public void removeUpdate(DocumentEvent e) { performCleaning(); }
            public void changedUpdate(DocumentEvent e) { performCleaning(); }
        });

        JScrollPane inputScroll = new JScrollPane(inputArea);
        inputScroll.setBorder(BorderFactory.createTitledBorder("Input Text"));

        // Output Area
        outputArea = new JTextArea();
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setEditable(false);
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setBorder(BorderFactory.createTitledBorder("Cleaned Text"));

        // Split Pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, inputScroll, outputScroll);
        splitPane.setResizeWeight(0.5);
        add(splitPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        
        JButton clearButton = new JButton("Clear Text");
        clearButton.addActionListener(e -> inputArea.setText(""));
        
        JButton copyButton = new JButton("Copy Output");
        copyButton.addActionListener(e -> copyToClipboard());

        buttonPanel.add(clearButton);
        buttonPanel.add(copyButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void performCleaning() {
        String rawText = inputArea.getText();
        String cleanedText = textCleaner.clean(rawText);
        outputArea.setText(cleanedText);
    }

    private void copyToClipboard() {
        String text = outputArea.getText();
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }
}