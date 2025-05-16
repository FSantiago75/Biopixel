package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.KeyHandler;

public class Object {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public boolean visible = true;
    protected GamePanel gp;
    KeyHandler key_handler;
    public int fire_num = 0;

    public Object(GamePanel gp) {
        this.gp = gp;
    }

    public void update() {
        System.out.println(fire_num);
        // Verifica se o jogador está sobre o objeto
        if (isPlayerOnTop(gp)) {
            switch (name) {
                case "Boots":
                    visible = false;
                    gp.player.boots_on = true;
                    break;
                case "Glass":
                    visible = false;
                    gp.glass_on();
                    break;
                case "Button":
                    if(fire_num == 8) {
                        visible = false;
                        gp.tile_manager.loadMap("/res/maps/map1.csv");
                    }
                    break;
                case "Fire":
                    fire_num += 1;
                    visible = false;
                    break;
                default:
                    break;
            }
        } else {
            visible = true;
        }
    }

    public void draw(Graphics2D g2, GamePanel gp){   
        if (!visible) return;
        
        int screenX = worldX - gp.player.world_x + gp.player.screen_x;
        int screenY = worldY - gp.player.world_y + gp.player.screen_y;

        if(worldX + gp.tile_size > gp.player.world_x - gp.player.screen_x &&
           worldX - gp.tile_size < gp.player.world_x + gp.player.screen_x &&
           worldY + gp.tile_size > gp.player.world_y - gp.player.screen_y &&
           worldY - gp.tile_size < gp.player.world_y + gp.player.screen_y){
            
            g2.drawImage(image, screenX, screenY, gp.tile_size, gp.tile_size, null);
        }
    }

    public boolean isPlayerOnTop(GamePanel gp) {
        // Verifica se o jogador está sobre o objeto
        return gp.player.world_x + gp.tile_size/2 > worldX && 
               gp.player.world_x < worldX + gp.tile_size/2 && 
               gp.player.world_y + gp.tile_size/2 > worldY && 
               gp.player.world_y < worldY + gp.tile_size/2;
    }
} 