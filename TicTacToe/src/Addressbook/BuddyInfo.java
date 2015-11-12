package Addressbook;


public class BuddyInfo {
	private String name;
    private String address;
    private int phoneNum;
	public BuddyInfo(String name, String address, int phoneNum){
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		
	}
	public String getName() {
		return name;
	}
	
	public void setName(String aName){
		name = aName;
	}

	public int getNum()
	{
		return phoneNum;
	}
	
	public void setNum(int aNum){
		phoneNum = aNum;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String aAddress){
		address = aAddress;
	}


/*
	public static void main(String[] args) {
        BuddyInfo man = new BuddyInfo("Homer","29 Hiram Rd",907703029);    
		System.out.println("Hello " + man.getName());
    }
    */
}

