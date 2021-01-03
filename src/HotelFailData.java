import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class HotelFailData extends java.util.Date {
	
	
	public static Date conv(String s){
		
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" ) ;
		java.util.Date convDate = null;
		java.sql.Date convSQLDate = null;
		try {
			convDate= sdf.parse(String.valueOf(s));
			convSQLDate = new java.sql.Date(convDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return convSQLDate;
		
	}
	
//READ GUEST	
	public static ArrayList<HotelGuestData> readGuestsFromFile(){
		ArrayList<HotelGuestData> listGuests = new ArrayList<HotelGuestData>();
		
		  try {
		    	FileReader fr = new FileReader("GuestData.txt");
		        BufferedReader br = new BufferedReader(fr);
		    	
		    			String[] res = new String[10];
		    			String strLine=null;

		    			while((strLine = br.readLine()) != null && strLine.length()>0)
		    			{

		    				res = strLine.split(" ");
		    				HotelGuestData tempG=new HotelGuestData(
		    				Integer.parseInt(res[0]),Integer.parseInt(res[1]),Integer.parseInt(res[2]),Boolean.parseBoolean(res[3]),
		    				res[4],res[5],res[6],res[7],conv(res[8]),conv(res[9]),Integer.parseInt(res[10]));
		    		
		    				listGuests.add(tempG);
		    			}
		    			
		    			br.close();
		    		}
		    		catch (FileNotFoundException e)
		    		{ System.out.println("File Not Found ..."); }
		    		catch(EOFException e) 
		    		{ System.out.println("End of file encountered ..."); }
		    		catch (IOException e)
		    		{System.out.println("Input/Output Error ...."); }
		return listGuests; 
	 }
	
//WRITE GUESTS	
	public static void writeGuestsToFile(ArrayList<HotelGuestData> list) {
	
			try {
				PrintStream out = new PrintStream("GuestData.txt");
				
				for(HotelGuestData tmp : list){
					out.println(tmp.toString());
				}
				
				out.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
			}		
		}
		

//READ ROOMS		
	public static ArrayList<HotelRoomData> readRoomsFromFile(){
		ArrayList<HotelRoomData> listRooms = new ArrayList<HotelRoomData>();

	  try {
	    	FileReader fr = new FileReader("RoomsData.txt");
	        BufferedReader br = new BufferedReader(fr);
	    	
	    			String[] res = new String[3];
	    			String strLine=null;
	    			

	    			while((strLine = br.readLine()) != null && strLine.length()>0)
	    			{
	    				res = strLine.split(" ");
	    				HotelRoomData tempR=new HotelRoomData(
	    				Integer.parseInt(res[0]),Integer.parseInt(res[1]),Integer.parseInt(res[2]), Boolean.parseBoolean(res[3]));
	    				listRooms.add(tempR);
	    			}
	    			
	    			br.close();
	    		}
	    		catch (FileNotFoundException e)
	    		{ System.out.println("File Not Found ..."); }
	    		catch(EOFException e) 
	    		{ System.out.println("End of file encountered ..."); }
	    		catch (IOException e)
	    		{System.out.println("Input/Output Error ...."); }
	return listRooms; 
}
		
//WRITE ROOMS	
		public static void writeRoomToFile(ArrayList<HotelRoomData> list) {
			
			try {
				PrintStream out = new PrintStream("RoomsData.txt");
				
				for(HotelRoomData tmp : list){
					out.println(tmp.toString());
				}
				
				out.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
			}		
		}	
	}
	
