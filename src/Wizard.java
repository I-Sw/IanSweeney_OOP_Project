import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Wizard extends Caster implements SpellCaster, Serializable {
    private static ArrayList<Spell> spellsKnown;
    private static ArrayList<Spell> spellsPrepared;

    public Wizard()
    {

    }

    public Wizard(String charName, String playerName, String background, String alignment, String race, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int movementSpeed, int maxHP)
    {
        super(charName, playerName, background, alignment, race, level, strength, dexterity, constitution, intelligence, wisdom, charisma, movementSpeed, maxHP);
        setCharClass("Wizard");
        setSpellSlots("Wizard", level);
    }

    public String toString()
    {
        return super.toString();
    }

    //This method adds a spell to the known spell list
    @Override
    public void addSpell()
    {
        Spell spell = new Spell();
        spellsKnown.add(spell);
    }

    //This method adds a spell to the prepared spell list
    public void prepareSpell()
    {
        String spellPrep = JOptionPane.showInputDialog("Enter the name of the spell you wish to prepare");
        for(int i = 0; i <= spellsKnown.size(); i++)
        {
            if(spellsKnown.get(i).getName() == spellPrep)
            {
                spellsPrepared.add(spellsKnown.get(i));
                JOptionPane.showMessageDialog(null,"Spell prepared");
            }
        }
    }

    //This method removes a spell from the known spell list
    @Override
    public void removeSpell()
    {
        String spellRemove = JOptionPane.showInputDialog("Enter the name of the spell you wish to remove");
        for(int i = 0; i <= spellsKnown.size(); i++)
        {
            //Searches the known spell list and removes the spell if found
            if(spellsKnown.get(i).getName() == spellRemove)
            {
                spellsKnown.remove(i);
                JOptionPane.showMessageDialog(null,"Spell removed");

                //Searches the prepared list and removes the spell if found
                for(int j = 0; j <= spellsPrepared.size(); j++)
                {
                    if(spellsPrepared.get(j).getName() == spellRemove)
                    {
                        spellsPrepared.remove(j);
                        JOptionPane.showMessageDialog(null,"Spell removed from prepared list");
                    }
                }
            }
        }
    }
}
