package hangman;

import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ZeroToNineVerifier extends InputVerifier {
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
            Integer num = Integer.parseInt(text);
            return (num <= 9 && num >= 1);
        } catch(NumberFormatException e) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
            "Enter a number 1-9",
            "Text error",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}