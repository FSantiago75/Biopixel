package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import object.AOBJ_BigFire;
import object.AOBJ_Fire;
import object.OBJ_Paper1;
import object.OBJ_Paper2;
import object.OBJ_Paper3;
import object.OBJ_Paper4;
import object.OBJ_Plastic1;
import object.OBJ_Plastic2;
import object.OBJ_Plastic3;
import object.OBJ_Plastic4;
import object.Object;

public class UI {
    GamePanel gp;
    Font arial_40;
    Font arial_20;
    BufferedImage plastic1, plastic2, plastic3, plastic4, paper1, paper2, paper3, paper4, bigFire, fire;
    public boolean messageOn = false;
    public String message = "Press E";
    public double message_counter = 0;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("", Font.PLAIN, 40);
        arial_20 = new Font("", Font.PLAIN, 20);

        try {
            plastic1 = new OBJ_Plastic1(gp).image;
            plastic2 = new OBJ_Plastic2(gp).image;
            plastic3 = new OBJ_Plastic3(gp).image;
            plastic4 = new OBJ_Plastic4(gp).image;
            
            paper1 = new OBJ_Paper1(gp).image;
            paper2 = new OBJ_Paper2(gp).image;
            paper3 = new OBJ_Paper3(gp).image;
            paper4 = new OBJ_Paper4(gp).image;

            bigFire = new AOBJ_BigFire(gp).image;
            fire = new AOBJ_Fire(gp).image;
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagens: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void showMessage(String text) {
        message = text;
        messageOn = true;
        message_counter = 0;
    }
    public void hideMessage() {
        messageOn = false;
        message = "";
    }
    public void draw(Graphics2D g2) {
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        
        if(gp.player.plastic_num < gp.player.max_plastic) {
            if (plastic1 != null) g2.drawImage(plastic1, 0, 20, gp.tile_size, gp.tile_size, null);
            if (plastic2 != null) g2.drawImage(plastic2, 25, 20, gp.tile_size, gp.tile_size, null);
            if (plastic3 != null) g2.drawImage(plastic3, 0, 45, gp.tile_size, gp.tile_size, null);
            if (plastic4 != null) g2.drawImage(plastic4, 25, 45, gp.tile_size, gp.tile_size, null);
            g2.drawString(gp.player.plastic_num  + "/" + gp.player.max_plastic, 90, 80);
        }
        
        if(gp.player.paper_num < gp.player.max_paper && gp.player.plastic_num == gp.player.max_plastic) {
            if (paper1 != null) g2.drawImage(paper1, 0, 20, gp.tile_size, gp.tile_size, null);
            if (paper2 != null) g2.drawImage(paper2, 25, 20, gp.tile_size, gp.tile_size, null);
            if (paper3 != null) g2.drawImage(paper3, 0, 45, gp.tile_size, gp.tile_size, null);
            if (paper4 != null) g2.drawImage(paper4, 25, 45, gp.tile_size, gp.tile_size, null);
            g2.drawString(gp.player.paper_num + "/" + gp.player.max_paper, 90, 80);
        }
        
        if(gp.player.fire_num < gp.player.max_fire && gp.player.paper_num == gp.player.max_paper && gp.player.plastic_num == gp.player.max_plastic) {
            if (bigFire != null) g2.drawImage(bigFire, 10, 20, gp.tile_size, gp.tile_size, null);
            if (fire != null) g2.drawImage(fire, 35, 45, gp.tile_size, gp.tile_size, null);
            g2.drawString(gp.player.fire_num + "/" + gp.player.max_fire, 90, 80);
        }

        // Verifica se algum objeto está com showMessage true
        for (Object obj : gp.obj) {
            if (obj != null && obj.showMessage && obj.visible) {
                g2.setFont(arial_20);
                g2.drawString("Press E", gp.player.screen_x - 5, gp.player.screen_y - 10);
                break; // Mostra apenas a mensagem do primeiro objeto com showMessage true
            }
        }
    }
}

