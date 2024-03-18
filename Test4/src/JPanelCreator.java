import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class JPanelCreator {

    private String name1;
    private String name2;
    JLayeredPane panel = new JLayeredPane();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();

    JPanel boxPanel = new JPanel();
    JPanel chestPanel = new JPanel();
    JPanel pineTreePanel = new JPanel();
    JPanel treePanel = new JPanel();

    JPanel boxPanel2 = new JPanel();
    JPanel chestPanel2 = new JPanel();
    JPanel pineTreePanel2 = new JPanel();
    JPanel treePanel2 = new JPanel();

    public void setName(String name1, String name2){
        this.name1 = name1;
        this.name2 = name2;
    }

    ArrayList<JLayeredPane> arrayListJPanel = new ArrayList<>();
    JPanelCreator(String name3,String name4,String name5) throws IOException {

        ImageCreator imageCreator = new ImageCreator();
        CustomRoomItemCreator customRoomItemCreator = new CustomRoomItemCreator();

        imageCreator.setName("game","room");
        Image room = imageCreator.getBufferedImage();



       imageCreator.setName("game","box");
       Image box = imageCreator.getBufferedImage();
       imageCreator.setName("game","chest");
       Image chest = imageCreator.getBufferedImage();
       imageCreator.setName("game","pineTree");
       Image pineTree = imageCreator.getBufferedImage();
       imageCreator.setName("game","tree");
       Image tree = imageCreator.getBufferedImage();


       //MapCreatorRandom mapCreatorRandom = new MapCreatorRandom();

       //ArrayList fightRoom = mapCreatorRandom.getFight();
       //ArrayList roomRoom = mapCreatorRandom.getRoom();

       RoomItemCreator itemBox = new RoomItemCreator(customRoomItemCreator,box,box,name5,"null",200,200);
       RoomItemCreator itemChest = new RoomItemCreator(customRoomItemCreator,chest,chest,name5,"null",200,200);
       RoomItemCreator itemPineTree = new RoomItemCreator(customRoomItemCreator,pineTree,pineTree,name5,"null",200,200);
       RoomItemCreator itemTree = new RoomItemCreator(customRoomItemCreator,tree,tree,name5,"null",200,200);
       RoomItemCreator roomm = new RoomItemCreator(customRoomItemCreator,room,room,name5,"null",1200,900);

       System.out.println("JPanelCreator"+" "+name3+" "+name4);

       if(name3.equals("null")) {
           System.out.println("JPanelCreator");
       } else {
           System.out.println("JPanelCreator ELSE");
           if(name3.equals("box")) {
               boxPanel.add(itemBox);
               boxPanel.setBounds(500,500,200,200);
               boxPanel.setBackground(Color.darkGray);
           }
           if(name3.equals("tree")) {
               treePanel.add(itemTree);
               treePanel.setBounds(400,400,200,200);
               treePanel.setBackground(Color.darkGray);
           }
           if(name3.equals("pineTree")) {
               pineTreePanel.add(itemPineTree);
               pineTreePanel.setBounds(300,300,200,200);
               pineTreePanel.setBackground(Color.darkGray);
           }
           if(name3.equals("chest")) {
               chestPanel.add(itemChest);
               chestPanel.setBounds(200,200,200,200);
               chestPanel.setBackground(Color.darkGray);
           }
       }

       if(name4.equals("null")) {

        } else {
            if(name4.equals("box")) {
                boxPanel2.add(itemBox);
                boxPanel2.setBounds(500,500,200,200);
                boxPanel2.setBackground(Color.darkGray);
            }
            if(name4.equals("tree")) {
                treePanel2.add(itemTree);
                treePanel2.setBounds(400,400,200,200);
                treePanel2.setBackground(Color.darkGray);
            }
            if(name4.equals("pineTree")) {
                pineTreePanel2.add(itemPineTree);
                pineTreePanel2.setBounds(300,300,200,200);
                pineTreePanel2.setBackground(Color.darkGray);
            }
            if(name4.equals("chest")) {
                chestPanel2.add(itemChest);
                chestPanel2.setBounds(200,200,200,200);
                chestPanel2.setBackground(Color.darkGray);
            }
        }

        panel2.add(roomm);
       panel2.setVisible(true);
       panel2.setBounds(10,10,1000,900);

       panel3.add(itemPineTree);
       panel3.setBounds(300,300,200,210);
       panel3.setBackground(Color.darkGray);

       panel.add(panel2,new Integer(1));
       panel.add(boxPanel,new Integer(2));
        panel.add(boxPanel2,new Integer(2));
        panel.add(chestPanel,new Integer(2));
        panel.add(chestPanel2,new Integer(2));
        panel.add(pineTreePanel,new Integer(2));
        panel.add(pineTreePanel2,new Integer(2));
        panel.add(treePanel,new Integer(2));
        panel.add(treePanel2,new Integer(2));



        if(name1 == null) {

        } else {

        }






        panel.setVisible(true);
       panel.setBounds(10,10,1000,900);


       arrayListJPanel.add(panel);


    }

    public ArrayList<JLayeredPane> getJPanel() {
        return arrayListJPanel;
    }

}
