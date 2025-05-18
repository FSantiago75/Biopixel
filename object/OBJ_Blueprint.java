package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Blueprint extends Object {
    public OBJ_Blueprint(GamePanel gp) {
        super(gp);
        name = "Blueprint";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/blueprint.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

