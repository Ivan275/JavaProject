import java.util.Scanner;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;
public class FacultyType {
	private String campusLocator;
	private String Department;
	public FacultyType()
//  constructor default
	{
		
	}
	public Vector chosenDepartment(Vector Computing,Vector Engineering,String name)
	// this operation select which department you wanna get into.
	{
		
		if(name.equals("Engineering"))
		{
			
			return Engineering;
		}
		else if(name.equals("Computing"))
		{
			//DepartmentType two = new DepartmentType();
			
			return Computing;
		}
		else
		{
			System.out.println(" The name of Department you entered is not in the file");
			return null;
		}
	}
	public void campusLocator(Vector a, Vector b)
	// this operation will print the exist campus locator.
	{
		StaffType[] arrayOne = new StaffType[a.size()]; //create first StaffType array;
		StaffType[] arrayTwo = new StaffType[b.size()];// create second StaffType array;
		String [] a1 = new String[arrayOne.length + arrayTwo.length];
		for(int i = 0; i < a.size(); i++)
		{
			arrayOne[i]= (StaffType) a.get(i);// copy all information Engineering as a StaffType array;
			
		}
		System.out.println();
		for(int i = 0; i < b.size(); i++)
		{
			arrayTwo[i]= (StaffType) b.get(i);// copy all information Computing as a StaffType array;
			
		}
		
		for(int i = 0; i < arrayTwo.length; i++)
			{
			a1[i]= arrayTwo[i].getCampLoc();//find out all compus locators in  Engineering;
			}
		
		for(int i = 0; i < arrayOne.length; i++)
		{
			a1[arrayTwo.length+i]=arrayOne[i].getCampLoc();//find out all compus locators in  Engineering;
		}
	
		
		
		
		for (int i=0; i<a1.length-1; i++) {
            for (int j=i+1; j<a1.length; j++) {
               if (a1[i].compareTo(a1[j]) > 0) {
                  String temp=a1[j]; a1[j]=a1[i]; a1[i]=temp;// sorting them;
                  
                  //http://www.roseindia.net/java/java-tips/data/strings/96string_examples/example_sort.shtml
               }
            }
         }
		
		
		Vector v = new Vector();// creat a vector.
		for(int i = 0; i< a1.length ;i++)
		{
			
			v.add(a1[i]);// add all elements to v.
			
		}
		int count = 12;
		
		while(( count> 0))
		{
			
			
			if(a1[count].equals(a1[count-1]))
			{
				
				v.remove(count-1);
				
			}
			count--;
		}
		
		
		if(v.size()==1)//if size equals one.
		{
			System.out.println(v.get(0));
		}
		else if(v.size()==2)//if size equals two.
		{
			System.out.println(v.get(0)+" "+v.get(1));
		}
		else if(v.size()==3)//if size equals three.
		{
			System.out.println(v.get(0)+" "+v.get(1)+" "+v.get(2));
		}
		else if(v.size()==4)//if size equals four.
		{
			System.out.println(v.get(0)+" "+v.get(1)+" "+v.get(2)+" "+v.get(3));
		}
		else
		{
			System.out.println("no campus Locator");
		}
	}
	public void printDepartment(Vector a, Vector b)
	// this operation will print all department directory.
	{
		DepartmentType one = new DepartmentType();
		System.out.println(one.Engineering());// this is Engineering Science.
		for(int i = 0; i < a.size(); i++)// all members in Engineering Science.
		{
			System.out.println(a.get(i));
		}
		System.out.println(one.Computing());// this is computing Science.
		for(int i = 0; i < b.size(); i++)
		{
			System.out.println(b.get(i));// all members in Engineering Science.
		}
		
	}
	public StaffType[] displayAllStaff(StaffType[] a, StaffType[] b)
	// this operation will print all staff information for all deparment.
	{
		
		StaffType[] c = new StaffType[13];
			for(int i = 0; i < 5; i++)
		{
			c[i] = a[i];
		}
		for(int i = 0; i < 8; i++)
		{
			c[c.length - i-1] = b[i];
		}
		for(int i = 0; i < 13; i++)
		{
			System.out.println(c[i]);
		}
		
		return c;
	}
	public void staffInCampusLocator(String cam, StaffType[] b)
	// this operation will print all staff by inputing campus locator.
	{
		for(int i = 0; i< b.length ;i++)
		{
			
			if(cam.equals(b[i].getCampLoc()))
			{
				System.out.println(b[i]);
			}
			
		}
	}
	public void facultyMenu()
	// this is the menu for faculty.
	{
		System.out.println("you have get into FAS,please enter a deparment name(Engineering Science or Computing Science):");
		System.out.println("please enter zero, to end the Faculty directory:");
		System.out.println("please enter one , to display Department in Faculty directory:");
		System.out.println("please enter two, to display list of unique campus locators in Faculty directory:");
		System.out.println("please enter three , to display all staff in Faculty directory:");
		
	}
	

}