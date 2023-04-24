import java.io.*;
import java.util.Scanner;	


public class SimpleCalculator {
	public static void main(String[] args) throws OutOfRangeException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String userCommand = scan.nextLine();
		String[] inputs = userCommand.split(" ");
		int num1 = Integer.parseInt(inputs[0]);
		int num2 = Integer.parseInt(inputs[2]);
		if(inputs[1].equals("+"))
		{
			try {
				result = num1+num2;
				add(num1, num2);
				System.out.println(result);
			}
			catch(OutOfRangeException e)
			{
				e.printStackTrace();
			}
			catch(AddZeroException e)
			{
				e.printStackTrace();
			}
		}
		else if(inputs[1].equals("-"))
		{
			try {
				result = num1-num2;
				subtract(num1, num2);
				System.out.println(result);
			}
			catch(OutOfRangeException e)
			{
				e.printStackTrace();
			}
			catch(SubtractZeroException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	static int result;
	
	public static void add(int a, int b) throws AddZeroException, OutOfRangeException
	{
		if(a + b > 1000)
		{
			throw new OutOfRangeException("Out of range");
		}
		if(a== 0 || b == 0)
		{
			throw new AddZeroException("Add Zero detected");
		}
		else
		{
			result = a+b;
		}

	}
	public static void subtract(int a, int b) throws SubtractZeroException, OutOfRangeException
	{
		if(a + b > 1000)
		{
			throw new OutOfRangeException("Out of range");
		}
		if(a== 0 || b == 0)
		{
			throw new SubtractZeroException("Subtract Zero detected");
		}
		else
		{
			result = a-b;
		}

	}
	public void print()
	{
			System.out.println(result);
	}
	public void reset()
	{
		result  = 0;
	}
	public int getResult()
	{
		return result;
	}
	public void setResult(int result)
	{
		this.result = result;
	}
}

class OutOfRangeException extends Exception{
	public OutOfRangeException(String message ) {
        super(message);
    }
}

class AddZeroException extends Exception{
	public AddZeroException(String message ) {
        super(message);
    }
}
class SubtractZeroException extends Exception{
	public SubtractZeroException(String message ) {
        super(message);
    }
}
