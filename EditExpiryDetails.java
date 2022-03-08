package bloodbanksystem1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

class EditExpiryDate {
	public void EditExpiryDateDetails(Connection con1, Scanner sc)throws Exception {
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
}
