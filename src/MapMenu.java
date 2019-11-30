import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class MapMenu implements ActionListener {
    public JFrame mapMenuGui = new JFrame("Map Menu");
    public ArrayList<BattleMap> mapList;
    public BattleMap currentMap;
    public JMenu mapMenuList;

    public MapMenu()
    {
        //Creating a list to store maps
        mapList = new ArrayList<>();
        //Setting properties of the GUI window
        mapMenuGui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mapMenuGui.setSize(300,300);
        //Creating and adding a JMenuBar to the GUI
        JMenuBar menuBar = new JMenuBar();
        mapMenuGui.setJMenuBar(menuBar);
        //Creating and adding a menu dropdown for managing maps
        JMenu mapCreationMenu = new JMenu("Manage Maps");
        menuBar.add(mapCreationMenu);
        JMenuItem newMap = new JMenuItem("Create New Map");
        JMenuItem saveMaps = new JMenuItem("Save Current Maps");
        JMenuItem loadMaps = new JMenuItem("Load Saved Maps");
        mapCreationMenu.add(newMap);
        mapCreationMenu.add(saveMaps);
        mapCreationMenu.add(loadMaps);
        //Adding the action listener to the buttons on the menu
        newMap.addActionListener(this);
        saveMaps.addActionListener(this);
        loadMaps.addActionListener(this);
        //Creating and adding menu item to list maps for retrieval
        mapMenuList = new JMenu("Map List");
        menuBar.add(mapMenuList);
        //Setting the completed GUI to visible
        mapMenuGui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //Stores action command as a string value
        String s = e.getActionCommand();
        System.out.println(s);
        //Action handling for new maps
        if(s.equals("Create New Map"))
        {
            //Creating a new BattleMap object
            BattleMap map = new BattleMap();
            System.out.println("Map Added");
            //Storing the BattleMap object in the map list
            mapList.add(map);
            //Creates a string corresponding to the new map
            String mapText = (mapList.size()) + " - Map";
            System.out.println("Map Text: " + mapText);
            //Creates a new menu item with the previously created string
            JMenuItem mapMenuItem = new JMenuItem(mapText);
            //Adds action listener to the new menu item
            mapMenuItem.addActionListener(this);
            //Adding the new menu item to the map list JMenu
            mapMenuList.add(mapMenuItem);
            //Repainting the GUI
            mapMenuList.repaint();
            mapMenuGui.repaint();
        }

        //Action handling for when a stored map is clicked in the menu
        if(Character.isDigit(s.charAt(0)))
        {
            //Retrieves the Map in the list at the position corresponding to the action command string, adding it to the GUI
            mapMenuGui.add(mapList.get((Character.getNumericValue(s.charAt(0))-1)));
            currentMap = mapList.get((Character.getNumericValue(s.charAt(0))-1));
            mapMenuGui.add(currentMap);
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
                    JMenuItem mapMenuItem = new JMenuItem((mapList.size()) + " - Map");
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

