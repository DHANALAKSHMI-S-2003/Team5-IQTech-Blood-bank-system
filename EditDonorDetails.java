package bloodbanksystem1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

class EditDetailsOfDonor {

	//method to edit donor details
	public void EditDonorDetails(Connection con1)throws Exception {
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

}
