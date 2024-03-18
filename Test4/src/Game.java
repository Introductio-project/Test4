import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

public class Game {
    ArrayList<String> arrayListTest = new ArrayList<>();
    boolean b = true;
    boolean b2 = false;

    String data = "nulll";
    String data2 = "nulll";
    String data3 = "nulll";

    public Game() throws IOException {
        ImageCreator imageCreator = new ImageCreator();


        BufferedReader reader2;


        File directory = new File("");
        String directoryFile = directory.getCanonicalPath();

        String fullDirectoryCenterField = directoryFile + "\\src\\run\\centerField.txt";
        String fullDirectoryRoomItem = directoryFile + "\\src\\run\\roomItem.txt";

        File f = new File(fullDirectoryCenterField);
        File f2 = new File(fullDirectoryRoomItem);



        //directoryFile = directory.getCanonicalPath();

        String fullDirectoryStartIconB = directoryFile + "\\src\\img\\mainMenu\\startButtonB.png";
        String fullDirectoryStartIconA = directoryFile + "\\src\\img\\mainMenu\\startButtonA.png";

        BufferedImage startIconA = ImageIO.read(new File(fullDirectoryStartIconA));
        BufferedImage startIconB = ImageIO.read(new File(fullDirectoryStartIconB));

        CustomButton customButton = new CustomButton();

        //create write File

        FileOutputStream fos = null;
        fos = new FileOutputStream(fullDirectoryCenterField);

        String mainMenuFileData = "null";
        fos.write(mainMenuFileData.getBytes());

        FileOutputStream fos2 = null;
        fos2 = new FileOutputStream(fullDirectoryRoomItem);

        String mainMenuFileData2 = "null";
        fos2.write(mainMenuFileData2.getBytes());


        //create write File

        ButtonCreator StartButton = new ButtonCreator(customButton, startIconA, startIconB, "r", 300, 60);
        ButtonCreator StartButton2 = new ButtonCreator(customButton, startIconA, startIconB, "r", 300, 60);
        ButtonCreator StartButton3 = new ButtonCreator(customButton, startIconA, startIconB, "r", 300, 60);
        ButtonCreator StartButton4 = new ButtonCreator(customButton, startIconA, startIconB, "r", 300, 60);
        ButtonCreator StartButton5 = new ButtonCreator(customButton, startIconA, startIconB, "r", 300, 60);



        JPanel jPanelWest = new JPanel();
        JPanel jPanelEast = new JPanel();
        JLayeredPane jPanelCenter = new JLayeredPane();
        JPanel jPanelSouth = new JPanel();
        JPanel jPanelNorth = new JPanel();
        JPanel jPanelCenterNorth = new JPanel();
        JPanel jPanelCenterSouth = new JPanel();
        JPanel jPanelCenterNorthA = new JPanel();
        JPanel jPanelCenterNorthB = new JPanel();
        JPanel jPanelCenterSouthA = new JPanel();
        JPanel jPanelCenterSouthB = new JPanel();

        GridLayout grid = new GridLayout(2,0);
        GridLayout grid2 = new GridLayout(2,0);

        Map map = new Map();
        JFrame frame = new JFrame();
        Container container  = frame.getContentPane();




        //jPanelCenter.add(StartButton4);
        //jPanelCenter.add(battle);
        jPanelCenterNorth.add(jPanelCenterNorthA,BorderLayout.SOUTH);
        jPanelCenterNorth.add(jPanelCenterNorthB,BorderLayout.NORTH);
        jPanelCenterSouth.add(jPanelCenterSouthA,BorderLayout.SOUTH);
        jPanelCenterSouth.add(jPanelCenterSouthB,BorderLayout.NORTH);
        jPanelCenter.add(jPanelCenterNorth,BorderLayout.NORTH);
        jPanelCenter.add(jPanelCenterSouth,BorderLayout.SOUTH);
        jPanelCenter.setLayout(grid);
        jPanelCenterNorth.setLayout(grid);
        jPanelCenterSouth.setLayout(grid);



        jPanelWest.add(map);
        jPanelEast.add(StartButton);
        jPanelNorth.add(StartButton2);
        jPanelSouth.add(StartButton3);

        // Empty room




        JLayeredPane CenterJLayeredPane = new JLayeredPane();
        JLayeredPane CenterJLayeredPane2 = new JLayeredPane();




        // Empty room

        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("yes");

        jPanelCenter.setBounds(10,10,1000,900);


        CenterJLayeredPane.setVisible(true);
        CenterJLayeredPane.setBounds(10,10,1000,1000);
        CenterJLayeredPane.setBackground(Color.BLACK);

        CenterJLayeredPane2.setVisible(true);
        CenterJLayeredPane2.setBounds(10,10,1000,1000);
        CenterJLayeredPane2.setBackground(Color.BLACK);

        CenterJLayeredPane.add(CenterJLayeredPane2);

        java.util.Timer timer = new java.util.Timer();
        java.util.Timer timer2 = new Timer();

        String fullDirectory = directoryFile + "\\src\\run\\MapCreator.txt";
        String fullDirectory2 = directoryFile + "\\src\\run\\centerField.txt";

        File fF = new File(fullDirectory);
        File fF2 = new File (fullDirectory2);
        // Обработка кнопок
        arrayListTest.add("null");
        arrayListTest.add("null");
        arrayListTest.add("null");
        arrayListTest.add("null");
        arrayListTest.add("null");



        //CenterJLayeredPane.add(panel.get(0));


        timer.schedule(new TimerTask() {
            public void run() {

                try(BufferedReader reader = new BufferedReader(new FileReader(fF2))) {
                    String value = reader.readLine();
                    reader.close();


                    if(value == null) {
                        System.out.println("CATCHCATCHCATCHCATCHCATCHCATCHCATCHCATCHCATCHCATCHCATCHCATCHCATCH");
                    } else {
                        String test = value;
                        String[] arrSplit = test.split(" ");
                        for (int i=0; i < arrSplit.length; i++)
                        {
                            String res = arrSplit[i];
                            arrayListTest.set(i,res);
                        }


                            if(arrayListTest.get(1).equals("null")) {

                            } else {

                                //| data.equals("nulll")&&data2.equals("nulll")&&data3.equals("nulll")

                                if(arrayListTest.get(0).equals(data)&&arrayListTest.get(1).equals(data2)&&arrayListTest.get(2).equals(data3) ) {
                                    b=false;
                                    System.out.println("IFIFIFIFIFIFIF");
                                } else {
                                    System.out.println("removeAll");
                                    b=true;
                                    CenterJLayeredPane2.removeAll();
                                }


                                JPanelCreator creator = new JPanelCreator(arrayListTest.get(1), arrayListTest.get(2),arrayListTest.get(0));
                                ArrayList<JLayeredPane> panel = creator.getJPanel();

                                System.out.println(arrayListTest.get(1) + " " + arrayListTest.get(2));


                                if (b == true) {

                                    if (arrayListTest.get(1).equals("null")) {

                                    } else {
                                        System.out.println("start");
                                        CenterJLayeredPane2.add(panel.get(0),1,new Integer(1));
                                        b=false;
                                    }

                                } else {

                                }
                            }

                        data = arrayListTest.get(0);
                        data2 = arrayListTest.get(1);
                        data3 = arrayListTest.get(2);


                    }


                } catch (IOException ex) {
                    ex.printStackTrace();

                }

                //System.out.println("test");

            }
        },0,1000);


        // Обработка панели

        timer.schedule(new TimerTask() {
            public void run() {


                try(BufferedReader reader = new BufferedReader(new FileReader(f))) {
                    String value = reader.readLine();
                    reader.close();
                    if(value == null) {
                        System.out.println("CATCH");
                    } else {

                    }



                } catch (IOException ex) {
                    ex.printStackTrace();

                }



                //System.out.println("Timer");
            }
        },0,100);



        container.add(jPanelWest,BorderLayout.WEST);
        container.add(jPanelEast,BorderLayout.EAST);

        //container.add(jPanelRoom,BorderLayout.CENTER);

        container.add(CenterJLayeredPane,BorderLayout.CENTER);

        container.add(jPanelSouth,BorderLayout.SOUTH);
        container.add(jPanelNorth,BorderLayout.NORTH);
        frame.setBounds(10,10,1920,1080);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
