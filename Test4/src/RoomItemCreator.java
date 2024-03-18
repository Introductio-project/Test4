import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

class RoomItemCreator extends Canvas
{
    Image imgButtonUp;
    Image imgButtonDn;
    Container cont;
    int btnWidth;
    int btnHeight;
    Dimension dimMinSize;
    boolean bButtonUp = true;
    boolean bButtonEnter = true;

    String btnTitle;

    File directory = new File("");
    String directoryFile = directory.getCanonicalPath();

    String fullDirectoryMainMenuFile = directoryFile+"\\src\\RunnableMainMenu.txt";
    File f2 = new File(fullDirectoryMainMenuFile);

    FileOutputStream fos = new FileOutputStream(fullDirectoryMainMenuFile);

    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> arrayList2 = new ArrayList<>();

    int stringNumber = 0;


    public RoomItemCreator(Container parent,
                           Image imgUp, Image imgDn,
                           String btnTitle,String name, int width, int height) throws IOException {

        fos = new FileOutputStream(fullDirectoryMainMenuFile);

        imgButtonUp = imgUp;
        imgButtonDn = imgDn;
        cont = parent;

        btnWidth  = width;
        btnHeight = height;
        this.btnTitle = btnTitle;

        dimMinSize = new Dimension(btnWidth, btnHeight);

        JPanel panel = new JPanel();

        String directoryFile = directory.getCanonicalPath();
        String fullDirectory2 = directoryFile + "\\src\\run\\MapCreator.txt";
        File fF2 = new File (fullDirectory2);
        BufferedReader reader = new BufferedReader(new FileReader(fF2));
        String value = reader.readLine();
        while (value != null) {
            //System.out.println(value);
            int t = 0;
            arrayList.add(value);
            value = reader.readLine();
            //System.out.println(value+"test value");
            t++;
        }

        for (int i = 0;i<8;i++) {
            String test = arrayList.get(i);
            try{
                int r = test.indexOf(btnTitle);
                int r2 = test.substring(r,r+40).indexOf("]");
                int r3 = r+r2;
                System.out.println(r+" "+r2+"r222222222222222222222222222222222222222222222222222222222222222222222222222222222222222");
                String run = test.substring(r,r3);
                System.out.println(run+"run");

            } catch (Exception ex){

            }
            //System.out.println(btnTitle);
        }

        for(int i = 0;i<8;i++) {
            String res = arrayList.get(i);
            String res2 = res.replace("box","xxxxx");
            //System.out.println(res2+"xxxxxxxxx");
            arrayList2.add(res2);
        }


        FileWriter fileWriter = new FileWriter(fullDirectory2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        int ss = 0;

        for (int i = 0;i<8;i++) {

            bufferedWriter.write(arrayList2.get(i));
            ss++;
            bufferedWriter.append('\n');
        }
        bufferedWriter.close();

        for(int i = 0;i<8;i++) {

        }



        reader.close();

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

    public void paint(Graphics g)
    {
        FontMetrics fm = g.getFontMetrics();
        int nTitileWidth = fm.stringWidth(btnTitle);
        int nTitleHeight = fm.getAscent() -
                fm.getLeading() - fm.getDescent();

        int x0 = (btnWidth - nTitileWidth) / 2;
        int y0 = ((btnHeight - nTitleHeight) / 2) +
                nTitleHeight;

        if(bButtonEnter == true) {
            g.drawImage(imgButtonDn, 0, 0, this);
            setBackground(Color.BLACK);
        }
        if(bButtonUp == true)
        {
            g.drawImage(imgButtonUp, 0, 0, this);
            setBackground(Color.BLACK);
        }
    }

    public boolean mouseDown(
            Event ev, int x, int y)
    {
        System.out.println("mouseDown");
        return true;
    }

    public boolean mouseUp(
            Event ev, int x, int y)
    {
        if(btnTitle == "tree") {

            String mainMenuFileData = "Start";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Start");

        }

        return true;

    }

    public boolean mouseEnter(
            Event ev, int x, int y)
    {
        bButtonUp = false;
        repaint();
        return true;
    }

    public boolean mouseExit(
            Event ev, int x, int y)
    {
        bButtonUp = true;
        repaint();
        return true;
    }

    public boolean mouseClick(Event ev,int x, int y) {
        return true;
    }

    public void run()
    {

    }

    public void doButtonAction()
    {
        ((CustomRoomItemCreator)cont).doButtonAction(this);
    }
}

