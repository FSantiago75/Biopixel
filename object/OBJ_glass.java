package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_glass extends Object {
    public OBJ_glass(GamePanel gp) {
        super(gp);
        name = "Glass";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/glass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

