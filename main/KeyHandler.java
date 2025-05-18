package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean up_pressed, left_pressed, down_pressed, right_pressed, e_pressed;
    public int shift_pressed = 1;
    public String last_direction = "down_idle";

    UI ui;
    GamePanel gp;

    public KeyHandler() {
    }

    public KeyHandler(UI ui) {
        this.ui = ui;
        this.gp = ui.gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            up_pressed = true;
        }
        if(code == KeyEvent.VK_A) {
            left_pressed = true;
        }
        if(code == KeyEvent.VK_S) {
            down_pressed = true;
        }
        if(code == KeyEvent.VK_D) {
            right_pressed = true;
        }
        if(code == KeyEvent.VK_SHIFT) {
            shift_pressed = 2;
        }
        if(code == KeyEvent.VK_E) {
            e_pressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_R && ui.gameOver) {
        // Se a tecla R for pressionada e o jogo estiver em gameOver
        // reinicie variáveis do jogo
        gp.restartGame();
        ui.gameOver = false;
        ui.showRestartGame = false;
    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            up_pressed = false;
            last_direction = "up_idle";
        }
        if(code == KeyEvent.VK_A) {
            left_pressed = false;
            last_direction = "left_idle";
        }
        if(code == KeyEvent.VK_S) {
            down_pressed = false;
            last_direction = "down_idle";
        }
        if(code == KeyEvent.VK_D) {
            right_pressed = false;
            last_direction = "right_idle";
        }
        if(code == KeyEvent.VK_SHIFT) {
            shift_pressed = 1;
        }
        if(code == KeyEvent.VK_E) {
            e_pressed = false;
        }
    }
    
}
