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
import javax.imageio.ImageIO;
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
    Font maruMonica_80, maruMonica_60, maruMonica_30;
    BufferedImage plastic1, plastic2, plastic3, plastic4, paper1, paper2, paper3, paper4, bigFire, fire;
    BufferedImage backgroundImage;
    double playTime;
    double timeLimit = 300; //Tempo de jogo
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    public boolean gameOver = false;
    public static boolean showEndGame = false;
    BufferedImage backgroundWinImage;
    BufferedImage backgroundLoseImage;

    public UI(GamePanel gp) {
        this.gp = gp;
        loadFonts();
        loadImages();
        loadBackground();
    }

    private void loadFonts() {
        try {
            InputStream is = getClass().getResourceAsStream("/res/font/x12y16pxMaruMonica.ttf");
            Font baseFont = Font.createFont(Font.TRUETYPE_FONT, is);
            maruMonica_80 = baseFont.deriveFont(80f);
            maruMonica_60 = baseFont.deriveFont(60f);
            maruMonica_30 = baseFont.deriveFont(30f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private void loadImages() {
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

    private void loadBackground() {
        try {
            backgroundWinImage = ImageIO.read(getClass().getResourceAsStream("/res/images/fimbom (2).png"));
            backgroundLoseImage = ImageIO.read(getClass().getResourceAsStream("/res/images/fimruim (2).png"));
        } catch (IOException e) {
            System.out.println("Erro ao carregar imagem de fundo de fim de jogo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        drawHUD(g2);
        drawMessages(g2);
        drawTimer(g2);
        drawEndScreen(g2);
    }

    private void drawHUD(Graphics2D g2) {
        g2.setFont(maruMonica_60);
        g2.setColor(Color.white);
        
        if(gp.player.plastic_num < gp.player.max_plastic) {
            drawPlasticHUD(g2);
        } else if(gp.player.paper_num < gp.player.max_paper) {
            drawPaperHUD(g2);
        } else if(gp.player.fire_num < gp.player.max_fire) {
            drawFireHUD(g2);
        }
    }

    private void drawPlasticHUD(Graphics2D g2) {
        if (plastic1 != null) g2.drawImage(plastic1, 0, 20, gp.tile_size, gp.tile_size, null);
        if (plastic2 != null) g2.drawImage(plastic2, 25, 20, gp.tile_size, gp.tile_size, null);
        if (plastic3 != null) g2.drawImage(plastic3, 0, 45, gp.tile_size, gp.tile_size, null);
        if (plastic4 != null) g2.drawImage(plastic4, 25, 45, gp.tile_size, gp.tile_size, null);
        g2.drawString(gp.player.plastic_num + "/" + gp.player.max_plastic, 90, 85);
    }

    private void drawPaperHUD(Graphics2D g2) {
        if (paper1 != null) g2.drawImage(paper1, 0, 20, gp.tile_size, gp.tile_size, null);
        if (paper2 != null) g2.drawImage(paper2, 25, 20, gp.tile_size, gp.tile_size, null);
        if (paper3 != null) g2.drawImage(paper3, 0, 45, gp.tile_size, gp.tile_size, null);
        if (paper4 != null) g2.drawImage(paper4, 25, 45, gp.tile_size, gp.tile_size, null);
        g2.drawString(gp.player.paper_num + "/" + gp.player.max_paper, 90, 85);
    }

    private void drawFireHUD(Graphics2D g2) {
        if (bigFire != null) g2.drawImage(bigFire, 10, 20, gp.tile_size, gp.tile_size, null);
        if (fire != null) g2.drawImage(fire, 35, 45, gp.tile_size, gp.tile_size, null);
        g2.drawString(gp.player.fire_num + "/" + gp.player.max_fire, 90, 85);
    }

    private void drawMessages(Graphics2D g2) {
        for (Object obj : gp.obj) {
            if (obj != null && obj.showMessage && obj.visible) {
                g2.setFont(maruMonica_30);
                int x = gp.player.screen_x;
                switch (obj.idObject) {
                    case "button": x -= 160; break;
                    case "fire": x -= 60; break;
                    case "can": x -= 140; break;
                    case "paper": x -= 150; break;
                    case "boots": x -= 120; break;
                    case "bluePrint": x -= 120; break;
                    case "npc7": x -= 250; break;
                    case "npc7Blueprint": x -= 160; break;
                    default: x -= 35; break;
                }
                g2.drawString(obj.message, x, gp.player.screen_y - 10);
                break;
            }
        }
    }

    private void drawTimer(Graphics2D g2) {
        if (!gameOver) {
            playTime += (double)1/60;
            double remainingTime = Math.max(0, timeLimit - playTime);
            
            if (remainingTime == 0) {
                gameOver = true;
                showEndGame = true;
            }
            
            int minutes = (int)(remainingTime / 60);
            int seconds = (int)(remainingTime % 60);
            g2.setFont(maruMonica_60);
            g2.setColor(Color.white);
            g2.drawString(String.format("%02d:%02d", minutes, seconds), gp.tile_size * 16, 85);
        }
    }

    private void drawEndScreen(Graphics2D g2) {
        if (showEndGame) {
            if (gp.player.usinaRecarregada) {
                drawWinScreen(g2);
            } else {
                drawGameOverScreen(g2);
            }
        }
    }

    private void drawBackground(Graphics2D g2) {
        if (backgroundImage != null) {
            g2.drawImage(backgroundImage, 0, 0, gp.screen_width, gp.screen_height, null);
            
            g2.setColor(new Color(0, 0, 0, 150));
            g2.fillRect(0, 0, gp.screen_width, gp.screen_height);
        } else {
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, gp.screen_width, gp.screen_height);
        }
    }

    private void drawCenteredText(Graphics2D g2, String text, int y, Color color) {
        FontMetrics fm = g2.getFontMetrics();
        int x = (gp.screen_width - fm.stringWidth(text)) / 2;
        g2.setColor(color);
        g2.drawString(text, x, y);
    }

    private void drawWinScreen(Graphics2D g2) {
        backgroundImage = backgroundWinImage;
        drawBackground(g2);

        g2.setFont(maruMonica_80);
        FontMetrics fm = g2.getFontMetrics();
        int y = (gp.screen_height - fm.getHeight()) / 2 + fm.getAscent();

        drawCenteredText(g2, "A CIDADE FOI SALVA!", y, Color.GREEN);

        g2.setFont(maruMonica_30);
        y += 50;
        drawCenteredText(g2, "Cada atitude conta! Estamos em uma contagem regressiva...", y, new Color(100, 255, 100));
        y += 30;
        drawCenteredText(g2, "Um mundo limpo começa com pequenas ações. Obrigado por salvar nosso futuro.", y, new Color(100, 255, 100));
        y += 50;
        drawCenteredText(g2, "Pressione 'R' para Reiniciar", y, new Color(100, 255, 100));
    }

    private void drawGameOverScreen(Graphics2D g2) {
        backgroundImage = backgroundLoseImage;
        drawBackground(g2);

        g2.setFont(maruMonica_80);
        FontMetrics fm = g2.getFontMetrics();
        int y = (gp.screen_height - fm.getHeight()) / 2 + fm.getAscent();

        drawCenteredText(g2, "GAME OVER", y, Color.RED);

        g2.setFont(maruMonica_30);
        y += 50;
        drawCenteredText(g2, "De pouco em pouco, o mundo se transforma.", y, new Color(255, 100, 100));
        y += 30;
        drawCenteredText(g2, "Quando não agimos a tempo, permitimos que ele definhe.", y, new Color(255, 100, 100));
        y += 50;
        drawCenteredText(g2, "Pressione 'R' para Reiniciar", y, new Color(255, 100, 100));
    }

    public void setEndGame(boolean value) {
        showEndGame = value;
    }
}

