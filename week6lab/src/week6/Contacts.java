package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap; 
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.util.Map.Entry;

public class Contacts {
	public HashMap<String,String> listOfContacts; 
	public Contacts() {
		listOfContacts = new HashMap<String,String>();
	}
	public void add(String s1, String s2) {
		if(!Character.isAlphabetic(s1.charAt(0))) {
			String s3 = s1;
			s1 = s2;
			s2 = s3;
		}
		if(listOfContacts.containsKey(s1)) {
			System.out.println("Name is already in contact. Cannot add");
			return;
		}
		else if(listOfContacts.containsValue(s2)) {
			System.out.println("Phone number is already in contact. Cannot add");
			return;
		}
		else if(s2.length() != 13) {
			System.out.println("Invalid Systax: Please check again the syntax of phone number");
			return;
		}
		String[] phoneNum = s2.split("-");
		if(phoneNum.length != 3) {
			System.out.println("Invalid Systax: Please check again the syntax of phone number");
			return;
		}
		if(phoneNum[0].length() != 3 || phoneNum[1].length() != 4 || phoneNum[2].length() != 4) {
			System.out.println("Invalid Systax: Please check again the syntax of phone number");
			return;
		}
		listOfContacts.put(s1, s2);
		System.out.println("Successfully added");
	}
	public void show() {
		List<String> keySet = new ArrayList<>(listOfContacts.keySet());
	    Collections.sort(keySet);
	    for(String key:keySet) {
	    	System.out.println(key + " " +  listOfContacts.get(key));
	    }
	}
	public void find(String string) {
		if(listOfContacts.containsKey(string)) {
			System.out.println(listOfContacts.get(string));
			return;
		}
		else if(listOfContacts.containsValue(string)) {
			Set<Entry<String, String>> entrySet = listOfContacts.entrySet();
	        for (Entry<String, String> entry : entrySet) {
	            if (entry.getValue().equals(string)) {
	                System.out.println(entry.getKey());
	            }
	        }
	        return;
		}
		else {
			System.out.println("Cannot find " + string);
			return;
		}

	}
	public void delete(String string) { 
		if(listOfContacts.containsKey(string)) {
			listOfContacts.remove(string);
			System.out.println("Removed " + string);
			return;
		}
		else if(listOfContacts.containsValue(string)) {
			listOfContacts.values().remove(string);
			System.out.println("Removed " + string);
			return;
		}
		else {
			System.out.println("Cannot delete " + string);
			return;
		}
		
	}
}