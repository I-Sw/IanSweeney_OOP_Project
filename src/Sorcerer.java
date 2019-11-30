import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Sorcerer extends Caster implements SpellCaster, Serializable {
    private ArrayList<Spell> spellsKnown;

    public Sorcerer()
    {

    }

    public Sorcerer(String charName, String playerName, String background, String alignment, String race, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int movementSpeed, int maxHP)
    {
        super(charName, playerName, background, alignment, race, level, strength, dexterity, constitution, intelligence, wisdom, charisma, movementSpeed, maxHP);
        setCharClass("Sorcerer");
        setSpellSlots("Sorcerer", level);
        spellsKnown = new ArrayList();
    }

    public String toString()
    {
        return super.toString();
    }

    @Override
    public void addSpell(Spell spell)
    {
        spellsKnown.add(spell);
    }

    @Override
    public void removeSpell()
    {
        String spellRemove = JOptionPane.showInputDialog("Enter the name of the spell you wish to remove");
        for(int i = 0; i <= spellsKnown.size(); i++)
        {
            if(spellsKnown.get(i).getName() == spellRemove)
            {
                spellsKnown.remove(i);
                JOptionPane.showMessageDialog(null,"Spell removed");
            }
        }
    }
}