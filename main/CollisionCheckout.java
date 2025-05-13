package main;

import entity.Entity;

public class CollisionCheckout {
	
	GamePanel gp;
	
	public CollisionCheckout(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		
		int entityLeftWorldX = entity.world_x + entity.solidArea.x;
		int entityRightWorldX = entity.world_x + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.world_y + entity.solidArea.y;
		int entityBottomWorldY = entity.world_y + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tile_size;
		int entityRightCol = entityRightWorldX/gp.tile_size;
		int entityTopRow = entityTopWorldY/gp.tile_size;
		int entityBottomRow = entityBottomWorldY/gp.tile_size;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed)/gp.tile_size;
			tileNum1 = gp.tile_manager.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tile_manager.mapTileNum[entityRightCol][entityTopRow];
			if(gp.tile_manager.tile[tileNum1].colision == true || gp.tile_manager.tile[tileNum2].colision == true) {
				entity.collisionON = true;
			}
			
			break;
		case "down":
			entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tile_size;
			tileNum1 = gp.tile_manager.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tile_manager.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tile_manager.tile[tileNum1].colision == true || gp.tile_manager.tile[tileNum2].colision == true) {
				entity.collisionON = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tile_size;
			tileNum1 = gp.tile_manager.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tile_manager.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tile_manager.tile[tileNum1].colision == true || gp.tile_manager.tile[tileNum2].colision == true) {
				entity.collisionON = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed)/gp.tile_size;
			tileNum1 = gp.tile_manager.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tile_manager.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tile_manager.tile[tileNum1].colision == true || gp.tile_manager.tile[tileNum2].colision == true) {
				entity.collisionON = true;
			}
			break;
		}
	}
}
