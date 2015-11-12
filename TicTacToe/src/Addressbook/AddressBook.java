package Addressbook;

import java.util.Collections;
import java.util.*; 

public class AddressBook {
private String bookName;
private List<BuddyInfo> adbook;
private int bookLength;
private String[] contactNames;


	public AddressBook(String bookName){
		this.bookName = bookName;
		adbook = new ArrayList<>();
	}

	public void addBuddy(AddressBook book, BuddyInfo newBuddy){
		book.adbook.add(newBuddy);
		//may need to return
	
	}
	
	public void removeBuddy(AddressBook book, BuddyInfo oldBuddy){
		book.adbook.remove(oldBuddy);
	}
	
	public String printContacts(){
		String s="";
		for(BuddyInfo b:adbook)
		{
			s+=(b.getName()+" "+b.getNum()+" "+b.getAddress()+"\n");
		}
		return s;
	}
	public List getAddBook()
	{
		return adbook;
	}
	public String[] getContactNames(){
		bookLength = adbook.size();
		contactNames = new String[bookLength];
		
		for(BuddyInfo b:adbook)
		{
			for (int i = 0; i < bookLength; i+=1){
				contactNames[i] = b.getName();
			}
		}
		return contactNames;
	}
	
	public void removeBuddyInt(AddressBook book,int i)
	{
		(book.adbook).remove(i);
	}
	
	
	
/*	public static void main(String arg[]){
		AddressBook book1 = new AddressBook("book1");
		BuddyInfo bud1 = new BuddyInfo("Bud"); 
		
		System.out.println("Address Book");
		book1.addBuddy(book1, bud1);
	}
	*/
	
}
