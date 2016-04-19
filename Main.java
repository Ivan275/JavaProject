import java.io.*;
import java.util.Scanner;
import java.util.Vector;
public class Main {
	public static void main(String args[]) {
		DepartmentType one = new DepartmentType();
		FacultyType two = new FacultyType();
		StaffType three = new StaffType();
		Vector r = new Vector();
		Vector z = new Vector();
		Scanner input = new Scanner(System.in);
		one.readfile(); // use readfile method in departmentType class
		StaffType[] Computing = one.ComputingScience();
		for(int i = 0; i<8 ;i++)
		{
			z.add(Computing[i]);// copy all members from computing science.

		}

		StaffType[] Engineering = one.EngineeringScience();
		
		for(int i = 0; i<5 ;i++)
		{
			r.add(Engineering[i]);// copy all members from Engineering science.
	
		}
		Scanner scan = new Scanner(System.in);
		
		boolean ss = false;
		while(ss==false)
		{
			
				two.facultyMenu();// call the faculty menu first.
				String c1 = input.next();// user's input
				//int pressOne = Integer.parseInt(c1);
				if(c1.equals("zero"))
				{
					ss = true;
					System.out.println("you have end the Faculty.");
				}
				else{
					if(c1.equals("one")) //if user print 1 then printing out all staffs information in Faculty.
					{
						
						two.printDepartment(r,z);
						
					}
					else if (c1.equals("two"))//if user print 2 then selecting the Department in Faculty.
					{	
						two.campusLocator(r,z);
						
					}
					else if ( c1.equals("three"))//if user print 2 then display all staff in Faculty.
					{
						
						one.writeFile(two.displayAllStaff(Engineering,  Computing));
					}
				
				System.out.println();
				System.out.println("please enter department name:");
				String t = input.next();// selecting department name
				Vector v = two.chosenDepartment(z,r,t);
				System.out.println("you have entered "+t+" Science");
				StaffType[] array = new StaffType[v.size()];
				for(int i = 0; i < v.size(); i++)
				{
					array[i]= (StaffType) v.get(i);//copy it to array.
					
				}
				
				System.out.println();
				System.out.println("press 1, search staff by name.");// this is menu.
				System.out.println("press 2, display staff from first name by alphabetical.");
				System.out.println("press 3, add an staff.");
				System.out.println("press 4, remove staff by name.");
				System.out.println("press 5, display campus locator.");
				System.out.println("press 6, display all information in the Department.");
				System.out.println("press 7, display detail information of the person.");
				System.out.println("press 8, change telephone number.");
				System.out.println("press 9, search telephone.");
				System.out.println("press 10, please enter campus locator to display all staff");
				
				//Scanner scan = new Scanner(System.in);
				
				boolean a = false;
				
				while(a == false)// if it is false do this
				{	
					System.out.println("enter 0 to quit process in Department.");
					System.out.println("please enter a number:");
					String num1 = scan.next();
					int press = Integer.parseInt(num1);
					if ( press == 0)// if user enter q, the program will end.
					{
						a = true;
						System.out.println("you have end the Department.");
						
					}
					
					else
					{
						switch(press)//use swith statement to determine the input
						{
						case 1:
							System.out.println("please enter the name of Staff:");
							String a1 = input.next();
							one.searchName(a1,array);                         
							break;
						case 2:
							String [] st = one.displayName(array);
							//one.writeFile(null,st,null);
							break;
						case 3:
							System.out.println("please enter:intialName surname campusLocator campusLocation telephoneNumber roomNumber");
							String intialName = input.next();
							String surname = input.next();
							String campusLocator = input.next();
							String  campusLocation = input.next();
							String roomNumber = input.next();
							String telephoneNumber = input.next();
							one.add(v,array,intialName,surname,campusLocator,campusLocation,roomNumber,telephoneNumber);                                //it searchs staff by name
							break;
						case 4:
							System.out.println("please enter the staff name who you wanna remove:");
							String b = input.next();
							one.removeName(b,v,array);                                //it searchs staff by name
							break;
						case 5:
							one.displayCampusLocators(array,v);                                //it searchs staff by name
							//one.writeFile(null,null,one.displayCampusLocators(array,v));
							break;
						case 6:
							//one.displayAllStaff(array,v);                                //it searchs staff by name
							one.writeFile(one.displayAllStaff(array,v));
							break;
						case 7:
							System.out.println("please enter the name of Staff:");
							String c = input.next();
							one.displayDetailOne(c,array);                                //it searchs staff by name
							break;
						case 8:
							System.out.println("please enter the telephone number you wanna to change(old number, new number,new office,new room number and new campus locator:");
							
							String a11 = input.next();			
							String a2 = input.next();
							String a3 = input.next();
							String a4 = input.next();
							String a5 = input.next();
							one.changeTelephone(a11,a2,a3,a4,a5,array);
		
							break;
						case 9:
							System.out.println("please enter a telephone number: ");
							String w = input.next();
							one.searchTelephone(w, array);                                //it searchs staff by name
							break;
						case 10:
							System.out.println("please enter a campus locator: ");
							String w1 = input.next();
							two.staffInCampusLocator(w1, array);
				
							
							break;
							default:
								
						
							System.out.println(" you did press nothing");
						}
					}
				}
		}
		}
	}

}
