import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class SwingRemove extends JFrame {

	private JPanel contentPane;
	private JTextField textField_CurentDate;
	private JTextField textField_FirstName;
	private JTextField textField_SecondName;
	private JTextField textField_LastName;
	private JTextField textField_EGN;
	private JTextField textField_DateLeaving;
	private JTextField textField_Price;
	private JTextField textField_ÎverdueDays;
	private JTextField textFieldl_OverduePrice;
	private JTextField textField_TotalPrice;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingRemove frame = new SwingRemove();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private ArrayList <HotelRoomData> listRooms = HotelFailData.readRoomsFromFile();
	private ArrayList <HotelGuestData> listGuests= HotelFailData.readGuestsFromFile();
	
	public SwingRemove() {
		setResizable(false);
		setTitle("\u041E\u0442\u043F\u0438\u0441\u0432\u0430\u043D\u0435");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setToolTipText("\u041E\u0442\u043F\u0438\u0441\u0432\u0430\u043D\u0435");
		contentPane.setForeground(new Color(153, 0, 255));
		contentPane.setBackground(new Color(255, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_FirstName = new JLabel("\u0418\u043C\u0435:");
		label_FirstName.setForeground(new Color(153, 0, 255));
		label_FirstName.setBounds(80, 166, 90, 15);
		contentPane.add(label_FirstName);
		
		JLabel label_SecondName = new JLabel("\u041F\u0440\u0435\u0437\u0438\u043C\u0435:");
		label_SecondName.setForeground(new Color(153, 0, 255));
		label_SecondName.setBounds(80, 196, 90, 15);
		contentPane.add(label_SecondName);
		
		JLabel label_LastName = new JLabel("\u0424\u0430\u043C\u0438\u043B\u0438\u044F:");
		label_LastName.setForeground(new Color(153, 0, 255));
		label_LastName.setBounds(80, 226, 90, 15);
		contentPane.add(label_LastName);
		
		JLabel lbl_RoomNumb = new JLabel("\u0418\u0437\u0431\u0435\u0440\u0435\u0442\u0435 \u043D\u043E\u043C\u0435\u0440 \u043D\u0430 \u0441\u0442\u0430\u044F :");
		lbl_RoomNumb.setForeground(new Color(153, 0, 255));
		lbl_RoomNumb.setBounds(80, 70, 151, 15);
		contentPane.add(lbl_RoomNumb);
		
		JLabel lbl_Picture = new JLabel("h");
		lbl_Picture.setToolTipText("");
		lbl_Picture.setIcon(new ImageIcon("D:\\JAVA\\JavaHotel\\celtic-corner-dark-grey-md.png"));
		lbl_Picture.setBounds(0, 0, 300, 282);
		contentPane.add(lbl_Picture);
		
		JLabel label_DateLeaving = new JLabel("\u0414\u0430\u0442\u0430 \u043D\u0430 \u043D\u0430\u043F\u0443\u0441\u043A\u0430\u043D\u0435:");
		label_DateLeaving.setForeground(new Color(153, 0, 255));
		label_DateLeaving.setBounds(80, 286, 120, 15);
		contentPane.add(label_DateLeaving);
		
		JLabel label_Price = new JLabel("\u0414\u044A\u043B\u0436\u0438\u043C\u0430 \u0421\u0443\u043C\u0430:");
		label_Price.setForeground(new Color(153, 0, 255));
		label_Price.setBounds(80, 346, 120, 15);
		contentPane.add(label_Price);
		
		JLabel label_OverduePrice = new JLabel("\u041D\u0435\u0443\u0441\u0442\u043E\u0439\u043A\u0430 \u0437\u0430 \u043F\u0440\u0435\u0441\u0440\u043E\u0447\u0435\u043D\u043E\u0442\u043E \u0432\u0440\u0435\u043C\u0435:");
		label_OverduePrice.setForeground(new Color(153, 0, 255));
		label_OverduePrice.setBounds(80, 376, 208, 15);
		contentPane.add(label_OverduePrice);
		
		JLabel label_TotalPrice = new JLabel("\u041E\u0431\u0449\u0430 \u0441\u0443\u043C\u0430 \u0437\u0430 \u043F\u043B\u0430\u0449\u0430\u043D\u0435:");
		label_TotalPrice.setForeground(new Color(153, 0, 255));
		label_TotalPrice.setBounds(80, 406, 137, 15);
		contentPane.add(label_TotalPrice);
		
		textField_CurentDate = new JTextField();
		java.util.Date d = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"+"ã.");
		textField_CurentDate.setText(sdf.format(d));
		textField_CurentDate.setForeground(new Color(153, 0, 255));
		textField_CurentDate.setEditable(false);
		textField_CurentDate.setColumns(10);
		textField_CurentDate.setBackground(new Color(255, 204, 255));
		textField_CurentDate.setBounds(440, 42, 80, 22);
		contentPane.add(textField_CurentDate);
		
		JLabel label_CurentDate = new JLabel("\u0422\u0435\u043A\u0443\u0449\u0430 \u0434\u0430\u0442\u0430 :");
		label_CurentDate.setForeground(new Color(153, 0, 255));
		label_CurentDate.setBounds(440, 17, 80, 14);
		contentPane.add(label_CurentDate);
		
		JLabel label_ÎverdueDays = new JLabel("\u0411\u0440\u043E\u0439 \u043F\u0440\u0435\u0441\u0440\u043E\u0447\u0435\u043D\u0438 \u0434\u043D\u0438:");
		label_ÎverdueDays.setForeground(new Color(153, 0, 255));
		label_ÎverdueDays.setBounds(80, 316, 137, 15);
		contentPane.add(label_ÎverdueDays);
		
		JLabel label_EGN = new JLabel("\u0415\u0413\u041D:");
		label_EGN.setForeground(new Color(153, 0, 255));
		label_EGN.setBounds(80, 256, 90, 15);
		contentPane.add(label_EGN);
	
		JLabel label_data = new JLabel("\u0414\u0430\u043D\u043D\u0438 \u043D\u0430 \u043A\u043B\u0438\u0435\u043D\u0442\u0430, \u043E\u0442\u0441\u0435\u0434\u043D\u0430\u043B \u0432 \u0438\u0437\u0431\u0440\u0430\u043D\u0430\u0442\u0430 \u0441\u0442\u0430\u044F :");
		label_data.setForeground(new Color(153, 0, 255));
		label_data.setBounds(80, 123, 319, 15);
		contentPane.add(label_data);
		
		textField_FirstName = new JTextField();
		textField_FirstName.setForeground(new Color(153, 0, 255));
		textField_FirstName.setEditable(false);
		textField_FirstName.setColumns(10);
		textField_FirstName.setBackground(new Color(255, 204, 255));
		textField_FirstName.setBounds(250, 166, 149, 20);
		contentPane.add(textField_FirstName);
		
		textField_SecondName = new JTextField();
		textField_SecondName.setForeground(new Color(153, 0, 255));
		textField_SecondName.setEditable(false);
		textField_SecondName.setColumns(10);
		textField_SecondName.setBackground(new Color(255, 204, 255));
		textField_SecondName.setBounds(250, 196, 149, 20);
		contentPane.add(textField_SecondName);
		
		textField_LastName = new JTextField();
		textField_LastName.setForeground(new Color(153, 0, 255));
		textField_LastName.setEditable(false);
		textField_LastName.setColumns(10);
		textField_LastName.setBackground(new Color(255, 204, 255));
		textField_LastName.setBounds(250, 226, 149, 20);
		contentPane.add(textField_LastName);
		
		textField_EGN = new JTextField();
		textField_EGN.setForeground(new Color(153, 0, 255));
		textField_EGN.setEditable(false);
		textField_EGN.setColumns(10);
		textField_EGN.setBackground(new Color(255, 204, 255));
		textField_EGN.setBounds(250, 256, 149, 20);
		contentPane.add(textField_EGN);
		
		textField_DateLeaving = new JTextField();
		textField_DateLeaving.setForeground(new Color(153, 0, 255));
		textField_DateLeaving.setEditable(false);
		textField_DateLeaving.setColumns(10);
		textField_DateLeaving.setBackground(new Color(255, 204, 255));
		textField_DateLeaving.setBounds(250, 286, 149, 20);
		contentPane.add(textField_DateLeaving);
		
		textField_Price = new JTextField();
		textField_Price.setForeground(new Color(153, 0, 255));
		textField_Price.setEditable(false);
		textField_Price.setColumns(10);
		textField_Price.setBackground(new Color(255, 204, 255));
		textField_Price.setBounds(330, 346, 72, 20);
		contentPane.add(textField_Price);
		
		textField_ÎverdueDays = new JTextField();
		textField_ÎverdueDays.setForeground(new Color(153, 0, 255));
		textField_ÎverdueDays.setEditable(false);
		textField_ÎverdueDays.setColumns(10);
		textField_ÎverdueDays.setBackground(new Color(255, 204, 255));
		textField_ÎverdueDays.setBounds(250, 316, 149, 20);
		contentPane.add(textField_ÎverdueDays);
		
		textFieldl_OverduePrice = new JTextField();
		textFieldl_OverduePrice.setForeground(new Color(153, 0, 255));
		textFieldl_OverduePrice.setEditable(false);
		textFieldl_OverduePrice.setColumns(10);
		textFieldl_OverduePrice.setBackground(new Color(255, 204, 255));
		textFieldl_OverduePrice.setBounds(330, 376, 72, 20);
		contentPane.add(textFieldl_OverduePrice);
		
		textField_TotalPrice = new JTextField();
		textField_TotalPrice.setForeground(new Color(153, 0, 255));
		textField_TotalPrice.setEditable(false);
		textField_TotalPrice.setColumns(10);
		textField_TotalPrice.setBackground(new Color(255, 204, 255));
		textField_TotalPrice.setBounds(330, 406, 72, 20);
		contentPane.add(textField_TotalPrice);
		
	
		
//COMBO		
		
		final JComboBox comboBox_RNumb = new JComboBox();
		comboBox_RNumb.setModel(new DefaultComboBoxModel(new String[] {"______"}));
		comboBox_RNumb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try{
				if(comboBox_RNumb.getSelectedItem().toString().equals("______")){
					JOptionPane.showMessageDialog(null, "Ìîëÿ èçáåðåòå íîìåð íà ñòàÿ");
				}
			for(HotelGuestData hgd:listGuests){
				if(Integer.parseInt(String.valueOf(comboBox_RNumb.getSelectedItem()))==hgd.getRoom()){
					textField_FirstName.setText(hgd.getFirstName().toString());
					textField_SecondName.setText(hgd.getSecondName());
					textField_LastName.setText(hgd.getLastName());
					textField_EGN.setText(hgd.getEGN());
					textField_DateLeaving.setText(hgd.getDateLeaving().toString());
					textField_Price.setText(String.valueOf(hgd.getPrice()) );
					
					int price = hgd.getPrice();
					java.util.Date toDay= new java.util.Date();toDay.setSeconds(0);toDay.setMinutes(0);toDay.setHours(0);
					java.sql.Date LeavingDay=hgd.getDateLeaving();
							
					if(LeavingDay.before(toDay)){
						long dif =((toDay.getTime()/(60*60*24*1000)) - (LeavingDay.getTime()/(60*60*24*1000)));
						int days =(int)dif;
						int OPrice = days*50;
						int TPrice = price+OPrice;
								
						if(days==0){
							textField_ÎverdueDays.setText("Íÿìà, äàòàòà ñúâïàäà");
							textFieldl_OverduePrice.setText("0");
							textField_TotalPrice.setText(String.valueOf(price));
						}else if(days>0){
							textField_ÎverdueDays.setText(String.valueOf(days));
							textFieldl_OverduePrice.setText(String.valueOf(OPrice));
							textField_TotalPrice.setText(String.valueOf(TPrice));
						}
						
					}else if (LeavingDay.after(toDay)){
							textField_ÎverdueDays.setText("Ãîñòúò íàïóñêà ïî-ðàíî");
							textFieldl_OverduePrice.setText("0");
							textField_TotalPrice.setText(String.valueOf(price));
							}
				}
			}
					
			}catch(java.lang.NumberFormatException e){
							
			}
		}
		});
		comboBox_RNumb.setForeground(new Color(153, 0, 255));
		comboBox_RNumb.setBackground(new Color(255, 204, 255));
		comboBox_RNumb.setBounds(250, 70, 70, 20);
		contentPane.add(comboBox_RNumb);
				
		for(HotelRoomData hrd: listRooms){
			if(hrd.getRoomStatus()==false){
				comboBox_RNumb.addItem(hrd.getRoom());
			}
		}
		
//REMOVE		
		JButton btnRemove = new JButton("\u041E\u0442\u043F\u0438\u0441\u0432\u0430\u043D\u0435");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				try{
					for(HotelRoomData hrd: listRooms){
						if(hrd.getRoom()==Integer.parseInt(comboBox_RNumb.getSelectedItem().toString())){
							hrd.setRoomStatus(true);
							HotelFailData.writeRoomToFile(listRooms);
						}
					}
					for(HotelGuestData hgd: listGuests){
						if(hgd.getRoom()==Integer.parseInt(comboBox_RNumb.getSelectedItem().toString())){
							listGuests.remove(hgd);
							HotelFailData.writeGuestsToFile(listGuests);
						}
					}
				 }catch(ConcurrentModificationException ex){
				 }catch(java.lang.NumberFormatException r){
				 }
				JOptionPane.showMessageDialog(null, "Óñïåøíî îòïèñâàíå");
				dispose();
				SwingRemove r = new SwingRemove();
				r.setVisible(true);				
			}	
		});
		btnRemove.setToolTipText("\u041F\u0440\u0435\u043C\u0430\u0445\u0432\u0430\u043D\u0435 \u043D\u0430 \u0433\u043E\u0441\u0442 \u043E\u0442 \u0441\u0438\u0441\u0442\u0435\u043C\u0430\u0442\u0430");
		btnRemove.setForeground(new Color(153, 0, 255));
		btnRemove.setBackground(UIManager.getColor("Button.background"));
		btnRemove.setBounds(412, 355, 118, 25);
		contentPane.add(btnRemove);
				
//CLEAR	
		JButton button_Clear = new JButton("\u0418\u0437\u0447\u0438\u0441\u0442\u0438");
		button_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				SwingRemove r = new SwingRemove();
				r.setVisible(true);
			}
		});
		button_Clear.setToolTipText("\u0418\u0437\u0447\u0438\u0441\u0442\u0432\u0430\u043D\u0435 \u043D\u0430 \u0432\u0441\u0438\u0447\u043A\u0438 \u043F\u043E\u043B\u0435\u0442\u0430");
		button_Clear.setForeground(new Color(153, 0, 255));
		button_Clear.setBackground(UIManager.getColor("Button.background"));
		button_Clear.setBounds(412, 385, 118, 25);
		contentPane.add(button_Clear);
			
//BACK		
		JButton button_Back = new JButton("\u041D\u0430\u0437\u0430\u0434");
		button_Back.setToolTipText("\u041A\u044A\u043C \u043F\u044A\u0440\u0432\u043E\u043D\u0430\u0447\u0430\u043B\u043D\u0438\u044F \u043F\u0440\u043E\u0437\u043E\u0440\u0435\u0446 \u043D\u0430 \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u0430\u0442\u0430");
		button_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SwingHotel h = new SwingHotel();
				h.setVisible(true);
			}
		});
		button_Back.setForeground(new Color(153, 0, 255));
		button_Back.setBackground(UIManager.getColor("Button.background"));
		button_Back.setBounds(412, 415, 118, 25);
		contentPane.add(button_Back);			
		}
}
