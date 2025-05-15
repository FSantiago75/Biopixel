package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class AOBJ_BigFire extends Object {
    GamePanel gp;
    private int spriteCounter = 0;
    private int spriteNum = 1;
    private final int ANIMATION_SPEED = 8; // Velocidade da animação
    private BufferedImage image2, image3, image4;
    
    public AOBJ_BigFire(GamePanel gp) {
        super(gp);
        name = "Fire";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/props/bigfire1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/props/bigfire2.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/res/props/bigfire3.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/res/props/bigfire4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }

    public void update() {
        super.update(); // Chama o método update da classe pai para verificar visibilidade
        
        if (!visible) return; // Se estiver invisível, não atualiza a animação
        
        spriteCounter++;
        if(spriteCounter > ANIMATION_SPEED) {
            if(spriteNum == 1) {
                spriteNum = 2;
            } else if(spriteNum == 2) {
                spriteNum = 3;
            } else {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        if (!visible) return; // Se estiver invisível, não desenha
        
        BufferedImage currentImage = null;
        switch(spriteNum) {
            case 1:
                currentImage = this.image;
                break;
            case 2:
                currentImage = this.image2;
                break;
            case 3:
                currentImage = this.image3;
                break;
            case 4:
                currentImage = this.image4;
                break;
        }
        
        int screenX = worldX - gp.player.world_x + gp.player.screen_x;
        int screenY = worldY - gp.player.world_y + gp.player.screen_y;
        
        if(worldX + gp.tile_size > gp.player.world_x - gp.player.screen_x &&
           worldX - gp.tile_size < gp.player.world_x + gp.player.screen_x &&
           worldY + gp.tile_size > gp.player.world_y - gp.player.screen_y &&
           worldY - gp.tile_size < gp.player.world_y + gp.player.screen_y) {
            
            g2.drawImage(currentImage, screenX, screenY, gp.tile_size, gp.tile_size, null);
        }
    }
}