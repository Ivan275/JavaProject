package university;

public class staff {
	String lastname;
	String initial;
	String campus;
	String building;
	String room;
	String phone;
	public staff(String lastname,String initial,String campus,String building,String room,String phone){
		this.lastname = lastname;
		this.initial = initial;
		this.campus = campus;
		this.building = building;
		this.room = room;
		this.phone = phone;	
	}
	public void display(){
		System.out.println(this.lastname + " "+ this.initial+" "+this.campus+" " +this.building+" "+this.room+" "+this.phone);
		//System.out.println();
	}
	public String getLastName(){
		return this.lastname;
	}
	public String getInitial(){
		return this.initial;
		
	}
	public String getCampus(){
		return this.campus;
	}
	public String getBuilding(){
		return this.building;	
	}
	public String getRoom(){
		return this.room;	
	}
	public String getPhone(){
		return this.phone;	
	}
	public String setPhone(String phoneNumber){
		this.phone = phoneNumber;
		return this.phone;
	}
	

}
