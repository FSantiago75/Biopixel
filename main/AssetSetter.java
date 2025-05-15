package main;

import java.util.Random;
import object.AOBJ_BigFire;
import object.AOBJ_Fire;

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

        gp.obj[8] = new AOBJ_Fire(gp);
        gp.obj[8].worldX = 4096;
        gp.obj[8].worldY = 1000;
    }
}
