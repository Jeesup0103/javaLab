import java.util.Scanner;
public class Week3 {

	//Returns the string created by adding 's2' after the position of 's1'
	static String addString(String s1, int index, String s2) {
		String strFirst = s1.substring(0, index+1);
		String strSecond = s1.substring(index+1);
		String rt = strFirst.concat(s2);
		rt = rt.concat(strSecond);
		return rt;
		//strFirst + s2 + strSecond
	}
	
	//Returns reversed string of 's'
	static String reverse(String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        return reverse;
	}
	
	//Returns a string with all 's2's removed from 's1'
	static String removeString (String s1, String s2) {
		String rt = "";
		String[] arr = s1.split(s2);
		for(String s : arr)
			rt += s;
		return rt;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str1 = scn.nextLine();
		int index = scn.nextInt();
		scn.nextLine();
		String str2 = scn.nextLine();
		String str3 = scn.nextLine();
		String str4 = scn.nextLine();
		String str5 = scn.nextLine();
		
		System.out.println(addString(str1, index, str2));
		System.out.println(reverse(str3));
		System.out.println(removeString(str4, str5));
		scn.close();
	}
}
