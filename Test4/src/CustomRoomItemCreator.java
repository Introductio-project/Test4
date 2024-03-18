import java.applet.Applet;
import java.io.IOException;

public class CustomRoomItemCreator extends Applet
{


    public CustomRoomItemCreator() throws IOException {
    }

    // ===========================================
    // init
    // ===========================================
    public void init()
    {

    }

    // ===========================================
    // getAppletInfo
    // ===========================================
    public String getAppletInfo()
    {
        return "Name: Custom Button";
    }

    // ===========================================
    // doButtonAction
    // ===========================================
    public void doButtonAction(RoomItemCreator btn)
    {

        repaint();
    }

}

