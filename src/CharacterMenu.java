import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Character;
import java.util.LinkedList;

public class CharacterMenu implements ActionListener {

    //Creating the main gui window, and gui components
    private static JFrame guiWindow = new JFrame("Character Control");
    private static JMenuBar guiMenuBar = new JMenuBar();
    private static JMenu charList = new JMenu("Characters");
    private static JLabel charInfoLabel = new JLabel("");
    private static JPanel charInfo = new JPanel();
    //Creating an LinkedList to store character information
    public LinkedList<CharSheet> characters = new LinkedList<CharSheet>();
    //Creates an object of the character info input menu
    public CharInfoInput charInput = new  CharInfoInput();

    public CharacterMenu()
    {
        //Setting the properties of the JFrame window
        guiWindow.setSize(1000,800);
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
        addWizard.addActionListener(this);
        addSorcerer.addActionListener(this);
        addBarbarian.addActionListener(this);
        addRogue.addActionListener(this);
        addCleric.addActionListener(this);
        //Placing the menu bar on the JFrame, adding the dropdown menus to the menu bar and setting the JFrame to visible
        guiWindow.setJMenuBar(guiMenuBar);
        guiMenuBar.add(addChar);
        guiMenuBar.add(charList);
        //Adding character info display to the GUI
        charInfo.add(charInfoLabel);
        guiWindow.add(charInfo, BorderLayout.WEST);
    }// End menu constructor

    public void openCharMenu()
    {
        //This method is used by the Main Menu to open the Character Menu
        guiWindow.setVisible(true);
    }

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
                charInput.openCharInput();
                //Reads in character name from user --- TEMPORARY --- to be replaced with gui allowing all data to be input at once
                String charName = JOptionPane.showInputDialog("Enter Wizard Name");
                //Creates new Wizard --- TEMPORARY --- Currently using hard coded values, see above comment
                Wizard wizard = new Wizard(charName, "PlayerName", "Background", "Alignment", "Race", 5, 10, 12, 12, 18, 16, 14, 30, 20);
                characters.add(wizard);
                //Assigning charInfo string and charArrayPos int for storage in arrays to use to retrieve character info
                charInfo = (characters.size()) + " - Wizard - " + charName;
            }

            //If chosen class is Sorcerer
            if(s.equals("New Sorcerer"))
            {
                //Reads in character name from user --- TEMPORARY --- to be replaced with gui allowing all data to be input at once
                String charName = JOptionPane.showInputDialog("Enter Sorcerer Name");
                //Creates new Wizard --- TEMPORARY --- Currently using hard coded values, see above comment
                Sorcerer sorcerer = new Sorcerer(charName, "PlayerName", "Background", "Alignment", "Race", 5, 10, 12, 12, 18, 16, 14, 30, 20);
                characters.add(sorcerer);
                //Assigning charInfo string and charArrayPos int for storage in arrays to use to retrieve character info
                charInfo = (characters.size()) + " - Sorcerer - " + charName;
            }

            //Creating a new JMenuItem with the character info corresponding to the new character
            JMenuItem character = new JMenuItem(charInfo);
            //Adding the action listener to this new menu item
            character.addActionListener(this);
            //Adding the new menu item to the charList JMenu
            charList.add(character);
            //Repainting the window so the new character appears in the character list
            guiWindow.repaint();
        }

        //If button pressed starts with a digit (character return buttons all do)
        if(Character.isDigit(s.charAt(0)))
        {
            System.out.println(s);
            System.out.println("\nNumeric Value of Char : " + (Character.getNumericValue(s.charAt(0)) - 1));
            //Returns the position of the character in the characters array based on its button text
            int number = (Character.getNumericValue(s.charAt(0)) - 1);

            System.out.println("Char Array Size: " + characters.size());
            System.out.println("Char Name: " + characters.get(number).getCharName());
            //Sets text of the character info label
            charInfoLabel.setText(characters.get(number).toString());
            //Repaints the GUI window to account for the changes in the info label
            guiWindow.repaint();
        }
    }// End actionPerformed
}//End CharacterMenu