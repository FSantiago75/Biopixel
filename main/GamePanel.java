package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

    final int original_tile_size = 16;
    final int scale = 2;
    public final int tile_size = original_tile_size * scale;

    public final int max_screen_col = 28;
    public final int max_screen_row = 21;
    public final int screen_width = tile_size * max_screen_col;
    public final int screen_height = tile_size * max_screen_row;

    public final int max_world_col = 100;
    public final int max_world_row = 50;
    public final int world_width = tile_size * max_world_col;
    public final int world_height = tile_size * max_world_row;

    int fps = 60;

    TileManager tile_manager = new TileManager(this);
    KeyHandler key_handler = new KeyHandler();
    Thread game_thread;
    public CollisionCheckout cChecker = new CollisionCheckout(this);
    public Player player = new Player(this, key_handler);

    public GamePanel() {

        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key_handler);
        this.setFocusable(true);
    }

    public void startGameThread() {

        game_thread = new Thread(this);
        game_thread.start();
    }

    @Override
    public void run() {
        double draw_interval = 1000000000/fps;
        double delta = 0;
        long last_time = System.nanoTime();
        long current_time;
        long timer = 0;
        long draw_count = 0;

        while (game_thread != null) {
            current_time = System.nanoTime();
            delta += (current_time - last_time) / draw_interval;
            timer += (current_time - last_time);
            last_time = current_time;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                draw_count++;
            }

            if(timer >= 1000000000) {
                System.out.println("FPS: " + draw_count);
                draw_count = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        tile_manager.draw(g2);
        player.draw(g2);

        g2.dispose();
    }
}
