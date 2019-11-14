import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Character;
import java.util.LinkedList;

public class CharacterMenu implements ActionListener {
    //Creating the main gui window, and gui components
    private static JFrame guiWindow;
    private static JMenuBar guiMenuBar;
    private static JMenu charList;
    private static JPanel charInfo;
    private static JLabel charInfoLabel;
    //Creating an LinkedList to store character information
    public LinkedList<CharSheet> characters;
    //Creates an object of the character info input menu
    public CharInfoInput charInput;
    //Creates variables for character info input
    private String charClass;
    private String charName;
    private String playerName;
    private String background;
    private String alignment;
    private String race;
    private int level;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int moveSpeed;
    private int maxHP;

    public CharacterMenu()
    {
        guiWindow = new JFrame("Character Control");
        guiMenuBar = new JMenuBar();
        charList = new JMenu("Character List");
        charInfo = new JPanel();
        charInfoLabel = new JLabel("");
        characters = new LinkedList<>();
        charInput = new  CharInfoInput();
        //Setting the properties of the JFrame window
        guiWindow.setSize(1000,800);
        //Creating a menu for character control as well as Add and Remove Character dropdown items
        JMenu characterMenu = new JMenu("Add/Remove Characters");
        JMenuItem addChar = new JMenuItem("New Character");
        JMenuItem removeChar = new JMenuItem("Remove Character");
        characterMenu.add(addChar);
        characterMenu.add(removeChar);
        //Adding the action listener to the menu
        addChar.addActionListener(this);
        removeChar.addActionListener(this);
        //Placing the menu bar on the JFrame, adding the dropdown menus to the menu bar and setting the JFrame to visible
        guiWindow.setJMenuBar(guiMenuBar);
        guiMenuBar.add(characterMenu);
        guiMenuBar.add(charList);
        //Adding character info display to the GUI
        charInfo.add(charInfoLabel);
        guiWindow.add(charInfo, BorderLayout.WEST);
        //Creates a confirm button to add to the hidden character input menu
        JButton confirmButton = new JButton("Confirm Character Input");
        //Adds action listener to this button
        confirmButton.addActionListener(this);
        //Adds character input panel to the GUI
        guiWindow.add(charInput.getGUI());
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
            System.out.println("Entered New Char if");
            //Opens the charInput gui panel
            charInput.openCharInput();
        }

        //If button pressed starts with a digit (character return buttons all do)
        if(Character.isDigit(s.charAt(0)))
        {
            //Returns the position of the character in the characters array based on its button text
            int number = (Character.getNumericValue(s.charAt(0)) - 1);
            System.out.println("Num: " + number);
            //Sets text of the character info label
            charInfoLabel.setText(characters.get(number).toString());
            JOptionPane.showMessageDialog(null,characters.get(number).getCharName());
            //Repaints the GUI window to account for the changes in the info label
            guiWindow.repaint();
        }

        //If button pressed is to confirm character info input
        if(s.equals("Confirm Character Input"))
        {
            //Action handling for when the user confirms character input on the character input box
            //Validates that numerical values are inputted as whole numbers
            if(validateChar(charInput.getCharClass(), charInput.getCharName(), charInput.getPlayerName(), charInput.getBackground(), charInput.getAlignment(),
                            charInput.getRace(), charInput.getLevel(), charInput.getStrength(), charInput.getDexterity(), charInput.getConstitution(),
                            charInput.getIntelligence(), charInput.getWisdom(), charInput.getCharisma(), charInput.getMoveSpeed(), charInput.getMaxHP()))
            {
                //Stores inputted data in variables
                charClass = charInput.getCharClass();
                charName =  charInput.getCharName();
                playerName =  charInput.getPlayerName();
                background =  charInput.getBackground();
                alignment =  charInput.getAlignment();
                race =  charInput.getRace();
                level =  Integer.parseInt(charInput.getLevel());
                strength = Integer.parseInt(charInput.getStrength());
                dexterity = Integer.parseInt(charInput.getDexterity());
                constitution = Integer.parseInt(charInput.getConstitution());
                intelligence = Integer.parseInt(charInput.getIntelligence());
                wisdom = Integer.parseInt(charInput.getWisdom());
                charisma = Integer.parseInt(charInput.getCharisma());
                moveSpeed = Integer.parseInt(charInput.getMoveSpeed());
                maxHP = Integer.parseInt(charInput.getMaxHP());

                //Creates the charInfo string to add to the character menu dropdown
                String charInfoString = (characters.size()) + 1 + " - " + charClass + " - " + charName;
                //If statement handling for different character classes
                if(charClass.equals("Wizard"))
                {
                    Wizard wizard = new Wizard(charName, playerName, background, alignment, race, level, strength, dexterity, constitution, intelligence, wisdom, charisma, moveSpeed, maxHP);
                    characters.add(wizard);
                    //Assigning charInfo string and charArrayPos int for storage in arrays to use to retrieve character info
                }

                //Creating a new JMenuItem with the character info corresponding to the new character
                JMenuItem character = new JMenuItem(charInfoString);
                //Adding the action listener to this new menu item
                character.addActionListener(this);
                //Adding the new menu item to the charList JMenu
                charList.add(character);
                //Repainting the window so the new character appears in the character list
                guiWindow.repaint();
            }

            else
                JOptionPane.showMessageDialog(null,"Invalid Data! - Ensure you have a value in every box and have put numeric values where required","Invalid Data Entered",JOptionPane.ERROR_MESSAGE);
        }
    }// End actionPerformed

    public boolean validateChar(String cClass, String cName, String pName, String background, String alignment,
                                String race, String level, String strength, String dexterity, String constitution,
                                String intelligence, String  wisdom, String charisma, String moveSpeed, String maxHP)
    {
        if(!cClass.equals("") && !cName.equals("") && !pName.equals("") && !background.equals("") && !alignment.equals("") && !race.equals(""))
        {
            try{
                int check;
                check = Integer.parseInt(level);
                check = Integer.parseInt(strength);
                check = Integer.parseInt(dexterity);
                check = Integer.parseInt(constitution);
                check = Integer.parseInt(intelligence);
                check = Integer.parseInt(wisdom);
                check = Integer.parseInt(charisma);
                check = Integer.parseInt(moveSpeed);
                check = Integer.parseInt(maxHP);
                return true;
            }
            catch (NumberFormatException numException) {
                return false;
            }
        }
        else
            return false;
    }
}//End CharacterMenu