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
    public int num_tile = 250;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[num_tile];
        mapTileNum = new int[gp.max_world_col][gp.max_world_row];
        getTileImage();
        loadMap("/res/maps/mapa pre att.csv");
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
            tile[3].colision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile2.png"));
            //tile[4].colision = true;

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
            tile[25].colision = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile24.png"));
            tile[26].colision = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile25.png"));
            tile[27].colision = true;

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile26.png"));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile27.png"));
            tile[29].colision = true;

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile28.png"));

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile29.png"));
            tile[31].colision = true;

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile30.png"));
            tile[32].colision = true;

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile31.png"));
            tile[33].colision = true;

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile32.png"));
            tile[34].colision = true;

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile33.png"));
            tile[35].colision = true;

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile34.png"));
            tile[36].colision = true;

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile35.png"));
            tile[37].colision = true;
            
            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile36.png"));
            tile[38].colision = true;

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile37.png"));
            tile[39].colision = true;

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile38.png"));
            tile[40].colision = true;

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile39.png"));
            tile[41].colision = true;

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
            tile[55].colision = true;

            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile54.png"));
            tile[56].colision = true;

            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile55.png"));
            tile[57].colision = true;

            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile56.png"));
            tile[58].colision = true;

            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile57.png"));

            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile58.png"));
            tile[60].colision = true;

            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile59.png"));
            tile[61].colision = true;

            tile[62] = new Tile();
            tile[62].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile60.png"));
            tile[62].colision = true;

            tile[63] = new Tile();
            tile[63].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile61.png"));

            tile[64] = new Tile();
            tile[64].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile62.png"));
            tile[64].colision = true;

            tile[65] = new Tile();
            tile[65].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile63.png"));

            tile[66] = new Tile();
            tile[66].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile64.png"));

            tile[67] = new Tile();
            tile[67].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile65.png"));
            tile[67].colision = true;

            tile[68] = new Tile();
            tile[68].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile66.png"));
            tile[68].colision = true;

            tile[69] = new Tile();
            tile[69].image = ImageIO.read(getClass().getResourceAsStream("/res/player_idle/down (1).png"));

            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile70.png"));
            tile[70].colision = true;

            tile[71] = new Tile();
            tile[71].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile71.png"));
            tile[71].colision = true;

            tile[72] = new Tile();
            tile[72].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile78.png"));

            tile[73] = new Tile();
            tile[73].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile79.png"));

            tile[74] = new Tile();
            tile[74].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile80.png"));

            tile[75] = new Tile();
            tile[75].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile81.png"));

            tile[76] = new Tile();
            tile[76].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile82.png"));

            tile[77] = new Tile();
            tile[77].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile83.png"));

            tile[78] = new Tile();
            tile[78].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile84.png"));

            tile[79] = new Tile();
            tile[79].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile72.png"));

            tile[80] = new Tile();
            tile[80].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile73.png"));

            tile[81] = new Tile();
            tile[81].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile74.png"));

            tile[82] = new Tile();
            tile[82].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile75.png"));

            tile[83] = new Tile();
            tile[83].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile76.png"));

            tile[84] = new Tile();
            tile[84].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile77.png"));

            tile[85] = new Tile();
            tile[85].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile89.png"));

            tile[86] = new Tile();
            tile[86].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile85.png"));
            tile[86].colision = true;

            tile[87] = new Tile();
            tile[87].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile86.png"));
            tile[87].colision = true;

            tile[88] = new Tile();
            tile[88].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile87.png"));
            tile[88].colision = true;

            tile[89] = new Tile();
            tile[89].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile88.png"));

            tile[90] = new Tile();
            tile[90].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile92.png"));

            tile[91] = new Tile();
            tile[91].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile90.png"));

            tile[92] = new Tile();
            tile[92].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile91.png"));

            tile[93] = new Tile();
            tile[93].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile94.png"));
            tile[93].colision = true;

            tile[94] = new Tile();
            tile[94].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile93.png"));
            tile[94].colision = true;

            tile[95] = new Tile();
            tile[95].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile113.png"));

            tile[96] = new Tile();
            tile[96].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile95.png"));

            tile[97] = new Tile();
            tile[97].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile96.png"));

            tile[98] = new Tile();
            tile[98].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile97.png"));

            tile[99] = new Tile();
            tile[99].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile98.png"));

            tile[100] = new Tile();
            tile[100].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile99.png"));
            tile[100].colision = true;

            tile[101] = new Tile();
            tile[101].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile100.png"));

            tile[102] = new Tile();
            tile[102].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile101.png"));

            tile[103] = new Tile();
            tile[103].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile102.png"));
            tile[103].colision = true;

            tile[104] = new Tile();
            tile[104].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile103.png"));

            tile[105] = new Tile();
            tile[105].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile104.png"));
            tile[105].colision = true;

            tile[106] = new Tile();
            tile[106].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile105.png"));
            tile[106].colision = true;

            tile[107] = new Tile();
            tile[107].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile106.png"));
            tile[107].colision = true;

            tile[108] = new Tile();
            tile[108].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile107.png"));
            tile[108].colision = true;

            tile[109] = new Tile();
            tile[109].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile108.png"));

            tile[110] = new Tile();
            tile[110].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile109.png"));
            tile[110].colision = true;

            tile[111] = new Tile();
            tile[111].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile110.png"));

            tile[112] = new Tile();
            tile[112].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile111.png"));

            tile[113] = new Tile();
            tile[113].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile112.png"));

            tile[114] = new Tile();
            tile[114].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile114.png"));

            tile[115] = new Tile();
            tile[115].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile117.png"));
            tile[115].colision = true;

            tile[116] = new Tile();
            tile[116].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile115.png"));

            tile[117] = new Tile();
            tile[117].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile116.png"));
            tile[117].colision = true;

            tile[118] = new Tile();
            tile[118].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile118.png"));
            tile[118].colision = true;

            tile[119] = new Tile();
            tile[119].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile119.png"));

            tile[120] = new Tile();
            tile[120].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile120.png"));

            tile[121] = new Tile();
            tile[121].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile121.png"));

            tile[122] = new Tile();
            tile[122].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile122.png"));

            tile[123] = new Tile();
            tile[123].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation22.png"));

            tile[124] = new Tile();
            tile[124].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation23.png"));

            tile[125] = new Tile();
            tile[125].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation24.png"));

            tile[126] = new Tile();
            tile[126].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation25.png"));

            tile[127] = new Tile();
            tile[127].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation26.png"));

            tile[128] = new Tile();
            tile[128].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation27.png"));

            tile[129] = new Tile();
            tile[129].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation28.png"));

            tile[130] = new Tile();
            tile[130].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation29.png"));

            tile[131] = new Tile();
            tile[131].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation30.png"));

            tile[132] = new Tile();
            tile[132].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation31.png"));

            tile[133] = new Tile();
            tile[133].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation32.png"));

            tile[134] = new Tile();
            tile[134].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation33.png"));

            tile[135] = new Tile();
            tile[135].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation34.png"));
            tile[135].colision = true;

            tile[136] = new Tile();
            tile[136].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation35.png"));
            tile[136].colision = true;

            tile[137] = new Tile();
            tile[137].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation36.png"));
            tile[137].colision = true;

            tile[138] = new Tile();
            tile[138].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation37.png"));
            tile[138].colision = true;

            tile[139] = new Tile();
            tile[139].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation38.png"));
            tile[139].colision = true;

            tile[140] = new Tile();
            tile[140].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation39.png"));
            tile[140].colision = true;

            tile[141] = new Tile();
            tile[141].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation40.png"));
            tile[141].colision = true;

            tile[142] = new Tile();
            tile[142].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation41.png"));
            tile[142].colision = true;

            tile[143] = new Tile();
            tile[143].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation42.png"));
            tile[143].colision = true;

            tile[144] = new Tile();
            tile[144].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation43.png"));
            tile[144].colision = true;

            tile[145] = new Tile();
            tile[145].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation44.png"));
            tile[145].colision = true;

            tile[146] = new Tile();
            tile[146].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation45.png"));
            tile[146].colision = true;

            tile[147] = new Tile();
            tile[147].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation46.png"));
            tile[147].colision = true;

            tile[148] = new Tile();
            tile[148].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation47.png"));
            tile[148].colision = true;

            tile[149] = new Tile();
            tile[149].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation48.png"));
            tile[149].colision = true;

            tile[150] = new Tile();
            tile[150].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation49.png"));

            tile[151] = new Tile();
            tile[151].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation50.png"));

            tile[152] = new Tile();
            tile[152].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation51.png"));

            tile[153] = new Tile();
            tile[153].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation52.png"));

            tile[154] = new Tile();
            tile[154].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation53.png"));

            tile[155] = new Tile();
            tile[155].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation54.png"));

            tile[156] = new Tile();
            tile[156].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation55.png"));

            tile[157] = new Tile();
            tile[157].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation56.png"));

            tile[158] = new Tile();
            tile[158].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation57.png"));

            tile[159] = new Tile();
            tile[159].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation1.png"));

            tile[160] = new Tile();
            tile[160].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation2.png"));

            tile[161] = new Tile();
            tile[161].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation3.png"));

            tile[162] = new Tile();
            tile[162].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation4.png"));

            tile[163] = new Tile();
            tile[163].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation5.png"));

            tile[164] = new Tile();
            tile[164].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation6.png"));

            tile[165] = new Tile();
            tile[165].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation7.png"));

            tile[166] = new Tile();
            tile[166].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation8.png"));

            tile[167] = new Tile();
            tile[167].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation9.png"));

            tile[168] = new Tile();
            tile[168].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation10.png"));

            tile[169] = new Tile();
            tile[169].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation11.png"));

            tile[170] = new Tile();
            tile[170].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation12.png"));

            tile[171] = new Tile();
            tile[171].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation13.png"));

            tile[172] = new Tile();
            tile[172].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation14.png"));

            tile[173] = new Tile();
            tile[173].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation15.png"));

            tile[174] = new Tile();
            tile[174].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation16.png"));

            tile[175] = new Tile();
            tile[175].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation17.png"));

            tile[176] = new Tile();
            tile[176].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation18.png"));

            tile[177] = new Tile();
            tile[177].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation19.png"));

            tile[178] = new Tile();
            tile[178].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation20.png"));

            tile[179] = new Tile();
            tile[179].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/vegetation21.png"));
            
            tile[180] = new Tile();
            tile[180].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile180.png"));
            
            tile[181] = new Tile();
            tile[181].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile181.png"));
            
            tile[182] = new Tile();
            tile[182].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile182.png"));
            
            tile[183] = new Tile();
            tile[183].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile183.png"));
            
            tile[184] = new Tile();
            tile[184].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile184.png"));

            tile[185] = new Tile();
            tile[185].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/npc1.png"));

            tile[186] = new Tile();
            tile[186].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/npc2.png"));   

            tile[187] = new Tile();
            tile[187].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/npc3.png"));

            tile[188] = new Tile();
            tile[188].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/npc4.png"));

            tile[189] = new Tile();
            tile[189].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/npc5.png"));

            tile[190] = new Tile();
            tile[190].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile185.png"));

            tile[191] = new Tile();
            tile[191].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile186.png"));

            tile[192] = new Tile();
            tile[192].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile187.png"));

            tile[193] = new Tile();
            tile[193].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile188.png"));

            tile[194] = new Tile();
            tile[194].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile189.png"));

            tile[195] = new Tile();
            tile[195].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile190.png"));

            tile[196] = new Tile();
            tile[196].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile191.png"));
            tile[196].colision = true;

            tile[197] = new Tile();
            tile[197].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile192.png"));
            tile[197].colision = true;

            tile[198] = new Tile();
            tile[198].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile193.png"));
            tile[198].colision = true;

            tile[199] = new Tile();
            tile[199].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile194.png"));
            tile[199].colision = true;

            tile[200] = new Tile();
            tile[200].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/button1v1.png"));

            


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
