package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Can extends Object {
    public OBJ_Can(GamePanel gp) {
        super(gp);
        name = "Can";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/can.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

