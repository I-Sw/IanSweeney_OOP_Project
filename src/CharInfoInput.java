import javax.swing.*;

public class CharInfoInput extends JPanel{
    private JPanel charInputGUI = new JPanel();
    private JLabel lblTitle;
    private JComboBox cboClasses;
    //private JButton confirmButton;
    private JTextField txtCharName;
    private JTextField txtPlayerName;
    private JTextField txtBackground;
    private JTextField txtAlignment;
    private JTextField txtLevel;
    private JTextField txtDexterity;
    private JTextField txtStrength;
    private JTextField txtRace;
    private JTextField txtConstitution;
    private JTextField txtWisdom;
    private JTextField txtIntelligence;
    private JTextField txtCharisma;
    private JTextField txtMoveSpeed;
    private JTextField txtMaxHP;
    private JLabel lblCharName;
    private JLabel lblPlayerName;
    private JLabel lblBackground;
    private JLabel lblAlignment;
    private JLabel lblRace;
    private JLabel lblLevel;
    private JLabel lblStrength;
    private JLabel lblDexterity;
    private JLabel lblConstitution;
    private JLabel lblIntelligence;
    private JLabel lblWisdom;
    private JLabel lblCharisma;
    private JLabel lblMoveSpeed;
    private JLabel lblMaxHP;

    public CharInfoInput() {
        String[] classes = { "Wizard", "Sorcerer", "Bard", "Rogue"};
        //Setting GUI size and layout
        charInputGUI.setSize(350, 600);
        charInputGUI.setLayout(null);
        //Creating title and class combo box
        lblTitle = new JLabel ("Character Info Input");
        cboClasses = new JComboBox(classes);
        //confirmButton = new JButton ("Confirm Character Input");
        //Creating and setting text for all required JLabels
        lblCharName = new JLabel ("Character Name", SwingConstants.RIGHT);
        lblPlayerName = new JLabel ("Player Name", SwingConstants.RIGHT);
        lblBackground = new JLabel ("Background", SwingConstants.RIGHT);
        lblAlignment = new JLabel("Alignment", SwingConstants.RIGHT);
        lblRace = new JLabel("Race", SwingConstants.RIGHT);
        lblLevel = new JLabel("Level", SwingConstants.RIGHT);
        lblStrength = new JLabel("Strength", SwingConstants.RIGHT);
        lblDexterity = new JLabel("Dexterity", SwingConstants.RIGHT);
        lblConstitution = new JLabel("Constitution", SwingConstants.RIGHT);
        lblIntelligence = new JLabel("Intelligence", SwingConstants.RIGHT);
        lblWisdom = new JLabel("Wisdom", SwingConstants.RIGHT);
        lblCharisma = new JLabel("Charisma", SwingConstants.RIGHT);
        lblMoveSpeed = new JLabel("Movement Speed", SwingConstants.RIGHT);
        lblMaxHP = new JLabel("Max HP", SwingConstants.RIGHT);
        //Creating all required JTextFields
        txtCharName = new JTextField (5);
        txtPlayerName = new JTextField (5);
        txtBackground = new JTextField();
        txtAlignment = new JTextField();
        txtLevel = new JTextField();
        txtDexterity = new JTextField();
        txtStrength = new JTextField();
        txtRace = new JTextField();
        txtConstitution = new JTextField();
        txtWisdom = new JTextField();
        txtIntelligence = new JTextField();
        txtCharisma = new JTextField();
        txtMoveSpeed = new JTextField();
        txtMaxHP = new JTextField();
        //Adding all the components to the GUI window
        charInputGUI.add(lblTitle);
        charInputGUI.add(cboClasses);
        charInputGUI.add(txtCharName);
        charInputGUI.add(txtPlayerName);
        charInputGUI.add(txtBackground);
        charInputGUI.add(txtAlignment);
        charInputGUI.add(txtLevel);
        charInputGUI.add(txtDexterity);
        charInputGUI.add(txtStrength);
        charInputGUI.add(txtRace);
        charInputGUI.add(txtConstitution);
        charInputGUI.add(txtWisdom);
        charInputGUI.add(txtIntelligence);
        charInputGUI.add(txtCharisma);
        charInputGUI.add(txtMoveSpeed);
        charInputGUI.add(txtMaxHP);
        charInputGUI.add(lblCharName);
        charInputGUI.add(lblPlayerName);
        charInputGUI.add(lblBackground);
        charInputGUI.add(lblAlignment);
        charInputGUI.add(lblRace);
        charInputGUI.add(lblLevel);
        charInputGUI.add(lblStrength);
        charInputGUI.add(lblDexterity);
        charInputGUI.add(lblConstitution);
        charInputGUI.add(lblIntelligence);
        charInputGUI.add(lblWisdom);
        charInputGUI.add(lblCharisma);
        charInputGUI.add(lblMoveSpeed);
        charInputGUI.add(lblMaxHP);
        //Placing the components on the GUI window
        lblTitle.setBounds(30, 15, 200, 25);
        cboClasses.setBounds(30,50,200,25);
        lblCharName.setBounds (30, 75, 100, 25);
        lblPlayerName.setBounds (30, 100, 100, 25);
        lblBackground.setBounds (30, 125, 100, 25);
        lblAlignment.setBounds (30, 150, 100, 25);
        lblRace.setBounds (30, 175, 100, 25);
        lblLevel.setBounds (30, 200, 100, 25);
        lblStrength.setBounds (30, 225, 100, 25);
        lblDexterity.setBounds (30, 250, 100, 25);
        lblConstitution.setBounds (30, 275, 100, 25);
        lblIntelligence.setBounds (30, 300, 100, 25);
        lblWisdom.setBounds (30, 325, 100, 25);
        lblCharisma.setBounds (30, 350, 100, 25);
        lblMoveSpeed.setBounds (30, 375, 100, 25);
        lblMaxHP.setBounds (30, 400, 100, 25);
        txtCharName.setBounds (130, 75, 100, 25);
        txtPlayerName.setBounds (130, 100, 100, 25);
        txtBackground.setBounds (130, 125, 100, 25);
        txtAlignment.setBounds (130, 150, 100, 25);
        txtRace.setBounds (130, 175, 100, 25);
        txtLevel.setBounds (130, 200, 100, 25);
        txtStrength.setBounds (130, 225, 100, 25);
        txtDexterity.setBounds (130, 250, 100, 25);
        txtConstitution.setBounds (130, 275, 100, 25);
        txtIntelligence.setBounds (130, 300, 100, 25);
        txtWisdom.setBounds (130, 325, 100, 25);
        txtCharisma.setBounds (130, 350, 100, 25);
        txtMoveSpeed.setBounds (130, 375, 100, 25);
        txtMaxHP.setBounds (130, 400, 100, 25);
        //Adding ActionListener to the confirm button
        //confirmButton.addActionListener(this);
    }

    public void openCharInput()
    {
        charInputGUI.setVisible(true);
    }

    public void addConfirmButton(JButton confirmButton) {
        charInputGUI.add(confirmButton);
        confirmButton.setBounds(30, 440, 200, 20);
        charInputGUI.repaint();
    }

    public String getCharClass()
    {
        return (String) cboClasses.getSelectedItem();
    }

    public String getCharName()
    {
        return txtCharName.getText();
    }
}//End CharInfoInput class
