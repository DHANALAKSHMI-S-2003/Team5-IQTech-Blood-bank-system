package bloodbanksystem1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

class NewDonorDetails {
	public void DonorDetails(Connection con1) throws Exception{
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
	
}
