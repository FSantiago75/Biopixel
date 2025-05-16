package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_boots extends Object {
    public OBJ_boots(GamePanel gp) {
        super(gp);
        name = "Boots";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/boots.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

