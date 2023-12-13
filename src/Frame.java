import java.awt.*;
import javax.swing.*;
public class Frame extends JFrame{
    ScreenPanel panel;

    Frame(){
        panel = new ScreenPanel();
        this.add(panel);
        this.setTitle("Java 3D Engine");
        this.setBackground(Color.black);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
