package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_NPC4 extends Object {
    public OBJ_NPC4(GamePanel gp) {
        super(gp);
        name = "NPC4";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/npc4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

