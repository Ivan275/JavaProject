package university;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class department {
	ArrayList<staff> lst;
	String name;
	static HashSet allCampus = new HashSet();// create hashset allcampus for collecting unit campus name
	public department(String name) {//constructor 
		 lst = new ArrayList<staff> ();
		 this.name = name;
	}
	public String getName(){//get department name
		return this.name;
	}

	public void display(){//display department name
		System.out.println("name: "+ name);
	}
	public void dispCamp(){//display all campus
		
		for(int i = 0; i< lst.size();i++){
			allCampus.add(lst.get(i).getCampus());
		}
		System.out.println("All campus list following: ");
		Iterator output = allCampus.iterator();
		while (output.hasNext()){//print out all campus name 
			   System.out.println(output.next());  
			   }
		System.out.println();
	}
	public void displayAllStaff(){//display all staff in the department
		for(int i = 0; i< lst.size();i++){
			lst.get(i).display();
		}
		
	}
	public void add(staff st) {//add a staff type object into list of staff called lst
		lst.add(st);
		
	}
	
	public void getStaffByName(String input){//find a staff by string type of name
		for(int i = 0; i<lst.size();i++){
			if(input.equals(lst.get(i).getLastName())){
				lst.get(i).display();
				System.out.println();
			}
		}
	}

	public void getStaffByPhone(int a) {//find a staff by integer type of name
		// TODO Auto-generated method stub
		for(int i = 0; i<lst.size();i++){
			if(Integer.toString(a).equals( lst.get(i).getPhone())){
				lst.get(i).display();
				System.out.println();
			}
		}
		
	}
	public void removeStaffByPhone(int a) {//remove a staff by integer type of phone number
		boolean temp = checkStaffByNum(a);
		if(temp == true){
			for(int i = 0; i<lst.size();i++){		
				if(Integer.toString(a).equals( lst.get(i).getPhone())){
					lst.remove(i);
					System.out.println();
				}
			}
		}else{
			System.out.println("No such person in the department!");
		}
	}
	public void removeStaffByName(String input) {//remove a staff by string type of name
		boolean temp = checkStaffByName(input);
		if(temp == true){	
			for(int i = 0; i<lst.size();i++){
				if(input.equals(lst.get(i).getLastName())){
					lst.remove(i);
					System.out.println();
				}
			}
		}else{
			System.out.println("No such person in the department!");
		}
	}
	public void editPhone(String input) {
		

		boolean temp = checkStaffByName(input);
		if(temp == true){
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter new phone");
			String phone = scan.next();
			for(int i = 0; i<lst.size();i++){
				if(input.equals(lst.get(i).getLastName())){
					lst.get(i).setPhone(phone);
					System.out.println();
				}
			}
		}else{
			System.out.println("No such person in the department!");
		}
	}
	public boolean checkStaffByNum(int a){//check number is in the list or not
		boolean check = false;
		for(int i = 0; i<lst.size();i++){		
			if(Integer.toString(a).equals( lst.get(i).getPhone())){
				check = true;
				break;
			}
		}
		return check;
	}
	public boolean checkStaffByName(String input){//check name is in the list or not
		boolean check = false;
		for(int i = 0; i<lst.size();i++){
			if(input.equals(lst.get(i).getLastName())){
				check = true;
				break;
			}
		}
		return check;
	}

}
