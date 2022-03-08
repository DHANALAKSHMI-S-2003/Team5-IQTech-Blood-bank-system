package bloodbanksystem1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class DonorList {
	//method to display the list of donors
    public void DisplayDonorDetails(Connection con1)throws Exception {
		Statement stmt=con1.createStatement();
		String query="select ID,FirstName,LastName,BloodGroup,Age,Gender,Address,PhoneNumber,DateOfLastDonation from BloodBank;";
		ResultSet rs= stmt.executeQuery(query);
		System.out.println("DonorID\t  First Name\tLast Name   BloodGroup\tAge\tGender\t  Address\tPhone Number\tLast Date Of Donation");
		while(rs.next()){
			System.out.println("    "+rs.getInt(1)+"\t  "+rs.getString(2)+"\t    "+rs.getString(3)+"\t      "+rs.getString(4)+"   \t"+rs.getInt(5)+"\t"+rs.getString(6)+"\t  "+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));
		}
		
	}
}
