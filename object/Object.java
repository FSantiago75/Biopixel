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
    public boolean showMessage = false;
    public String message = "Press E"; //Atualização futura de personalziar mensagem
    KeyHandler key_handler;

    public Object(GamePanel gp) {
        this.gp = gp;
    }

    public void update() {
        // Só atualiza se o objeto estiver visível
        if (!visible) return;

        // Verifica se o jogador está sobre o objeto
        boolean isPlayerOnTop = isPlayerOnTop(gp);
        boolean keyPressed = gp.key_handler.e_pressed;
        
        // Se o jogador não está sobre o objeto, reseta o estado
        if (!isPlayerOnTop) {
            showMessage = false;
            return;
        }

        // Verifica as condições de interação baseado no tipo do objeto
        boolean canInteract = false;
        
        switch (name) {
            case "Boots":
                canInteract = (gp.player.plastic_num == 10);
                if (canInteract && keyPressed) {
                    visible = false;
                    gp.player.boots_on = true;
                    showMessage = false;
                }
                break;
                
            case "Button":
                canInteract = (gp.player.fire_num == 8);
                if (canInteract && keyPressed) {
                    visible = false;
                    gp.tile_manager.loadMap("/res/maps/mapa correto02.csv");
                    showMessage = false;
                }
                break;
                
            case "Fire":
                canInteract = (gp.player.can_on);
                if (canInteract && keyPressed) {
                    gp.player.fire_num++;
                    visible = false;
                    showMessage = false;

                }
                break;
                
            case "Can":
                canInteract = (gp.player.paper_num == 12 && gp.player.plastic_num == 10);
                if (canInteract && keyPressed) {
                    gp.player.can_on = true;
                    visible = false;
                    showMessage = false;
                }
                break;
                
            case "Paper":
                canInteract = (gp.player.plastic_num == 10);
                if (canInteract && keyPressed) {
                    visible = false;
                    gp.player.paper_num++;
                    showMessage = false;
                }
                break;
                
            case "Plastic":
                if (keyPressed) {
                    gp.player.plastic_num++;
                    visible = false;
                    showMessage = false;
                }
                break;
        }
        
        // Atualiza o showMessage baseado na interatividade apenas se não foi coletado
        if (visible) {
            showMessage = canInteract || name.equals("Plastic");
        }
    }

    public void draw(Graphics2D g2, GamePanel gp) {   
        if (!visible) return;
        
        int screenX = worldX - gp.player.world_x + gp.player.screen_x;
        int screenY = worldY - gp.player.world_y + gp.player.screen_y;

        // Só desenha se estiver na tela
        if(worldX + gp.tile_size > gp.player.world_x - gp.player.screen_x &&
           worldX - gp.tile_size < gp.player.world_x + gp.player.screen_x &&
           worldY + gp.tile_size > gp.player.world_y - gp.player.screen_y &&
           worldY - gp.tile_size < gp.player.world_y + gp.player.screen_y) {
            
            g2.drawImage(image, screenX, screenY, gp.tile_size, gp.tile_size, null);
        }
    }

    public boolean isPlayerOnTop(GamePanel gp) {
        return gp.player.world_x + gp.tile_size*1.5 > worldX && 
               gp.player.world_x < worldX + gp.tile_size*1.5 && 
               gp.player.world_y + gp.tile_size*1.5 > worldY && 
               gp.player.world_y < worldY + gp.tile_size*1.5;
    }
} 