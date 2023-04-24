package week5;

class Animal{
	public void move() {
		System.out.println("Animal can move");
	}
}

class Dog extends Animal {
	public void move() {
		System.out.println("Dogs can move and walk");
	}
}
class Cat extends Animal {
	public void move() {
		System.out.println("Cats can move and walk");
	}
	public void foo() {
		System.out.println("fooo");
	}
}
public class TestDog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Animal();
		Dog d = new Dog();
		a.move();
		d.move();
		Animal c = new Cat();
		c.move();
		((Cat)c).foo();
	}

}
