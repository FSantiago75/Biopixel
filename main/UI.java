package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import object.AOBJ_BigFire;
import object.AOBJ_Fire;
import object.OBJ_Paper1;
import object.OBJ_Paper2;
import object.OBJ_Paper3;
import object.OBJ_Paper4;
import object.OBJ_Plastic1;
import object.OBJ_Plastic2;
import object.OBJ_Plastic3;
import object.OBJ_Plastic4;
import object.Object;

public class UI {
    GamePanel gp;
    Font maruMonica;
    Font pixelFont_20;
    BufferedImage plastic1, plastic2, plastic3, plastic4, paper1, paper2, paper3, paper4, bigFire, fire;
    public boolean messageOn = false;
    public String message = "Press E";

    double playTime;
    double timeLimit = 300.00; // 5 minutos em segundos
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    public boolean gameOver = false;
    public boolean showRestartGame = false;

    public UI(GamePanel gp) {
        this.gp = gp;

        try {
            // Carrega a fonte para tamanho 40
            InputStream is40 = getClass().getResourceAsStream("/res/font/x12y16pxMaruMonica.ttf");
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is40).deriveFont(60f); // Aumentei para 80
            
            // Carrega a fonte para tamanho 20
            InputStream is20 = getClass().getResourceAsStream("/res/font/x12y16pxMaruMonica.ttf");
            pixelFont_20 = Font.createFont(Font.TRUETYPE_FONT, is20).deriveFont(30f); // Aumentei para 40
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        try {
            plastic1 = new OBJ_Plastic1(gp).image;
            plastic2 = new OBJ_Plastic2(gp).image;
            plastic3 = new OBJ_Plastic3(gp).image;
            plastic4 = new OBJ_Plastic4(gp).image;
            
            paper1 = new OBJ_Paper1(gp).image;
            paper2 = new OBJ_Paper2(gp).image;
            paper3 = new OBJ_Paper3(gp).image;
            paper4 = new OBJ_Paper4(gp).image;

            bigFire = new AOBJ_BigFire(gp).image;
            fire = new AOBJ_Fire(gp).image;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int centralizarTexto(String texto, Graphics2D g2) {
    FontMetrics fm = g2.getFontMetrics();
    return (gp.screen_height - fm.stringWidth(texto)) / 2;
}

    public void draw(Graphics2D g2) {
        g2.setFont(maruMonica);
        g2.setColor(Color.white);
        
        if(gp.player.plastic_num < gp.player.max_plastic) {
            if (plastic1 != null) g2.drawImage(plastic1, 0, 20, gp.tile_size, gp.tile_size, null);
            if (plastic2 != null) g2.drawImage(plastic2, 25, 20, gp.tile_size, gp.tile_size, null);
            if (plastic3 != null) g2.drawImage(plastic3, 0, 45, gp.tile_size, gp.tile_size, null);
            if (plastic4 != null) g2.drawImage(plastic4, 25, 45, gp.tile_size, gp.tile_size, null);
            g2.drawString(gp.player.plastic_num + "/" + gp.player.max_plastic, 90, 85);
        }
        
        if(gp.player.paper_num < gp.player.max_paper && gp.player.plastic_num == gp.player.max_plastic) {
            if (paper1 != null) g2.drawImage(paper1, 0, 20, gp.tile_size, gp.tile_size, null);
            if (paper2 != null) g2.drawImage(paper2, 25, 20, gp.tile_size, gp.tile_size, null);
            if (paper3 != null) g2.drawImage(paper3, 0, 45, gp.tile_size, gp.tile_size, null);
            if (paper4 != null) g2.drawImage(paper4, 25, 45, gp.tile_size, gp.tile_size, null);
            g2.drawString(gp.player.paper_num + "/" + gp.player.max_paper, 90, 85);
        }
        
        if(gp.player.fire_num < gp.player.max_fire && gp.player.paper_num == gp.player.max_paper && gp.player.plastic_num == gp.player.max_plastic) {
            if (bigFire != null) g2.drawImage(bigFire, 10, 20, gp.tile_size, gp.tile_size, null);
            if (fire != null) g2.drawImage(fire, 35, 45, gp.tile_size, gp.tile_size, null);
            g2.drawString(gp.player.fire_num + "/" + gp.player.max_fire, 90, 85);
        }

        // Verifica se algum objeto está com showMessage true
        for (Object obj : gp.obj) {
            if (obj != null) {

                if (obj.showMessage && obj.visible) {
                    g2.setFont(pixelFont_20);
                    int x = gp.player.screen_x;
                    // Ajusta a posição da mensagem baseado no tipo do objeto
                    switch (obj.idObject) {
                        case "button":
                            x -= 160;
                            break;
                        case "fire":
                            x -= 60;
                            break;
                        case "can":
                            x -= 140;
                            break;
                        case "paper":
                            x -= 150;
                            break;
                        case "boots":
                            x -= 120;
                            break;
                        case "default":
                            x -= 35;
                            break;
                        default:
                            x -= 35;
                            break;
                    }
                    
                    g2.drawString(obj.message, x, gp.player.screen_y - 10);
                    break; // Mostra apenas a mensagem do primeiro objeto com showMessage true
                }
            }
        }

        // Atualiza o tempo de jogo
        if (!gameOver) {
            playTime += (double)1/60;
            double remainingTime = timeLimit - playTime;
            
            if (remainingTime <= 0) {
                remainingTime = 0;
                gameOver = true;
                showRestartGame = true;
                // Aqui você pode adicionar a lógica de game over
            }
            
            // Formata o tempo em minutos:segundos
            int minutes = (int)(remainingTime / 60);
            int seconds = (int)(remainingTime % 60);
            String timeString = String.format("%02d:%02d", minutes, seconds);
            
            g2.setFont(maruMonica);
            g2.setColor(Color.white);
            g2.drawString(timeString, gp.tile_size * 16, 85);
        }

        if (showRestartGame) {
            g2.setFont(maruMonica);
            g2.setColor(new Color(0, 0, 0, 150));
            g2.fillRect(0, 0, gp.screen_height, gp.screen_width);

            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 48));
            String textoGameOver = gp.player.usinaRecarregada ? "VOCÊ VENCEU, A CIDADE FOI SALVA!" : "GAME OVER";
            int x = centralizarTexto(textoGameOver, g2);
            g2.drawString(textoGameOver, x, gp.screen_width / 2 - 50);

            g2.setFont(new Font("Arial", Font.PLAIN, 24));
            String textoReiniciar = "Aperte R para reiniciar";
            x = centralizarTexto(textoReiniciar, g2);
            g2.drawString(textoReiniciar, x, gp.screen_width / 2);
        }
    }
}

