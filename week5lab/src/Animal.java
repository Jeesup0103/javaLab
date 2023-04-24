public class Animal {
	public static void main(String[] args) 
	{
		Cat cat = new Cat("Nero", 10.0);
		Cat cat2 = new Cat("Nabi");
		Dog dog = new Dog("Baduk", 20.0);
		Crocodile croco = new Crocodile("Crocodile", 50.0);
		System.out.println(cat.getName() + " " + cat.getWeight()); 
		cat.setName("Kiki");
		cat.sleep();
		cat.meow();
		cat2.meow();
		cat.breed(3); System.out.println(Mammal.numMammal);
		System.out.println(dog.getName() + " " + dog.getWeight()); dog.setName("Walwal");
		dog.bark();
		dog.breed(5);
		System.out.println(Mammal.numMammal);
		System.out.println(croco.getName() + " " + croco.getWeight()); croco.setName("Alligator");
		croco.spawn(20);
		System.out.println(Reptile.numReptile);
	}

}

abstract class Mammal extends Animal
{
	static int numMammal = 0;
	public int getNumMammal() {
		return numMammal;
	}
}
abstract class Reptile extends Animal
{
	static int numReptile = 0;
	public int getNumReptile() {
		return numReptile;
	}
}

final class Cat extends Mammal
{	
	public Cat(String string, double d) {
		name = string;
		weight = d;
		numMammal +=1;

	}
	public Cat(String string) {
		name = string;
		numMammal += 1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	String name;
	double weight;
	
	void meow() {
		System.out.println(this.name + ": Meow");
	}
	void sleep() {
		System.out.println(this.name + ": Zzzz");
	}
	void breed(int numKitties) {
		numMammal += numKitties;
	}
	
}
final class Dog extends Mammal
{
	public Dog(String string, double d) {
		name = string;
		weight = d;
		numMammal +=1;
	}
	public Dog(String string) {
		name = string;
		numMammal +=1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	String name;
	double weight;
	
	void bark() {
		System.out.println(this.name + ": Bowwow");
	}
	void breed(int numPuppies) {
		numMammal += numPuppies;
	}
	
}
final class Crocodile extends Reptile
{
	public Crocodile(String string, double d) {
		name = string;
		weight = d;
		numReptile += 1;
	}
	public Crocodile(String string) {
		name = string;
		numReptile += 1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	String name;
	double weight;
	
	void spawn(int numCrocos) {
		numReptile += numCrocos;
	}
}