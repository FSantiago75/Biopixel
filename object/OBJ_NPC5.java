package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_NPC5 extends Object {
    public OBJ_NPC5(GamePanel gp) {
        super(gp);
        name = "NPC1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/npc5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

