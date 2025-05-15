package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Fire extends Object {
    public OBJ_Fire(GamePanel gp) {
        super(gp);
        name = "Fire";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/fire1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

