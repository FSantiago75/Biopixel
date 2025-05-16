package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Plastic4 extends Object {
    public OBJ_Plastic4(GamePanel gp) {
        super(gp);
        name = "Plastic";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/plastic4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

