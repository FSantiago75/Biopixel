package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Paper1 extends Object {
    public OBJ_Paper1(GamePanel gp) {
        super(gp);
        name = "Paper";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/paper1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

