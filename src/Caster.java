import java.util.ArrayList;

public class Caster extends CharSheet {
    public static int[] spellSlots = new int[10];
    private static int[] slotsUsed;
    private static ArrayList<Spell> spellsKnown;

    public Caster()
    {
        super();
    }

    public Caster(String charName, String playerName, String background, String alignment, String race, int level, int strength, int dexterity, int constitution,int intelligence, int wisdom, int charisma,int movementSpeed, int maxHP)
    {
        super(charName, playerName, background, alignment, race, level, strength, dexterity, constitution, intelligence, wisdom, charisma, movementSpeed, maxHP);
        //selectSpells(charClass, level);    This code will be in use once the selectSpells method is created
    }

    public void inputSpellSlots(int level1, int level2, int level3, int level4, int level5, int level6, int level7, int level8, int level9)
    {
        this.spellSlots[1] = level1;
        this.spellSlots[2] = level2;
        this.spellSlots[3] = level3;
        this.spellSlots[4] = level4;
        this.spellSlots[5] = level5;
        this.spellSlots[6] = level6;
        this.spellSlots[7] = level7;
        this.spellSlots[8] = level8;
        this.spellSlots[9] = level9;
    }

    public void setSpellSlots(String className, int level)
    {
        if(className.equals("Bard") || className.equals("Cleric")  || className.equals("Druid")  || className.equals("Wizard")  || className.equals("Sorcerer"))
        {
            switch(level)
            {
                case 1:
                    inputSpellSlots(2, 0, 0, 0, 0, 0, 0, 0, 0);
                case 2:
                    inputSpellSlots(3, 0, 0, 0, 0, 0, 0, 0, 0);
                case 3:
                    inputSpellSlots(4, 2, 0, 0, 0, 0, 0, 0, 0);
                case 4:
                    inputSpellSlots(4, 3, 0, 0, 0, 0, 0, 0, 0);
                case 5:
                    inputSpellSlots(4, 3, 2, 0, 0, 0, 0, 0, 0);
                case 6:
                    inputSpellSlots(4, 3, 3, 0, 0, 0, 0, 0, 0);
                case 7:
                    inputSpellSlots(4, 3, 3, 1, 0, 0, 0, 0, 0);
                case 8:
                    inputSpellSlots(4, 3, 3, 2, 0, 0, 0, 0, 0);
                case 9:
                    inputSpellSlots(4, 3, 3, 3, 1, 0, 0, 0, 0);
                case 10:
                    inputSpellSlots(4, 3, 3, 3, 2, 0, 0, 0, 0);
                case 11:
                    inputSpellSlots(4, 3, 3, 3, 2, 1, 0, 0, 0);
                case 12:
                    inputSpellSlots(4, 3, 3, 3, 2, 1, 0, 0, 0);
                case 13:
                    inputSpellSlots(4, 3, 3, 3, 2, 1, 1, 0, 0);
                case 14:
                    inputSpellSlots(4, 3, 3, 3, 2, 1, 1, 0, 0);
                case 15:
                    inputSpellSlots(4, 3, 3, 3, 2, 1, 1, 1, 0);
                case 16:
                    inputSpellSlots(4, 3, 3, 3, 2, 1, 1, 1, 0);
                case 17:
                    inputSpellSlots(4, 3, 3, 3, 2, 1, 1, 1, 1);
                case 18:
                    inputSpellSlots(4, 3, 3, 3, 3, 1, 1, 1, 1);
                case 19:
                    inputSpellSlots(4, 3, 3, 3, 3, 2, 1, 1, 1);
                case 20:
                    inputSpellSlots(4, 3, 3, 3, 3, 2, 2, 1, 1);
            }
        }

        if(className.equals("Paladin") || className.equals("Ranger"))
        {
            switch(level)
            {
                case 1:
                    inputSpellSlots(0, 0, 0, 0, 0, 0, 0, 0, 0);
                case 2:
                    inputSpellSlots(2, 0, 0, 0, 0, 0, 0, 0, 0);
                case 3:
                    inputSpellSlots(3, 0, 0, 0, 0, 0, 0, 0, 0);
                case 4:
                    inputSpellSlots(3, 0, 0, 0, 0, 0, 0, 0, 0);
                case 5:
                    inputSpellSlots(4, 2, 0, 0, 0, 0, 0, 0, 0);
                case 6:
                    inputSpellSlots(4, 2, 0, 0, 0, 0, 0, 0, 0);
                case 7:
                    inputSpellSlots(4, 3, 0, 0, 0, 0, 0, 0, 0);
                case 8:
                    inputSpellSlots(4, 3, 0, 0, 0, 0, 0, 0, 0);
                case 9:
                    inputSpellSlots(4, 3, 2, 0, 0, 0, 0, 0, 0);
                case 10:
                    inputSpellSlots(4, 3, 2, 0, 0, 0, 0, 0, 0);
                case 11:
                    inputSpellSlots(4, 3, 3, 0, 0, 0, 0, 0, 0);
                case 12:
                    inputSpellSlots(4, 3, 3, 0, 0, 0, 0, 0, 0);
                case 13:
                    inputSpellSlots(4, 3, 3, 1, 0, 0, 0, 0, 0);
                case 14:
                    inputSpellSlots(4, 3, 3, 1, 0, 0, 0, 0, 0);
                case 15:
                    inputSpellSlots(4, 3, 3, 2, 0, 0, 0, 0, 0);
                case 16:
                    inputSpellSlots(4, 3, 3, 2, 0, 0, 0, 0, 0);
                case 17:
                    inputSpellSlots(4, 3, 3, 3, 1, 0, 0, 0, 0);
                case 18:
                    inputSpellSlots(4, 3, 3, 3, 1, 0, 0, 0, 0);
                case 19:
                    inputSpellSlots(4, 3, 3, 3, 2, 0, 0, 0, 0);
                case 20:
                    inputSpellSlots(4, 3, 3, 3, 2, 0, 0, 0, 0);
            }
        }

        System.out.println("Spell Slots Set");
    }

    public int[] getSpellSlots()
    {
        return this.spellSlots;
    }

    public String slotsAsString()
    {
        String slots = "";
        for(int i = 1; i < 10; i++)
        {
            slots += Integer.toString(this.spellSlots[i]);
        }
        return slots;
    }

    public void selectSpells(String className, int level)
    {
        //Spell selection goes here
    }
}
