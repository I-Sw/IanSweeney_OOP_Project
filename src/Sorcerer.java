import java.util.ArrayList;

public class Sorcerer extends Caster implements SpellCaster {
    private static ArrayList<String> spellsPrepared;

    public Sorcerer()
    {

    }

    public Sorcerer(String charName, String playerName, String background, String alignment, String race, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int movementSpeed, int maxHP)
    {
        super(charName, playerName, background, alignment, race, level, strength, dexterity, constitution, intelligence, wisdom, charisma, movementSpeed, maxHP);
        setCharClass("Sorcerer");
        setSpellSlots("Sorcerer", level);
    }

    public String toString()
    {
        return super.toString();
    }
}