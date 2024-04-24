import javax.swing.*;

public class MyFrame extends JFrame {
    MyPanel panel;

    public MyFrame() {
        panel = new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Ensure GUI instantiation is done on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}
