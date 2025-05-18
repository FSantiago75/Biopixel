package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler key_handler;

    public final int screen_x;
    public final int screen_y;
    public int worldX;
    public boolean boots_on = false;
    public boolean can_on = false;
    public boolean hasBattery = false;
    public boolean usinaRecarregada = false;
    public int fire_num = 0;
    public int paper_num = 0;
    public int plastic_num = 0;
    public int max_paper = 12;
    public int max_plastic = 10;
    public int max_fire = 8;
    public Player(GamePanel gp, KeyHandler key_handler) {

        this.gp = gp;

        this.key_handler = key_handler;

        screen_x = gp.screen_width/2 - (gp.tile_size/2);
        screen_y = gp.screen_height/2 - (gp.tile_size/2);
        
        solidArea = new Rectangle();
        solidArea.x = 6 * gp.scale;
        solidArea.y = 9 * gp.scale;        
        solidArea.width = 3 * gp.scale;
        solidArea.height = 4 * gp.scale;

        set_default_value();
        get_player_image();
    }

    public void set_default_value() {
        setDefaultValues();
    }

    public void setDefaultValues() {
    // Posição inicial no mundo
    world_x = gp.tile_size * 70;
    world_y = gp.tile_size * 48;

    // Velocidade base
    speed = 2 * gp.scale;

    // Direção inicial
    direction = "down";

    // Estados do jogador
    boots_on = false;
    can_on = false;

    // Coletas e limites
    fire_num = 0;
    paper_num = 0;
    plastic_num = 0;
    max_paper = 12;
    max_plastic = 10;
    max_fire = 8;

    // Sprite inicial
    sprite_num = 1;
    sprite_counter = 0;

    // Reset de colisão
    collisionOn = false;
}


    public void get_player_image() {
        try {
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down (1).png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/down (2).png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/down (3).png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/res/player/down (4).png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/res/player/down (5).png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/res/player/down (6).png"));
            down7 = ImageIO.read(getClass().getResourceAsStream("/res/player/down (7).png"));
            down8 = ImageIO.read(getClass().getResourceAsStream("/res/player/down (8).png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left (1).png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/left (2).png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/left (3).png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/left (4).png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/res/player/left (5).png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/res/player/left (6).png"));
            left7 = ImageIO.read(getClass().getResourceAsStream("/res/player/left (7).png"));
            left8 = ImageIO.read(getClass().getResourceAsStream("/res/player/left (8).png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right (1).png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/right (2).png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/right (3).png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/right (4).png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/res/player/right (5).png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/res/player/right (6).png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("/res/player/right (7).png"));
            right8 = ImageIO.read(getClass().getResourceAsStream("/res/player/right (8).png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/up (1).png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/up (2).png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/up (3).png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/up (4).png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/res/player/up (5).png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/res/player/up (6).png"));
            up7 = ImageIO.read(getClass().getResourceAsStream("/res/player/up (7).png"));
            up8 = ImageIO.read(getClass().getResourceAsStream("/res/player/up (8).png"));

            down_idle_1 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/down (1).png"));
            down_idle_2 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/down (2).png"));
            down_idle_3 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/down (3).png"));
            down_idle_4 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/down (4).png"));
            left_idle_1 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/left (1).png"));
            left_idle_2 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/left (2).png"));
            left_idle_3 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/left (3).png"));
            left_idle_4 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/left (4).png"));
            right_idle_1 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/right (1).png"));
            right_idle_2 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/right (2).png"));
            right_idle_3 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/right (3).png"));
            right_idle_4 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/right (4).png"));
            up_idle_1 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/up (1).png"));
            up_idle_2 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/up (2).png"));
            up_idle_3 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/up (3).png"));
            up_idle_4 = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/up (4).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        if(boots_on == true) {
            if(key_handler.up_pressed == true) {
                direction = "up";
                speed = 2 * gp.scale * key_handler.shift_pressed;
            } else if(key_handler.left_pressed == true) {
                direction = "left";
                speed = 2 * gp.scale * key_handler.shift_pressed;
            } else if(key_handler.down_pressed == true) {
                direction = "down";
                speed = 2 * gp.scale * key_handler.shift_pressed;
            } else if(key_handler.right_pressed == true) {
                direction = "right";
                speed = 2 * gp.scale * key_handler.shift_pressed;
            } else {
                direction = key_handler.last_direction;
            }
        } else {
            if(key_handler.up_pressed == true) {
                direction = "up";
                speed = 2 * gp.scale;
            } else if(key_handler.left_pressed == true) {
                direction = "left";
                speed = 2 * gp.scale;
            } else if(key_handler.down_pressed == true) {
                direction = "down";
                speed = 2 * gp.scale;
            } else if(key_handler.right_pressed == true) {
                direction = "right";
                speed = 2 * gp.scale;
            } else {
                direction = key_handler.last_direction;
            }
        }
        
        // CHECK TILE COLLISION
        collisionOn = false;
        gp.cChecker.checkTile(this);
        
        // IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(collisionOn == false) {
        	
        	switch(direction) {
        	case "up": world_y -= speed; break;
    		case "down": world_y += speed; break;
    		case "left": world_x -= speed; break;
    		case "right": world_x += speed;	break;
        	}
        }
        
        // Mostrar coordenadas do player
        System.out.println("Player X: " + world_x + " Y: " + world_y);
        
        sprite_counter++;
        
        if(sprite_counter > 4) {
            if(sprite_num == 1) {
                sprite_num = 2;
            } else if (sprite_num == 2) {
                sprite_num = 3;
            } else if (sprite_num == 3) {
                sprite_num = 4;
            } else if (sprite_num == 4) {
                sprite_num = 5;
            } else if (sprite_num == 5) {
                sprite_num = 6;
            } else if (sprite_num == 6) {
                sprite_num = 7;
            } else if (sprite_num == 7) {
                sprite_num = 8;
            } else if (sprite_num == 8) {
                sprite_num = 1;
            }
            sprite_counter = 0;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if(sprite_num == 1) {
                    image = up1;
                }
                if(sprite_num == 2) {
                    image = up2;
                }
                if(sprite_num == 3) {
                    image = up3;
                }
                if(sprite_num == 4) {
                    image = up4;
                }
                if(sprite_num == 5) {
                    image = up5;
                }
                if(sprite_num == 6) {
                    image = up6;
                }
                if(sprite_num == 7) {
                    image = up8;
                }
                if(sprite_num == 8) {
                    image = up8;
                }
                break;
            case "left":
                if(sprite_num == 1) {
                    image = left1;
                }
                if(sprite_num == 2) {
                    image = left2;
                }
                if(sprite_num == 3) {
                    image = left3;
                }
                if(sprite_num == 4) {
                    image = left4;
                }
                if(sprite_num == 5) {
                    image = left5;
                }
                if(sprite_num == 6) {
                    image = left6;
                }
                if(sprite_num == 7) {
                    image = left8;
                }
                if(sprite_num == 8) {
                    image = left8;
                }
                break;
            case "down":
                if(sprite_num == 1) {
                    image = down1;
                }
                if(sprite_num == 2) {
                    image = down2;
                }
                if(sprite_num == 3) {
                    image = down3;
                }
                if(sprite_num == 4) {
                    image = down4;
                }
                if(sprite_num == 5) {
                    image = down5;
                }
                if(sprite_num == 6) {
                    image = down6;
                }
                if(sprite_num == 7) {
                    image = down8;
                }
                if(sprite_num == 8) {
                    image = down8;
                }
                break;
            case "right":
                if(sprite_num == 1) {
                    image = right1;
                }
                if(sprite_num == 2) {
                    image = right2;
                }
                if(sprite_num == 3) {
                    image = right3;
                }
                if(sprite_num == 4) {
                    image = right4;
                }
                if(sprite_num == 5) {
                    image = right5;
                }
                if(sprite_num == 6) {
                    image = right6;
                }
                if(sprite_num == 7) {
                    image = right8;
                }
                if(sprite_num == 8) {
                    image = right8;
                }
                break;
            case "up_idle":
                if(sprite_num == 1) {
                    image = up_idle_1;
                }
                if(sprite_num == 2) {
                    image = up_idle_1;
                }
                if(sprite_num == 3) {
                    image = up_idle_2;
                }
                if(sprite_num == 4) {
                    image = up_idle_2;
                }
                if(sprite_num == 5) {
                    image = up_idle_3;
                }
                if(sprite_num == 6) {
                    image = up_idle_3;
                }
                if(sprite_num == 7) {
                    image = up_idle_4;
                }
                if(sprite_num == 8) {
                    image = up_idle_4;
                }
                break;
            case "left_idle":
                if(sprite_num == 1) {
                    image = left_idle_1;
                }
                if(sprite_num == 2) {
                    image = left_idle_1;
                }
                if(sprite_num == 3) {
                    image = left_idle_2;
                }
                if(sprite_num == 4) {
                    image = left_idle_2;
                }
                if(sprite_num == 5) {
                    image = left_idle_3;
                }
                if(sprite_num == 6) {
                    image = left_idle_3;
                }
                if(sprite_num == 7) {
                    image = left_idle_4;
                }
                if(sprite_num == 8) {
                    image = left_idle_4;
                }
                break;
            case "down_idle":
                if(sprite_num == 1) {
                    image = down_idle_1;
                }
                if(sprite_num == 2) {
                    image = down_idle_1;
                }
                if(sprite_num == 3) {
                    image = down_idle_2;
                }
                if(sprite_num == 4) {
                    image = down_idle_2;
                }
                if(sprite_num == 5) {
                    image = down_idle_3;
                }
                if(sprite_num == 6) {
                    image = down_idle_3;
                }
                if(sprite_num == 7) {
                    image = down_idle_4;
                }
                if(sprite_num == 8) {
                    image = down_idle_4;
                }
                break;
            case "right_idle":
                if(sprite_num == 1) {
                    image = right_idle_1;
                }
                if(sprite_num == 2) {
                    image = right_idle_1;
                }
                if(sprite_num == 3) {
                    image = right_idle_2;
                }
                if(sprite_num == 4) {
                    image = right_idle_2;
                }
                if(sprite_num == 5) {
                    image = right_idle_3;
                }
                if(sprite_num == 6) {
                    image = right_idle_3;
                }
                if(sprite_num == 7) {
                    image = right_idle_4;
                }
                if(sprite_num == 8) {
                    image = right_idle_4;
                }
                break;
            
        }
        g2.drawImage(image, screen_x, screen_y, gp.tile_size, gp.tile_size, null);
        // Desenha a área de colisão em vermelho
        // g2.setColor(Color.RED);
        // g2.drawRect(screen_x + solidArea.x, screen_y + solidArea.y, solidArea.width, solidArea.height);
    }
}
