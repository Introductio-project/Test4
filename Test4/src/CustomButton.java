import java.applet.Applet;
import java.io.IOException;

// ===========================================
// Class CustomButton
// ===========================================
public class CustomButton extends Applet
{


  public CustomButton() throws IOException {
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
  public void doButtonAction(ButtonCreator btn)
  {

    repaint();
  }

}

