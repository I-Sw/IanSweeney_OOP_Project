import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.lang.Character;

public class TestGui implements ActionListener {

    private static JFrame guiWindow = new JFrame("Test GUI");
    private static TestGui m = new TestGui();
    ArrayList<CharSheet> characters = new ArrayList<CharSheet>();
    private static JMenu charList = new JMenu("Characters");

    public static void main(String args[])
    {

        guiWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiWindow.setSize(1000,600);

        JMenuBar guiMenuBar = new JMenuBar();

        JMenu addChar = new JMenu("Add Character");
        JMenuItem addWizard = new JMenuItem("New Wizard");
        JMenuItem addSorcerer = new JMenuItem("New Sorcerer");
        JMenuItem addBarbarian = new JMenuItem("New Barbarian");
        JMenuItem addRogue = new JMenuItem("New Rogue");
        JMenuItem addCleric = new JMenuItem("New Cleric");
        addChar.add(addWizard);
        addChar.add(addSorcerer);
        addChar.add(addRogue);
        addChar.add(addBarbarian);
        addChar.add(addCleric);

        guiMenuBar.add(addChar);
        //guiWindow.setJMenuBar(guiMenuBar);
        //guiWindow.setVisible(true);



        addWizard.addActionListener(m);
        addSorcerer.addActionListener(m);
        addBarbarian.addActionListener(m);
        addRogue.addActionListener(m);
        addCleric.addActionListener(m);

        guiWindow.setJMenuBar(guiMenuBar);
        guiMenuBar.add(charList);
        guiWindow.setVisible(true);

        /*
        for(int i = 0; i < 3; i++)
        {
            String s = JOptionPane.showInputDialog("Enter Character Name");
            JMenuItem character = new JMenuItem(s);
            characters.add(character);
            charList.add(character);
        }

        guiMenuBar.add(charList);
        guiWindow.setJMenuBar(guiMenuBar);
        guiWindow.setVisible(true);

        for(int i = 0; i < characters.size(); i++)
        {

        }
        */

    }

    public void displayChar()
    {

    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        System.out.println(s);

        if(s.equals("New Wizard"))
        {
            String charName = JOptionPane.showInputDialog("Enter Wizard Name");
            Wizard wizard = new Wizard(charName, "PlayerName", "Background", "Alignment", "Race", 5, 10, 12, 12, 18, 16, 14, 30, 20);
            characters.add(wizard);
            JMenuItem character = new JMenuItem("[" + characters.size() + "] " + charName);
            character.addActionListener(m);
            charList.add(character);
            guiWindow.repaint();
        }

        if(s.charAt(0) == '[')
        {
            char num = s.charAt(1);
            System.out.println("num: " + num);
            int number = (Character.getNumericValue(num) - 1);
            System.out.println("number: " + number);
            //JOptionPane.showMessageDialog(null,((characters.get(number)).toString()),"Character Info",JOptionPane.INFORMATION_MESSAGE);
            JFrame charInfoOutput = new JFrame("Character Info");
            JLabel charInfo = new JLabel((characters.get(number)).toString());
            charInfoOutput.setSize(300,500);
            charInfoOutput.add(charInfo);
            charInfoOutput.setVisible(true);
        }
    }
}
