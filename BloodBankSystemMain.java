package bloodbanksystem1;
import java.sql.*;
import java.util.*;



public class Main {
	//main program
	public static void main(String args[])throws Exception{
		
		
		Scanner sc=new Scanner(System.in);
		
	    String url1="jdbc:mysql://localhost:3306/javajdbc?";
	    String uname1="vijayasri";
		String pass1="Vijaya@02";
		
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1 = DriverManager.getConnection(url1,uname1,pass1);
        int i=1;
		while(i==1) {
			System.out.println("\n\n-------Welcome to the Blood Bank System--------");
			System.out.println("Select Any required action from the List");
			System.out.println("1.Enter the details of the donor\n2.Update the details of the donor\n3.Display list of donors\n4.Delete a donor\n5.Display the Availability of Blood\n6.Edit Expiry Details of the Blood\n7.Increase the Quantity of Blood Available\n8.Decrease the Quantity of Blood Available\n9.Exit");
		switch(sc.nextInt()) {
		case 1:
			NewDonorDetails nd=new NewDonorDetails();
			nd.DonorDetails(con1);
			i=1;
			break;
		case 2:
			EditDetailsOfDonor ed2=new EditDetailsOfDonor();
			ed2.EditDonorDetails(con1);
			i=1;
			break;
		case 3:
			DonorList don=new DonorList();
			don.DisplayDonorDetails(con1);
			i=1;
			break;
		case 4:
			DeleteDonorDetails d1=new DeleteDonorDetails();
			d1.DeleteDonor(con1,sc);
			i=1;
			break;
		case 5:
			BloodAvailability b1=new BloodAvailability();
			b1.DisplayBloodAvailability(con1);
			i=1;
			break;
		case 6:
			EditExpiryDate d2=new EditExpiryDate();
			d2.EditExpiryDateDetails(con1,sc);
			i=1;
			break;
		case 7:
			EditBloodQuantity ed=new EditBloodQuantity();
			ed.EditBloodQuantityInc(con1,sc);
			i=1;
			break;
		case 8:
			EditBloodQuantity ed1=new EditBloodQuantity();
			ed1.EditBloodQuantityDec(con1,sc);
			i=1;
			break;
		case 9:
			i=0;
			break;
		default:
			System.out.println("Invalid Selection");
			i=1;
			break;
		}
		}
		
	    con1.close();
	    sc.close();
			
	}

}
