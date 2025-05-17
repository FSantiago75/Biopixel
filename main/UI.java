package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
public class UI {
    GamePanel gp;
    Font arial_40;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("", Font.PLAIN, 40);
    }

    public void draw(Graphics2D g2) {
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        if(gp.player.plastic_num < gp.player.max_plastic) {
            g2.drawString("Plastic: " + gp.player.plastic_num  + "/" + gp.player.max_plastic, 50, 50);
        }
        if(gp.player.paper_num < gp.player.max_paper && gp.player.plastic_num == gp.player.max_plastic) {
            g2.drawString("Papers:" + gp.player.paper_num + "/" + gp.player.max_paper, 50, 50);
        }
        
        if(gp.player.fire_num < gp.player.max_fire && gp.player.paper_num == gp.player.max_paper && gp.player.plastic_num == gp.player.max_plastic) {
            g2.drawString("Fire: " + gp.player.fire_num + "/" + gp.player.max_fire, 50, 50);
        }
    }
}

