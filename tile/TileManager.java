package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    public int num_tile = 72;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[num_tile];
        mapTileNum = new int[gp.max_world_col][gp.max_world_row];
        getTileImage();
        loadMap("/res/maps/mapa3.csv");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile67.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile68.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile69.png"));
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile1.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile2.png"));
            tile[4].colision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile3.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile4.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile5.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile6.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile7.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile8.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile9.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile10.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile11.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile12.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile13.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile14.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile15.png"));
            
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile16.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile17.png"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile18.png"));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile19.png"));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile20.png"));

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile21.png"));

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile22.png"));

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile23.png"));

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile24.png"));

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile25.png"));

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile26.png"));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile27.png"));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile28.png"));

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile29.png"));

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile30.png"));

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile31.png"));

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile32.png"));

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile33.png"));

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile34.png"));

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile35.png"));
            tile[37].colision = true;

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile36.png"));

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile37.png"));

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile38.png"));

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile39.png"));

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile40.png"));

            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile41.png"));

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile42.png"));

            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile43.png"));

            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile44.png"));

            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile45.png"));

            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile46.png"));

            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile47.png"));

            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile48.png"));

            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile49.png"));

            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile50.png"));

            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile51.png"));

            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile52.png"));

            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile53.png"));

            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile54.png"));

            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile55.png"));

            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile56.png"));

            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile57.png"));

            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile58.png"));

            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile59.png"));

            tile[62] = new Tile();
            tile[62].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile60.png"));

            tile[63] = new Tile();
            tile[63].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile61.png"));

            tile[64] = new Tile();
            tile[64].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile62.png"));

            tile[65] = new Tile();
            tile[65].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile63.png"));

            tile[66] = new Tile();
            tile[66].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile64.png"));

            tile[67] = new Tile();
            tile[67].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile65.png"));

            tile[68] = new Tile();
            tile[68].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile66.png"));

            tile[69] = new Tile();
            tile[69].image = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/down (1).png"));

            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile70.png"));

            tile[71] = new Tile();
            tile[71].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile71.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String file_path) {
        try {
            InputStream is = getClass().getResourceAsStream(file_path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            
            String line;
            while ((line = br.readLine()) != null && row < gp.max_world_row) {
                String[] numbers = line.split(",");
                for (col = 0; col < numbers.length && col < gp.max_world_col; col++) {
                    String num = numbers[col].trim();
                    if (!num.isEmpty()) {
                        int tileId = Integer.parseInt(num);
                        if (tileId >= 0 && tileId < tile.length) {
                            mapTileNum[col][row] = tileId;
                        } else {
                            System.out.println("ID inválido encontrado: " + tileId + " na posição [" + col + "," + row + "]");
                            mapTileNum[col][row] = 0;
                        }
                    }
                }
                row++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao carregar o mapa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int world_col = 0;
        int world_row = 0;

        while(world_col < gp.max_world_col && world_row < gp.max_world_row) {
            int tile_num = mapTileNum[world_col][world_row];
            int world_x = world_col * gp.tile_size;
            int world_y = world_row * gp.tile_size;
            int screen_x = world_x - gp.player.world_x + gp.player.screen_x;
            int screen_y = world_y - gp.player.world_y + gp.player.screen_y;

            if(world_x + gp.tile_size > gp.player.world_x - gp.player.screen_x && 
               world_x - gp.tile_size < gp.player.world_x + gp.player.screen_x && 
               world_y + gp.tile_size > gp.player.world_y - gp.player.screen_y && 
               world_y - gp.tile_size < gp.player.world_y + gp.player.screen_y) {
                g2.drawImage(tile[tile_num].image, screen_x, screen_y, gp.tile_size, gp.tile_size, null);
            }
            world_col++;

            if(world_col == gp.max_world_col) {
                world_col = 0;
                world_row++;
            }
        }
    }
}
