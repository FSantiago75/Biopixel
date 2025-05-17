package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;

public class Entity {
    
    GamePanel gp;

    public int world_x, world_y;
    public int speed;

    public BufferedImage down1, down2, down3, down4, down5, down6, down7, down8, left1, left2, left3, left4, left5, left6, left7, left8, right1, right2, right3, right4, right5, right6, right7, right8, up1, up2, up3, up4, up5, up6, up7, up8, down_idle_1, down_idle_2, down_idle_3, down_idle_4, left_idle_1, left_idle_2, left_idle_3, left_idle_4, right_idle_1, right_idle_2, right_idle_3, right_idle_4, up_idle_1, up_idle_2, up_idle_3, up_idle_4;
    public String direction;

    public int sprite_counter = 0;
    public int sprite_num = 1;
    
    public Rectangle solidArea;

    public boolean collisionOn = false;
}
