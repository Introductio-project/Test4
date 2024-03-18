import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;
import java.util.TimerTask;

public class Map extends Canvas implements ActionListener, KeyListener {

    ImageIcon title = new ImageIcon("C:\\Users\\User\\IdeaProjects 1\\GameV0.5\\src\\img\\mainMenu\\background2.png");
    ImageIcon playerTest = new ImageIcon("C:\\Users\\User\\IdeaProjects 1\\GameV0.5\\src\\img\\game\\player.png");

    Image player;
    Image fight;
    Image chest;
    Image room;

    int time = 200;
    Timer timer = new Timer(time,this);

    ArrayList<String> arrayListRoomResult = new ArrayList();
    ArrayList<String> arrayListFightResult = new ArrayList();


    int fightIndex = 0;
    int chestIndex = 0;
    int roomIndex = 0;
    int questionIndex = 0;


    Dimension dimMinSize;

    int x = 100;
    int y = 100;

    int xChest = 200;
    int yChest = 200;

    int xFight = 150;
    int yFight = 150;

    boolean b = true;

    File directory = new File("");

    String directoryFile = directory.getCanonicalPath();
    String fullDirectoryCenterFile = directoryFile+"\\src\\run\\centerField.txt";
    //FileOutputStream fos = new FileOutputStream(fullDirectoryCenterFile);
    String fullDirectoryMapCreator = directoryFile + "\\src\\run\\MapCreator.txt";

    ArrayList<Integer> fightX = new ArrayList<>();
    ArrayList<Integer> fightY = new ArrayList<>();
    ArrayList<Integer> roomX = new ArrayList<>();
    ArrayList<Integer> roomY = new ArrayList<>();
    ArrayList<Integer> chestX = new ArrayList<>();
    ArrayList<Integer> chestY = new ArrayList<>();
    ArrayList<Integer> questX = new ArrayList<>();
    ArrayList<Integer> questY = new ArrayList<>();

    int xX = 0;
    int yY = 0;

    int startSetting = 1000;

    public Map() throws IOException {
        java.util.Timer timer2 = new java.util.Timer();

        String directoryFile = directory.getCanonicalPath();

        String fullDirectory = directoryFile + "\\src\\run\\MapCreator.txt";

        File f = new File(fullDirectory);





        timer2.schedule(new TimerTask() {
            public void run() {
                try(BufferedReader reader = new BufferedReader(new FileReader(f))) {
                    String value = reader.readLine();

                    while (value != null) {
                        //System.out.println(value);
                        value = reader.readLine();
                    }
                    reader.close();

                    if(value == null) {

                    } else {

                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        },0,1000);





        for(int i=0;i<10;i++) {
            fightX.add(i,startSetting);
            fightY.add(i,startSetting);
            chestX.add(i,startSetting);
            chestY.add(i,startSetting);
            roomX.add(i,startSetting);
            roomY.add(i,startSetting);
            questX.add(i,startSetting);
            questY.add(i,startSetting);
        }

        MapCreatorRandom mapCreatorRandom = new MapCreatorRandom();
        ArrayList arrayListFight = mapCreatorRandom.getFight();
        ArrayList arrayListRoom = mapCreatorRandom.getRoom();
        ArrayList all = mapCreatorRandom.getAll();


        System.out.println(arrayListFight);
        System.out.println(arrayListRoom);




        for(int i = 0;i<4;i++) {
            String resultRun1 = arrayListFight.get(i).toString();
            //String resultRun2 = resultRun1.replaceAll("fight","");
            String resultRun3 = resultRun1.replaceAll(","," ");
            String resultRun4 = resultRun3.replaceAll("]","");
            String resultRun5 = resultRun4.replace("[","");
            //System.out.println(resultRun5);
            arrayListFightResult.add(i,resultRun5);
        }


        for(int i = 0;i<4;i++) {
            String resultRun1 = arrayListRoom.get(i).toString();
            //String resultRun2 = resultRun1.replaceAll("room","");
            String resultRun3 = resultRun1.replaceAll(","," ");
            String resultRun4 = resultRun3.replaceAll("]","");
            String resultRun5 = resultRun4.replace("[","");
            //System.out.println(resultRun5);
            arrayListRoomResult.add(i,resultRun5);
        }







        for(int i = 0;i<63;i++) {
            String result = all.get(i).toString();
            String result2 = result.substring(0,2);
            if(i==7|i==15|i==23|i==31|i==39|i==47|i==55|i==63){
                yY = yY+50;
                xX=xX-350;
            } else {
                xX = xX+50;
            }

            if(result2.equals("[f")) {
                fightX.set(fightIndex,xX);
                fightY.set(fightIndex,yY);
                fightIndex++;

            }
            if(result2.equals("[c")) {
                chestX.set(chestIndex,xX);
                chestY.set(chestIndex,yY);
                chestIndex++;

            }
            if(result2.equals("[q")) {
                questX.set(questionIndex,xX);
                questY.set(questionIndex,yY);
                questionIndex++;

            }
            if(result2.equals("[r")) {
                roomX.set(roomIndex,xX);
                roomY.set(roomIndex,yY);
                roomIndex++;

            }
            if(result == "[]") {

            }
            //System.out.println(result2);

        }

        timer.start();

        System.out.println("Start");
        this.setFocusable(true);  //  Сосредоточьтесь
        this.addKeyListener(this); //  Слушайте события клавиатуры
        dimMinSize = new Dimension(400, 400);

        ImageCreator imageCreator = new ImageCreator();
        imageCreator.setName("game","MapPlayerA");
        try {
            player = imageCreator.getBufferedImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageCreator.setName("game","MapFight");
        try {
            fight = imageCreator.getBufferedImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageCreator.setName("game","MapChest");
        try {
            chest = imageCreator.getBufferedImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageCreator.setName("game","MapEmptyRoom");
        try {
            room = imageCreator.getBufferedImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(fightX+"rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");

    }

    public void paint(Graphics g) {

        title.paintIcon(this,g,0,0);
        // player.paintIcon(this ,g,x,y);


        g.drawImage(fight,fightX.get(0),fightY.get(0),this);
        g.drawImage(fight,fightX.get(1),fightY.get(1),this);
        g.drawImage(fight,fightX.get(2),fightY.get(2),this);
        g.drawImage(fight,fightX.get(3),fightY.get(3),this);
        g.drawImage(fight,fightX.get(4),fightY.get(4),this);
        g.drawImage(fight,fightX.get(5),fightY.get(5),this);

        g.drawImage(chest,chestX.get(0),chestY.get(0),this);
        g.drawImage(chest,chestX.get(1),chestY.get(1),this);
        g.drawImage(chest,chestX.get(2),chestY.get(2),this);

        g.drawImage(room,roomX.get(0),roomY.get(0),this);
        g.drawImage(room,roomX.get(1),roomY.get(1),this);
        g.drawImage(room,roomX.get(2),roomY.get(2),this);
        g.drawImage(room,roomX.get(3),roomY.get(3),this);
        g.drawImage(room,roomX.get(4),roomY.get(4),this);
        g.drawImage(room,roomX.get(5),roomY.get(5),this);

        g.drawImage(player,x,y,this);

    }

    public Dimension getPreferredSize()
    {
        return dimMinSize;
    }

    public Dimension getMinimumSize()
    {
        return dimMinSize;
    }

    public Dimension preferredSize()
    {
        return dimMinSize;
    }

    public Dimension minimumSize()
    {
        return dimMinSize;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {



        if(x==roomX.get(0)&&y==roomY.get(0)) {
            System.out.println("ROOOM 0 ++++++++++++++++++++++++++");
            String data = arrayListRoomResult.get(0);
            try {
                FileWriter writer = new FileWriter(fullDirectoryCenterFile);
                writer.write(data);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(x==roomX.get(1)&&y==roomY.get(1)) {
            System.out.println("ROOOM 1 ++++++++++++++++++++++++++");
            String data = arrayListRoomResult.get(1);
            try {
                FileWriter writer = new FileWriter(fullDirectoryCenterFile);
                writer.write(data);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(x==roomX.get(2)&&y==roomY.get(2)) {
            System.out.println("ROOOM 2 ++++++++++++++++++++++++++");

        }
        if(x==roomX.get(3)&&y==roomY.get(3)) {
            System.out.println("ROOOM 3 ++++++++++++++++++++++++++");

        }
        if(x==roomX.get(4)&&y==roomY.get(4)) {
            System.out.println("ROOOM 4 ++++++++++++++++++++++++++");

        }
        if(x==roomX.get(5)&&y==roomY.get(5)) {
            System.out.println("ROOOM 5 ++++++++++++++++++++++++++");

        }
        if(x==fightX.get(0)&&y==fightY.get(0)) {
            System.out.println("FIGHT 0 ++++++++++++++++++++++++++");

        }
        if(x==fightX.get(1)&&y==fightY.get(1)) {
            System.out.println("FIGHT 1 ++++++++++++++++++++++++++");

        }
        if(x==fightX.get(2)&&y==fightY.get(2)) {
            System.out.println("FIGHT 2 ++++++++++++++++++++++++++");

        }
        if(x==fightX.get(3)&&y==fightY.get(3)) {
            System.out.println("FIGHT 3 ++++++++++++++++++++++++++");

        }
        if(x==fightX.get(4)&&y==fightY.get(4)) {
            System.out.println("FIGHT 4 ++++++++++++++++++++++++++");

        }
        if(x==chestX.get(0)&&y==chestY.get(0)) {
            System.out.println("CHEST 0 ++++++++++++++++++++++++++");

        }
        if(x==chestX.get(1)&&y==chestY.get(1)) {
            System.out.println("CHEST 1 ++++++++++++++++++++++++++");

        }
        if(x==chestX.get(2)&&y==chestY.get(2)) {
            System.out.println("CHEST 2 ++++++++++++++++++++++++++");

        }






    }



    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println("KeyTyped");
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int KeyCode = keyEvent.getKeyCode();

        if (KeyCode == KeyEvent.VK_SPACE) {
            System.out.println("Space");
        }

        if (KeyCode == KeyEvent.VK_UP){
            System.out.println("Up");
            y = y-50;
            repaint();
        }

        if (KeyCode == KeyEvent.VK_DOWN){
            System.out.println("Down");
            y = y+50;
            repaint();
        }

        if (KeyCode == KeyEvent.VK_RIGHT){
            System.out.println("Right");
            x = x+50;
            repaint();
        }

        if (KeyCode == KeyEvent.VK_LEFT){
            System.out.println("Left");
            x = x-50;
            repaint();
        }


    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
