package pa1;

public class Player extends GameObject{
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

	public Player(int y, int x) {
		posX = x;
		posY = y;
	}

	
	public void move(int ny, int nx, char[][] board) {
        board[ny][nx] = 'P';
        posX = nx;
        posY = ny;
	}
}
