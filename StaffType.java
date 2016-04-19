
import java.util.Vector;
public class StaffType {
	private String name;
	private String initial;
	private String campusLocator;
	private String officeLocation;
	private String roomNumber;
	private String telephoneNumber;
	//private String areaCodePrefix;
	public StaffType()
//  constructor default
	{
		
		
	}
	public StaffType(String nameOne,String campusLocatorOne,String officeLocationOne,String roomNumberOne,String telephone,String areaPrefix,String a)
	// constructor
	{
		 name = nameOne;
		 campusLocator = campusLocatorOne;
		 officeLocation = officeLocationOne;
		 roomNumber = roomNumberOne;
		 telephoneNumber = telephone;
		 initial = a;
		 //areaCodePrefix = areaPrefix;
	}
	public String getOffice()
	// accessor function
	{
		return officeLocation;
	}
	public void setOffice(String c)
	// accessor function
	{
		officeLocation = c;
	}
	public String getInitial()
	// accessor function
	{
		return initial;
	}
	public void setInitial(String a)
	// accessor function
	{
		initial = a;
	}
	public String getName()
	// accessor function
	{
		return name;
	}
	public void setName(String nameOne)
	// accessor function
	{
		name = nameOne;
	}
	public String getCampLoc()
	// accessor function
	{
		return campusLocator;
	}
	public void setCampLoc(String b)
	// accessor function
	{
		campusLocator = b;
	}

	public void setRoom(String roomNumberOne)
	// accessor function
	{
		roomNumber = roomNumberOne;
	}
	public String getRoom()
	// accessor function
	{
		return roomNumber;
	}
	public void setTelephone(String telephone)
	// accessor function
	{
		telephoneNumber = telephone;
	}
	public String getTelephone()
	// accessor function
	{
		//DepartmentType a = new DepartmentType();
		return telephoneNumber;
	}

	public String toString(){
		DepartmentType b = new DepartmentType();
		return name + " " + initial +" " +campusLocator +" " + officeLocation +" " + roomNumber +" " +b.getPrefix()+"-"+ telephoneNumber ;
	}
	
}


