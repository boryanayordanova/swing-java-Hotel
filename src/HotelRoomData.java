
public class HotelRoomData {
	private int floor_num;
	private int room_num;
	private int room_type;
	private boolean room_status;
	
	
	
	public HotelRoomData(int f, int r, int t, boolean rs){
		floor_num=f;
		room_num=r;
		room_type=t;
		room_status=rs;
		
	}
	public HotelRoomData(){
		floor_num=1;
		room_num=0;
		room_type=0;
		room_status=true;
	}
		
	
	public int getFloor(){
		return floor_num;
	}
	public int getRoom(){
		return room_num;
	}
	
	public int getRoomType(){
		return room_type;
	}
	public boolean getRoomStatus(){
		return room_status;
	}
	
	public void setFloor(int f){
		floor_num=f;
	}
	public void setRoom(int r){
		room_num=r;
	}
	
	public void setRoomType(int b){
		room_type=b;
	}
	public void setRoomStatus(boolean rs){
		room_status = rs;
	}
	
	
	
	public String toString(){
		String temp = "";
		temp+=floor_num+" "+room_num+" "+room_type+" "+room_status;
		return temp;		
	}



}
