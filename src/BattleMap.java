import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.ArrayList;

public class BattleMap extends JPanel implements Serializable, ActionListener, MouseMotionListener {
    private JFrame mapGui;
    private String name;
    private int mapHeight;
    private int mapWidth;
    private ArrayList<ImageIcon> imageList;

    public BattleMap()
    {
        boolean valid = false;

        int backgroundConfirm = JOptionPane.showConfirmDialog(null,"Do you want to add a background image?","Battlemap Creation",JOptionPane.YES_NO_OPTION);
        if (backgroundConfirm == 0)
        {
            String bMapFile = "images/" + JOptionPane.showInputDialog("Enter the filename and extension of your background\n(Must be stored in images folder)");
            java.net.URL battlemapUrl = MapMenu.class.getResource(bMapFile);
            ImageIcon background = new ImageIcon(battlemapUrl);
            JLabel backgroundLabel = new JLabel(background);
            mapGui.add(backgroundLabel);
            mapHeight = background.getIconHeight();
            mapWidth = background.getIconWidth();
            //Add code for background handling
            valid = true;
        }
        while(!valid)
        {
            try
            {
                mapHeight = Integer.parseInt(JOptionPane.showInputDialog("How many pixels high do you want your map to be? (Images are 50x50 pixels)"));
                mapWidth = Integer.parseInt(JOptionPane.showInputDialog("How many pixels wide do you want your map to be? (Images are 50x50 pixels)"));
                valid = true;
            }
            //Catches NumberFormatExceptions from the parsing of the Int values and prints out an error message
            catch (NumberFormatException numException)
            {
                JOptionPane.showMessageDialog(null,"Invalid Input! - Please enter digits only","Invalid Data Entered",JOptionPane.ERROR_MESSAGE);
            }
        }

        mapGui = new JFrame("Map Gui");
        mapGui.setSize(mapWidth,mapHeight);
        mapGui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        //Creating Menu for adding and removing Images
        JMenu imageMenu = new JMenu("Add/Remove Images");
        menuBar.add(imageMenu);
        JMenuItem addImage = new JMenuItem("Add Image");
        JMenuItem removeImage = new JMenuItem("Remove Image");
        imageMenu.add(addImage);
        imageMenu.add(removeImage);
        addImage.addActionListener(this);
        removeImage.addActionListener(this);
        //Adding MenuBar to the GUI
        mapGui.setJMenuBar(menuBar);
        mapGui.setVisible(true);
    }

    public void addImage(JLabel imageLabel, int xPos, int yPos)
    {
        this.add(imageLabel, xPos, yPos);
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        System.out.println(s);
        if(s.equals("Add Image"))
        {
            String imagePath = JOptionPane.showInputDialog("Enter the filename and extension of your image\n(Must be stored in images folder)");
            java.net.URL imgUrl = MapMenu.class.getResource("images/" + imagePath);
            ImageIcon image2 = new ImageIcon(new ImageIcon(imgUrl).getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
            JLabel imageLabel = new JLabel(image2);
            imageLabel.addMouseMotionListener(this);
            mapGui.add(imageLabel);
            mapGui.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        //Use thread.sleep (Measures in milliseconds - 1000 = 1 second)
        if(e.getX() < mapWidth && e.getX() > -(mapWidth) && e.getY() < mapHeight && e.getY() > -(mapHeight))
        {
            e.getComponent().setBounds(e.getX(), e.getY(), e.getComponent().getWidth(), e.getComponent().getHeight());
            try {
                Thread.sleep(50);
                System.out.print("X: " + e.getX() + " Y:" + e.getY() + " ");
                mapGui.repaint();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }
}
