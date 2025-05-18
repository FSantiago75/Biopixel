package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_NPC2 extends Object {
    public OBJ_NPC2(GamePanel gp) {
        super(gp);
        name = "NPC2";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/npc2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

