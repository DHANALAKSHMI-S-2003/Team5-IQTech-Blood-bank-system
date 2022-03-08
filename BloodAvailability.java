package bloodbanksystem1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class BloodAvailability {
	public void DisplayBloodAvailability(Connection con1)throws Exception {
		Statement stmt=con1.createStatement();
		String query="select * from BloodAvailable;";
		ResultSet rs= stmt.executeQuery(query);
		System.out.println("Blood ID\tBlood Group\tBlood Quantity\t  Expiry Date");
		while(rs.next()){
			System.out.println("    "+rs.getInt(1)+"\t            "+rs.getString(2)+"\t    "+rs.getString(3)+"      \t  "+rs.getString(4));
		}
		
	}
}
