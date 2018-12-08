package User;
import Login.*;
import java.sql.ResultSet;

public class Bookingdisplays {
	
	public static ResultSet Upbooking(String username)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
			
			String query = "SELECT refno,location,hotel,checkin,checkout,noofrooms,noofpeople,status FROM bookinginfo WHERE username='"+username+"' and (status ='CONFIRMED' or status='WAITING')";
			rs = MyConnection.executeQuery(query);
			return rs;
		}catch(Exception e)
		{
			return rs;
		}
		
	}
	public static ResultSet Prevbooking(String username)
	{
	MyConnection.getConnection();
	ResultSet rs=null;
	try {
		
		String query = "SELECT refno,location,hotel,checkin,checkout,noofrooms,noofpeople,status FROM bookinginfo WHERE username='"+username+"' and (status ='COMPLETED' or status='CANCELLED' or status='INCOMPLETE')";
		rs = MyConnection.executeQuery(query);
		return rs;
	}catch(Exception e)
	{
		return rs;
	}
	}
	
	public static int statusShow(int refno)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
		String query="select status from bookinginfo where refno="+refno;
		rs = MyConnection.executeQuery(query);
		if(rs.next())
		{
			if(rs.getString(1).equals("WAITING"))
			{
				return 1;
			}
			if(rs.getString(1).equals("COMPLETED"))
				return 2;
			else
				return 0;
		}
		else
			return 0;
		
		}catch(Exception e)
		{
			return 0;
		}
		
	}
	
	public static int checkFeedback(int a)
	{
		MyConnection.getConnection();
		String str = null;
		ResultSet rs=null;
		try {
		String query = "select feedback from bookinginfo where refno="+a;
		rs = MyConnection.executeQuery(query);
		if(rs.next())
		{
			if(rs.getString(1).equals(str))
			{
				return 1;
			}
			else
				return 0;
		}
		else
			return 0;
		}catch(Exception e)
		{
			return 1;
		}
		finally {
		MyConnection.closeConnection();
		}
	}
	
	public static String gethotelname(int refno)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
			String query = "select hotel from bookinginfo where refno="+refno;
			rs = MyConnection.executeQuery(query);
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
				return null;
		}catch(Exception e)
		{
			return null;
		}
		finally {
			MyConnection.closeConnection();
		}
	}
	
	public static String getlocation(int refno)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
			String query = "select location from bookinginfo where refno="+refno;
			rs = MyConnection.executeQuery(query);
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
				return null;
		}catch(Exception e)
		{
			return null;
		}
		finally {
			MyConnection.closeConnection();
		}
	}
	
	public static java.sql.Date getcheckin(int refno)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
			String query = "select checkin from bookinginfo where refno="+refno;
			rs = MyConnection.executeQuery(query);
			if(rs.next())
			{
				return rs.getDate(1);
			}
			else
				return null;
		}catch(Exception e)
		{
			return null;
		}
		finally {
			MyConnection.closeConnection();
		}
	}
	
	public static java.sql.Date getcheckout(int refno)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
			String query = "select checkout from bookinginfo where refno="+refno;
			rs = MyConnection.executeQuery(query);
			if(rs.next())
			{
				return rs.getDate(1);
			}
			else
				return null;
		}catch(Exception e)
		{
			return null;
		}
		finally {
			MyConnection.closeConnection();
		}
	}
	
	public static int getnoofrooms(int refno)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
			String query = "select noofrooms from bookinginfo where refno="+refno;
			rs = MyConnection.executeQuery(query);
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
				return 0;
		}catch(Exception e)
		{
			return 0;
		}
		finally {
			MyConnection.closeConnection();
		}
	}
	
	public static int getnoofpeople(int refno)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
			String query = "select noofpeople from bookinginfo where refno="+refno;
			rs = MyConnection.executeQuery(query);
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
				return 0;
		}catch(Exception e)
		{
			return 0;
		}
		finally {
			MyConnection.closeConnection();
		}
	}
	
	public static double getprice(String location,String hotel)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
			String query = "select pricePerRoom from hotelinfo where location='"+location+"' and hotel='"+hotel+"'";
			rs = MyConnection.executeQuery(query);
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
				return 0;
		}catch(Exception e)
		{
			return 0;
		}
		finally {
			MyConnection.closeConnection();
		}
	}
	

}
