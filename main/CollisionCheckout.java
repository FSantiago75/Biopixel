package main;

import entity.Entity;

public class CollisionCheckout {
	
	GamePanel gp;
	
	public CollisionCheckout(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		// Reset da colisão
		entity.collisionOn = false;
		
		// Calcula os índices dos tiles que a entidade está tocando
		int entityLeftCol = (entity.world_x + entity.solidArea.x) / gp.tile_size;
		int entityRightCol = (entity.world_x + entity.solidArea.x + entity.solidArea.width) / gp.tile_size;
		int entityTopRow = (entity.world_y + entity.solidArea.y) / gp.tile_size;
		int entityBottomRow = (entity.world_y + entity.solidArea.y + entity.solidArea.height) / gp.tile_size;
		
		// Verifica colisão baseada na direção do movimento
		switch(entity.direction) {
		case "up":
			entityTopRow = (entity.world_y + entity.solidArea.y - entity.speed) / gp.tile_size;
			// Verifica os três pontos de colisão (esquerda, centro, direita)
			if(checkCollision(entityLeftCol, entityTopRow) || 
			   checkCollision(entityLeftCol + (entityRightCol - entityLeftCol)/2, entityTopRow) ||
			   checkCollision(entityRightCol, entityTopRow)) {
				entity.collisionOn = true;
			}
			break;
			
		case "down":
			entityBottomRow = (entity.world_y + entity.solidArea.y + entity.solidArea.height + entity.speed) / gp.tile_size;
			if(checkCollision(entityLeftCol, entityBottomRow) || 
			   checkCollision(entityLeftCol + (entityRightCol - entityLeftCol)/2, entityBottomRow) ||
			   checkCollision(entityRightCol, entityBottomRow)) {
				entity.collisionOn = true;
			}
			break;
			
		case "left":
			entityLeftCol = (entity.world_x + entity.solidArea.x - entity.speed) / gp.tile_size;
			if(checkCollision(entityLeftCol, entityTopRow) || 
			   checkCollision(entityLeftCol, entityTopRow + (entityBottomRow - entityTopRow)/2) ||
			   checkCollision(entityLeftCol, entityBottomRow)) {
				entity.collisionOn = true;
			}
			break;
			
		case "right":
			entityRightCol = (entity.world_x + entity.solidArea.x + entity.solidArea.width + entity.speed) / gp.tile_size;
			if(checkCollision(entityRightCol, entityTopRow) || 
			   checkCollision(entityRightCol, entityTopRow + (entityBottomRow - entityTopRow)/2) ||
			   checkCollision(entityRightCol, entityBottomRow)) {
				entity.collisionOn = true;
			}
			break;
		}
	}
	
	private boolean checkCollision(int col, int row) {
		// Verifica se a posição está dentro dos limites do mapa
		if(col < 0 || col >= gp.max_world_col || row < 0 || row >= gp.max_world_row) {
			return true; // Considera colisão se estiver fora dos limites
		}
		
		// Obtém o ID do tile na posição
		int tileNum = gp.tile_manager.mapTileNum[col][row];
		
		// Verifica se o tile tem colisão
		return gp.tile_manager.tile[tileNum].colision;
	}
}
