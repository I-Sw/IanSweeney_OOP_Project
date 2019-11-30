import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class Spell implements ActionListener, Serializable {
    private String name;
    private int level;
    private String school;
    private String castTime;
    private String components;
    private String duration;
    private int range;
    private String description;
    private boolean verbal;
    private boolean somatic;
    private boolean concentration;
    private boolean ritual;
    private JFrame spellInputGUi;
    private JTextField txtSpellName;
    private JTextField txtSpellLevel;
    private JTextField txtSchool;
    private JTextField txtCastTime;
    private JTextField txtComponents;
    private JTextField txtDuration;
    private JTextField txtRange;
    private JTextField txtSpellDescription;
    private JCheckBox chkVerbal;
    private JCheckBox chkSomatic;
    private JCheckBox chkConcentration;
    private JCheckBox chkRitual;

    public Spell()
    {
        spellInputGUi = new JFrame();
        //Setting GUI size and layout
        spellInputGUi.setSize(350, 600);
        spellInputGUi.setLayout(null);
        //Creating title, class combo box and a clear data button
        JLabel lblTitle = new JLabel ("Spell Info Input");
        JButton clearButton = new JButton("Clear Spell Data");
        //Creating and setting text for all required JLabels
        JLabel lblSpellName = new JLabel ("Spell Name", SwingConstants.RIGHT);
        JLabel lblSpellLevel = new JLabel ("Spell Level", SwingConstants.RIGHT);
        JLabel lblSchool = new JLabel ("School", SwingConstants.RIGHT);
        JLabel lblCastTime = new JLabel("Casting Time", SwingConstants.RIGHT);
        JLabel lblComponents = new JLabel("Components", SwingConstants.RIGHT);
        JLabel lblDuration = new JLabel("Duration", SwingConstants.RIGHT);
        JLabel lblRange = new JLabel("Range", SwingConstants.RIGHT);
        JLabel lblSpellDescription = new JLabel("Spell Description", SwingConstants.RIGHT);
        JLabel lblVerbal = new JLabel("Verbal", SwingConstants.RIGHT);
        JLabel lblSomatic = new JLabel("Somatic", SwingConstants.RIGHT);
        JLabel lblConcentration = new JLabel("Concentration", SwingConstants.RIGHT);
        JLabel lblRitual = new JLabel("Ritual", SwingConstants.RIGHT);
        //Creating all required JTextFields
        txtSpellName = new JTextField ();
        txtSpellLevel = new JTextField ();
        txtSchool = new JTextField();
        txtCastTime = new JTextField();
        txtComponents = new JTextField();
        txtDuration = new JTextField();
        txtRange = new JTextField();
        txtSpellDescription = new JTextField();
        chkVerbal = new JCheckBox();
        chkSomatic = new JCheckBox();
        chkConcentration = new JCheckBox();
        chkRitual = new JCheckBox();
        //Adding all the components to the GUI window
        spellInputGUi.add(lblTitle);
        spellInputGUi.add(lblSpellName);
        spellInputGUi.add(lblSpellLevel);
        spellInputGUi.add(lblSchool);
        spellInputGUi.add(lblCastTime);
        spellInputGUi.add(lblComponents);
        spellInputGUi.add(lblDuration);
        spellInputGUi.add(lblRange);
        spellInputGUi.add(lblSpellDescription);
        spellInputGUi.add(lblVerbal);
        spellInputGUi.add(lblSomatic);
        spellInputGUi.add(lblConcentration);
        spellInputGUi.add(lblRitual);
        spellInputGUi.add(txtSpellName);
        spellInputGUi.add(txtSpellLevel);
        spellInputGUi.add(txtSchool);
        spellInputGUi.add(txtCastTime);
        spellInputGUi.add(txtComponents);
        spellInputGUi.add(txtDuration);
        spellInputGUi.add(txtRange);
        spellInputGUi.add(txtSpellDescription);
        spellInputGUi.add(chkVerbal);
        spellInputGUi.add(chkSomatic);
        spellInputGUi.add(chkConcentration);
        spellInputGUi.add(chkRitual);
        spellInputGUi.add(clearButton);
        //Placing the components on the GUI window
        lblTitle.setBounds(30, 25, 200, 25);
        lblSpellName.setBounds(30,50,200,25);
        lblSpellLevel.setBounds (30, 75, 100, 25);
        lblSchool.setBounds (30, 100, 100, 25);
        lblCastTime.setBounds (30, 125, 100, 25);
        lblComponents.setBounds (30, 150, 100, 25);
        lblDuration.setBounds (30, 175, 100, 25);
        lblRange.setBounds (30, 200, 100, 25);
        lblSpellDescription.setBounds (30, 225, 100, 25);
        lblVerbal.setBounds (30, 250, 100, 25);
        lblSomatic.setBounds (30, 275, 100, 25);
        lblConcentration.setBounds (30, 300, 100, 25);
        lblRitual.setBounds (30, 325, 100, 25);
        txtSpellName.setBounds(135,50,100,25);
        txtSpellLevel.setBounds (135, 75, 100, 25);
        txtSchool.setBounds (135, 100, 100, 25);
        txtCastTime.setBounds (135, 125, 100, 25);
        txtComponents.setBounds (135, 150, 100, 25);
        txtDuration.setBounds (135, 175, 100, 25);
        txtRange.setBounds (135, 200, 100, 25);
        txtSpellDescription.setBounds (135, 225, 100, 25);
        chkVerbal.setBounds (135, 250, 100, 25);
        chkSomatic.setBounds (135, 275, 100, 25);
        chkConcentration.setBounds (135, 300, 100, 25);
        chkRitual.setBounds (135, 325, 100, 25);
        clearButton.setBounds(30, 400, 200, 25);
        clearButton.addActionListener(this);
        spellInputGUi.setVisible(false);
    }

    public Spell(String name, int level, String school, String castTime, String components, String duration, int range, ArrayList<String> classes, String description, boolean v, boolean s, boolean c, boolean r)
    {
        this.name = name;
        this.level = level;
        this.school = school;
        this.castTime = castTime;
        this.components = components;
        this.duration = duration;
        this.range = range;
        this.description = description;
        this.verbal = v;
        this.somatic = s;
        this.concentration = c;
        this.ritual = r;

        /*if(name.equals("Fire Bolt"))
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
        }*/
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals("Clear Spell Data"))
        {
            txtSpellName.setText("");
            txtSpellLevel.setText("");
            txtSchool.setText("");
            txtCastTime.setText("");
            txtComponents.setText("");
            txtDuration.setText("");
            txtRange.setText("");
            txtSpellDescription.setText("");
            chkVerbal.setSelected(false);
            chkSomatic.setSelected(false);
            chkConcentration.setSelected(false);
            chkRitual.setSelected(false);
        }
    }
}
