import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.Character;
import java.util.ArrayList;

public class CharacterMenu implements ActionListener, Serializable{
    //Creating the main gui window, and gui components
    private static JFrame guiWindow;
    private static JMenuBar guiMenuBar;
    private static JMenu charList;
    private static JPanel charInfo;
    private static JLabel charInfoLabel;
    //Creating an LinkedList to store character information
    public ArrayList<CharSheet> characters;
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

    //Constructs the menu
    public CharacterMenu()
    {
        guiWindow = new JFrame("Character Control");
        guiMenuBar = new JMenuBar();
        charList = new JMenu("Character List");
        charInfo = new JPanel();
        charInfoLabel = new JLabel("");
        characters = new ArrayList<>();
        charInput = new  CharInfoInput();

        //Setting the properties of the JFrame window
        guiWindow.setSize(800,800);
        guiWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //Creating a menu for character control
        JMenu characterMenu = new JMenu("Add/Remove Characters");
        JMenuItem loadChar = new JMenuItem("Load Saved Characters");
        JMenuItem addChar = new JMenuItem("New Character");
        JMenuItem removeChar = new JMenuItem("Remove Character");
        JMenuItem saveCharList = new JMenuItem("Save Characters");
        saveCharList.addActionListener(this);
        characterMenu.add(loadChar);
        characterMenu.add(addChar);
        characterMenu.add(removeChar);
        //Adding the action listener to the menu
        addChar.addActionListener(this);
        removeChar.addActionListener(this);
        loadChar.addActionListener(this);
        //Placing the menu bar on the JFrame, adding the dropdown menus to the menu bar and setting the JFrame to visible
        guiWindow.setJMenuBar(guiMenuBar);
        guiMenuBar.add(characterMenu);
        guiMenuBar.add(charList);
        guiMenuBar.add(saveCharList);
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

    //This method is used by the Main Menu to open the Character Menu
    public void openCharMenu()
    {

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

            //TEMPORARY CODE - Testing toString problems by returning all array values
            String names = "";
            for(int i = 0; i < characters.size(); i++)
            {
                names += (characters.get(i).getCharName() + " - ");
            }
            System.out.println("List contents: " + names);
            //TEMPORARY CODE

            //Repaints the GUI window to account for the changes in the info label
            guiWindow.repaint();
        }

        if(s.equals("Save Characters"))
        {
            try{
                ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(new File("charStorage.dat")));
                objectOut.writeObject(characters);
                objectOut.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error! Characters were unable to be saved, please try again","Error Saving Characters",JOptionPane.ERROR_MESSAGE);
            }
        }

        if(s.equals("Load Saved Characters"))
        {
            try{
                ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(new File("charStorage.dat")));
                characters = (ArrayList<CharSheet>) objectIn.readObject();
                objectIn.close();

                System.out.println(characters.get(0).getCharName());

                int charCounter = 0;
                System.out.println("Array Size: " + characters.size());
                charList.removeAll();
                for (int i = 0; i < characters.size(); i++)
                {
                    System.out.println("i " + i);
                    //This enhanced for loop takes loaded characters and re-adds them to the JMenu
                    //Creates a string with character info to base the menu item off of
                    String charInfoString = (i + 1) + " - " + characters.get(i).getCharClass() + " - " + characters.get(i).getCharName();
                    //Creates a JMenuItem from the previously created string
                    JMenuItem newCharacter = new JMenuItem(charInfoString);
                    //Adding the action listener to this new menu item
                    newCharacter.addActionListener(this);
                    //Adding the new menu item to the charList JMenu
                    charList.add(newCharacter);
                }
            }
            catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error! Characters were unable to be loaded, please try again","Error Saving Characters",JOptionPane.ERROR_MESSAGE);
            }
        }

        //If button pressed is to confirm character info input
        if(s.equals("Confirm Character Input"))
        {
            //Action handling for when the user confirms character input on the character input box
            //Validates that numerical values are inputted as whole numbers
            //Stores inputted data in variables
            charClass = charInput.getCharClass();
            charName =  charInput.getCharName();
            playerName =  charInput.getPlayerName();
            background =  charInput.getBackground();
            alignment =  charInput.getAlignment();
            race =  charInput.getRace();
            //Try catch validates that all the stat inputs are numeric by catching a parsing and catching any NumberFormatExceptions
            try
            {
                level =  Integer.parseInt(charInput.getLevel());
                strength = Integer.parseInt(charInput.getStrength());
                dexterity = Integer.parseInt(charInput.getDexterity());
                constitution = Integer.parseInt(charInput.getConstitution());
                intelligence = Integer.parseInt(charInput.getIntelligence());
                wisdom = Integer.parseInt(charInput.getWisdom());
                charisma = Integer.parseInt(charInput.getCharisma());
                moveSpeed = Integer.parseInt(charInput.getMoveSpeed());
                maxHP = Integer.parseInt(charInput.getMaxHP());

                if(validateChar(charClass, charName, playerName, background, alignment, race, level, strength, dexterity, constitution, intelligence, wisdom, charisma, moveSpeed, maxHP))
                {
                    //Creates the charInfo string to add to the character menu dropdown
                    String charInfoString = (characters.size()) + 1 + " - " + charClass + " - " + charName;
                    //Passes character info into a method which adds the character to the CharSheet list
                    addCharacter(charClass, charName, playerName, background, alignment, race, level, strength, dexterity, constitution, intelligence, wisdom, charisma, moveSpeed, maxHP);
                    //Creating a new JMenuItem with the character info corresponding to the new character
                    JMenuItem newCharacter = new JMenuItem(charInfoString);
                    //Adding the action listener to this new menu item
                    newCharacter.addActionListener(this);
                    //Adding the new menu item to the charList JMenu
                    charList.add(newCharacter);
                    //Repainting the window so the new character appears in the character list
                    guiWindow.repaint();
                }
            }
            //Catches NumberFormatExceptions from the parsing of the Int values and prints out an error message
            catch (NumberFormatException numException)
            {
                JOptionPane.showMessageDialog(null,"Invalid Data! - Ensure your level and stats are all numbers","Invalid Data Entered",JOptionPane.ERROR_MESSAGE);
            }
        }
    }// End actionPerformed

    //validateChar method, which validates entered info, to ensure
    public boolean validateChar(String cClass, String cName, String pName, String background, String alignment,
                                String race, int level, int strength, int dexterity, int constitution,
                                int intelligence, int  wisdom, int charisma, int moveSpeed, int maxHP)

    {
        if(!cClass.equals("") && !cName.equals("") && !pName.equals("") && !background.equals("") && !alignment.equals("") && !race.equals(""))
        {
            if(level > 0 && level < 21 && strength > 0 && strength < 21 && dexterity > 0 && dexterity < 21 && constitution > 0 && constitution < 21 && intelligence > 0 && intelligence < 21 && wisdom > 0 && wisdom < 21 && charisma > 0 && charisma < 21 && moveSpeed > 0 && maxHP > 0)
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Data! - Ensure your level and stats are all between 1 and 20","Invalid Data Entered",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid Data! - Ensure you have a value in every box","Invalid Data Entered",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //This method is used to add characters to the character list
    public void addCharacter(String cClass, String cName, String pName, String background, String alignment, String race, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int moveSpeed, int maxHP)
    {
        //If statement handling for different character classes
        if(charClass.equals("Wizard"))
        {
            Wizard wizard = new Wizard(charName, playerName, background, alignment, race, level, strength, dexterity, constitution, intelligence, wisdom, charisma, moveSpeed, maxHP);
            characters.add(wizard);
        }
        if(charClass.equals("Sorcerer"))
        {
            Sorcerer sorcerer = new Sorcerer(charName, playerName, background, alignment, race, level, strength, dexterity, constitution, intelligence, wisdom, charisma, moveSpeed, maxHP);
            characters.add(sorcerer);
        }
    }
}//End CharacterMenu