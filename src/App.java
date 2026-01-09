import javax.swing.SwingUtilities;
import logic.DefaultTextCleaner;
import logic.TextCleaner;
import ui.MainWindow;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            TextCleaner cleaner = new DefaultTextCleaner();
            MainWindow window = new MainWindow(cleaner);
            window.setVisible(true);
        });
    }
}
