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
    private static JPanel charInfo = new JPanel();
    private static JLabel charInfoLabel = new JLabel("");
    //Creating an LinkedList to store character information
    public LinkedList<CharSheet> characters = new LinkedList<CharSheet>();
    //Creates an object of the character info input menu
    public CharInfoInput charInput = new  CharInfoInput();
    //Creates variables for character info input
    private String charClass="";
    private String charName="";
    private String playerName="";
    private String background="";
    private String alignment="";
    private String race="";
    private int level=0;
    private int strength=0;
    private int dexterity=0;
    private int constitution=0;
    private int intelligence=0;
    private int wisdom=0;
    private int charisma=0;
    private int moveSpeed=0;
    private int maxHP=0;

    public CharacterMenu()
    {
        //Setting the properties of the JFrame window
        guiWindow.setSize(1000,800);
        //Creating an "Add Character" menu dropdown
        JMenuItem addChar = new JMenuItem("New Character");
        //Adding the action listener to the menu
        addChar.addActionListener(this);
        //Placing the menu bar on the JFrame, adding the dropdown menus to the menu bar and setting the JFrame to visible
        guiWindow.setJMenuBar(guiMenuBar);
        guiMenuBar.add(charList);
        guiMenuBar.add(addChar);
        //Adding character info display to the GUI
        charInfo.add(charInfoLabel);
        guiWindow.add(charInfo, BorderLayout.WEST);
        //Creates a confirm button to add to the hidden character input menu
        JButton confirmButton = new JButton("Confirm Character Input");
        //Adds action listener to this button
        confirmButton.addActionListener(this);
        //Adds character input panel to the GUI
        guiWindow.add(charInput);
        //Adds the confirm button onto the character menu panel
        charInput.addConfirmButton(confirmButton);

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
        System.out.println(s);
        //If button pressed is to add a new character
        if(s.equals("New Character"))
        {
            //Opens the charInput gui panel
            charInput.openCharInput();
        }

        //If button pressed starts with a digit (character return buttons all do)
        if(Character.isDigit(s.charAt(0)))
        {
            //Returns the position of the character in the characters array based on its button text
            int number = (Character.getNumericValue(s.charAt(0)) - 1);
            //Sets text of the character info label
            charInfoLabel.setText(characters.get(number).toString());
            //Repaints the GUI window to account for the changes in the info label
            guiWindow.repaint();
        }

        //If button pressed is to confirm character info input
        if(s.equals("Confirm Character Input"))
        {
            //Action handling for when the user confirms character input on the character input box
            //Creates variables for storing inputted values
            charClass = charInput.getCharClass();
            charName = "";
            playerName = "";
            background = "";
            alignment = "";
            race = "";
            level = 0;
            strength = 0;
            dexterity = 0;
            constitution = 0;
            intelligence = 0;
            wisdom = 0;
            charisma = 0;
            moveSpeed = 0;
            maxHP = 0;

            //Creates the charInfo string to add to the character menu dropdown
            String charInfo = (characters.size()) + " - " + charClass + " - " + charName;
            //If statement handling for different character classes
            if(charClass.equals("Wizard"))
            {
                Wizard wizard = new Wizard(charName, playerName, background, alignment, race, level, strength, dexterity, constitution, intelligence, wisdom, charisma, moveSpeed, maxHP);
                characters.add(wizard);
                //Assigning charInfo string and charArrayPos int for storage in arrays to use to retrieve character info
                charInfo = (characters.size()) + " - Wizard - " + charName;
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
    }// End actionPerformed
}//End CharacterMenu