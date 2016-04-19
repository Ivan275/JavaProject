import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Scanner;
public class DepartmentType {
	private String campusLocator;
	private int numberOfStaff;
	private String surnameOne;
	private String Engineering= "Engineering Science" ;
	private String Computing = "Computing Science";
	private StaffType[] staffOne = new StaffType[20];
	private StaffType[] staffTwo = new StaffType[20];
	private String areaCodePrefix ;
  	public DepartmentType()
  	//  constructor default
	{

	}  	

	public DepartmentType(String campusLocatorOne, int numberOfStaffOne,String surname)
	// constructor
	{                                                                      
		campusLocator = campusLocatorOne;
		surnameOne = surname;
		numberOfStaff = numberOfStaffOne;
	}
	public void readfile()
	//read file by bufferedreader
	{
		try {
            FileInputStream fstream = new FileInputStream("test.txt");
            
            DataInputStream in = new DataInputStream(fstream);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = null;
            
            String[] s = new String[5];
           
            int index = 0;
           
            String a = br.readLine(); // this is line for the  FAS 2 
        
            String b = br.readLine();// this is the line for Engineering Science

            String words[]=new String [30];

	    	    int j = 0;
	            while (((strLine = br.readLine()) != null)&&(!strLine.equals("*")))//reading the lines for Engineering Science
	            {
	            		String message = strLine;
	            		StaffType one = new StaffType();
	       			 	StringTokenizer st=new StringTokenizer(message);
	       			 	int idx=0;
	       				while (st.hasMoreTokens()) // i use string tokenizer.
	       			        {
	       			    		words[idx]=st.nextToken(); // take out all String.
	       			    		idx++;
	       			    	}
	       			 one.setName(words[0]);		// i set each word in one line to a StaffType called one;
					 one.setInitial(words[1]);
					 one.setCampLoc(words[2]);
					 one.setOffice(words[3]);
					 one.setRoom(words[4]);
					 one.setTelephone(words[5]);			 
					 staffOne[j] = one; // i add each StaffType in to a StaffType array call staffOne.
					 j++;// each StaffType array position will contain all StaffType one for all.
	
	            }

	            String c = br.readLine();// this is the line for Computing Science.
            		int i = 0;
            	
		            while (((strLine = br.readLine()) != null)&&(!strLine.equals("*")))//reading the lines for Computing Science
		            {
		            	
		            	String message = strLine;
		        		StaffType two = new StaffType();
		   			 	StringTokenizer st=new StringTokenizer(message);
		   			 	int idx=0;
		   				while (st.hasMoreTokens()) // i use string tokenizer.
		   			        {
		   			    		words[idx]=st.nextToken(); // take out all String in one line.
		   			    		idx++;
		   			    	}
		   			 two.setName(words[0]);// i set each word in one line to a StaffType called Two;
					 two.setInitial(words[1]);
					 two.setCampLoc(words[2]);
					 two.setOffice(words[3]);
					 two.setRoom(words[4]);
					 two.setTelephone(words[5]);
					 
					 staffTwo[i] = two;// i add each StaffType in to a StaffType array call staffTwo.
					 i++;// each StaffType array position will contain all StaffType one for all.
		              
		            }

        }
		catch (Exception e) 
		{
            System.err.println("Error: " + e.getMessage());
        }

		
	}
	public void writeFile(StaffType[] v)
	//write file by bufferedreader.
	{
	  try{
		  // Create file 
		  FileWriter fstream = new FileWriter("out.txt");
		  BufferedWriter out = new BufferedWriter(fstream);
		  //String [] v ={"a","b","c"};
		  for(int i = 0; i<v.length;i++)
		  {
			  out.write(v[i].toString());
		  }
		 
		  
		  out.close();
		  }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }
	}
	public StaffType[] ComputingScience()
	// get all staff in Computing Science.
	{
		
		return staffTwo;
	}
	public StaffType[] EngineeringScience()
	//get  all staff in Engineering Science.
	{
		
		return staffOne;
	}
	public String Engineering()
	// get the name of Engineering Science
	{	
		return Engineering;
	}
	public String Computing()
	// get the name of Computing Science.
	{
		return Computing;
	}
	public void setPrefix(String prefixOne)
	// set the prefix and area code.
	{
		areaCodePrefix = prefixOne;
	}
	public String getPrefix()
	//get the prefix and area code.
	{
		return areaCodePrefix = "778-782";
	}

	
	public void searchName(String surname, StaffType [] a)
	//search the existence of the input name .
	{
	
		int count = 0;
		
		for(int i = 0; i< a.length ;i++)
		{
			
			if(surname.equals(a[i].getName()))
			{
				count++;
			}
			
		}

		if (count >0)
		{
			System.out.println("I find him");
		}
		else{
			System.out.println("I didn't find him");
		}

	}
	public String[] displayName(StaffType[] a)
	 //display Name by alphabetic listing
	{
	
		String [] b = new String[a.length];// using String array to collect all name;
		for(int i = 0; i< a.length ;i++)
		{
			
			b[i] = a[i].getName();
		
		}
		
		for (int i=0; i<b.length-1; i++) {//this is sorting algrithmn.
             for (int j=i+1; j<b.length; j++) {
                if (b[i].compareTo(b[j]) > 0) {
                   String temp=b[j]; b[j]=b[i]; b[i]=temp;
                   
                   // this is the address: http://www.roseindia.net/java/java-tips/data/strings/96string_examples/example_sort.shtml
                }
             }
          }
		for(int i = 0; i< b.length ;i++)
		{
			
			System.out.println(b[i]);
		
		}
          return b;
		
	}
	public void add(Vector a,StaffType[] w, String b,String c,String d,String e,String f,String g)
	// this method can add a new staff.
	{
		StaffType two = new StaffType();// create a new StaffType call two.
		int count = 0;
		int j =0;
		
		for(int i = 0; i < w.length;i++)
		
		{
			if(w[i].getName().equals(b))// see that if the name exist or not
			{
				count++;
			}
		}
		if(count==0)// name of staff does not exist in file.
		{
		
			two.setName(b);// set everything for StaffType two.
			two.setInitial(c);
			two.setCampLoc(d);
			two.setOffice(e);
			two.setRoom(f);
			two.setTelephone(g);
			a.add(two); // use vector to add the StaffType two
			for(int i = 0; i < a.size();i++)
			{
				
				System.out.println(a.get(i)+" ");
			
				
			}
			System.out.println("you have add: "+two);
		}
		else// the name of staff already be the file
		{
			System.out.println("please enter again");
		}
	

	}
	public void removeName(String surname,Vector a,StaffType[] b)
	// this operation will remove staff by surname.
	{	
		int count = 0;
		while(!surname.equals(b[count].getName()))//using while loop find the position of name.
				{
				count++;
				}
		
		a.remove(count);// remove the the StaffType for that name.
		for(int i = 0; i<a.size() ;i++)
		{
			
			System.out.println(a.get(i)+" ");// print it to screen.
			
		}
		System.out.println("you have been remove: "+ b[count]);// report to user.
		
	}
	public String displayCampusLocators(StaffType[] a, Vector c)
	 //the operation will print out all compus locator in the department.
	{
		String[] b = new String[a.length];// creat a string array call b.
		Vector v = new Vector();
		for(int i = 0; i< c.size() ;i++)
		{
			
			b[i] =a[i].getCampLoc();// signing all string type of campus locator into the array b.
			
		}
		for (int i=0; i<b.length-1; i++) {// sorting them.
            for (int j=i+1; j<b.length; j++) {
               if (b[i].compareTo(b[j]) > 0) {
                  String temp=b[j]; b[j]=b[i]; b[i]=temp;
                  
                  //http://www.roseindia.net/java/java-tips/data/strings/96string_examples/example_sort.shtml
               }
            }
         }
		for(int i = 0; i< a.length ;i++)
		{
			
			v.add(b[i]);// using  vector call r to add all campus locator t from the array b.
			
		}
		
	
		int count = a.length-1;
		
		while(( count> 0))
		{
			
			
			if(b[count].equals(b[count-1]))// find same compus locator
			{
				
				v.remove(count-1);// if two compus locator beside each other and they equal each. then delete left side
				
			}
			count--;
		}
		
		if(v.size()==1)// we know they are order. so if size of vector is 1 
		{
			
			System.out.println(v.get(0));// print it out
			return (String) v.get(0);
		}
		else if(v.size()==2)//so if size of vector is 2
		{
			
			System.out.println(v.get(0)+" "+v.get(1));
			return v.get(0)+" "+v.get(1);
		}
		else if(v.size()==3)//so if size of vector is 3 
		{
			System.out.println(v.get(0)+" "+v.get(1)+" "+v.get(2));
			return v.get(0)+" "+v.get(1)+" "+v.get(2);
		}
		else//"no campus Locator"
		{
			System.out.println("no campus Locator");
			return "no campus Locator";
		}
		
		//System.out.println("displayCampusLocators method has been called.");
	}
	public StaffType[] displayAllStaff(StaffType[]a, Vector b)
	// this operation will display all staff in the department
	{
		for(int i = 0; i< b.size() ;i++)
		{
			
			System.out.println(a[i]+" ");
			
		}
		return a;
		
	}
	public void displayDetailOne(String surname,StaffType[] a)
	// this operation will display the detail of a staff.
	{
		for(int i = 0; i< a.length ;i++)
		{
			
			if(surname.equals(a[i].getName()))// search the position of this staff.
			{
				System.out.println(a[i]);
			}
			
		}
		
	}
	public void changeTelephone(String oldTelephone,String newTelephone,String office,String roomNum,String CampusLocator,StaffType[] b)
	// this operation will change telephone and room number , office and campus locator.
	{
		//StaffType a = new StaffType();
	
		int i =0;
		while(!b[i].getTelephone().equals(oldTelephone))// search the position for input of telephone
		{
		
			i++;
		}
		//v.remove(i);
		b[i].setName(b[i].getName());// set everything.
		b[i].setInitial(b[i].getInitial());
		b[i].setCampLoc(CampusLocator);
		b[i].setOffice(office);
		b[i].setRoom(roomNum);
		b[i].setTelephone(newTelephone);;
		for(int j = 0; j < b.length;j++)
		{
			System.out.println(b[j]);
		}
		System.out.print("you have changed telephone number"+"change tel# "+oldTelephone +" to "+ newTelephone);
		if (!b[i].getCampLoc().equals(CampusLocator))// search the campus locator is same or not.
		{
			System.out.print(",room changes to"+ office+" "+ " to "+ roomNum+", campus changes to "+ CampusLocator);
		}
		else
		{
			System.out.print(",room changes to"+ office+" "+ " to "+ roomNum+", no campus changes ");
		}
		
	}
	public void searchTelephone(String Telephone,StaffType[] b)
	// thie operation searchs Telephone number for you.
	{
		for(int i = 0; i< b.length ;i++)
		{
			
			if(Telephone.equals(b[i].getTelephone()))
			{
				System.out.println(b[i]);
			}
			
		}
	}


}
