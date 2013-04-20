package iiitb.ebay.users.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Blob;

import iiitb.ebay.users.model.UserCredential;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.utilities.DB;

public class UserService {

	public static UserDetails getUserDetails(int userID) {
		UserDetails userDetails = new UserDetails();
		Connection connectionUD;
		ResultSet resultSetUD;
		String fetchUserDetails = "SELECT * FROM userdetails WHERE userID="
				+ userID;

		try {
			connectionUD = DB.getConnection();
			resultSetUD = DB.readFromDB(fetchUserDetails, connectionUD);

			while (resultSetUD.next()) {
				userDetails.setAddress(resultSetUD.getString("address"));
				userDetails.setCity(resultSetUD.getString("city"));
				userDetails.setCountry(resultSetUD.getString("country"));
				userDetails.setDOB(resultSetUD.getString("DOB"));
				userDetails.setEmail(resultSetUD.getString("email"));
				userDetails.setFirstName(resultSetUD.getString("firstname"));
				userDetails.setImage(resultSetUD.getBlob("image"));
				userDetails.setLastName(resultSetUD.getString("lastname"));
				userDetails
						.setMemberSince(resultSetUD.getString("membersince"));
				userDetails.setPinCode(resultSetUD.getInt("pincode"));
				userDetails.setRole(resultSetUD.getString("role"));
				userDetails.setState(resultSetUD.getString("state"));
				userDetails.setTelephone(resultSetUD.getString("telephone"));
				userDetails.setUserID(resultSetUD.getInt("userid"));
			}
			connectionUD.close();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return userDetails;
	}

	/* This method does not include login information like password and secret QA for safety reasons
	 * Use login classes for such information.
	 *  */
	public static UserCredential getUserCredentials(int userID) {
		UserCredential userCreds = new UserCredential();
		Connection connectionUC;
		ResultSet resultSetUC;
		String fetchUserDetails = "SELECT * FROM usercredential  WHERE userID="
				+ userID;
		System.out.println(fetchUserDetails);

		try {
			connectionUC = DB.getConnection();
			resultSetUC = DB.readFromDB(fetchUserDetails, connectionUC);

			while (resultSetUC.next()) {
					userCreds.setAccStatus(resultSetUC.getString("accStatus"));
					userCreds.setUcID(resultSetUC.getInt("ucID"));
					userCreds.setUserName(resultSetUC.getString("userName"));
			}
			connectionUC.close();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return userCreds;
	}

}
