import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// ===========================================
// Class cButton
// ===========================================
class ButtonCreator extends Canvas
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

    Thread threadAnimate = null;
    Color clrTitleColor = Color.black;

    File directory = new File("");
    String directoryFile = directory.getCanonicalPath();

    String fullDirectoryMainMenuFile = directoryFile+"\\src\\RunnableMainMenu.txt";
    File f2 = new File(fullDirectoryMainMenuFile);

    FileOutputStream fos = new FileOutputStream(fullDirectoryMainMenuFile);




    public ButtonCreator(Container parent,
                         Image imgUp, Image imgDn,
                         String btnTitle, int width, int height) throws IOException {

        fos = new FileOutputStream(fullDirectoryMainMenuFile);
        String mainMenuFileData = "----";
        //fos.write(mainMenuFileData.getBytes());

        imgButtonUp = imgUp;
        imgButtonDn = imgDn;
        cont = parent;

        btnWidth  = width;
        btnHeight = height;
        this.btnTitle = btnTitle;

        dimMinSize = new Dimension(btnWidth, btnHeight);

        JPanel panel = new JPanel();

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
        if(btnTitle == "Start") {

            String mainMenuFileData = "Start";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Start");

        }
        if(btnTitle == "Option") {

            String mainMenuFileData = "Option";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Option");

        }
        if(btnTitle == "Gallery") {

            String mainMenuFileData = "Gallery";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Gallery");

        }
        if(btnTitle == "Exit") {
            String mainMenuFileData = "Exit";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Exit");
        }
        if(btnTitle == "Resolution") {
            String mainMenuFileData = "Resolution";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Resolution");
        }
        if(btnTitle == "1280x720") {
            String mainMenuFileData = "1280x720";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("1280x720");
        }
        if(btnTitle == "1920x1080") {
            String mainMenuFileData = "1920x1080";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("1920x1080");
        }
        if(btnTitle == "2560x1440") {
            String mainMenuFileData = "2560x1440";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("2560x1440");
        }
        if(btnTitle == "ON") {
            String mainMenuFileData = "ON";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("ON");
        }
        if(btnTitle == "OFF") {
            String mainMenuFileData = "OFF";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("OFF");
        }
        if(btnTitle == "Language") {
            String mainMenuFileData = "Language";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Language");
        }
        if(btnTitle == "FullSize") {
            String mainMenuFileData = "FullSize";
            try {
                fos = new FileOutputStream(fullDirectoryMainMenuFile);
                fos.write(mainMenuFileData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("FullSize");
        }
        System.out.println("mouseUp");
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
        ((CustomButton)cont).doButtonAction(this);
    }
}




        //    try {
                //    String fileData = "Some Test";
               //     File f = new File("D:\\example.txt");
                 //   FileOutputStream fos = new FileOutputStream("D:\\example.txt");
                //    fos.write(fileData.getBytes());
                 //   if (f.createNewFile())
                 //   System.out.println("File created");
                 //   else
                 //   System.out.println("File already exists");
                   // new Option();
                //    } catch (IOException e) {
                   // e.printStackTrace();
               //     }