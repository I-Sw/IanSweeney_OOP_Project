import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MapMenu implements ActionListener {
    public JFrame mapMenuGui = new JFrame("Map Menu");
    public LinkedList<BattleMap> mapList;
    public BattleMap currentMap;
    public JMenu mapListMenu;

    public MapMenu()
    {
        mapList = new LinkedList<>();
        mapMenuGui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mapMenuGui.setSize(800,800);
        JMenuBar menuBar = new JMenuBar();
        //Creating Menu for creating maps
        JMenu mapCreationMenu = new JMenu("Manage Maps");
        menuBar.add(mapCreationMenu);
        JMenuItem newMap = new JMenuItem("Create New Map");
        JMenuItem saveMaps = new JMenuItem("Save Current Maps");
        JMenuItem loadMaps = new JMenuItem("Load Saved Maps");
        mapCreationMenu.add(newMap);
        mapCreationMenu.add(saveMaps);
        mapCreationMenu.add(loadMaps);
        newMap.addActionListener(this);
        saveMaps.addActionListener(this);
        loadMaps.addActionListener(this);
        //Creating Menu for adding and removing Images
        JMenu imageMenu = new JMenu("Add/Remove Images");
        menuBar.add(imageMenu);
        JMenuItem addImage = new JMenuItem("Add Image");
        JMenuItem removeImage = new JMenuItem("Remove Image");
        imageMenu.add(addImage);
        imageMenu.add(removeImage);
        addImage.addActionListener(this);
        removeImage.addActionListener(this);
        //Creating map list menu
        mapListMenu = new JMenu("Map List");
        menuBar.add(mapListMenu);
        //Adding MenuBar to the GUI
        mapMenuGui.setJMenuBar(menuBar);
        mapListMenu = new JMenu("Map List");
        //TEMPORARY CODE

        //




        mapMenuGui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        System.out.println(s);
        if(s.equals("Create New Map"))
        {
            BattleMap map = new BattleMap();
            mapList.add(map);
            JMenuItem mapMenuItem = new JMenuItem((mapList.size()+1) + " - Map");
            mapMenuItem.addActionListener(this);
            mapListMenu.add(mapMenuItem);
            mapMenuGui.repaint();
        }

        if(s.equals("Add Image"))
        {
            java.net.URL imgUrl = MapMenu.class.getResource("images/Cleric.png");
            ImageIcon image2 = new ImageIcon(new ImageIcon(imgUrl).getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
            JLabel imageLabel = new JLabel(image2);
            currentMap.addImage(imageLabel,5,5);
            currentMap.repaint();
            mapMenuGui.repaint();
        }

        if(Character.isDigit(s.charAt(0)))
        {
            mapMenuGui.add(mapList.get(Character.getNumericValue(s.charAt(0))));
            currentMap = mapList.get(Character.getNumericValue(s.charAt(0)));
            mapMenuGui.repaint();
        }

        if(s.equals("Load Saved Maps"))
        {
            mapMenuGui.add(mapList.get(0));
            currentMap = mapList.get(0);
            mapMenuGui.repaint();
        }
    }

    public void openMapMenu()
    {
        //This method is used by the Main Menu to open the Map Menu
        mapMenuGui.setVisible(true);
    }
}

