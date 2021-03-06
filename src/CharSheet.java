import java.io.Serializable;
import java.util.ArrayList;

public class CharSheet implements Serializable {
    private String charName;
    private String playerName;
    private String background;
    private String alignment;
    private String race;
    private String charClass;
    private int level;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int movementSpeed;
    private int maxHP;
    private int currentHP;
    private ArrayList<Item> items;
    private ArrayList<Item> equippedItems;

    //Null constructor for CharSheet which fills in default values
    public CharSheet()
    {
        setCharName("-No Character Name-");
        setPlayerName("-No Player Name-");
        setBackground("-No Background-");
        setAlignment("-No Alignment-");
        setRace("-No Race-");
        setCharClass("-No Class-");
        setLevel(0);
        setStrength(10);
        setDexterity(10);
        setConstitution(10);
        setIntelligence(10);
        setWisdom(10);
        setCharisma(10);
        setMovementSpeed(30);
        setMaxHP(10);
        setCurrentHP(10);
    }

    //Multiple Argument constructor that creates a character with all of its data inputted
    public CharSheet(String charName, String playerName, String background, String alignment, String race, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int movementSpeed, int maxHP)
    {
        setCharName(charName);
        setPlayerName(playerName);
        setBackground(background);
        setAlignment(alignment);
        setRace(race);
        setCharClass("-No Class-");
        setLevel(level);
        setStrength(strength);
        setDexterity(dexterity);
        setConstitution(constitution);
        setIntelligence(intelligence);
        setWisdom(wisdom);
        setCharisma(charisma);
        setMovementSpeed(movementSpeed);
        setMaxHP(maxHP);
        setCurrentHP(maxHP);
    }

    public void setCharName(String charName)
    {
        this.charName = charName;
    }

    public String getCharName()
    {
        return this.charName;
    }

    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    public String getPlayerName()
    {
        return this.playerName;
    }

    public void setBackground(String background)
    {
        this.background = background;
    }

    public String getBackground()
    {
        return this.background;
    }

    public void setAlignment(String alignment)
    {
        this.alignment = alignment;
    }

    public String getAlignment()
    {
        return this.alignment;
    }

    public void setRace(String race)
    {
        this.race = race;
    }

    public String getRace()
    {
        return this.race;
    }

    public void setCharClass(String charClass)
    {
        this.charClass = charClass;
    }

    public String getCharClass()
    {
        return this.charClass;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public int getLevel()
    {
        return this.level;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    public int getStrength()
    {
        return this.strength;
    }

    public void setDexterity(int dexterity)
    {
        this.dexterity = dexterity;
    }

    public int getDexterity()
    {
        return this.dexterity;
    }

    public void setConstitution(int constitution)
    {
        this.constitution = constitution;
    }

    public int getConstitution()
    {
        return this.constitution;
    }

    public void setIntelligence(int intelligence)
    {
        this.intelligence = intelligence;
    }

    public int getIntelligence()
    {
        return this.intelligence;
    }

    public void setWisdom(int wisdom)
    {
        this.wisdom = wisdom;
    }

    public int getWisdom()
    {
        return this.wisdom;
    }

    public void setCharisma(int charisma)
    {
        this.charisma = charisma;
    }

    public int getCharisma()
    {
        return this.charisma;
    }

    public void setMovementSpeed(int movementSpeed)
    {
        this.movementSpeed = movementSpeed;
    }

    public int getMovementSpeed()
    {
        return this.movementSpeed;
    }

    public void setMaxHP(int maxHP)
    {
        this.maxHP = maxHP;
    }

    public int getMaxHP()
    {
        return this.maxHP;
    }

    public void setCurrentHP(int currentHP)
    {
        this.currentHP = currentHP;
    }

    public int getCurrentHP()
    {
        return this.currentHP;
    }

    //This method subtracts health from the character
    public void removeHP(int damage)
    {
        setCurrentHP(getCurrentHP() - damage);
        if(getCurrentHP() == 0)
        {
            //Death Saves Here
        }
    }

    //This method adds health to the character
    public void addHP(int healing)
    {
        setCurrentHP(getCurrentHP() + healing);
        if(getCurrentHP() > getMaxHP())
        {
            setCurrentHP(getMaxHP());
        }
    }

    public String toString()
    {
        return "<html>Character Name: " + getCharName() +
                "<br/>Player Name: " + getPlayerName() +
                "<br/>Background: " + getBackground() +
                "<br/>Alignment: " + getAlignment() +
                "<br/>Race: " + getRace() +
                "<br/>Class: " + getCharClass() +
                "<br/>Level: " + getLevel() +
                "<br/>Strength: " + getStrength() +
                "<br/>Dexterity: " + getDexterity() +
                "<br/>Constitution: " + getConstitution() +
                "<br/>Intelligence: " + getIntelligence() +
                "<br/>Wisdom: " + getWisdom() +
                "<br/>Charisma: " + getCharisma() +
                "<br/>Movement Speed: " + getMovementSpeed() + "ft" +
                "<br/>Max HP: " + getMaxHP();
    }

    public void addSpell(Spell spell)
    {
        System.out.println("Error - this character should not be able to learn spells");
    }
}