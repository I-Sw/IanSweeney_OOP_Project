import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.lang.Character;

public class CharacterMenu implements ActionListener {

    //Creating the main gui window, character menu (for action listener) and character list menu dropdown
    private static JFrame guiWindow = new JFrame("Character Control");
    private static CharacterMenu m = new CharacterMenu();
    private static JMenu charList = new JMenu("Characters");
    private static JLabel charInfoLabel = new JLabel("");
    private static JPanel charInfo = new JPanel();
    //Creates ArrayLists for storing  and returning character info
    ArrayList<String> characters = new ArrayList<String>();
    ArrayList<Integer> charArrayPos = new ArrayList<Integer>();
    //Creating lists for storing characters by type
    //Wizard characters
    ArrayList<Wizard> wizards = new ArrayList<Wizard>();
    //Sorcerer characters
    ArrayList<Sorcerer> sorcerers = new ArrayList<Sorcerer>();



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
        charInfo.add(charInfoLabel);
        guiWindow.add(charInfo, BorderLayout.WEST);
        guiWindow.setVisible(true);
    }// End main

    public void actionPerformed(ActionEvent e)
    {
        //Returning a String from the ActionEvent to find which button was pressed
        String s = e.getActionCommand();
        System.out.println(s.substring(0,3));
        //If button pressed is to add a new character
        if(s.substring(0,3).equals("New"))
        {
            //Creating charInfo string for later use
            String charInfo = "";

            //If chosen class is Wizard
            if(s.equals("New Wizard"))
            {
                //Reads in character name from user --- TEMPORARY --- to be replaced with gui allowing all data to be input at once
                String charName = JOptionPane.showInputDialog("Enter Wizard Name");
                //Creates new Wizard --- TEMPORARY --- Currently using hard coded values, see above comment
                Wizard wizard = new Wizard(charName, "PlayerName", "Background", "Alignment", "Race", 5, 10, 12, 12, 18, 16, 14, 30, 20);
                wizards.add(wizard);
                //Assigning charInfo string and charArrayPos int for storage in arrays to use to retrieve character info
                charInfo = (characters.size() + 1 ) + " - Wizard - " + charName;
                charArrayPos.add(wizards.size()-1);
            }

            //If chosen class is Sorcerer
            if(s.equals("New Sorcerer"))
            {
                //Reads in character name from user --- TEMPORARY --- to be replaced with gui allowing all data to be input at once
                String charName = JOptionPane.showInputDialog("Enter Sorcerer Name");
                //Creates new Wizard --- TEMPORARY --- Currently using hard coded values, see above comment
                Sorcerer sorcerer = new Sorcerer(charName, "PlayerName", "Background", "Alignment", "Race", 5, 10, 12, 12, 18, 16, 14, 30, 20);
                sorcerers.add(sorcerer);
                //Assigning charInfo string and charArrayPos int for storage in arrays to use to retrieve character info
                charInfo = (characters.size() + 1 ) + " - Sorcerer - " + charName;
                charArrayPos.add(sorcerers.size()-1);
            }

            //Adding charInfo the the characters arrayList
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

        //If button pressed starts with a digit (character return buttons all do)
        if(Character.isDigit(s.charAt(0)))
        {
            //Returns the position of the character in the characters array based on its button text
            int number = (Character.getNumericValue(s.charAt(0)) - 1);
            //Uses a for loop which searches through the characters of the string s to return the charClass using a substring
            String charClass = "";
            for(int i=4; i < s.length(); i++)
            {
                if(s.charAt(i) == '-')
                    charClass = s.substring(4,i-1);
            }
            //Using the new charClass string to decide which specific constructor should be called
            //Constructing a wizard
            if(charClass.equals("Wizard"))
                charInfoLabel.setText((wizards.get(charArrayPos.get(number))).toString());
            //Constructing a sorcerer
            if(charClass.equals("Sorcerer"))
                charInfoLabel.setText((sorcerers.get(charArrayPos.get(number))).toString());

            guiWindow.repaint();
        }
    }// End actionPerformed
}//End CharacterMenu