package week4;

public class Baby {
	public String name = "SLing";
	private String nickName = "bee";
	private boolean gender;
	double weight = 5.0;
	int numcry = 0;
	Baby[] siblings;
	
	void cry() {
		numcry += 1;
		System.out.println("Dear mother, " +
		"I have cried");
	}
	
	void sayHi() {
		System.out.println("My name is " + name);
	}
	
	void eat(double foodWeight) {
		if(foodWeight >= 0 && foodWeight < weight) {
			weight+= foodWeight;
			System.out.println("I ate " + foodWeight);
		}
	}
	
	//Constructor 만들지 않으면 default로 만들어
	Baby(){}
	Baby(String myName, boolean myGender){
		name = myName;
		gender = myGender;
	}
	
	//access itself , self reference
	//setter
	public void setnickName(String nickName) {
		this.nickName =  nickName;
	}
	//getter
	public String getnickName() {
		return this.nickName;
	}
	//reference type Baby, 주소를 전달 받음 함수 선언하면 그럼
	
	//modify private data
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Baby temp = new Baby();
		temp.sayHi();
		temp.eat(3.0);
		temp.name = "Boo Boo";
		temp.sayHi();
		
		Baby baby1 = new Baby("Charlie", true);
		System.out.println(baby1.name);
		baby1.sayHi();
		
		Baby siloh = new Baby();
		Stranger stranger1 = new Stranger();
		stranger1.setandgetNameOf(siloh);
	}
}

class Stranger{
	void setandgetNameOf(Baby b) {
		b.setnickName("cuty");
		System.out.println(b.getnickName());
	}
}