import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;


public class SwingAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField_FirstName;
	private JTextField textField_SecondName;
	private JTextField textField_LastName;
	private JTextField textField_EGN;
	private JTextField textField_TotalPrice;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingAdd frame = new SwingAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ArrayList <HotelRoomData> listRooms = HotelFailData.readRoomsFromFile();
	private ArrayList <HotelGuestData> listGuests= HotelFailData.readGuestsFromFile();

	public SwingAdd() {
		setResizable(false);
		setTitle("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setToolTipText("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F");
		contentPane.setForeground(new Color(153, 0, 255));
		contentPane.setBackground(new Color(255, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//System.out.println(listRooms.toString());
		//System.out.println(listGuests.toString());
		
//FIRST NAME
		
		
		textField_FirstName = new JTextField();
		textField_FirstName.setTransferHandler(null);
		textField_FirstName.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			
				char c = e.getKeyChar();
				if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| (c==KeyEvent.VK_DELETE) || (c==KeyEvent.VK_SPACE) )){
					e.consume();
					
				}
			}
			public void keyPressed(KeyEvent e) {
				 if(textField_FirstName.getText().length()>=20)
				    {
					 textField_FirstName.setText(textField_FirstName.getText().substring(0, 19));
				    }
			}
		});
		textField_FirstName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{				
					textField_SecondName.requestFocus();
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex);
					
				}
			}
		});
		textField_FirstName.setBackground(new Color(255, 204, 255));
		textField_FirstName.setForeground(new Color(153, 0, 255));
		textField_FirstName.setBounds(215, 50, 180, 20);
		contentPane.add(textField_FirstName);
		textField_FirstName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("\u0418\u043C\u0435 :"); 
		lblFirstName.setForeground(new Color(153, 0, 255));
		lblFirstName.setBounds(90, 50, 90, 15);
		contentPane.add(lblFirstName);
		
//SECOND NAME
		
		textField_SecondName = new JTextField();
		textField_SecondName.setTransferHandler(null);
		textField_SecondName.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| (c==KeyEvent.VK_DELETE) || (c==KeyEvent.VK_SPACE) )){
					e.consume();
					
				}
			}public void keyPressed(KeyEvent e) {
				 if(textField_SecondName.getText().length()>=20)
				    {
					 textField_SecondName.setText(textField_SecondName.getText().substring(0, 19));
				    }
			}
		});
		textField_SecondName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{				
					textField_LastName.requestFocus();
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex);
					
				}
			}
		});
		textField_SecondName.setBackground(new Color(255, 204, 255));
		textField_SecondName.setForeground(new Color(153, 0, 255));
		textField_SecondName.setBounds(215, 80, 180, 20);
		contentPane.add(textField_SecondName);
		textField_SecondName.setColumns(10);
		
		JLabel lblSecondName = new JLabel("\u041F\u0440\u0435\u0437\u0438\u043C\u0435 :"); 
		lblSecondName.setForeground(new Color(153, 0, 255));
		lblSecondName.setBounds(90, 80, 90, 15);
		contentPane.add(lblSecondName);
		
//LAST NAME		
		textField_LastName = new JTextField();
		textField_LastName.setTransferHandler(null);
		textField_LastName.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| (c==KeyEvent.VK_DELETE) || (c==KeyEvent.VK_SPACE) )){
					e.consume();
					
				}
			}
			public void keyPressed(KeyEvent e) {
				 if(textField_LastName.getText().length()>=20)
				    {
					 textField_LastName.setText(textField_LastName.getText().substring(0, 19));
				    }
			}
		
		});
		textField_LastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{				
				    textField_EGN.requestFocus();
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex);
					
				}
			}
		});
		textField_LastName.setBackground(new Color(255, 204, 255));
		textField_LastName.setForeground(new Color(153, 0, 255));
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(215, 110, 180, 20);
		contentPane.add(textField_LastName);
		
		JLabel lblLastName = new JLabel("\u0424\u0430\u043C\u0438\u043B\u0438\u044F :"); 
		lblLastName.setForeground(new Color(153, 0, 255));
		lblLastName.setBounds(90, 110, 90, 15);
		contentPane.add(lblLastName);

//EGN	
		final JRadioButton radioButton_floor_1 = new JRadioButton("\u041F\u044A\u0440\u0432\u0438");	
		textField_EGN = new JTextField();
		textField_EGN.setTransferHandler(null);
		textField_EGN.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| (c==KeyEvent.VK_DELETE))){
					e.consume();
					
				}
			}
			public void keyPressed(KeyEvent e) {
				 if(textField_EGN.getText().length()>=10)
				    {
					 textField_EGN.setText(textField_EGN.getText().substring(0, 9));
				    }
				
					 
			}
		});
		
		textField_EGN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{				
					radioButton_floor_1.requestFocus();
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex);
					
				}
			}
		});
		textField_EGN.setBackground(new Color(255, 204, 255));
		textField_EGN.setForeground(new Color(153, 0, 255));
		textField_EGN.setColumns(10);
		textField_EGN.setBounds(215, 140, 180, 20);
		contentPane.add(textField_EGN);
			
		JLabel lblEgn = new JLabel("\u0415\u0413\u041D :");
		lblEgn.setForeground(new Color(153, 0, 255));
		lblEgn.setBounds(90, 140, 90, 15);
		contentPane.add(lblEgn);
				
//PRICE
		final JLabel lbl_Price = new JLabel("");
		lbl_Price.setToolTipText("");
		lbl_Price.setBounds(189, 441, 46, 14);
		contentPane.add(lbl_Price);
		
		textField_TotalPrice = new JTextField();
		textField_TotalPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_TotalPrice.setEditable(false);
		textField_TotalPrice.setBackground(new Color(255, 204, 255));
		textField_TotalPrice.setForeground(new Color(153, 0, 255));
		textField_TotalPrice.setColumns(10);
		textField_TotalPrice.setBounds(90, 435, 46, 20);
		contentPane.add(textField_TotalPrice);

// ROOM NUMBER COMBO
		final JComboBox comboBox_RNumb = new JComboBox();
		comboBox_RNumb.setBackground(new Color(255, 204, 255));
		comboBox_RNumb.setForeground(new Color(153, 0, 255));
		comboBox_RNumb.setBounds(215, 230, 70, 20);
		contentPane.add(comboBox_RNumb);	
				
		JLabel lblRoomNumber = new JLabel("\u041D\u043E\u043C\u0435\u0440 \u043D\u0430 \u0441\u0442\u0430\u044F :");
		lblRoomNumber.setForeground(new Color(153, 0, 255));
		lblRoomNumber.setBounds(90, 230, 90, 15);
		contentPane.add(lblRoomNumber);
		
		
//ROOM TYPE RADIO BUTTONS
		
		//final JRadioButton radioButton_floor_1 = new JRadioButton("\u041F\u044A\u0440\u0432\u0438");
		final JRadioButton radioButton_floor_2 = new JRadioButton("\u0412\u0442\u043E\u0440\u0438");
		final JRadioButton radioButton_floor_3 = new JRadioButton("\u0422\u0440\u0435\u0442\u0438");
				
		final JRadioButton radioButton_roomType_1 = new JRadioButton("1 \u043B\u0435\u0433\u043B\u043E");
		radioButton_roomType_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_RNumb.requestFocus();
				
				comboBox_RNumb.removeAllItems();
				for(HotelRoomData hrd: listRooms){
				if(radioButton_roomType_1.isSelected()){
					
					if(radioButton_floor_1.isSelected()){
						if(hrd.getRoomType()==1 && hrd.getFloor()==1 && hrd.getRoomStatus()==true){
								comboBox_RNumb.addItem(hrd.getRoom());
								}
				    }else if(radioButton_floor_2.isSelected()){
				    	if(hrd.getRoomType()==1 && hrd.getFloor()==2 && hrd.getRoomStatus()==true){	
				    			comboBox_RNumb.addItem(hrd.getRoom());
								}
				    }else if(radioButton_floor_3.isSelected()){
				    	if(hrd.getRoomType()==1 && hrd.getFloor()==3 && hrd.getRoomStatus()==true){
				    			comboBox_RNumb.addItem(hrd.getRoom());
								}
			    	};
				
				}
				}	
						
			}
		});
		radioButton_roomType_1.setForeground(new Color(153, 0, 255));
		radioButton_roomType_1.setBackground(new Color(255, 153, 204));
		radioButton_roomType_1.setBounds(215, 200, 70, 20);
		contentPane.add(radioButton_roomType_1);
		
		final JRadioButton radioButton_roomType_2 = new JRadioButton("2 \u043B\u0435\u0433\u043B\u0430");
		radioButton_roomType_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_RNumb.requestFocus();
				
				comboBox_RNumb.removeAllItems();
				for(HotelRoomData hrd: listRooms){
				if(radioButton_roomType_2.isSelected()){
					
					if(radioButton_floor_1.isSelected()){
						if(hrd.getRoomType()==2 && hrd.getFloor()==1 && hrd.getRoomStatus()==true){
								comboBox_RNumb.addItem(hrd.getRoom());
								}
				    }else if(radioButton_floor_2.isSelected()){
				    	if(hrd.getRoomType()==2 && hrd.getFloor()==2 && hrd.getRoomStatus()==true){
								comboBox_RNumb.addItem(hrd.getRoom());
								}
				    }else if(radioButton_floor_3.isSelected()){
				    	if(hrd.getRoomType()==2 && hrd.getFloor()==3 && hrd.getRoomStatus()==true){
								comboBox_RNumb.addItem(hrd.getRoom());
								}
			    	};
				}
			}
			}
		});
		radioButton_roomType_2.setForeground(new Color(153, 0, 255));
		radioButton_roomType_2.setBackground(new Color(255, 153, 204));
		radioButton_roomType_2.setBounds(280, 200, 70, 20);
		contentPane.add(radioButton_roomType_2);
		
		final JRadioButton radioButton_roomType_flat = new JRadioButton("\u0410\u043F\u0430\u0440\u0442\u0430\u043C\u0435\u043D\u0442");
		radioButton_roomType_flat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_RNumb.requestFocus();
				
				comboBox_RNumb.removeAllItems();
				for(HotelRoomData hrd: listRooms){
				if(radioButton_roomType_flat.isSelected()){
					
					if(radioButton_floor_1.isSelected()){
						if(hrd.getRoomType()==3 && hrd.getFloor()==1 && hrd.getRoomStatus()==true){
								comboBox_RNumb.addItem(hrd.getRoom());
								}
				    }else if(radioButton_floor_2.isSelected()){
				    	if(hrd.getRoomType()==3 && hrd.getFloor()==2 && hrd.getRoomStatus()==true){
							comboBox_RNumb.addItem(hrd.getRoom());
							}
				    }else if(radioButton_floor_3.isSelected()){
				    	if(hrd.getRoomType()==3 && hrd.getFloor()==3 && hrd.getRoomStatus()==true){
							comboBox_RNumb.addItem(hrd.getRoom());
							}
			    	};
				}
				}
			}
		});
		radioButton_roomType_flat.setForeground(new Color(153, 0, 255));
		radioButton_roomType_flat.setBackground(new Color(255, 153, 204));
		radioButton_roomType_flat.setBounds(350, 200, 95, 20);
		contentPane.add(radioButton_roomType_flat);
		radioButton_roomType_flat.addFocusListener(new FocusListener(){
		    public void focusLost(FocusEvent e){
		    	radioButton_roomType_flat.setSelected(false);
		    	
		    	if (radioButton_roomType_flat.isSelected()){
		    		comboBox_RNumb.requestFocus();
		    	}else radioButton_roomType_1.requestFocus();	    	
		    }
		    public void focusGained(FocusEvent e){
		    	radioButton_roomType_flat.setSelected(false);  
		   }
		    
		});
	

		ButtonGroup groupRoomType = new ButtonGroup();
		groupRoomType.add(radioButton_roomType_1);
		groupRoomType.add(radioButton_roomType_2);
		groupRoomType.add(radioButton_roomType_flat);	
	
		JLabel lblRoomType = new JLabel("\u0422\u0438\u043F \u0441\u0442\u0430\u044F :");
		lblRoomType.setForeground(new Color(153, 0, 255));
		lblRoomType.setBounds(90, 200, 90, 15);
		contentPane.add(lblRoomType);
				
//FLOOR NUMBER RADIO BUTTONS	
	
		//final JRadioButton radioButton_floor_1 = new JRadioButton("\u041F\u044A\u0440\u0432\u0438");
		radioButton_floor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_roomType_1.requestFocus();
				
				comboBox_RNumb.removeAllItems();
				for(HotelRoomData hrd: listRooms){
				if(radioButton_floor_1.isSelected()){
					
					if(radioButton_roomType_1.isSelected()){
						if(hrd.getFloor()==1 && hrd.getRoomType()==1 && hrd.getRoomStatus()==true){
								comboBox_RNumb.addItem(hrd.getRoom());
								}
				    }else if(radioButton_roomType_2.isSelected()){
				    	if(hrd.getFloor()==1 && hrd.getRoomType()==2 && hrd.getRoomStatus()==true){
								comboBox_RNumb.addItem(hrd.getRoom());
								}
				    }else if(radioButton_roomType_flat.isSelected()){
				    	if(hrd.getFloor()==1 && hrd.getRoomType()==3 && hrd.getRoomStatus()==true){
								comboBox_RNumb.addItem(hrd.getRoom());
								}
			    	};
				}
				}
			}
		});
		radioButton_floor_1.setForeground(new Color(153, 0, 255));
		radioButton_floor_1.setBackground(new Color(255, 153, 204));
		radioButton_floor_1.setBounds(215, 170, 70, 20);
		contentPane.add(radioButton_floor_1);
		
		
		//final JRadioButton radioButton_floor_2 = new JRadioButton("\u0412\u0442\u043E\u0440\u0438");
		radioButton_floor_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_roomType_1.requestFocus();
				
				comboBox_RNumb.removeAllItems();
				for(HotelRoomData hrd: listRooms){
				if(radioButton_floor_2.isSelected()){
					
					if(radioButton_roomType_1.isSelected()){
						if(hrd.getFloor()==2 && hrd.getRoomType()==1 && hrd.getRoomStatus()==true){
								comboBox_RNumb.addItem(hrd.getRoom());
								}
				    }else if(radioButton_roomType_2.isSelected()){
				    	if(hrd.getFloor()==2 && hrd.getRoomType()==2 && hrd.getRoomStatus()==true){
							comboBox_RNumb.addItem(hrd.getRoom());
							}
				    }else if(radioButton_roomType_flat.isSelected()){
				    	if(hrd.getFloor()==2 && hrd.getRoomType()==3 && hrd.getRoomStatus()==true){
							comboBox_RNumb.addItem(hrd.getRoom());
							}
			    	};
				}
				}
			}
			
		});
		radioButton_floor_2.setForeground(new Color(153, 0, 255));
		radioButton_floor_2.setBackground(new Color(255, 153, 204));
		radioButton_floor_2.setBounds(280, 170, 70, 20);
		contentPane.add(radioButton_floor_2);

		
		//final JRadioButton radioButton_floor_3 = new JRadioButton("\u0422\u0440\u0435\u0442\u0438");
		radioButton_floor_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_roomType_1.requestFocus();
				
				comboBox_RNumb.removeAllItems();
				for(HotelRoomData hrd: listRooms){
				if(radioButton_floor_3.isSelected()){
					
					if(radioButton_roomType_1.isSelected()){
						if(hrd.getFloor()==3 && hrd.getRoomType()==1 && hrd.getRoomStatus()==true){
							//	comboBox_RNumb.removeAllItems();
								comboBox_RNumb.addItem(hrd.getRoom());
								}
				    }else if(radioButton_roomType_2.isSelected()){
				    	if(hrd.getFloor()==3 && hrd.getRoomType()==2 && hrd.getRoomStatus()==true){
				    		//comboBox_RNumb.removeAllItems();
							comboBox_RNumb.addItem(hrd.getRoom());
							}
				    }else if(radioButton_roomType_flat.isSelected()){
				    	if(hrd.getFloor()==3 && hrd.getRoomType()==3 && hrd.getRoomStatus()==true){
				    	//	comboBox_RNumb.removeAllItems();
							comboBox_RNumb.addItem(hrd.getRoom());
							}
			    	};
				}
				}
			}
		});
		radioButton_floor_3.setForeground(new Color(153, 0, 255));
		radioButton_floor_3.setBackground(new Color(255, 153, 204));
		radioButton_floor_3.setBounds(350, 170, 70, 20);
		contentPane.add(radioButton_floor_3);
		radioButton_floor_3.addFocusListener(new FocusListener(){
		    public void focusLost(FocusEvent e){
		    	radioButton_floor_3.setSelected(false);
		    	
		    	if (radioButton_floor_3.isSelected()){
		    		radioButton_roomType_1.requestFocus();
		    	}else radioButton_floor_1.requestFocus();	    	
		    }
		    public void focusGained(FocusEvent e){
		    	radioButton_floor_3.setSelected(false);  
		   }
		    
		});
	
		ButtonGroup groupFloor = new ButtonGroup();
		groupFloor.add(radioButton_floor_1);
		groupFloor.add(radioButton_floor_2);
		groupFloor.add(radioButton_floor_3);
	
		JLabel lblFloorNumber = new JLabel("\u041D\u043E\u043C\u0435\u0440 \u043D\u0430 \u0435\u0442\u0430\u0436 :");
		lblFloorNumber.setForeground(new Color(153, 0, 255));
		lblFloorNumber.setBounds(90, 170, 100, 15);
		contentPane.add(lblFloorNumber);

	

		
//definirane na kalendarite	
				
		final JCalendar calendar_Arriving = new JCalendar();
		final JCalendar calendar_Leaving = new JCalendar(); 
				
				
//CALENDAR 1			
		calendar_Arriving.addPropertyChangeListener("calendar",new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				final Calendar a = (Calendar) e.getNewValue(); 
				Date a1= a.getTime();
				long longDateA=a1.getTime()/(60*60*24*1000);
				long longDateL= calendar_Leaving.getDate().getTime()/(60*60*24*1000);
				long longRez= longDateA-longDateL;
				int days =(int)longRez;
				int intPrice=0;
				
				if(radioButton_roomType_1.isSelected()){
			    	intPrice= days*20;
			    	textField_TotalPrice.setText(Integer.toString(intPrice));
			    }else if(radioButton_roomType_2.isSelected()){
			    	intPrice= days*40;
			    	textField_TotalPrice.setText(Integer.toString(intPrice));
			    }else if(radioButton_roomType_flat.isSelected()){
			    	intPrice= days*50;
			    	textField_TotalPrice.setText(Integer.toString(intPrice));
		    	};
			}
			
		});
		calendar_Arriving.setSundayForeground(new Color(0, 0, 0));
		calendar_Arriving.setWeekdayForeground(new Color(102, 0, 255));
		calendar_Arriving.setDecorationBackgroundColor(new Color(255, 204, 255));
		calendar_Arriving.getYearChooser().getSpinner().setForeground(new Color(255, 204, 255));
		calendar_Arriving.getMonthChooser().getComboBox().setForeground(new Color(153, 0, 204));
		calendar_Arriving.getYearChooser().getSpinner().setBackground(new Color(255, 204, 255));
		calendar_Arriving.getMonthChooser().getComboBox().setBackground(new Color(255, 204, 255));
		calendar_Arriving.setForeground(new Color(153, 0, 204));
		calendar_Arriving.getDayChooser().setWeekOfYearVisible(false);
		calendar_Arriving.getDayChooser().getDayPanel().setBackground(new Color(255, 153, 204));
		calendar_Arriving.setBounds(90, 290, 155, 153);
		contentPane.add(calendar_Arriving);
			
		JLabel label_DateArriving = new JLabel("\u0414\u0430\u0442\u0430 \u043D\u0430 \u043F\u0440\u0438\u0441\u0442\u0438\u0433\u0430\u043D\u0435 :");
		label_DateArriving.setForeground(new Color(153, 0, 255));
		label_DateArriving.setBounds(90, 270, 155, 15);
		contentPane.add(label_DateArriving);
					
//CALENDAR 2
				
		//final JCalendar calendar_Leaving = new JCalendar();
		calendar_Leaving.addPropertyChangeListener("calendar",new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				final Calendar l = (Calendar) e.getNewValue() ; 
					long longRez= ( calendar_Leaving.getDate().getTime()/(60*60*24*1000)- calendar_Arriving.getDate().getTime()/(60*60*24*1000));
					int days =(int)longRez;
					int intPrice=0;
												
					if(radioButton_roomType_1.isSelected()){
					   	intPrice= days*20;
					   	textField_TotalPrice.setText(Integer.toString(intPrice));
					   }else if(radioButton_roomType_2.isSelected()){
					   	intPrice= days*40;
					   	textField_TotalPrice.setText(Integer.toString(intPrice));
					   }else if(radioButton_roomType_flat.isSelected()){
					   	intPrice= days*50;
					   	textField_TotalPrice.setText(Integer.toString(intPrice));
					};
				 		
			}
		});
		calendar_Leaving.getDayChooser().getDayPanel().setBackground(new Color(255, 153, 204));
		calendar_Leaving.getDayChooser().setWeekOfYearVisible(false);
		calendar_Leaving.getYearChooser().getSpinner().setForeground(new Color(255, 204, 255));
		calendar_Leaving.getYearChooser().getSpinner().setBackground(new Color(255, 204, 255));
		calendar_Leaving.getMonthChooser().getComboBox().setForeground(new Color(153, 0, 204));
		calendar_Leaving.getMonthChooser().getComboBox().setBackground(new Color(255, 204, 255));
		calendar_Leaving.setWeekdayForeground(new Color(102, 0, 255));
		calendar_Leaving.setSundayForeground(Color.BLACK);
		calendar_Leaving.setForeground(new Color(153, 0, 204));
		calendar_Leaving.setDecorationBackgroundColor(new Color(255, 204, 255));
		calendar_Leaving.setBounds(254, 290, 155, 153);
		contentPane.add(calendar_Leaving);
		
		JLabel label_DateLeaving = new JLabel("\u0414\u0430\u0442\u0430 \u043D\u0430 \u043D\u0430\u043F\u0443\u0441\u043A\u0430\u043D\u0435 :");
		label_DateLeaving.setForeground(new Color(153, 0, 255));
		label_DateLeaving.setBounds(254, 270, 155, 15);
		contentPane.add(label_DateLeaving);
				

		
//CURENT DATE
								
		JTextField textField_toDayDate = new JTextField();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"+"г.");
		textField_toDayDate.setText(sdf.format(d));
		textField_toDayDate.setEditable(false);
		textField_toDayDate.setBackground(new Color(255, 204, 255));
		textField_toDayDate.setForeground(new Color(153, 0, 255));
		textField_toDayDate.setColumns(10);
		textField_toDayDate.setBounds(452, 49, 80, 22);
		contentPane.add(textField_toDayDate);
								
		JLabel lblDate = new JLabel("\u0422\u0435\u043A\u0443\u0449\u0430 \u0434\u0430\u0442\u0430 :");
		lblDate.setForeground(new Color(153, 0, 255));
		lblDate.setBounds(452, 24, 80, 14);
		contentPane.add(lblDate);
			
	
//BUTTONS 		
		
	//SAVE
		JButton btnSave = new JButton("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u0430\u043D\u0435");
		btnSave.setToolTipText("\u0414\u043E\u0431\u0430\u0432\u0438 \u0433\u043E\u0441\u0442 \u0432 \u0445\u043E\u0442\u0435\u043B\u0430");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	    			
	    	try {
	    	java.sql.Date dateA = new java.sql.Date(calendar_Arriving.getDate().getTime());
	  	    java.sql.Date dateL = new java.sql.Date(calendar_Leaving.getDate().getTime());
	  	    long longL= (calendar_Leaving.getDate().getTime()/(60*60*24*1000));
	  	    long longA=(calendar_Arriving.getDate().getTime()/(60*60*24*1000));
	  	    long longT=(System.currentTimeMillis()/(60*60*24*1000));
	  	    			
	  	    if(longA==longL){
	  	    	JOptionPane.showMessageDialog(null, "Регистрацията трябва да обхваща поне една нощувка!");
	  	    }
	  	    if(longA<longT || longL<longT){
	  			JOptionPane.showMessageDialog(null, "Не може да се прави регистрация със задна дата!");			
	  		}
	  		if(longA>longL){
	  		  JOptionPane.showMessageDialog(null, "Датата на напускане не може да е преди датата на пристигане!");
	  		}
	  		if(longA<longL && longA>=longT && longT<longL){    		
	    		HotelGuestData OB = new HotelGuestData(); 
                boolean flag2= true;
                
                if(radioButton_floor_1.isSelected()){
				 	OB.setFloor(1);
				}else if(radioButton_floor_2.isSelected()){
				    OB.setFloor(2);
				}else if(radioButton_floor_3.isSelected()){
				    OB.setFloor(3);
			    }else flag2=false;
			  
                if(comboBox_RNumb.getSelectedItem()== null ){
			    	flag2=false;
			    }else if(comboBox_RNumb.getSelectedItem()!= null){ 
			    	OB.setRoom(Integer.parseInt(comboBox_RNumb.getSelectedItem().toString()));
			   	}
			  
			   if(radioButton_roomType_1.isSelected()){
			        OB.setRoomType(1);
			   }else if(radioButton_roomType_2.isSelected()){
				   	OB.setRoomType(2);
			   }else if(radioButton_roomType_flat.isSelected()){
				  	OB.setRoomType(3);
			   }else flag2=false;
			    	
			   OB.setRoomStatus(false);
			    
			   if(textField_FirstName.getText().equals("")){
				   flag2=false;
	    	   }else if(!textField_FirstName.getText().equals("")){
	    		   OB.setFirstName(textField_FirstName.getText());
	    	   }
	    		
	    		if(textField_SecondName.getText().equals("")){
	    			flag2=false;
	    		}else if (!textField_SecondName.getText().equals("")){
	    			OB.setSecondName(textField_SecondName.getText());
	    		}
	    			
	    		if(textField_LastName.getText().equals("")){
	    			flag2=false;
	    		}else if (!textField_LastName.getText().equals("")){
	    			OB.setLastName(textField_LastName.getText());
	    		}
	    			    			
	    		if(textField_EGN.getText().equals("")){
	    			flag2=false;
	    		}else if (!textField_EGN.getText().equals("")){
	    			OB.setEGN(textField_EGN.getText());
	    		}
	    		
	    		OB.setDateArriving(dateA);
		    	OB.setDateLeaving(dateL);
	    			
	    		if(textField_TotalPrice.getText().equals("")){
	    			flag2=false;
	    		}else if (!textField_TotalPrice.getText().toString().equals("")){
	    			OB.setPrice(Integer.parseInt(textField_TotalPrice.getText().toString()));
	    		}
	    		
	    		if(flag2==false){
	    			//System.out.println("nepylni danni");
	    			JOptionPane.showMessageDialog(null, "Моля попълнете всички полета!");
	    		}else if (flag2==true){ 
	    			//System.out.println("pvavilni danni");
	    			JOptionPane.showMessageDialog(null, "Успешна регистрация");
	    			OB.AddGuestsToFile(OB);
	    			for(HotelRoomData hrd: listRooms){
	    				if(OB.getRoom()==hrd.getRoom()){
	    					hrd.setRoomStatus(false);
	    					HotelFailData.writeRoomToFile(listRooms);
	    				}
	    				
	    			}dispose();
	    			SwingAdd a = new SwingAdd();
	    			a.setVisible(true);
	    		}	
	    	}
	    			
	    	}catch (Throwable any) {
	                System.out.println("Java ERROR: "+any);
	                any.printStackTrace();
	                
	    	}
		}
		});
				
		btnSave.setForeground(new Color(153, 0, 255));
		btnSave.setBackground(UIManager.getColor("Button.background"));
		btnSave.setBounds(413, 354, 119, 25);
		contentPane.add(btnSave);
		
	//CLEAR
		JButton btnClear = new JButton("\u0418\u0437\u0447\u0438\u0441\u0442\u0438");
		btnClear.setToolTipText("\u0418\u0437\u0447\u0438\u0441\u0442\u0438 \u0432\u0441\u0438\u0447\u043A\u0438 \u043F\u043E\u043B\u0435\u0442\u0430");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				SwingAdd a = new SwingAdd();
				a.setVisible(true);
			}
		});
		btnClear.setForeground(new Color(153, 0, 255));
		btnClear.setBackground(UIManager.getColor("Button.background"));
		btnClear.setBounds(413, 384, 119, 25);
		contentPane.add(btnClear);
		
	//BACK
		JButton btnBack = new JButton("\u041D\u0430\u0437\u0430\u0434");
		btnBack.setToolTipText("\u041A\u044A\u043C \u043F\u044A\u0440\u0432\u043E\u043D\u0430\u0447\u0430\u043B\u043D\u0438\u044F \u043F\u0440\u043E\u0437\u043E\u0440\u0435\u0446 \u043D\u0430 \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u0430\u0442\u0430");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SwingHotel h = new SwingHotel();
				h.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(153, 0, 255));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(413, 414, 119, 25);
		contentPane.add(btnBack);
	
//Picture
		
		JLabel textField_tribal = new JLabel("");
		textField_tribal.setBackground(new Color(255, 204, 255));
		textField_tribal.setIcon(new ImageIcon("D:\\JAVA\\JavaHotel\\celtic-corner-dark-grey-md.png"));
		textField_tribal.setBounds(0, 0, 300, 282);
		contentPane.add(textField_tribal);
		
		JLabel lblTotalPrice = new JLabel("\u0426\u0435\u043D\u0430 :");
		lblTotalPrice.setForeground(new Color(153, 0, 255));
		lblTotalPrice.setBounds(40, 440, 40, 15);
		contentPane.add(lblTotalPrice);
		
		
		
	}
}
