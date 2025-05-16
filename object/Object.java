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

    public Object(GamePanel gp) {
        this.gp = gp;
    }

    public void update() {
        System.out.println(gp.player.paper_num);
        // Verifica se o jogador está sobre o objeto
        if (isPlayerOnTop(gp)) {
            switch (name) {
                case "Boots":
                    if(gp.player.plastic_num == 10 && gp.key_handler.e_pressed == true) {
                        visible = false;
                        gp.player.boots_on = true;
                    }
                    break;
                case "Button":
                    if(gp.player.fire_num == 8 && gp.key_handler.e_pressed == true) {
                        visible = false;
                        gp.tile_manager.loadMap("/res/maps/mapa correto02.csv");
                    }
                    break;
                case "Fire":
                    if(gp.player.can_on == true && gp.key_handler.e_pressed == true) {
                        gp.player.fire_num++;
                        visible = false;
                    }
                    break;
                case "Can":
                    if(gp.player.paper_num == 12 && gp.player.plastic_num == 10) {
                        gp.player.can_on = true;
                        visible = false;
                    }
                    break;
                case "Paper":
                    if (gp.key_handler.e_pressed == true && gp.player.plastic_num == 10) {
                        visible = false;
                        gp.player.paper_num++;
                    }
                    break;
                case "Plastic":
                    if (gp.key_handler.e_pressed == true) {
                        gp.player.plastic_num++;
                        visible = false;
                    }
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
        return gp.player.world_x + gp.tile_size*1.5 > worldX && 
               gp.player.world_x < worldX + gp.tile_size*1.5 && 
               gp.player.world_y + gp.tile_size*1.5 > worldY && 
               gp.player.world_y < worldY + gp.tile_size*1.5;

    }
} 