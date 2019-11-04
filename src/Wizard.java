import java.util.ArrayList;

public class Wizard extends Caster implements SpellCaster {
    private static ArrayList<String> spellsPrepared;

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
}
