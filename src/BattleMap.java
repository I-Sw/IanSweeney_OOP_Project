import javax.swing.*;
import java.io.Serializable;

public class BattleMap extends JLabel implements Serializable {
    private String name;
    private int gridWidth;
    private int mapWidth;
    private int gridHeight;
    private int mapHeight;
    private JLabel[][] mapSpaces;

    public BattleMap()
    {
        boolean valid = false;
        while(!valid)
        {
            try
            {
                gridHeight = Integer.parseInt(JOptionPane.showInputDialog("How many spaces high do you want your map to be? (Spaces are 50x50 pixels)"));
                gridWidth = Integer.parseInt(JOptionPane.showInputDialog("How many spaces wide do you want your map to be? (Spaces are 50x50 pixels)"));
                valid = true;
            }
            //Catches NumberFormatExceptions from the parsing of the Int values and prints out an error message
            catch (NumberFormatException numException)
            {
                JOptionPane.showMessageDialog(null,"Invalid Input! - Please enter digits only","Invalid Data Entered",JOptionPane.ERROR_MESSAGE);
            }
        }

        mapSpaces = new JLabel[gridHeight][gridWidth];

        mapHeight = gridHeight * 50;
        mapWidth = gridWidth * 50;

        int backgroundConfirm = JOptionPane.showConfirmDialog(null,"Do you wish to add a background image?","Battlemap Creation",JOptionPane.YES_NO_OPTION);
        if (backgroundConfirm == 0)
        {
            String bMapFile = JOptionPane.showInputDialog("Enter the filename and extension of your background\n(Must be stored in images folder)");
            java.net.URL battlemapUrl = MapMenu.class.getResource(bMapFile);
            ImageIcon battlemap = new ImageIcon("images/" + battlemapUrl);
            JLabel battlemapLabel = new JLabel(battlemap);
            //mapMenuGui.add(battlemapLabel);
            //Add code for background handling
        }
    }

    public void addImage(JLabel imageLabel, int xPos, int yPos)
    {
        mapSpaces[xPos][yPos] = imageLabel;
        this.add(mapSpaces[xPos][yPos]);
        mapSpaces[xPos][yPos].setBounds(xPos*50, yPos*50,50,50);
        this.repaint();
    }

}
