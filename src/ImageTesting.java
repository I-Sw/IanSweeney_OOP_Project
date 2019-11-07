import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class ImageTesting {
    private static JFrame GUIwindow = new JFrame("IMAGE TESTING");
    private int mouseX = 0;
    private int mouseY = 0;

    public static void main(String args[]) {
        //JLayeredPane GUI = new JLayeredPane();
        JPanel GUI = new JPanel();
        GUI.setLayout(new OverlayLayout(GUI));
        JScrollPane scrollBar = new JScrollPane(GUI, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        GUIwindow.add(scrollBar);

        //GUI.add(scrollBar);
        //GUIwindow.add(GUI);


        java.net.URL battlemapUrl = TestGui.class.getResource("images/battlemap.jpg");
        ImageIcon battlemap = new ImageIcon(battlemapUrl);

        JLabel battlemapLabel = new JLabel(battlemap);
        battlemapLabel.setBounds(0, 0, battlemap.getIconWidth(), battlemap.getIconHeight());

        GUIwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUIwindow.setSize(battlemap.getIconWidth(), battlemap.getIconHeight());
        GUIwindow.setVisible(true);

        GUI.add(battlemapLabel, -1);

        GUIwindow.repaint();

        java.net.URL imgUrl = TestGui.class.getResource("images/Paladin.png");
        ImageIcon image = new ImageIcon(imgUrl);

        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(0, 0, 250, 250);
        System.out.println(image.getIconHeight());

        GUI.add(imageLabel, 0);
        GUI.repaint();
        imageLabel.setVisible(true);
    }
}