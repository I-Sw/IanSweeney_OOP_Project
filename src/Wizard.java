import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Wizard extends Caster implements SpellCaster, Serializable {
    private ArrayList<Spell> spellsKnown;
    private ArrayList<Spell> spellsPrepared;

    public Wizard()
    {

    }

    public Wizard(String charName, String playerName, String background, String alignment, String race, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int movementSpeed, int maxHP)
    {
        super(charName, playerName, background, alignment, race, level, strength, dexterity, constitution, intelligence, wisdom, charisma, movementSpeed, maxHP);
        setCharClass("Wizard");
        setSpellSlots("Wizard", level);
        spellsKnown = new ArrayList();
        spellsPrepared = new ArrayList();
    }

    //This method adds a spell to the known spell list
    @Override
    public void addSpell(Spell spell)
    {
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


    public String toString()
    {
        //Creates a String representation of all known spells
        String knownSpells = "<br/>Spells Known...";
        if(spellsKnown.size() > 0)
        {
            for(Spell spell : spellsKnown)
            {
                knownSpells += ("<br/>" + spell.getName());
            }
        }
        //Creates a String representation of all prepared spells
        String preparedSpells = "<br/>Spells Prepared...";
        if (spellsPrepared.size() > 0)
        {
            for(Spell spell : spellsPrepared)
            {
                preparedSpells += ("<br/>" +spell.getName());
            }
        }
        //Returns toString of super class and adds on list of known and prepared spells
        return super.toString() + "<br/><br/>" + knownSpells + "<br/><br/>" + preparedSpells + "</html>";
    }
}
