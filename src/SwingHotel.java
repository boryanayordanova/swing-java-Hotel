import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SwingHotel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Action action = new SwingAction();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingHotel frame = new SwingHotel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static String DIR  ="D:\\JAVA\\JavaHotel\\Rykovodstvo";   // folder where word documents are present.
         
	public SwingHotel() {
		setResizable(false);
		setTitle("Hotel Welcome");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btn_MakeReg = new JButton("\u041D\u0430\u043F\u0440\u0430\u0432\u0438 \u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F");
		btn_MakeReg.setToolTipText("\u0414\u043E\u0431\u0430\u0432\u0438 \u0433\u043E\u0441\u0442 \u0432 \u0445\u043E\u0442\u0435\u043B\u0430");
		btn_MakeReg.setForeground(new Color(153, 0, 255));
		btn_MakeReg.setBackground(UIManager.getColor("Button.background"));
		btn_MakeReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SwingAdd a = new SwingAdd();
				a.setVisible(true);
			}
		});
		btn_MakeReg.setBounds(40, 450, 180, 25);
		contentPane.add(btn_MakeReg);
		
		
		JButton btn_RemoveReg = new JButton("\u041F\u0440\u0435\u043C\u0430\u0445\u043D\u0438 \u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F");
		btn_RemoveReg.setToolTipText("\u041F\u0440\u0435\u043C\u0430\u0445\u043D\u0438 \u0433\u043E\u0441\u0442 \u043E\u0442 \u0445\u043E\u0442\u0435\u043B\u0430");
		btn_RemoveReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SwingRemove r = new SwingRemove();
				r.setVisible(true);
			}
		});
		btn_RemoveReg.setForeground(new Color(153, 0, 255));
		btn_RemoveReg.setBackground(UIManager.getColor("Button.background"));
		btn_RemoveReg.setBounds(240, 450, 180, 25);
		contentPane.add(btn_RemoveReg);
		
		JButton btn_Queries = new JButton("\u0421\u043F\u0440\u0430\u0432\u043A\u0438");
		btn_Queries.setToolTipText("\u0421\u043F\u0440\u0430\u0432\u043A\u0438");
		btn_Queries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SwingQuery q = new SwingQuery();
				q.setVisible(true);
			}
		});
		btn_Queries.setForeground(new Color(153, 0, 255));
		btn_Queries.setBackground(UIManager.getColor("Button.background"));
		btn_Queries.setBounds(440, 450, 180, 25);
		contentPane.add(btn_Queries);
		
		JLabel lblHotel = new JLabel("Hotel");
		lblHotel.setForeground(new Color(153, 0, 255));
		lblHotel.setFont(new Font("Script MT Bold", Font.BOLD, 40));
		lblHotel.setBounds(421, 40, 132, 30);
		contentPane.add(lblHotel);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(new Color(153, 0, 255));
		lblWelcome.setFont(new Font("Script MT Bold", Font.BOLD, 40));
		lblWelcome.setBounds(470, 96, 172, 30);
		contentPane.add(lblWelcome);
		
//PICTURE		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setIcon(new ImageIcon("D:\\JAVA\\JavaHotel\\13334865301132640982Pink Brick House.svg.hi.png"));
		lblNewLabel.setBounds(27, 16, 605, 407);
		contentPane.add(lblNewLabel);
		

//HELP BUTTON
		JButton btnOpen = new JButton("Help");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Desktop desktop = Desktop.getDesktop();  
		          try {
		            File f = new File( DIR  +  ".doc");
		             desktop.open(f);
		          }
		          catch(Exception ex) {
		        	  JOptionPane.showMessageDialog(SwingHotel.this,ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		          }
	            }
	        });
		btnOpen.setBounds(10, 11, 64, 23);
		contentPane.add(btnOpen);
	   

	}	
	private class SwingAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub	
		}
	
	}
}
