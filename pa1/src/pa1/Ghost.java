package pa1;

public class Ghost extends GameObject{
	int posX;
	int posY;
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Ghost(int y, int x) {
		posX = x;
		posY = y;
	}	
	
	public void move(int gY, int gX, char[][] board) {
		/* add your code, you can add parameter, too */
		board[gY][gX] = 'G';
		posX = gX;
		posY = gY;
	}
	
}
