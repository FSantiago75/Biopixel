package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.GamePanel;

public class Object {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public boolean visible = true;
    protected GamePanel gp;

    public Object(GamePanel gp) {
        this.gp = gp;
    }

    public void update() {
        // Verifica se o jogador está sobre o objeto
        if (isPlayerOnTop(gp)) {
            visible = false;
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
        return gp.player.world_x + gp.tile_size > worldX && 
               gp.player.world_x < worldX + gp.tile_size && 
               gp.player.world_y + gp.tile_size > worldY && 
               gp.player.world_y < worldY + gp.tile_size;
    }
} 