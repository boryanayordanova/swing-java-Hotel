import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class SwingQuery extends JFrame  {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingQuery frame = new SwingQuery();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ArrayList <HotelRoomData> listRooms = HotelFailData.readRoomsFromFile();
	private ArrayList <HotelGuestData> listGuests= HotelFailData.readGuestsFromFile();
	
	public SwingQuery() {
		setResizable(false);
		setTitle("\u0421\u043F\u0440\u0430\u0432\u043A\u0438");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setToolTipText("\u0421\u043F\u0440\u0430\u0432\u043A\u0438");
		contentPane.setBackground(new Color(255, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\JAVA\\JavaHotel\\celtic-corner-dark-grey-md.png"));
		lblNewLabel.setBounds(0, 0, 350, 282);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(90, 70, 115, 23);
		contentPane.add(menuBar);
		menuBar.setBackground(new Color(255, 204, 255));
		
		final JMenu mnNewMenu = new JMenu("\u0418\u0437\u0431\u0435\u0440\u0435\u0442\u0435 \u0441\u043F\u0440\u0430\u0432\u043A\u0430");
		menuBar.add(mnNewMenu);
		mnNewMenu.setForeground(new Color(153, 0, 255));
		mnNewMenu.setBackground(new Color(255, 204, 255));
		
		
		
		JMenuItem MenuItem_AllFreeRooms = new JMenuItem("\u0412\u0441\u0438\u0447\u043A\u0438 \u0421\u0432\u043E\u0431\u043E\u0434\u043D\u0438 \u0441\u0442\u0430\u0438 \u0432 \u0445\u043E\u0442\u0435\u043B\u0430");
		MenuItem_AllFreeRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0421\u0432\u043E\u0431\u043E\u0434\u043D\u0438 \u0441\u0442\u0430\u0438 \u0432 \u0445\u043E\u0442\u0435\u043B\u0430");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Тип", "Етаж"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==true){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getRoomType()),String.valueOf(hrd.getFloor())});
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
				 
			}
		});
		
		MenuItem_AllFreeRooms.setForeground(new Color(153, 0, 255));
		MenuItem_AllFreeRooms.setBackground(new Color(255, 228, 225));
		mnNewMenu.add(MenuItem_AllFreeRooms);
		
		JMenu Menu_AllFreeRoomsFloor = new JMenu("\u0412\u0441\u0438\u0447\u043A\u0438 \u0421\u0432\u043E\u0431\u043E\u0434\u043D\u0438 \u0441\u0442\u0430\u0438 \u043D\u0430 \u0435\u0442\u0430\u0436 \u043D\u043E\u043C\u0435\u0440");
		Menu_AllFreeRoomsFloor.setForeground(new Color(153, 0, 255));
		Menu_AllFreeRoomsFloor.setBackground(new Color(255, 228, 225));
		mnNewMenu.add(Menu_AllFreeRoomsFloor);
		
		JMenuItem MenuItem_FreeRoomsFloor1 = new JMenuItem("1");
		MenuItem_FreeRoomsFloor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0421\u0432\u043E\u0431\u043E\u0434\u043D\u0438 \u0441\u0442\u0430\u0438 \u043D\u0430 \u0435\u0442\u0430\u0436 \u043D\u043E\u043C\u0435\u0440 1");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Тип"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==true && hrd.getFloor()==1){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getRoomType())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
		});
		MenuItem_FreeRoomsFloor1.setForeground(new Color(153, 0, 255));
		MenuItem_FreeRoomsFloor1.setBackground(new Color(255, 228, 225));
		Menu_AllFreeRoomsFloor.add(MenuItem_FreeRoomsFloor1);
		
		JMenuItem MenuItem_FreeRoomsFloor2 = new JMenuItem("2");
		MenuItem_FreeRoomsFloor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0421\u0432\u043E\u0431\u043E\u0434\u043D\u0438 \u0441\u0442\u0430\u0438 \u043D\u0430 \u0435\u0442\u0430\u0436 \u043D\u043E\u043C\u0435\u0440 2");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Тип"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==true && hrd.getFloor()==2){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getRoomType())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);		
			}
		});
		MenuItem_FreeRoomsFloor2.setForeground(new Color(153, 0, 255));
		MenuItem_FreeRoomsFloor2.setBackground(new Color(255, 228, 225));
		Menu_AllFreeRoomsFloor.add(MenuItem_FreeRoomsFloor2);
		
		JMenuItem MenuItem_FreeRoomsFloor3 = new JMenuItem("3");
		MenuItem_FreeRoomsFloor3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0421\u0432\u043E\u0431\u043E\u0434\u043D\u0438 \u0441\u0442\u0430\u0438 \u043D\u0430 \u0435\u0442\u0430\u0436 \u043D\u043E\u043C\u0435\u0440 3");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Тип"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==true && hrd.getFloor()==3){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getRoomType())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);	
			}
		});
		MenuItem_FreeRoomsFloor3.setForeground(new Color(153, 0, 255));
		MenuItem_FreeRoomsFloor3.setBackground(new Color(255, 228, 225));
		Menu_AllFreeRoomsFloor.add(MenuItem_FreeRoomsFloor3);
		
		JMenu Menu_AllFreeRoomsType = new JMenu("\u0412\u0441\u0438\u0447\u043A\u0438 \u0421\u0432\u043E\u0431\u043E\u0434\u043D\u0438 \u0441\u0442\u0430\u0438 \u043E\u0442 \u0442\u0438\u043F:");
		Menu_AllFreeRoomsType.setForeground(new Color(153, 0, 255));
		Menu_AllFreeRoomsType.setBackground(new Color(255, 228, 225));
		mnNewMenu.add(Menu_AllFreeRoomsType);
		
		JMenuItem MenuItem_FreeRoomsType1 = new JMenuItem("1 \u043B\u0435\u0433\u043B\u043E");
		MenuItem_FreeRoomsType1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0421\u0432\u043E\u0431\u043E\u0434\u043D\u0438 \u0441\u0442\u0430\u0438 \u043E\u0442 \u0442\u0438\u043F: 1");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Етаж"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				 for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==true && hrd.getRoomType()==1){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getFloor())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
		});
		MenuItem_FreeRoomsType1.setForeground(new Color(153, 0, 255));
		MenuItem_FreeRoomsType1.setBackground(new Color(255, 228, 225));
		Menu_AllFreeRoomsType.add(MenuItem_FreeRoomsType1);
		
		JMenuItem MenuItem_FreeRoomsType2 = new JMenuItem("2 \u043B\u0435\u0433\u043B\u0430");
		MenuItem_FreeRoomsType2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0421\u0432\u043E\u0431\u043E\u0434\u043D\u0438 \u0441\u0442\u0430\u0438 \u043E\u0442 \u0442\u0438\u043F: 2");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Етаж"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==true && hrd.getRoomType()==2){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getFloor())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);	
			}
		});
		MenuItem_FreeRoomsType2.setForeground(new Color(153, 0, 255));
		MenuItem_FreeRoomsType2.setBackground(new Color(255, 228, 225));
		Menu_AllFreeRoomsType.add(MenuItem_FreeRoomsType2);
		
		JMenuItem MenuItem_FreeRoomsType3 = new JMenuItem("\u0410\u043F\u0430\u0440\u0442\u0430\u043C\u0435\u043D\u0442");
		MenuItem_FreeRoomsType3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0421\u0432\u043E\u0431\u043E\u0434\u043D\u0438 \u0441\u0442\u0430\u0438 \u043E\u0442 \u0442\u0438\u043F: 3");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Етаж"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==true && hrd.getRoomType()==3){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getFloor())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);	
			}
		});
		MenuItem_FreeRoomsType3.setForeground(new Color(153, 0, 255));
		MenuItem_FreeRoomsType3.setBackground(new Color(255, 228, 225));
		Menu_AllFreeRoomsType.add(MenuItem_FreeRoomsType3);
		
		JMenuItem MenuItem_AllTakenRooms = new JMenuItem("\u0412\u0441\u0438\u0447\u043A\u0438 \u0417\u0430\u0435\u0442\u0438 \u0441\u0442\u0430\u0438 \u0432 \u0445\u043E\u0442\u0435\u043B\u0430");
		MenuItem_AllTakenRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0417\u0430\u0435\u0442\u0438 \u0441\u0442\u0430\u0438 \u0432 \u0445\u043E\u0442\u0435\u043B\u0430");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер","Тип","Етаж"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==false){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getRoomType()),String.valueOf(hrd.getFloor())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);	
			}
		});
		MenuItem_AllTakenRooms.setForeground(new Color(153, 0, 255));
		MenuItem_AllTakenRooms.setBackground(new Color(255, 228, 225));
		mnNewMenu.add(MenuItem_AllTakenRooms);
		
		JMenu Menu_AllTakenRoomsFloor = new JMenu("\u0412\u0441\u0438\u0447\u043A\u0438 \u0417\u0430\u0435\u0442\u0438 \u0441\u0442\u0430\u0438 \u043D\u0430 \u0435\u0442\u0430\u0436 \u043D\u043E\u043C\u0435\u0440");
		Menu_AllTakenRoomsFloor.setForeground(new Color(153, 0, 255));
		Menu_AllTakenRoomsFloor.setBackground(new Color(255, 228, 225));
		mnNewMenu.add(Menu_AllTakenRoomsFloor);
		
		JMenuItem MenuItem_TakenRoomsFloor1 = new JMenuItem("1");
		MenuItem_TakenRoomsFloor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0417\u0430\u0435\u0442\u0438 \u0441\u0442\u0430\u0438 \u043D\u0430 \u0435\u0442\u0430\u0436 \u043D\u043E\u043C\u0435\u0440 1");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Тип"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==false && hrd.getFloor()==1){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getRoomType())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
		});
		MenuItem_TakenRoomsFloor1.setForeground(new Color(153, 0, 255));
		MenuItem_TakenRoomsFloor1.setBackground(new Color(255, 228, 225));
		Menu_AllTakenRoomsFloor.add(MenuItem_TakenRoomsFloor1);
		
		JMenuItem MenuItem_TakenRoomsFloor2 = new JMenuItem("2");
		MenuItem_TakenRoomsFloor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0417\u0430\u0435\u0442\u0438 \u0441\u0442\u0430\u0438 \u043D\u0430 \u0435\u0442\u0430\u0436 \u043D\u043E\u043C\u0435\u0440 2");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Тип"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==false && hrd.getFloor()==2){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getRoomType())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
		});
		MenuItem_TakenRoomsFloor2.setForeground(new Color(153, 0, 255));
		MenuItem_TakenRoomsFloor2.setBackground(new Color(255, 228, 225));
		Menu_AllTakenRoomsFloor.add(MenuItem_TakenRoomsFloor2);
		
		JMenuItem MenuItem_TakenRoomsFloor3 = new JMenuItem("3");
		MenuItem_TakenRoomsFloor3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0417\u0430\u0435\u0442\u0438 \u0441\u0442\u0430\u0438 \u043D\u0430 \u0435\u0442\u0430\u0436 \u043D\u043E\u043C\u0435\u0440 3");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Тип"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==false && hrd.getFloor()==3){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getRoomType())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
		});
		MenuItem_TakenRoomsFloor3.setForeground(new Color(153, 0, 255));
		MenuItem_TakenRoomsFloor3.setBackground(new Color(255, 228, 225));
		Menu_AllTakenRoomsFloor.add(MenuItem_TakenRoomsFloor3);
		
		JMenu Menu_AllTakenRoomsType = new JMenu("\u0412\u0441\u0438\u0447\u043A\u0438 \u0417\u0430\u0435\u0442\u0438 \u0441\u0442\u0430\u0438 \u043E\u0442 \u0442\u0438\u043F:");
		Menu_AllTakenRoomsType.setForeground(new Color(153, 0, 255));
		Menu_AllTakenRoomsType.setBackground(new Color(255, 228, 225));
		mnNewMenu.add(Menu_AllTakenRoomsType);
		
		JMenuItem MenuItem_TakenRoomsType1 = new JMenuItem("1 \u043B\u0435\u0433\u043B\u043E");
		MenuItem_TakenRoomsType1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0417\u0430\u0435\u0442\u0438 \u0441\u0442\u0430\u0438 \u043E\u0442 \u0442\u0438\u043F: 1");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Етаж"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				 for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==false && hrd.getRoomType()==1){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getFloor())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
		});
		MenuItem_TakenRoomsType1.setForeground(new Color(153, 0, 255));
		MenuItem_TakenRoomsType1.setBackground(new Color(255, 228, 225));
		Menu_AllTakenRoomsType.add(MenuItem_TakenRoomsType1);
		
		JMenuItem MenuItem_TakenRoomsType2 = new JMenuItem("2 \u043B\u0435\u0433\u043B\u0430");
		MenuItem_TakenRoomsType2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0417\u0430\u0435\u0442\u0438 \u0441\u0442\u0430\u0438 \u043E\u0442 \u0442\u0438\u043F: 2");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Етаж"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				 for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==false && hrd.getRoomType()==2){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getFloor())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
		});
		MenuItem_TakenRoomsType2.setForeground(new Color(153, 0, 255));
		MenuItem_TakenRoomsType2.setBackground(new Color(255, 228, 225));
		Menu_AllTakenRoomsType.add(MenuItem_TakenRoomsType2);
		
		JMenuItem MenuItem_TakenRoomsType3 = new JMenuItem("\u0410\u043F\u0430\u0440\u0442\u0430\u043C\u0435\u043D\u0442");
		MenuItem_TakenRoomsType3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0417\u0430\u0435\u0442\u0438 \u0441\u0442\u0430\u0438 \u043E\u0442 \u0442\u0438\u043F: 3");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Стая номер", "Етаж"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				 for (HotelRoomData hrd: listRooms) {
			       	if(hrd.getRoomStatus()==false && hrd.getRoomType()==3){
			        	model.addRow(new String[]{String.valueOf(hrd.getRoom()),String.valueOf(hrd.getFloor())});
			            System.out.println(hrd.toString());
			           }
			     }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
		});
		MenuItem_TakenRoomsType3.setForeground(new Color(153, 0, 255));
		MenuItem_TakenRoomsType3.setBackground(new Color(255, 228, 225));
		Menu_AllTakenRoomsType.add(MenuItem_TakenRoomsType3);
		
		JMenuItem MenuItem_AllArriveGuests = new JMenuItem("\u0412\u0441\u0438\u0447\u043A\u0438 \u0433\u043E\u0441\u0442\u0438, \u043D\u0430\u0441\u0442\u0430\u043D\u0438\u043B\u0438 \u0441\u0435 \u043F\u0440\u0435\u0437 \u0434\u0435\u043D\u044F");
		MenuItem_AllArriveGuests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0433\u043E\u0441\u0442\u0438, \u043D\u0430\u0441\u0442\u0430\u043D\u0438\u043B\u0438 \u0441\u0435 \u043F\u0440\u0435\u0437 \u0434\u0435\u043D\u044F");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Дата", "Име","Презиме","Фамилия","ЕГН"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelGuestData hgd: listGuests) {
			       	String arriving = String.valueOf(hgd.getDateArriving());
			       	java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
			       	if(arriving.equals(String.valueOf(today))){
			       		model.addRow(new String[]{String.valueOf(hgd.getDateArriving()),String.valueOf(hgd.getFirstName()),
			       								  String.valueOf(hgd.getSecondName()),String.valueOf(hgd.getLastName()),String.valueOf(hgd.getEGN())});
			        }
			    }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
		});
		MenuItem_AllArriveGuests.setForeground(new Color(153, 0, 255));
		MenuItem_AllArriveGuests.setBackground(new Color(255, 228, 225));
		mnNewMenu.add(MenuItem_AllArriveGuests);
		
		JMenuItem MenuItem_AllLeavingGuests = new JMenuItem("\u0412\u0441\u0438\u0447\u043A\u0438 \u0433\u043E\u0441\u0442\u0438,\u043A\u043E\u0438\u0442\u043E \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u043D\u0430\u043F\u0443\u0441\u043D\u0430\u0442 \u043F\u0440\u0435\u0437 \u0434\u0435\u043D\u044F ");
		MenuItem_AllLeavingGuests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u0412\u0441\u0438\u0447\u043A\u0438 \u0433\u043E\u0441\u0442\u0438,\u043A\u043E\u0438\u0442\u043E \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u043D\u0430\u043F\u0443\u0441\u043D\u0430\u0442 \u043F\u0440\u0435\u0437 \u0434\u0435\u043D\u044F ");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Дата", "Име", "Презиме","Фамилия","ЕГН"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelGuestData hgd: listGuests) {
					String leaving = String.valueOf(hgd.getDateLeaving());
			       	java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
			       	if(leaving.equals(String.valueOf(today))){
			       		model.addRow(new String[]{String.valueOf(hgd.getDateLeaving()),String.valueOf(hgd.getFirstName()),
			       								  String.valueOf(hgd.getSecondName()),String.valueOf(hgd.getLastName()),String.valueOf(hgd.getEGN())});
			       		}
			       	}
			    f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
					
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
	
			}
		});
		MenuItem_AllLeavingGuests.setForeground(new Color(153, 0, 255));
		MenuItem_AllLeavingGuests.setBackground(new Color(255, 228, 225));
		mnNewMenu.add(MenuItem_AllLeavingGuests);
		
		JMenuItem MenuItem_ProfitArrivingGuests = new JMenuItem("\u041F\u0435\u0447\u0430\u043B\u0431\u0430\u0442\u0430 \u043E\u0442 \u0433\u043E\u0441\u0442\u0438\u0442\u0435, \u043D\u0430\u0441\u0442\u0430\u043D\u0438\u043B\u0438 \u0441\u0435 \u043F\u0440\u0435\u0437 \u0434\u0435\u043D\u044F");
		MenuItem_ProfitArrivingGuests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u041F\u0435\u0447\u0430\u043B\u0431\u0430\u0442\u0430 \u043E\u0442 \u0433\u043E\u0441\u0442\u0438\u0442\u0435, \u043D\u0430\u0441\u0442\u0430\u043D\u0438\u043B\u0438 \u0441\u0435 \u043F\u0440\u0435\u0437 \u0434\u0435\u043D\u044F");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Дата на пристигане", "Печалба", "Име","Презиме","Фамилия","ЕГН"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelGuestData hgd: listGuests) {
			       	String arriving = String.valueOf(hgd.getDateArriving());
			       	java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
			       	if(arriving.equals(String.valueOf(today))){
			       		model.addRow(new String[]{String.valueOf(hgd.getDateArriving()),String.valueOf(hgd.getPrice()),
			       								  String.valueOf(hgd.getFirstName()), String.valueOf(hgd.getSecondName()),
			       								  String.valueOf(hgd.getLastName()),String.valueOf(hgd.getEGN())});
			        }
			    }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
		});
		
		JMenuItem menuItem = new JMenuItem("\u041F\u043E\u0434\u0440\u043E\u0431\u043D\u0430 \u0441\u043F\u0440\u0430\u0432\u043A\u0430 \u0437\u0430 \u0432\u0441\u0438\u0447\u043A\u0438 \u0433\u043E\u0441\u0442\u0438");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u041F\u043E\u0434\u0440\u043E\u0431\u043D\u0430 \u0441\u043F\u0440\u0430\u0432\u043A\u0430 \u0437\u0430 \u0432\u0441\u0438\u0447\u043A\u0438 \u0433\u043E\u0441\u0442\u0438");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Име",
														"Презиме",
														"Фамилия",
														"ЕГН",
														"Пристигане",
														"Заминаване",
														"Дни",
														"Стая",
														"Тип",
														"Етаж",
														"Цена"});
				table = new JTable(model);
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelGuestData hgd: listGuests) {
					long dif =((hgd.getDateLeaving().getTime()/(60*60*24*1000)) - (hgd.getDateArriving().getTime()/(60*60*24*1000)));
					int days =(int)dif;
			       
			       		model.addRow(new String[]{String.valueOf(hgd.getFirstName()),
			       								  String.valueOf(hgd.getSecondName()),
			       								  String.valueOf(hgd.getLastName()),
			       								  String.valueOf(hgd.getEGN()),
			       								  String.valueOf(hgd.getDateArriving()),
			       								  String.valueOf(hgd.getDateLeaving()),
			       								  String.valueOf(days),
			       								  String.valueOf(hgd.getRoom()),
			       								  String.valueOf(hgd.getRoomType()),
			       								  String.valueOf(hgd.getFloor()),
			       								  String.valueOf(hgd.getPrice())
			       								  });
			    }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
				
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				TableColumn column = null;
				for (int i = 0; i < 11; i++) {
				    column = table.getColumnModel().getColumn(i);
				    if (i < 3) {
				        column.setPreferredWidth(90); 
				    }
				    if(i>5){
				    	 column.setPreferredWidth(40); 
				    }else{
				        column.setPreferredWidth(80); 
				    }
				}
				
			}
		});
		menuItem.setForeground(new Color(153, 0, 255));
		menuItem.setBackground(new Color(255, 228, 225));
		mnNewMenu.add(menuItem);
		MenuItem_ProfitArrivingGuests.setForeground(new Color(153, 0, 255));
		MenuItem_ProfitArrivingGuests.setBackground(new Color(255, 228, 225));
		mnNewMenu.add(MenuItem_ProfitArrivingGuests);
		
		JMenuItem MenuItem_ProfitLeavingGuests = new JMenuItem("\u041F\u0435\u0447\u0430\u043B\u0431\u0430\u0442\u0430 \u043E\u0442 \u0433\u043E\u0441\u0442\u0438\u0442\u0435, \u043A\u043E\u0438\u0442\u043E \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u043D\u0430\u043F\u0443\u0441\u043D\u0430\u0442 \u043F\u0440\u0435\u0437 \u0434\u0435\u043D\u044F");
		MenuItem_ProfitLeavingGuests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingShowQuery f = new SwingShowQuery();
				f.setVisible(true);
				f.setTitle("\u041F\u0435\u0447\u0430\u043B\u0431\u0430\u0442\u0430 \u043E\u0442 \u0433\u043E\u0441\u0442\u0438\u0442\u0435, \u043D\u0430\u043F\u0443\u0441\u043D\u0430\u043B\u0438 \u043F\u0440\u0435\u0437 \u0434\u0435\u043D\u044F");
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"Дата на заминаване", "Печалба", "Име","Презиме","Фамилия","ЕГН"});
				table = new JTable(model); 
				table.setBounds(20, 100, 450, 350);
				table.setForeground(new Color(153, 0, 255));
				table.setBackground(new Color(255, 204, 255));
				f.getContentPane().add(table);
				for (HotelGuestData hgd: listGuests) {
					int p = hgd.getPrice();
			       	String leaving = String.valueOf(hgd.getDateLeaving());
			       	java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
			       	if(leaving.equals(String.valueOf(today))){
			       		model.addRow(new String[]{String.valueOf(hgd.getDateLeaving()),String.valueOf(hgd.getPrice()),
			       				String.valueOf(hgd.getFirstName()),String.valueOf(hgd.getSecondName()),String.valueOf(hgd.getLastName()),String.valueOf(hgd.getEGN())});
			        }
			    }
				f.getContentPane().setLayout(new BorderLayout());
				f.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
				f.getContentPane().add(table, BorderLayout.CENTER);
				 
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				f.getContentPane().add(scrollPane, BorderLayout.CENTER);
				
				
			}
		});
		MenuItem_ProfitLeavingGuests.setForeground(new Color(153, 0, 255));
		MenuItem_ProfitLeavingGuests.setBackground(new Color(255, 228, 225));
		mnNewMenu.add(MenuItem_ProfitLeavingGuests);
		
		JButton button = new JButton("\u041D\u0430\u0437\u0430\u0434");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				SwingHotel h = new SwingHotel();
				h.setVisible(true);
			}
		});
		button.setToolTipText("\u041A\u044A\u043C \u043F\u044A\u0440\u0432\u043E\u043D\u0430\u0447\u0430\u043B\u043D\u0438\u044F \u043F\u0440\u043E\u0437\u043E\u0440\u0435\u0446 \u043D\u0430 \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u0430\u0442\u0430");
		button.setForeground(new Color(153, 0, 255));
		button.setBackground(UIManager.getColor("Button.background"));
		button.setBounds(315, 332, 119, 25);
		contentPane.add(button);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
