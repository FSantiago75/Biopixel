package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import object.Object;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

    final int original_tile_size = 16;
    public final int scale = 4;
    public final int tile_size = original_tile_size * scale;

    public final int max_screen_col = 18;
    public final int max_screen_row = 14;
    public int screen_width = tile_size * max_screen_col;
    public int screen_height = tile_size * max_screen_row;


    public final int max_world_col = 100;
    public final int max_world_row = 70;
    public final int world_width = tile_size * max_world_col;
    public final int world_height = tile_size * max_world_row;

    int fps = 60;

    public TileManager tile_manager = new TileManager(this);
    public KeyHandler key_handler = new KeyHandler();
    Thread game_thread;
    public CollisionCheckout cChecker = new CollisionCheckout(this);
    public UI ui = new UI(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, key_handler);
    public Object obj[] = new Object[100]; //Numero max de objetos ao mesmo tempo

    public GamePanel() {
        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setBackground(Color.decode("#3e92d1"));
        this.setDoubleBuffered(true);
        this.addKeyListener(key_handler);
        this.setFocusable(true);
        
        setupGame();
    }


    public void setupGame(){
        aSetter.setObject();
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
                //System.out.println("FPS: " + draw_count);
                draw_count = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
        for(int i = 0; i < obj.length; i++) {
            if(obj[i] != null && obj[i].visible) {
                obj[i].update();
                if(obj[i].isPlayerOnTop(this)) {
                    //obj[i].visible = false;
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        tile_manager.draw(g2);
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }
        player.draw(g2);
        ui.draw(g2);
        g2.dispose();
    }

    public static void restartApp() {
    try {
        // Caminho do executável Java
        String javaBin = System.getProperty("java.home") + "/bin/java";

        // Caminho da classe principal (main.Game)
        String className = "main.Game";

        // Caminho do classpath (diretório onde está o código compilado)
        String classPath = System.getProperty("java.class.path");

        // Constrói o processo para reiniciar o jogo
        ProcessBuilder builder = new ProcessBuilder(
            javaBin, "-cp", classPath, className
        );

        builder.start();
        System.exit(0); // Encerra o processo atual
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
