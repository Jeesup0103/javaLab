package pa1;

public class Key extends GameObject{

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

	public Key(int y, int x) {
		posX = x;
		posY = y;
	}
}
