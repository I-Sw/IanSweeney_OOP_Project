import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class MapMenu implements ActionListener {
    public JFrame mapMenuGui = new JFrame("Map Menu");
    public ArrayList<BattleMap> mapList;
    public BattleMap currentMap;
    public static JMenu mapMenuList;

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
        mapMenuList = new JMenu("Map List");
        menuBar.add(mapMenuList);
        //Adding MenuBar to the GUI
        mapMenuGui.setJMenuBar(menuBar);
        mapMenuList = new JMenu("Map List");
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
            System.out.println("Map Added");
            mapList.add(map);
            String mapText = (mapList.size()) + " - Map";
            System.out.println("Map Text: " + mapText);
            JMenuItem mapMenuItem = new JMenuItem(mapText);
            mapMenuItem.addActionListener(this);
            mapMenuList.add(mapMenuItem);
            mapMenuList.repaint();
            mapMenuGui.repaint();
        }

        if(Character.isDigit(s.charAt(0)))
        {
            mapMenuGui.add(mapList.get(Character.getNumericValue(s.charAt(0))));
            currentMap = mapList.get(Character.getNumericValue(s.charAt(0)));
            mapMenuGui.repaint();
        }

        if(s.equals("Save Current Maps"))
        {
            try{
                ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(new File("mapStorage.dat")));
                objectOut.writeObject(mapList);
                objectOut.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error! Maps were unable to be saved, please try again","Error Saving Maps",JOptionPane.ERROR_MESSAGE);
            }
        }

        if(s.equals("Load Saved Maps"))
        {
            try{
                ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(new File("mapStorage.dat")));
                mapList = (ArrayList<BattleMap>) objectIn.readObject();
                objectIn.close();
                for(BattleMap map : mapList)
                {
                    JMenuItem mapMenuItem = new JMenuItem((mapList.size()+1) + " - Map");
                    mapMenuItem.addActionListener(this);
                    mapMenuList.add(mapMenuItem);
                }
                System.out.println("Maps Saved");
            }
            catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error! Mapss were unable to be loaded, please try again","Error Saving Maps",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void openMapMenu()
    {
        //This method is used by the Main Menu to open the Map Menu
        mapMenuGui.setVisible(true);
    }
}

