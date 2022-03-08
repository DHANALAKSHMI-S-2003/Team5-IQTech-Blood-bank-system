package bloodbanksystem1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class EditBloodQuantity {
	public void EditBloodQuantityInc(Connection con1, Scanner sc)throws Exception {
		System.out.println("BloodID\nA+ve = 1\nA-ve = 2\nB+ve = 3\nB-ve = 4\nO+ve = 5\nO-ve = 6\nAB+ve = 7\nAB-ve = 8");
		System.out.print("Enter the BloodId:");
		int id=sc.nextInt();
		System.out.print("Enter the units of blood to be Increased:");
		int units=sc.nextInt();
		Statement stmt=con1.createStatement();
		String query1="select BloodQuantity from BloodAvailable Where BloodID="+id+";";
		ResultSet rs= stmt.executeQuery(query1);
		rs.next();
		int prevUnits=rs.getInt(1);
		if(prevUnits+units<=150) {
			String query="Update BloodAvailable SET BloodQuantity=BloodQuantity+? Where BloodID=?;";
			PreparedStatement pstmt = con1.prepareStatement(query);
			pstmt.setInt(1, units);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			System.out.println("Successfully Updated the Blood Quantity");
		}
		else {
			System.out.println("Threshold configuration of the blood Exceeded!");
			
		}
		
	}

	public void EditBloodQuantityDec(Connection con1, Scanner sc)throws Exception {
		System.out.println("BloodID\nA+ve = 1\nA-ve = 2\nB+ve = 3\nB-ve = 4\nO+ve = 5\nO-ve = 6\nAB+ve = 7\nAB-ve = 8");
		System.out.print("Enter the BloodId:");
		int id=sc.nextInt();
		System.out.print("Enter the units of blood to be Decreased:");
		int units=sc.nextInt();
		Statement stmt=con1.createStatement();
		String query1="select BloodQuantity from BloodAvailable Where BloodID="+id+";";
		ResultSet rs= stmt.executeQuery(query1);
		rs.next();
		int prevUnits=rs.getInt(1);
		if(prevUnits-units>=50) {
			String query="Update BloodAvailable SET BloodQuantity=BloodQuantity-? Where BloodID=?;";
			PreparedStatement pstmt = con1.prepareStatement(query);
			pstmt.setInt(1, units);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			System.out.println("Successfully Updated the Blood Quantity");
		}
		else {
			System.out.println("Threshold configuration of the blood is not maintained!");
			
		}
		
	}
}
