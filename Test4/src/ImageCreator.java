import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageCreator {
    File directory = new File("");
    private String folder;
    private String fileName;

    public void setName(String folder, String fileName){
        this.folder = folder;
        this.fileName = fileName;
    }

    public BufferedImage getBufferedImage() throws IOException {

        String directoryFile = directory.getCanonicalPath();
        String fullDirectory = directoryFile + "\\src\\img\\"+folder+"\\"+fileName+".png";

        BufferedImage bufferedImage = ImageIO.read(new File(fullDirectory));

        return bufferedImage;

    }
}
