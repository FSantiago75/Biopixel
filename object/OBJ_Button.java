package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Button extends Object {
    public OBJ_Button(GamePanel gp) {
        super(gp);
        name = "Button";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/button1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

