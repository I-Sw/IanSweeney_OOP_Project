import java.util.ArrayList;

public class Spell {
    private String name;
    private int level;
    private String school;
    private String castTime;
    private String components;
    private String duration;
    private int range;
    private ArrayList<String> classes;
    private String description;

    public Spell()
    {
        this.name = "-No Name-";
        this.level = 0;
        this.school = "-No School-";
        this.castTime = "-No Cast Time-";
        this.components = "-No Specified Components-";
        this.duration = "-No Duration-";
        this.range = 0;
        ArrayList<String> nullClasses = new ArrayList<String>();
        nullClasses.add("-No Classes-");
        this.classes = nullClasses;
        this.description = "-No Description-";
    }

    public Spell(String name)
    {
        if(name.equals("Fire Bolt"))
        {
            this.name = name;
            this.level = 0;
            this.school = "Evocation";
            this.castTime = "1 Action";
            this.components = "Verbal, Somatic";
            this.duration = "Instantaneous";
            this.range = 120;
            ArrayList<String> classes = new ArrayList<String>();
            classes.add("Wizard");
            classes.add("Sorcerer");
            this.classes = classes;
            this.description = "You hurl a mote of fire at a creature or object within range." +
                               "\nMake a ranged spell attack against the target. \nOn a hit, the target takes 1d10 fire damage." +
                               "\nA flammable object hit by this spell ignites if it isn’t being worn or carried." +
                               "\n\nThis spell's damage increases by an additional 1d10 when you reach 5th level, 11th level, and 17th level.";
        }
    }
}
