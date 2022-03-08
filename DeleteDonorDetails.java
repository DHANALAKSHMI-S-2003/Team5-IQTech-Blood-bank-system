package bloodbanksystem1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

class DeleteDonorDetails {

	public void DeleteDonor(Connection con1,Scanner sc) throws Exception{
		System.out.println("Enter the DonorID of the Donor to be deleted:");
		int id=sc.nextInt();
		String query="delete from bloodbank where ID=?;";
		PreparedStatement pstmt = con1.prepareStatement(query);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		System.out.println("Successfully Deleted");
		
	}
}
