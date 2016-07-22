package university;
import java.util.*;
import java.io.*;

public class main {
	static ArrayList<department>  depts = new ArrayList<department>();
	
	public static void readFile(String fileName){
		//read file from text.txt
		File file = new File(fileName);
		ArrayList<String> data = new ArrayList<String>();
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				data.add(scan.nextLine());
			}
			data.remove(0);// remove first line FAS
			department temp1 = null;
			int count;
			for(int i = 0; i< data.size()-1;i++ ){
				String a = data.get(i);
				
				if(a.equals("*")){
					temp1 = null;
					temp1 = new department(data.get(i+1));
					depts.add(temp1);//add new department into department list			
					i++;	
					
				}else if(i==0){
					temp1 = new department(data.get(0)); // add first deparment name
					depts.add(temp1);
				}else{
					// get attributes from each staff
					String[] cur = a.split(" ");
					String lastname = cur[0];
					String initial = cur[1];
					String campus = cur[2];
					String building = cur[3];
					String room = cur[4];
					String phone = cur[5];
					staff st = new staff(lastname,initial,campus,building,room,phone);
					temp1.add(st);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static void displayStaff(department depart){//display all staff
		depart.displayAllStaff();
		System.out.println();
	}
	public static void displayCampus(department depart){//display all staff
		depart.dispCamp();
	}
	public static void findStaff(department depart){// find a staff by last name or phone number
		System.out.println("Please type in a last name or tellphone number:");
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		try{
	        int a = Integer.parseInt(input);//get number
	        depart.getStaffByPhone(a);   
	    } catch (Exception ex){
	    	depart.getStaffByName(input);//get Name string
	    }
	}
	public static void addStaff(department depart) {//add a staff by his attributes
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter last name");
		String a1 = scan.next();
		System.out.println("Please enter initial name");
		String a2 = scan.next();
		System.out.println("Please enter campus name");
		String a3 = scan.next();
		System.out.println("Please enter building name");
		String a4 = scan.next();
		System.out.println("Please enter room name");
		String a5 = scan.next();
		System.out.println("Please enter phone name");
		String a6 = scan.next();
		staff cur = new staff(a1,a2,a3,a4,a5,a6);//assign each attributes by creating staff cur
		depart.add(cur);//add all staff into department type of depart
		System.out.print("You have added: ");
		cur.display();
	}
	public static void removeStaff(department depart) {//remove a staff last name or phone number
		System.out.println("Please type in a last name or tellphone number that want to remove:");
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		try{
	        int a = Integer.parseInt(input);//if input is integer
	        depart.removeStaffByPhone(a);          
	    } catch (Exception ex){
	    	depart.removeStaffByName(input);// if input is string
	    }
	}
	public static void changePhone(department depart) {//change a telephone number of staff
		// TODO Auto-generated method stub
		System.out.println("Whos phone you want to change, please enter last name:");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		depart.editPhone(name);
		
	}
	public static void unitDep(department depart){//enter specific department
		
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("What do you want to do :");
			System.out.println("A: Display all staff");
			System.out.println("B: Display all campus");
			System.out.println("C: Find a staff");
			System.out.println("D: Add new staff");
			System.out.println("E: Remove staff");
			System.out.println("F: Change the phone");
			System.out.println("G: Go back to choose a department");
			String input = scan.next();
			if(input.equalsIgnoreCase("A")){
				displayStaff(depart);
			}else if(input.equalsIgnoreCase("B")){
				displayCampus(depart);
			}else if(input.equalsIgnoreCase("C")){
				findStaff(depart);
			}else if(input.equalsIgnoreCase("D")){
				addStaff(depart);
			}else if(input.equalsIgnoreCase("E")){
				removeStaff(depart);
			}else if(input.equalsIgnoreCase("F")){
				changePhone(depart);
			}else if(input.equalsIgnoreCase("G")){
				break;			
			}else{
				System.out.println("Sorry, please enter again!");
				System.out.println();
			}
		}
	}
	public static void main(String []args){
		// Create an ArrayList that holds references to String
		String fileName = "text.txt";
		readFile(fileName);		
		while(true){
			for(int i = 0; i<depts.size(); i++){
				System.out.println("Depratment: "+depts.get(i).getName());
			}
			System.out.println("Please Enter Department Name, or Enter 'q' to quit:");	
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			boolean a = false;
			for(int i=0;i<depts.size();i++){//check input department is whether in deparment list
				String input1 = depts.get(i).getName();
				if(input.equals(input1)){
					a = true;
				}
			}
			if(a == true){
				int count = 0;
				while(count< depts.size()){
					String input1 = depts.get(count).getName();
					if(input.equals(input1)){
						unitDep(depts.get(count));// enter specific department 
					}
					count++;
				}
			}else if (input.equalsIgnoreCase("Q")){
				break;
			}
			else{
				System.out.println("Sorry,please enter correct department name!");
			}
		}
	 }
}
