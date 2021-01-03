import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;


public class HotelGuestData  extends HotelRoomData {
	

	private String first_name;
	private String second_name;
	private String last_name;
	private String egn;
	private Date date_arriving;
	private Date date_leaving;
	private int price;
	
	
	

	public HotelGuestData(int f, int r, int t, boolean rs, String fn, String s, String l, String e, java.sql.Date da, java.sql.Date dl,int p){
		super(f,r,t,rs);
		first_name=fn;
		second_name=s;
		last_name=l;
		egn=e;
		date_arriving=da;
		date_leaving=dl;
		price=p;
	
	}
	
	public HotelGuestData() {
		super();
		
	}

	public String getFirstName(){
		return first_name;
	}
	public String getSecondName(){
		return second_name;
	}
	public String getLastName(){
		return last_name;
	}
	public String getEGN(){
		return egn;
	}
	public java.sql.Date getDateArriving(){
		return date_arriving;
	}
	public java.sql.Date getDateLeaving(){
		return date_leaving;
	}
	public int getPrice(){
	return price;
	}
	public int getFloor(){
		return super.getFloor();
	}
	
	
	
	public void setFirstName(String fn){
		first_name=fn;
	}
	public void setSecondName(String sn){
		second_name=sn;
	}
	public void setLastName(String ln){
		last_name=ln;
	}
	public void setEGN(String e){
		egn=e;
	}
	public void setDateArriving(java.sql.Date date){
		date_arriving=date;
	}
	public void setDateLeaving(java.sql.Date date){
		date_leaving=date;
	}
	public void setPrice(int p){
		price=p;
	}
	

	public String toString(){
		return super.toString()+" "+first_name+" "+second_name+" "+last_name+" "+egn+" "
								   +date_arriving+" "+date_leaving+" "+price;
	}
	

	public  void AddGuestsToFile(HotelGuestData obj) {
		try{
		FileWriter fw = new FileWriter("GuestData.txt",true); //the true will append the new data
	    fw.write(obj.toString());
	    fw.write(System.lineSeparator());
		fw.close();
		}catch (FileNotFoundException e){ 
			System.out.println("File Not Found ...");
		}catch (IOException e){
			System.out.println("Input/Output Error ....");
		}
		
	}
	
	

	
}

