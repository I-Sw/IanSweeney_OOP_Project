import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.lang.Character;

public class CharacterMenu implements ActionListener {

    //Creating the main gui window, character menu (for action listener) and character list menu dropdown
    private static JFrame guiWindow = new JFrame("Character Control");
    private static CharacterMenu m = new CharacterMenu();
    private static JMenu charList = new JMenu("Characters");
    private static JLabel charInfo = new JLabel("");
    //Creates a list of strings for storing character names and classes for retrieval from the following Array
    ArrayList<String> characters = new ArrayList<String>();
    //Creating a list and counter for storing Wizard characters
    ArrayList<Wizard> wizards = new ArrayList<Wizard>();
    private static int numWizards;


    public static void main(String args[])
    {
        //Setting the properties of the JFrame window
        guiWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiWindow.setSize(1000,800);
        //Creating a new JMenuBar
        JMenuBar guiMenuBar = new JMenuBar();
        //Creating an "Add Character" menu dropdown
        JMenu addChar = new JMenu("Add Character");
        //Creating menu items for the dropdown
        JMenuItem addWizard = new JMenuItem("New Wizard");
        JMenuItem addSorcerer = new JMenuItem("New Sorcerer");
        JMenuItem addBarbarian = new JMenuItem("New Barbarian");
        JMenuItem addRogue = new JMenuItem("New Rogue");
        JMenuItem addCleric = new JMenuItem("New Cleric");
        //Adding the items to the dropdown menu
        addChar.add(addWizard);
        addChar.add(addSorcerer);
        addChar.add(addRogue);
        addChar.add(addBarbarian);
        addChar.add(addCleric);
        //Adding the action listener to the dropdown items
        addWizard.addActionListener(m);
        addSorcerer.addActionListener(m);
        addBarbarian.addActionListener(m);
        addRogue.addActionListener(m);
        addCleric.addActionListener(m);
        //Placing the menu bar on the JFrame, adding the dropdown menus to the menu bar and setting the JFrame to visible
        guiWindow.setJMenuBar(guiMenuBar);
        guiMenuBar.add(addChar);
        guiMenuBar.add(charList);
        //Adding character info display to the GUI
        charInfo.setBounds(10,0, 300,800);
        guiWindow.add(charInfo);
        guiWindow.setLayout(null);
        guiWindow.setVisible(true);
    }// End main

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        System.out.println(s);

        //If button pressed is "New Wizard"...
        if(s.equals("New Wizard"))
        {
            //Reads in character name from user --- TEMPORARY - to be replaced with gui allowing all data to be input at once
            String charName = JOptionPane.showInputDialog("Enter Wizard Name");
            //Creates new Wizard --- TEMPORARY - Currently using hard coded values, see above comment
            Wizard wizard = new Wizard(charName, "PlayerName", "Background", "Alignment", "Race", 5, 10, 12, 12, 18, 16, 14, 30, 20);
            wizards.add(wizard);
            //Creating charInfo string to store character name and class which is added to the character list for character retrieval
            String charInfo = (characters.size() + 1 ) + " - Wizard - " + charName;
            characters.add(charInfo);
            //Creating a new JMenuItem with the character info corresponding to the new character
            JMenuItem character = new JMenuItem(charInfo);
            //Adding the action listener to this new menu item
            character.addActionListener(m);
            //Adding the new menu item to the charList JMenu
            charList.add(character);
            //Repainting the window so the new character appears in the character list
            guiWindow.repaint();
        }

        if(Character.isDigit(s.charAt(0)))
        {
            charInfo.setText("");
            System.out.println("Character Chosen");
            char num = s.charAt(0);
            System.out.println("num: " + num);
            int number = (Character.getNumericValue(num) - 1);
            charInfo.setText((wizards.get(number)).toString());
            charInfo.setBounds(10,0, 300,800);
            guiWindow.add(charInfo);
            guiWindow.setLayout(null);
            guiWindow.repaint();
        }
    }// End actionPerformed
}//End CharacterMenu