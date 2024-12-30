
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class virtualScreen {
    public static void main(String[] args) throws AWTException, IOException{
        Robot robot =new Robot();
        BufferedImage screenshot=robot.createScreenCapture(new Rectangle(0,0,800,600));
        
        File outputFile=new File("screenshot.png");
        
        ImageIO.write(screenshot,"png", outputFile);
    }
}
