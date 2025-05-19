package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Battery extends Object {
    public OBJ_Battery(GamePanel gp) {
        super(gp);
        name = "Battery";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/battery.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

