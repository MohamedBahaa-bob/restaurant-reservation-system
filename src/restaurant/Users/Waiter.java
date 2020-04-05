package restaurant.Users;

import javax.swing.JOptionPane;

import restaurant.filesWork.UserData;

public class Waiter extends UserData{
	@Override
	public boolean compareWithDB(String username,String password) {
		boolean isRole=false,msg=true;int i=0;String role="Waiter";
		//System.out.println(userList.get(i).getUsername());
		while(userList.size()>i && isRole==false) {
			if(userList.get(i).getUsername().contentEquals(username) && userList.get(i).getPassword().contentEquals(password)) {
				if(userList.get(i).getRole().contentEquals(role)) {
					isRole=true;
					msg=false;
					break;
				}else {
					JOptionPane.showMessageDialog(null,"Username doesn't match chosen role");
					msg=false;
				}
			}/*else {
				JOptionPane.showMessageDialog(null,"Incorrect Username or password");
			}*/
			i++;
		}
		if(msg) {
			JOptionPane.showMessageDialog(null,"Incorrect Username or password");
		}
		return isRole;
	}
}
