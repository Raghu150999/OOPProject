package User;
import Login.*;
import net.proteanit.sql.DbUtils;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Admin.MyDate;

import java.awt.event.*;
import java.sql.ResultSet;

import Hotel.Hotel;
import Hotel.MyContainer;
@SuppressWarnings({ "serial", "unused" })
public class MyBookingFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable prevtable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				try {
					MyBookingFrame frame = new MyBookingFrame("ankit");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyBookingFrame(String username) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180,30,900,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("BookMyHotel");
		
		JLabel label = new JLabel("BookMyHotel");
		label.setForeground(new Color(102, 0, 51));
		label.setFont(new Font("Consolas", Font.BOLD, 40));
		label.setBackground(Color.WHITE);
		label.setBounds(24, 11, 320, 65);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("-Your Stay our Responsibility");
		label_1.setForeground(new Color(102, 0, 51));
		label_1.setFont(new Font("Consolas", Font.ITALIC, 23));
		label_1.setBounds(278, 11, 399, 65);
		contentPane.add(label_1);
		
		DropDown dropDown = new DropDown(username, this);
		contentPane.add(dropDown);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dropDown.resize();
			}
		});
		
		
		JPanel bg_panel = new JPanel();
		bg_panel.setBackground(new Color(250, 235, 215));
		bg_panel.setBounds(10, 79, 864, 571);
		contentPane.add(bg_panel);
		bg_panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(250, 235, 215));
		panel_2.setBounds(0, 0, 463, 64);
		bg_panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel cardpanel = new JPanel();
		cardpanel.setBackground(new Color(250, 235, 215));
		cardpanel.setBounds(0, 64, 864, 507);
		bg_panel.add(cardpanel);
		cardpanel.setLayout(new CardLayout(0, 0));
		
		
		JPanel upbooking_panel = new JPanel();
		upbooking_panel.setBackground(new Color(250, 235, 215));
		cardpanel.add(upbooking_panel, "upbooking");
		upbooking_panel.setLayout(null);
		
		JButton btnMdifyBooking = new JButton("Modify Booking");
		btnMdifyBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModifyFrame(getRefno1(),username).setVisible(true);dispose();
			}
		});
		btnMdifyBooking.setForeground(Color.WHITE);
		btnMdifyBooking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMdifyBooking.setBackground(new Color(106, 90, 205));
		btnMdifyBooking.setBounds(607, 416, 213, 34);
		btnMdifyBooking.setVisible(false);
		upbooking_panel.add(btnMdifyBooking);
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelBookingFrame ob=new CancelBookingFrame(getRefno1(),username);
				ob.setVisible(true);
				dispose();
			}
		});
		btnCancelBooking.setForeground(Color.WHITE);
		btnCancelBooking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelBooking.setBackground(new Color(106, 90, 205));
		btnCancelBooking.setBounds(607, 462, 213, 34);
		btnCancelBooking.setVisible(false);
		upbooking_panel.add(btnCancelBooking);
		
		
		JPanel prevbooking_panel = new JPanel();
		prevbooking_panel.setBackground(new Color(250, 235, 215));
		cardpanel.add(prevbooking_panel, "prevbooking");
		prevbooking_panel.setLayout(null);
		
		
		JButton Feedbackbtn = new JButton("Give Feedback");
		Feedbackbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeedbackFrame obj= new FeedbackFrame(username,getRefno());
				obj.setVisible(true);
				dispose();
			}
		});
		Feedbackbtn.setForeground(Color.WHITE);
		Feedbackbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Feedbackbtn.setBackground(new Color(106, 90, 205));
		Feedbackbtn.setBounds(641, 431, 213, 34);
		Feedbackbtn.setVisible(false);
		prevbooking_panel.add(Feedbackbtn);
		
		
		 JLabel NoFeedback = new JLabel("Feedback given.");
		 NoFeedback.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
			NoFeedback.setBounds(641, 431, 213, 34);
			NoFeedback.setVisible(false);
			prevbooking_panel.add(NoFeedback);
			
		JLabel lblNewLabel = new JLabel("Feedback cannot be given.");
		lblNewLabel.setVisible(false);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel.setBounds(625, 432, 229, 34);
		prevbooking_panel.add(lblNewLabel);	
		
		JLabel lblNewLabel_1 = new JLabel("Modification allowed only 3 days before CheckIn");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(163, 425, 343, 19);
		upbooking_panel.add(lblNewLabel_1);
			
		JButton upbooking_btn = new JButton("View Upcoming Booking");
		upbooking_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upBook(username);
				Feedbackbtn.setVisible(false);
				NoFeedback.setVisible(false);
				btnMdifyBooking.setEnabled(true);
				btnMdifyBooking.setVisible(false);
				btnCancelBooking.setVisible(false);
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(false);
				CardLayout c= (CardLayout)(cardpanel.getLayout());
				c.show(cardpanel,"upbooking");
			}
		});
		upbooking_btn.setBackground(new Color(204, 0, 0));
		upbooking_btn.setForeground(new Color(255, 255, 255));
		upbooking_btn.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		upbooking_btn.setBounds(0, 0, 232, 64);
		panel_2.add(upbooking_btn);
		
		
		JButton prevbooking_btn = new JButton("View Previous Booking");
		prevbooking_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevBook(username);
				btnMdifyBooking.setVisible(false);
				btnCancelBooking.setVisible(false);
				btnMdifyBooking.setEnabled(true);
				Feedbackbtn.setVisible(false);
				NoFeedback.setVisible(false);
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(false);
				CardLayout c= (CardLayout)(cardpanel.getLayout());
				c.show(cardpanel,"prevbooking");
			}
		});
		prevbooking_btn.setForeground(Color.WHITE);
		prevbooking_btn.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		prevbooking_btn.setBackground(new Color(204, 0, 0));
		prevbooking_btn.setBounds(230, 0, 232, 64);
		panel_2.add(prevbooking_btn);
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(102, 102, 51));
		scrollPane.setBounds(10, 26, 844, 381);
		upbooking_panel.add(scrollPane);
		
		table = new JTable()
				{ private static final long serialVersionUID = 1L;

		        public boolean isCellEditable(int row, int column) {                
		                return false;   
		        };};
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		        table.setRowHeight(35);
		        table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int a=Bookingdisplays.statusShow(getRefno1());
				int b=MyDate.getIndex(Bookingdisplays.getcheckin(getRefno1()));
				int c=MyDate.getIndex(MyDate.getCurrDate());
				if((b-c)>3)
				{
					if(a!=1)
					{
						btnMdifyBooking.setVisible(true);
						btnCancelBooking.setVisible(true);
						lblNewLabel_1.setVisible(false);
						btnMdifyBooking.setEnabled(true);
					}
					else
					{
						btnMdifyBooking.setVisible(false);
						btnCancelBooking.setVisible(false);
						lblNewLabel_1.setVisible(false);
						btnMdifyBooking.setEnabled(true);
					}
				}
				else
				{
					btnMdifyBooking.setEnabled(false);
					btnMdifyBooking.setVisible(true);
					btnCancelBooking.setVisible(true);
					lblNewLabel_1.setVisible(true);
				}
			}
		});
		scrollPane.setViewportView(table);
		

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 26, 844, 381);
		prevbooking_panel.add(scrollPane_1);
	
		
		prevtable = new JTable()
		{ private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        };
    };
		prevtable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	
	
	prevtable.setRowHeight(35);	
    prevtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int b=Bookingdisplays.statusShow(getRefno());
				int c=getRefno();
				int a=Bookingdisplays.checkFeedback(c);
				if(b==2)
				{
				if(a==1)
				{
					NoFeedback.setVisible(false);
					Feedbackbtn.setVisible(true);
					lblNewLabel.setVisible(false);
				}
				else if(a==0)
				{
					NoFeedback.setVisible(true);
					Feedbackbtn.setVisible(false);
					lblNewLabel.setVisible(false);
				}
				}
				else
				{
					lblNewLabel.setVisible(true);
					NoFeedback.setVisible(false);
					Feedbackbtn.setVisible(false);
				}
					
			}
		});
		scrollPane_1.setViewportView(prevtable);
		
		
		upBook(username);
		CardLayout c= (CardLayout)(cardpanel.getLayout());
		c.show(cardpanel,"upbooking");
	}
	
	void upBook(String username)
	{
		ResultSet rs;
		rs=Bookingdisplays.Upbooking(username);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		MyConnection.closeConnection();
	}
	void prevBook(String username)
	{
		ResultSet rs;
		rs=Bookingdisplays.Prevbooking(username);
		prevtable.setModel(DbUtils.resultSetToTableModel(rs));
		MyConnection.closeConnection();
	}
	int getRefno()
	{
		int b=prevtable.getSelectedRow();
		String s = prevtable.getModel().getValueAt(b,0).toString();
		int c = Integer.parseInt(s);
		return c;
	}
	int getRefno1()
	{
		int b=table.getSelectedRow();
		String s = table.getModel().getValueAt(b,0).toString();
		int c = Integer.parseInt(s);
		return c;
	}
}
