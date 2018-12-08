package User;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.MyDate;
import Hotel.Hotel;
import Hotel.MyContainer;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CancelBookingFrame extends JFrame
{

	private JPanel contentPane;
	JFrame Fobj = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					CancelBookingFrame frame = new CancelBookingFrame(1,"ankit");
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CancelBookingFrame(int refno,String username)
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(180, 30, 900,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("BookMyHotel");
		
		//BookMyHotel label
		JLabel lblBookMyHotel = new JLabel("BookMyHotel");
		lblBookMyHotel.setBackground(new Color(255, 255, 255));
		lblBookMyHotel.setForeground(new Color(102, 0, 51));
		lblBookMyHotel.setFont(new Font("Consolas", Font.BOLD, 40));
		lblBookMyHotel.setBounds(23, 11, 321, 65);
		contentPane.add(lblBookMyHotel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(222, 133, 445, 416);
		contentPane.add(panel);
		panel.setLayout(null);
		
		DropDown dropDown = new DropDown(username, this);
		contentPane.add(dropDown);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dropDown.resize();
			}
		});
		
		
		JLabel lblYourBookingDetails = new JLabel("Your booking details");
		lblYourBookingDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourBookingDetails.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblYourBookingDetails.setBounds(98, 26, 249, 35);
		panel.add(lblYourBookingDetails);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLocation.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblLocation.setBounds(82, 94, 113, 26);
		panel.add(lblLocation);
		
		JLabel lblNewLabel = new JLabel(Bookingdisplays.getlocation(refno));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNewLabel.setBounds(245, 94, 138, 29);
		panel.add(lblNewLabel);
		
		JLabel lblHotel = new JLabel("Hotel");
		lblHotel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHotel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblHotel.setBounds(82, 135, 113, 26);
		panel.add(lblHotel);
		
		JLabel label_1 = new JLabel(Bookingdisplays.gethotelname(refno));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_1.setBounds(245, 135, 138, 29);
		panel.add(label_1);
		
		JLabel lblCheckIn = new JLabel("Check In");
		lblCheckIn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCheckIn.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblCheckIn.setBounds(82, 175, 113, 26);
		panel.add(lblCheckIn);
		
		JLabel label_3 = new JLabel(Bookingdisplays.getcheckin(refno).toString());
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_3.setBounds(245, 175, 138, 29);
		panel.add(label_3);
		
		JLabel lblCheckOut = new JLabel("Check Out");
		lblCheckOut.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCheckOut.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblCheckOut.setBounds(82, 215, 113, 26);
		panel.add(lblCheckOut);
		
		JLabel label_5 = new JLabel(Bookingdisplays.getcheckout(refno).toString());
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_5.setBounds(245, 215, 138, 29);
		panel.add(label_5);
		
		JLabel lblNumberOfRooms = new JLabel("Number of Rooms");
		lblNumberOfRooms.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfRooms.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNumberOfRooms.setBounds(34, 255, 161, 26);
		panel.add(lblNumberOfRooms);
		
		JLabel label_7 = new JLabel(Integer.toString(Bookingdisplays.getnoofrooms(refno)));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_7.setBounds(245, 255, 138, 29);
		panel.add(label_7);
		
		JLabel lblNumberOfPeople = new JLabel("Number of People");
		lblNumberOfPeople.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfPeople.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNumberOfPeople.setBounds(12, 295, 183, 26);
		panel.add(lblNumberOfPeople);
		
		JLabel label_9 = new JLabel(Integer.toString(Bookingdisplays.getnoofpeople(refno)));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_9.setBounds(245, 295, 138, 29);
		panel.add(label_9);
		
		int a=MyDate.getIndex(Bookingdisplays.getcheckin(refno));
		int d=MyDate.getIndex(Bookingdisplays.getcheckout(refno));
		int b=MyDate.getIndex(MyDate.getCurrDate());
		double c=Bookingdisplays.getnoofrooms(refno)*Bookingdisplays.getprice(Bookingdisplays.getlocation(refno),Bookingdisplays.gethotelname(refno))*(d-a+1);
		
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblPrice.setBounds(12, 336, 183, 26);
		panel.add(lblPrice);
		
		JLabel label_2 = new JLabel(Double.toString(Bookingdisplays.getnoofrooms(refno)*Bookingdisplays.getprice(Bookingdisplays.getlocation(refno),Bookingdisplays.gethotelname(refno))*(d-a+1)));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Roboto", Font.PLAIN, 20));
		label_2.setBounds(245, 336, 138, 29);
		panel.add(label_2);
				
		JLabel lblRefundAmount = new JLabel("Refund Amount");
		lblRefundAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRefundAmount.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblRefundAmount.setBounds(12, 373, 183, 26);
		panel.add(lblRefundAmount);
		
		JLabel label = new JLabel(Double.toString(calrefund(a,b,c)));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Roboto", Font.PLAIN, 20));
		label.setBounds(245, 370, 138, 29);
		panel.add(label);
		
		JButton button = new JButton("Back to MyBookings");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyBookingFrame ob=new MyBookingFrame(username);
				ob.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBackground(new Color(106, 90, 205));
		button.setBounds(636, 584, 196, 34);
		contentPane.add(button);
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Confirm Cancellation", "Information", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) 
				{
				MyContainer obj1=MyContainer.getContainer();
				Hotel hotel= obj1.getHotel(Bookingdisplays.gethotelname(refno),Bookingdisplays.getlocation(refno));
				hotel.cancelBooking(refno);
				MyContainer.storeContainer(obj1);
				MyBookingFrame ob=new MyBookingFrame(username);
				ob.setVisible(true);
				dispose();
				}
				
			}
		});
		btnCancelBooking.setForeground(Color.WHITE);
		btnCancelBooking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelBooking.setBackground(new Color(106, 90, 205));
		btnCancelBooking.setBounds(346, 584, 196, 34);
		contentPane.add(btnCancelBooking);
	}
	
	public double calrefund(int a,int b,double c)
	{
		if((a-b)>=3)
			return c;
		else
			return 0.5*c;
	}
}
