package main;

import java.util.Random;
import object.AOBJ_BigFire;
import object.AOBJ_Fire;
import object.OBJ_Blueprint;
import object.OBJ_Button;
import object.OBJ_Can;
import object.OBJ_NPC1;
import object.OBJ_NPC2;
import object.OBJ_NPC3;
import object.OBJ_NPC4;
import object.OBJ_NPC5;
import object.OBJ_NPC6;
import object.OBJ_NPC7;
import object.OBJ_Paper1;
import object.OBJ_Paper2;
import object.OBJ_Paper3;
import object.OBJ_Paper4;
import object.OBJ_Plastic1;
import object.OBJ_Plastic2;
import object.OBJ_Plastic3;
import object.OBJ_Plastic4;
import object.OBJ_boots;

public class AssetSetter {
    GamePanel gp;
    Random random = new Random();

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        // Primeiro conjunto de fogos
        gp.obj[0] = new AOBJ_Fire(gp);
        gp.obj[0].worldX = 5952;
        gp.obj[0].worldY = 1408;

        gp.obj[1] = new AOBJ_BigFire(gp);
        gp.obj[1].worldX = 5824;
        gp.obj[1].worldY = 568;

        gp.obj[2] = new AOBJ_Fire(gp);
        gp.obj[2].worldX = 5376;
        gp.obj[2].worldY = 376;

        gp.obj[3] = new AOBJ_BigFire(gp);
        gp.obj[3].worldX = 5256;
        gp.obj[3].worldY = 648;

        gp.obj[4] = new AOBJ_Fire(gp);
        gp.obj[4].worldX = 3848;
        gp.obj[4].worldY = 368;

        gp.obj[5] = new AOBJ_BigFire(gp);
        gp.obj[5].worldX = 4168;
        gp.obj[5].worldY = 616;

        gp.obj[6] = new AOBJ_Fire(gp);
        gp.obj[6].worldX = 4864;
        gp.obj[6].worldY = 1064;

        gp.obj[7] = new AOBJ_BigFire(gp);
        gp.obj[7].worldX = 3840;
        gp.obj[7].worldY = 944;
        
        gp.obj[8] = new OBJ_boots(gp);
        gp.obj[8].worldX = 448;
        gp.obj[8].worldY = 2952;

        gp.obj[9] = new OBJ_Button(gp);
        gp.obj[9].worldX = 4096;
        gp.obj[9].worldY = 1020;

        gp.obj[10] = new OBJ_Can(gp);
        gp.obj[10].worldX = 4096;
        gp.obj[10].worldY = 3816;

        gp.obj[10] = new OBJ_Can(gp);
        gp.obj[10].worldX = 5368;
        gp.obj[10].worldY = 3432;

        gp.obj[11] = new OBJ_Paper1(gp);
        gp.obj[11].worldX = 5392;
        gp.obj[11].worldY = 2736;

        gp.obj[12] = new OBJ_Paper2(gp);
        gp.obj[12].worldX = 4216;
        gp.obj[12].worldY = 3200;

        gp.obj[13] = new OBJ_Paper3(gp);
        gp.obj[13].worldX = 4752;
        gp.obj[13].worldY = 2552;

        gp.obj[14] = new OBJ_Paper4(gp);
        gp.obj[14].worldX = 3232;
        gp.obj[14].worldY = 2680;

        gp.obj[15] = new OBJ_Paper1(gp);
        gp.obj[15].worldX = 3400;
        gp.obj[15].worldY = 3424;

        gp.obj[16] = new OBJ_Paper2(gp);
        gp.obj[16].worldX = 3192;
        gp.obj[16].worldY = 4056;

        gp.obj[17] = new OBJ_Paper3(gp);
        gp.obj[17].worldX = 4096;
        gp.obj[17].worldY = 3808;

        gp.obj[18] = new OBJ_Paper4(gp);
        gp.obj[18].worldX = 5960;
        gp.obj[18].worldY = 3904;

        gp.obj[19] = new OBJ_Paper1(gp);
        gp.obj[19].worldX = 3512;
        gp.obj[19].worldY = 2680;

        gp.obj[21] = new OBJ_Paper2(gp);
        gp.obj[21].worldX = 3648;
        gp.obj[21].worldY = 3256;

        gp.obj[22] = new OBJ_Paper3(gp);
        gp.obj[22].worldX = 4864;
        gp.obj[22].worldY = 3328;

        gp.obj[23] = new OBJ_Paper4(gp);
        gp.obj[23].worldX = 5376;
        gp.obj[23].worldY = 3648;

        gp.obj[24] = new OBJ_Plastic1(gp);
        gp.obj[24].worldX = 1848;
        gp.obj[24].worldY = 2848;

        gp.obj[25] = new OBJ_Plastic2(gp);
        gp.obj[25].worldX = 1016;
        gp.obj[25].worldY = 3280;

        gp.obj[26] = new OBJ_Plastic3(gp);
        gp.obj[26].worldX = 312;
        gp.obj[26].worldY = 3816;

        gp.obj[27] = new OBJ_Plastic4(gp);
        gp.obj[27].worldX = 584;
        gp.obj[27].worldY = 3064;

        gp.obj[28] = new OBJ_Plastic1(gp);
        gp.obj[28].worldX = 1496;
        gp.obj[28].worldY = 3680;

        gp.obj[29] = new OBJ_Plastic2(gp);
        gp.obj[29].worldX = 1992;
        gp.obj[29].worldY = 3304;

        gp.obj[30] = new OBJ_Plastic3(gp);
        gp.obj[30].worldX = 1288;
        gp.obj[30].worldY = 2976;

        gp.obj[31] = new OBJ_Plastic4(gp);
        gp.obj[31].worldX = 912;
        gp.obj[31].worldY = 3968;

        gp.obj[32] = new OBJ_Plastic1(gp);
        gp.obj[32].worldX = 2272;
        gp.obj[32].worldY = 3968;

        gp.obj[33] = new OBJ_Plastic2(gp);
        gp.obj[33].worldX = 584;
        gp.obj[33].worldY = 3536;

        gp.obj[34] = new OBJ_NPC1(gp);
        gp.obj[34].worldX = 4992;
        gp.obj[34].worldY = 3520;

        gp.obj[35] = new OBJ_NPC2(gp);
        gp.obj[35].worldX = 4672;
        gp.obj[35].worldY = 3520;

        gp.obj[36] = new OBJ_NPC3(gp);
        gp.obj[36].worldX = 4992;
        gp.obj[36].worldY = 3456;

        gp.obj[37] = new OBJ_NPC4(gp);
        gp.obj[37].worldX = 4992;
        gp.obj[37].worldY = 3584;

        gp.obj[38] = new OBJ_NPC5(gp);
        gp.obj[38].worldX = 2304;
        gp.obj[38].worldY = 3776;

        gp.obj[39] = new OBJ_NPC6(gp);
        gp.obj[39].worldX = 5504;
        gp.obj[39].worldY = 3264;

        gp.obj[40] = new OBJ_NPC7(gp);
        gp.obj[40].worldX = 1600;
        gp.obj[40].worldY = 1600;

        gp.obj[41] = new OBJ_Blueprint(gp);
        gp.obj[41].worldX = 344;
        gp.obj[41].worldY = 1592;
    }
}
