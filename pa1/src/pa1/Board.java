package pa1;

import java.util.Scanner;

public class Board implements Game {
	Player player;
	Ghost ghost;
	Key key;
	Door door;
	public char prev;
	public char[][] board;
	boolean ghostRest = false;
	boolean foundKey = false;
	boolean foundDoorNotKey = false;
	Scanner scn = new Scanner(System.in);
	int playerX, playerY, ghostX, ghostY, keyX, keyY, doorX, doorY;


	public Board() {		
		/* add your code, you can add parameter, too */
		board= new char[][] {
			{' ','■',' ',' ',' ',' ','■',' ','■',' ',' ',' ',' ',' ',' '},
			{' ','■',' ','■','■','■','■',' ','■',' ','■',' ','■','■',' '}, 
			{' ','■',' ',' ',' ','■',' ',' ','■',' ','■',' ',' ','■',' '},
			{' ','■',' ','■',' ','■',' ','■','■',' ','■','■',' ','■',' '}, 
			{' ',' ',' ','■',' ','■',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ','■','■','■',' ',' ',' ','■','■','■','■','■','■','■',' '}, 
			{' ',' ',' ',' ',' ','■',' ',' ',' ',' ',' ',' ',' ','■',' '}, 
			{'■','■',' ','■','■','■',' ','■','■','■','■','■',' ','■',' '}, 
			{' ',' ',' ',' ',' ',' ',' ','■',' ',' ',' ',' ',' ','■',' '},
			{' ','■','■',' ','■','■',' ','■',' ','■','■','■',' ','■',' '}, 
			{' ','■',' ',' ',' ',' ',' ','■',' ',' ',' ','■',' ','■',' '},
			{' ','■',' ','■','■','■','■','■','■','■','■','■',' ','■',' '}, 
			{' ','■',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','■',' '},
			{' ','■','■','■',' ','■','■','■','■','■','■','■',' ','■',' '}, 
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
		};
	}
	
 
    public void printBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15	; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

	public void initObjects() {
		/* add your code, you can add parameter, too */

		
		while(true) {
			System.out.println("input player x, y (0 ~ 14)");
			playerX = scn.nextInt();
			playerY = scn.nextInt();
			
			if(playerX <0 || playerY < 0 || playerX > 14 || playerY > 14 || board[playerY][playerX] == '■' ) {
				continue;
			}
			else {
				player = new Player(playerY, playerX);
				break;
			}
		}
		while(true) {
			System.out.println("input ghost x, y (0 ~ 14)");
			ghostX = scn.nextInt();
			ghostY = scn.nextInt();
			
			if(ghostX <0 || ghostY < 0 || ghostX > 14 || ghostY > 14 || (ghostY == playerY && ghostX == playerX) ) {
				continue;
			}
			else {
				ghost = new Ghost(ghostY, ghostX);
				prev = board[ghostY][ghostX];
				break;
			}
		}

		while(true) {
			System.out.println("input key x, y (0 ~ 14)");
			keyX = scn.nextInt();
			keyY = scn.nextInt();
			
			if(keyX <0 || keyY < 0 || keyX > 14 || keyY > 14){
				continue;
			}
			else if((keyY == playerY && keyX == playerX) || (keyY == ghostY && keyX == ghostX) || board[keyY][keyX] == '■'){
				continue;
			}
			else {
				key = new Key(keyY, keyX);
				break;
			}
		}
		while(true) {
			System.out.println("input door x, y (0 ~ 14)");
			doorX = scn.nextInt();
			doorY = scn.nextInt();
			scn.nextLine();
			
			if(doorX <0 || doorY < 0 || doorX > 14 || doorY > 14) {
				continue;
			}
			else if((doorY == playerY && doorX == playerX) || (doorY == ghostY && doorX == ghostX) || (doorY == keyY && doorX == keyX) || board[doorY][doorX] == '■') {
				continue;
			}
			else {
				door = new Door(doorY, doorX);
				break;
			}
		}
		

		board[keyY][keyX] = 'K';
		board[doorY][doorX] = 'D';
		board[playerY][playerX] = 'P';
		board[ghostY][ghostX] = 'G';
	}
	
	public void movePlayer() {
		int curX = player.getPosX();
		int curY = player.getPosY();
		while(true) {
			String direction = scn.nextLine();
			int nx = 0, ny = 0;
	        if(direction.equals("u")) {
	        	ny = curY-1;
	        	nx = curX;
	            if (ny < 0 || board[ny][nx] == '■') {
	            	System.out.println("Invalid direction. Try again.");
	                continue;
	            }
	        }

	        else if(direction.equals("d")) {
	        	ny = curY+1;
	        	nx = curX;
	            if (ny > 14 || board[ny][nx] == '■') {
	                System.out.println("Invalid direction. Try again.");
	                continue;
	            }
	            
	        }
	        else if(direction.equals("l")) {
	        	ny = curY;
	        	nx = curX - 1;
	            if (nx < 0 || board[ny][nx] == '■') {
	            	System.out.println("Invalid direction. Try again.");
	                continue;
	            }
	            
	        }
	        else if(direction.equals("r")) {
	        	ny = curY;
	        	nx = curX + 1;
	            if (nx > 14 || board[ny][nx] == '■') {
	            	System.out.println("Invalid direction. Try again.");
	                continue;
	            }
	        }
	        else {
	        	System.out.println("Invalid input. Try again.");
	        	continue;
	        }
			player.move(ny, nx, board);
			board[curY][curX] = ' ';
			break;
		}
		if(foundDoorNotKey) {
			board[curY][curX] = 'D';
			foundDoorNotKey = false;
		}
		if(player.getPosX() == key.getPosX() && player.getPosY() == key.getPosY())
			foundKey = true;
		else if(player.getPosX() == door.getPosX() && player.getPosY() == door.getPosY() && !foundKey)
			foundDoorNotKey = true;
	}	
	
	public void moveGhost() {
		if(ghostRest == true) {
			ghostRest = false;
			return;
		}
		int ghX = ghost.getPosX();
		int ghY = ghost.getPosY();
		int plyX = player.getPosX();
		int plyY = player.getPosY();
		
		int signX = 0;
		int signY = 0;
		if (ghX - plyX > 0)
		    signX = -1;
		else if (ghX - plyX < 0)
		    signX = 1;
		if (ghY - plyY > 0)
		    signY = -1;
		else if (ghY - plyY < 0)
		    signY = 1;
		
		board[ghY][ghX] = prev;
		prev = board[ghY + signY][ghX + signX];
		ghost.move(ghY + signY, ghX + signX, board);
		ghostRest = true;

	}
	
	public boolean isFinish() {
		if(ghost.getPosX() == player.getPosX() && ghost.getPosY() == player.getPosY()) {
			System.out.println("Game over. You lose!");
			return true;
		}
		else if(player.getPosX() == doorX && player.getPosY() == doorY && foundKey) {
			System.out.println("You win!");
			return true;
		}
		else return false;
	}
	
}
