import java.io.Serializable;
import java.util.ArrayList;

public class Caster extends CharSheet implements Serializable {
    public int[] spellSlots = new int[10];
    private int[] slotsUsed = new int[10];
    private ArrayList<Spell> spellsKnown;

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
            if(level == 1)
                inputSpellSlots(2, 0, 0, 0, 0, 0, 0, 0, 0);
            if(level == 2)
                inputSpellSlots(3, 0, 0, 0, 0, 0, 0, 0, 0);
            if(level == 3)
                inputSpellSlots(4, 2, 0, 0, 0, 0, 0, 0, 0);
            if(level == 4)
                inputSpellSlots(4, 3, 0, 0, 0, 0, 0, 0, 0);
            if(level == 5)
                inputSpellSlots(4, 3, 2, 0, 0, 0, 0, 0, 0);
            if(level == 6)
                inputSpellSlots(4, 3, 3, 0, 0, 0, 0, 0, 0);
            if(level == 7)
                inputSpellSlots(4, 3, 3, 1, 0, 0, 0, 0, 0);
            if(level == 8)
                inputSpellSlots(4, 3, 3, 2, 0, 0, 0, 0, 0);
            if(level == 9)
                inputSpellSlots(4, 3, 3, 3, 1, 0, 0, 0, 0);
            if(level == 10)
                inputSpellSlots(4, 3, 3, 3, 2, 0, 0, 0, 0);
            if(level == 11)
                inputSpellSlots(4, 3, 3, 3, 2, 1, 0, 0, 0);
            if(level == 12)
                inputSpellSlots(4, 3, 3, 3, 2, 1, 0, 0, 0);
            if(level == 13)
                inputSpellSlots(4, 3, 3, 3, 2, 1, 1, 0, 0);
            if(level == 14)
                inputSpellSlots(4, 3, 3, 3, 2, 1, 1, 0, 0);
            if(level == 15)
                inputSpellSlots(4, 3, 3, 3, 2, 1, 1, 1, 0);
            if(level == 16)
                inputSpellSlots(4, 3, 3, 3, 2, 1, 1, 1, 0);
            if(level == 17)
                inputSpellSlots(4, 3, 3, 3, 2, 1, 1, 1, 1);
            if(level == 18)
                inputSpellSlots(4, 3, 3, 3, 3, 1, 1, 1, 1);
            if(level == 19)
                inputSpellSlots(4, 3, 3, 3, 3, 2, 1, 1, 1);
            if(level == 20)
                inputSpellSlots(4, 3, 3, 3, 3, 2, 2, 1, 1);
        }

        if(className.equals("Paladin") || className.equals("Ranger"))
        {
            if(level == 1)
                    inputSpellSlots(0, 0, 0, 0, 0, 0, 0, 0, 0);
            if(level == 2)
                    inputSpellSlots(2, 0, 0, 0, 0, 0, 0, 0, 0);
            if(level == 3)
                    inputSpellSlots(3, 0, 0, 0, 0, 0, 0, 0, 0);
            if(level == 4)
                    inputSpellSlots(3, 0, 0, 0, 0, 0, 0, 0, 0);
            if(level == 5)
                    inputSpellSlots(4, 2, 0, 0, 0, 0, 0, 0, 0);
            if(level == 6)
                    inputSpellSlots(4, 2, 0, 0, 0, 0, 0, 0, 0);
            if(level == 7)
                    inputSpellSlots(4, 3, 0, 0, 0, 0, 0, 0, 0);
            if(level == 8)
                    inputSpellSlots(4, 3, 0, 0, 0, 0, 0, 0, 0);
            if(level == 9)
                    inputSpellSlots(4, 3, 2, 0, 0, 0, 0, 0, 0);
            if(level == 10)
                    inputSpellSlots(4, 3, 2, 0, 0, 0, 0, 0, 0);
            if(level == 11)
                    inputSpellSlots(4, 3, 3, 0, 0, 0, 0, 0, 0);
            if(level == 12)
                    inputSpellSlots(4, 3, 3, 0, 0, 0, 0, 0, 0);
            if(level == 13)
                    inputSpellSlots(4, 3, 3, 1, 0, 0, 0, 0, 0);
            if(level == 14)
                    inputSpellSlots(4, 3, 3, 1, 0, 0, 0, 0, 0);
            if(level == 15)
                    inputSpellSlots(4, 3, 3, 2, 0, 0, 0, 0, 0);
            if(level == 16)
                    inputSpellSlots(4, 3, 3, 2, 0, 0, 0, 0, 0);
            if(level == 17)
                    inputSpellSlots(4, 3, 3, 3, 1, 0, 0, 0, 0);
            if(level == 18)
                    inputSpellSlots(4, 3, 3, 3, 1, 0, 0, 0, 0);
            if(level == 19)
                    inputSpellSlots(4, 3, 3, 3, 2, 0, 0, 0, 0);
            if(level == 20)
                    inputSpellSlots(4, 3, 3, 3, 2, 0, 0, 0, 0);
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

    public String toString()
    {
        return super.toString() +
                "<br/>" +
                "<br/>Spell Slots... " +
                "<br/>Level 1 Spell Slots: " + this.spellSlots[1] +
                "<br/>Level 2 Spell Slots: " + this.spellSlots[2] +
                "<br/>Level 3 Spell Slots: " + this.spellSlots[3] +
                "<br/>Level 4 Spell Slots: " + this.spellSlots[4] +
                "<br/>Level 5 Spell Slots: " + this.spellSlots[5] +
                "<br/>Level 6 Spell Slots: " + this.spellSlots[6] +
                "<br/>Level 7 Spell Slots: " + this.spellSlots[7] +
                "<br/>Level 8 Spell Slots: " + this.spellSlots[8] +
                "<br/>Level 9 Spell Slots: " + this.spellSlots[9] +
                "<br/><br/>Spell Slots Used... " +
                "<br/>Level 1 Spell Slots: " + this.slotsUsed[1] +
                "<br/>Level 2 Spell Slots: " + this.slotsUsed[2] +
                "<br/>Level 3 Spell Slots: " + this.slotsUsed[3] +
                "<br/>Level 4 Spell Slots: " + this.slotsUsed[4] +
                "<br/>Level 5 Spell Slots: " + this.slotsUsed[5] +
                "<br/>Level 6 Spell Slots: " + this.slotsUsed[6] +
                "<br/>Level 7 Spell Slots: " + this.slotsUsed[7] +
                "<br/>Level 8 Spell Slots: " + this.slotsUsed[8] +
                "<br/>Level 9 Spell Slots: " + this.slotsUsed[9];
    }
}
