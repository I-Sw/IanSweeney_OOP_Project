import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CharInfoInput extends JPanel implements ActionListener {
    private JFrame charInputGUI = new JFrame("Character Input");
    private JLabel titleLabel;
    private JButton confirmButton;
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
        //Setting GUI size and layout
        charInputGUI.setSize(350, 600);
        charInputGUI.setLayout(null);
        //Creating title and confirm button
        titleLabel = new JLabel ("Character Info Input");
        confirmButton = new JButton ("Confirm Character Input");
        //Creating and setting text for all required JLabels
        lblCharName = new JLabel ("Character Name");
        lblPlayerName = new JLabel ("Player Name");
        lblBackground = new JLabel ("Background");
        lblAlignment = new JLabel("Alignment");
        lblRace = new JLabel("Race");
        lblLevel = new JLabel("Level");
        lblStrength = new JLabel("Strength");
        lblDexterity = new JLabel("Dexterity");
        lblConstitution = new JLabel("Constitution");
        lblIntelligence = new JLabel("Intelligence");
        lblWisdom = new JLabel("Wisdom");
        lblCharisma = new JLabel("Charisma");
        lblMoveSpeed = new JLabel("Movement Speed");
        lblMaxHP = new JLabel("Max HP");
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
        charInputGUI.add(confirmButton);
        charInputGUI.add(titleLabel);
        charInputGUI.add(txtPlayerName);
        charInputGUI.add(txtCharName);
        charInputGUI.add(lblCharName);
        charInputGUI.add(lblPlayerName);
        charInputGUI.add(lblBackground);
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
        confirmButton.setBounds(30, 420, 200, 20);
        titleLabel.setBounds(30, 15, 200, 25);
        lblCharName.setBounds (30, 50, 100, 25);
        lblPlayerName.setBounds (30, 75, 100, 25);
        lblBackground.setBounds (30, 100, 100, 25);
        lblAlignment.setBounds (30, 125, 100, 25);
        lblRace.setBounds (30, 150, 100, 25);
        lblLevel.setBounds (30, 175, 100, 25);
        lblStrength.setBounds (30, 200, 100, 25);
        lblDexterity.setBounds (30, 225, 100, 25);
        lblConstitution.setBounds (30, 250, 100, 25);
        lblIntelligence.setBounds (30, 275, 100, 25);
        lblWisdom.setBounds (30, 300, 100, 25);
        lblCharisma.setBounds (30, 325, 100, 25);
        lblMoveSpeed.setBounds (30, 350, 100, 25);
        lblMaxHP.setBounds (30, 375, 100, 25);
        txtCharName.setBounds (130, 50, 100, 25);
        txtPlayerName.setBounds (130, 75, 100, 25);
        txtBackground.setBounds (130, 100, 100, 25);
        txtAlignment.setBounds (130, 125, 100, 25);
        txtLevel.setBounds (130, 175, 100, 25);
        txtDexterity.setBounds (130, 225, 100, 25);
        txtStrength.setBounds (130, 200, 100, 25);
        txtRace.setBounds (130, 150, 100, 25);
        txtConstitution.setBounds (130, 250, 100, 25);
        txtWisdom.setBounds (130, 300, 100, 25);
        txtIntelligence.setBounds (130, 275, 100, 25);
        txtCharisma.setBounds (130, 325, 100, 25);
        txtMoveSpeed.setBounds (130, 350, 100, 25);
        txtMaxHP.setBounds (130, 375, 100, 25);
        //Adding ActionListener to the confirm button
        confirmButton.addActionListener(this);
    }

    public void openCharInput()
    {
        charInputGUI.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        //Returning a String from the ActionEvent to find which button was pressed
        String s = e.getActionCommand();
        if(s.equals("Confirm Character Input"))
        {
            System.out.println("Character Input");
        }

    }// End actionPerformed
}//End CharInfoInput class
