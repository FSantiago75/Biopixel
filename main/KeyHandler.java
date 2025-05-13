package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean up_pressed, left_pressed, down_pressed, right_pressed;
    public String last_direction = "down_idle";

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
    }
    
}
