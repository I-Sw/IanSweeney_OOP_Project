import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu implements ActionListener
{
    private static MainMenu m = new MainMenu();
    private static CharacterMenu charMenu = new CharacterMenu();

    public static void main(String args[])
    {
        menuGui();
    }
    private static void menuGui()
    {
        JFrame mainMenuGui = new JFrame("Main Menu");
        mainMenuGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuGui.setSize(300,100);
        mainMenuGui.setLayout(new FlowLayout());
        JButton charMenuButton = new JButton("Character Menu");
        charMenuButton.addActionListener(m);
        mainMenuGui.add(charMenuButton);
        JButton mapMenuButton = new JButton("Map Menu");
        mapMenuButton.addActionListener(m);
        mainMenuGui.add(mapMenuButton);
        mainMenuGui.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        //Returning a String from the ActionEvent to find which button was pressed
        String s = e.getActionCommand();

        if(s.equals("Character Menu"))
        {
            charMenu.openCharMenu();
        }
    }
}
