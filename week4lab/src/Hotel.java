import java.util.Random;
import java.util.Scanner;

class Room{
	boolean states;
	int capacity;
	Random random = new Random();
	
	Room(){
		states = true;
		capacity = random.nextInt(4)+1;
	}
}

public class Hotel {
	static void checkIn(int n, int j, Room[] r) {
		if(r[n].states == false) {
			System.out.println("Check in error: already occupied");
		}
		else if(r[n].capacity < j) {
			System.out.println("Check in error: capacity exceed");
		}
		else {
			r[n].states = false;
			System.out.println("Check in Success");
		}
	}
	
	static void checkOut(int n, Room[] r) {
		if(r[n].states == true) {
			System.out.println("Check out error: already checked out");
		}
		else {
			r[n].states = true;
			System.out.println("Check out Success");

		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Room[] r;
		r = new Room[10];
		for(int i = 0; i < 10; i++) {
			r[i] = new Room();
		}
		
		System.out.println("Each Room's Capacity");
		for (int i = 0; i < 10 ; i++) {
			System.out.print(r[i].capacity + " ");
		}
		System.out.println();
		int index;
		while(true) {
			System.out.println("Enter number (1 : check in), (2 : check out). (3 : Finish)");
			index = scn.nextInt();
			if(index == 3) {
				break;
			}
			if(index == 1) {
				System.out.println("Enter room number");
				int roomN = scn.nextInt();
				scn.nextLine();
				
				System.out.println("How many people?");
				int peopleN = scn.nextInt();
				scn.nextLine();
				checkIn(roomN, peopleN, r);
				
			}
			else if(index == 2) {
				System.out.println("Enter room number");
				int roomN = scn.nextInt();
				scn.nextLine();
				
				checkOut(roomN, r);
			}
		}
		scn.close();
		return;
	}
}