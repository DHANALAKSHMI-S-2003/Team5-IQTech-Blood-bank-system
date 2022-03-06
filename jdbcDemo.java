package bloodbanksystem1;
import java.sql.*;
import java.util.*;



public class JdbcDemo {
	//main program
	public static void main(String args[])throws Exception{
		System.out.println("-------Welcome to the Blood Bank System--------");
		System.out.println("Select Any required action from the List");
		System.out.println("1.Enter the details of the donor\n2.Update the details of the donor\n3.Display list of donors\n4.Delete a donor\n5.Display the Availability of Blood\n6.Edit Expiry Details of the Blood\n7.Increase the Quantity of Blood Available\n8.Decrease the Quantity of Blood Available");
		
		Scanner sc=new Scanner(System.in);
		
	    String url1="jdbc:mysql://localhost:3306/javajdbc?";
	    String uname1="vijayasri";
		String pass1="Vijaya@02";
		
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1 = DriverManager.getConnection(url1,uname1,pass1);
		
		switch(sc.nextInt()) {
		case 1:
			DonorDetails(con1); 
			break;
		case 2:
			EditDonorDetails(con1);
			break;
		case 3:
			DisplayDonorDetails(con1);
			break;
		case 4:
			DeleteDonor(con1,sc);
			break;
		case 5:
			DisplayBloodAvailability(con1);
			break;
		case 6:
			EditExpiryDate(con1,sc);
			break;
		case 7:
			EditBloodQuantityInc(con1,sc);
			break;
		case 8:
			EditBloodQuantityDec(con1,sc);
			break;
		}
		
	    con1.close();
	    sc.close();
			
	}
	public static void EditBloodQuantityInc(Connection con1, Scanner sc)throws Exception {
		System.out.println("BloodID\nA+ve = 1\nA-ve = 2\nB+ve = 3\nB-ve = 4\nO+ve = 5\nO-ve = 6\nAB+ve = 7\nAB-ve = 8");
		System.out.print("Enter the BloodId:");
		int id=sc.nextInt();
		System.out.print("Enter the units of blood to be Increased:");
		int units=sc.nextInt();
		String query="Update BloodAvailable SET BloodQuantity=BloodQuantity+? Where BloodID=?;";
		PreparedStatement pstmt = con1.prepareStatement(query);
		pstmt.setInt(1, units);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
		System.out.println("Successfully Updated the Blood Quantity");
		
	}

	public static void EditBloodQuantityDec(Connection con1, Scanner sc)throws Exception {
		System.out.println("BloodID\nA+ve = 1\nA-ve = 2\nB+ve = 3\nB-ve = 4\nO+ve = 5\nO-ve = 6\nAB+ve = 7\nAB-ve = 8");
		System.out.println("Enter the BloodId:");
		int id=sc.nextInt();
		System.out.print("Enter the units of blood to be Decreased:");
		int units=sc.nextInt();
		String query="Update BloodAvailable SET BloodQuantity=BloodQuantity-? Where BloodID=?;";
		PreparedStatement pstmt = con1.prepareStatement(query);
		pstmt.setInt(1, units);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
		System.out.println("Successfully Updated the Blood Quantity");
		
		
	}
		public static void EditExpiryDate(Connection con1, Scanner sc)throws Exception {
		System.out.println("BloodID\nA+ve = 1\nA-ve = 2\nB+ve = 3\nB-ve = 4\nO+ve = 5\nO-ve = 6\nAB+ve = 7\nAB-ve = 8");
		System.out.println("Enter the BloodId:");
		int id=sc.nextInt();
		System.out.print("Enter the Updated Expiry Date(YYYY-MM-DD):");
		String expiryDate=sc.next();
		String query="Update BloodAvailable SET ExpiryDate=? Where BloodID=?;";
		PreparedStatement pstmt = con1.prepareStatement(query);
		pstmt.setString(1, expiryDate);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
		System.out.println("Successfully Updated the Expiry Date");
		
	}
		
		public static void DisplayBloodAvailability(Connection con1)throws Exception {
		Statement stmt=con1.createStatement();
		String query="select * from BloodAvailable;";
		ResultSet rs= stmt.executeQuery(query);
		System.out.println("Blood ID\tBlood Group\tBlood Quantity\t  Expiry Date");
		while(rs.next()){
			System.out.println("    "+rs.getInt(1)+"\t            "+rs.getString(2)+"\t    "+rs.getString(3)+"      \t  "+rs.getString(4));
		}
		
	}
	public static void DeleteDonor(Connection con1,Scanner sc) throws Exception{
		System.out.println("Enter the DonorID of the Donor to be deleted:");
		int id=sc.nextInt();
		String query="delete from bloodbank where ID=?;";
		PreparedStatement pstmt = con1.prepareStatement(query);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		System.out.println("Successfully Deleted");
		
	}
	//method to get the donor details
	public static void DonorDetails(Connection con1) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Details of the Donor:");
		System.out.print("Enter the First Name:");
		String firstName=sc.next();
		System.out.print("Enter the Last Name:");
		String lastName=sc.next();
		System.out.print("Enter the Blood Group:");
		String bloodGroup=sc.next();
		System.out.print("Enter the Age:");
		int age=sc.nextInt();
		System.out.print("Enter the Gender:");
		String gender=sc.next();
		System.out.print("Enter the Address:");
		String address=sc.next();
		System.out.print("Enter the Phone Number:");
		String phoneNo=sc.next();
		System.out.print("Enter the Date of Last Donation(YYYY-MM-DD):");
		String dateOfLastDonation=sc.next();
		String query="insert into BloodBank(FirstName,LastName,BloodGroup,Age,Gender,Address,PhoneNumber,DateOfLastDonation) values(?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt = con1.prepareStatement(query); 
		pstmt.setString(1,firstName);
		pstmt.setString(2,lastName);
		pstmt.setString(3,bloodGroup);
		pstmt.setInt(4,age);
		pstmt.setString(5,gender);
		pstmt.setString(6,address);
		pstmt.setString(7,phoneNo);
		pstmt.setString(8,dateOfLastDonation);
		pstmt.executeUpdate();
		System.out.println("Inserted");
		sc.close();
	}

	

	//method to edit donor details
	public static void EditDonorDetails(Connection con1)throws Exception {

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the Donor ID");

		int id=sc.nextInt();

		System.out.println("Select the parameter to be Updated");

		System.out.println("1.First Name\n2.Last Name\n3.Blood Group\n4.Age\n5.Gender\n6.Address\n7.Phone Number\n8.Date of last Donation");

		

		switch(sc.nextInt()) {

		case 1:

			System.out.print("Enter the First Name:");

			String firstName=sc.next();

			String query1="Update BloodBank SET FirstName = ? Where ID=?;";

			PreparedStatement pstmt1 = con1.prepareStatement(query1); 

			pstmt1.setString(1,firstName);

			pstmt1.setInt(2,id);

			pstmt1.executeUpdate();

			break;

			

		case 2:

			System.out.print("Enter the Last Name:");

			String lastName=sc.next();

			String query2="Update BloodBank SET LastName = ? Where ID=?;";

			PreparedStatement pstmt2 = con1.prepareStatement(query2); 

			pstmt2.setString(1,lastName);

			pstmt2.setInt(2,id);

			pstmt2.executeUpdate();

			break;

			

		case 3:

			System.out.print("Enter the Blood Group:");

			String bloodGroup=sc.next();

			String query3="Update BloodBank SET BloodGroup = ? Where ID=?;";

			PreparedStatement pstmt3 = con1.prepareStatement(query3); 

			pstmt3.setString(1,bloodGroup);

			pstmt3.setInt(2,id);

			pstmt3.executeUpdate();

			break;

		case 4:

			System.out.print("Enter the Age:");

			int age=sc.nextInt();

			String query4="Update BloodBank SET Age = ? Where ID=?;";

			PreparedStatement pstmt4 = con1.prepareStatement(query4); 

			pstmt4.setInt(1,age);

			pstmt4.setInt(2,id);

			pstmt4.executeUpdate();

			break;

			

		case 5:

			System.out.print("Enter the Gender:");

			String gender=sc.next();

			String query5="Update BloodBank SET Gender = ? Where ID=?;";

			PreparedStatement pstmt5 = con1.prepareStatement(query5); 

			pstmt5.setString(1,gender);

			pstmt5.setInt(2,id);

			pstmt5.executeUpdate();

			break;

			

		case 6:

			System.out.print("Enter the Address:");

			String address=sc.next();

			String query6="Update BloodBank SET Address = ? Where ID=?;";

			PreparedStatement pstmt6 = con1.prepareStatement(query6); 

			pstmt6.setString(1,address);

			pstmt6.setInt(2,id);

			pstmt6.executeUpdate();

			break;

			

		case 7:

			System.out.print("Enter the Phone Number:");

			String phoneNumber=sc.next();

			String query7="Update BloodBank SET PhoneNumber = ? Where ID=?;";

			PreparedStatement pstmt7 = con1.prepareStatement(query7); 

			pstmt7.setString(1,phoneNumber);

			pstmt7.setInt(2,id);

			pstmt7.executeUpdate();

			break;

		

		case 8:

			System.out.print("Enter the Date of Last Donation:");

			String dateOfLastDonation=sc.next();

			String query8="Update BloodBank SET DateOfLastDonation = ? Where ID=?;";

			PreparedStatement pstmt8 = con1.prepareStatement(query8); 

			pstmt8.setString(1,dateOfLastDonation);

			pstmt8.setInt(2,id);

			pstmt8.executeUpdate();

			break;

			

			

		}

		

		sc.close();

	}

	//method to display the list of donors

    public static void DisplayDonorDetails(Connection con1)throws Exception {

		Statement stmt=con1.createStatement();

		String query="select ID,FirstName,LastName,BloodGroup,Age,Gender,Address,PhoneNumber,DateOfLastDonation from BloodBank;";

		ResultSet rs= stmt.executeQuery(query);

		System.out.println("DonorID\t  First Name\tLast Name   BloodGroup\tAge\tGender\t  Address\tPhone Number\tLast Date Of Donation");

		while(rs.next()){

			System.out.println("    "+rs.getInt(1)+"\t  "+rs.getString(2)+"\t    "+rs.getString(3)+"\t      "+rs.getString(4)+"   \t"+rs.getInt(5)+"\t"+rs.getString(6)+"\t  "+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));

		}

		

	}
	
}
