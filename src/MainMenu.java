import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class MainMenu implements ActionListener
{
    private static MainMenu m = new MainMenu();
    private static CharacterMenu charMenu = new CharacterMenu();
    private MapMenu mapMenu;
    private static JFrame mainMenuGui;
    private static int confirm;

    public static void main(String args[])
    {
        menuGui();
        setWindowListener();
    }

    //Constructs the menu gui
    private static void menuGui()
    {
        mainMenuGui = new JFrame("Main Menu");
        mainMenuGui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainMenuGui.setSize(400,400);
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
        //Action Handlers to open the different menus
        if(s.equals("Character Menu"))
        {
            charMenu.openCharMenu();
        }

        if(s.equals("Map Menu"))
        {
            mapMenu = new MapMenu();
            mapMenu.openMapMenu();
        }
    }

    private static void setWindowListener()
    {
        WindowListener windowClosing = new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) { }

            @Override
            public void windowClosing(WindowEvent e)
            {
                if(!charMenu.isSaved())

                confirm = JOptionPane.showConfirmDialog(null, "Are you sure to exit? You have unsaved characters", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                System.out.println("Confirm Dialog: " + confirm);
                if (confirm == 0) {
                    System.exit(0);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) { }

            @Override
            public void windowIconified(WindowEvent e) { }

            @Override
            public void windowDeiconified(WindowEvent e) { }

            @Override
            public void windowActivated(WindowEvent e) { }

            @Override
            public void windowDeactivated(WindowEvent e) { }
        };
        mainMenuGui.addWindowListener(windowClosing);
    }
}
