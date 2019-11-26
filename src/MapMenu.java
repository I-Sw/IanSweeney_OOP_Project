import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class MapMenu implements ActionListener {
    public JFrame mapMenuGui = new JFrame("Map Menu");
    public ArrayList<BattleMap> mapList;
    public BattleMap currentMap;
    public JMenu mapListMenu;

    public MapMenu()
    {
        mapList = new ArrayList<>();
        mapMenuGui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mapMenuGui.setSize(300,300);
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

