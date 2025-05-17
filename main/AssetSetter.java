package main;

import java.util.Random;
import object.AOBJ_BigFire;
import object.AOBJ_Fire;
import object.OBJ_Button;
import object.OBJ_boots;
import object.OBJ_Can;
import object.OBJ_NPC1;
import object.OBJ_NPC2;
import object.OBJ_NPC3;
import object.OBJ_NPC4;
import object.OBJ_NPC5;
import object.OBJ_NPC6;
import object.OBJ_NPC7;

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
        gp.obj[8].worldX = 4496;
        gp.obj[8].worldY = 3816;

        gp.obj[9] = new OBJ_Button(gp);
        gp.obj[9].worldX = 4096;
        gp.obj[9].worldY = 1024;

        gp.obj[10] = new OBJ_NPC1(gp);
        gp.obj[10].worldX = 4992;
        gp.obj[10].worldY = 3520;

        gp.obj[69] = new OBJ_NPC2(gp);
        gp.obj[69].worldX = 4672;
        gp.obj[69].worldY = 3520;

        gp.obj[70] = new OBJ_NPC3(gp);
        gp.obj[70].worldX = 4992;
        gp.obj[70].worldY = 3456;

        gp.obj[71] = new OBJ_NPC4(gp);
        gp.obj[71].worldX = 4992;
        gp.obj[71].worldY = 3584;

        gp.obj[72] = new OBJ_NPC5(gp);
        gp.obj[72].worldX = 2304;
        gp.obj[72].worldY = 3776;

        gp.obj[73] = new OBJ_NPC6(gp);
        gp.obj[73].worldX = 5504;
        gp.obj[73].worldY = 3264;

        gp.obj[74] = new OBJ_NPC7(gp);
        gp.obj[74].worldX = 1600;
        gp.obj[74].worldY = 1600;
        
    }
}
