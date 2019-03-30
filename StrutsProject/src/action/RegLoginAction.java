package action;

import bean.JDBCon;
import bean.RegisterUser;

public class RegLoginAction {
	RegisterUser registUser;

	public RegisterUser getRegistUser() {
		return registUser;
	}

	public void setRegistUser(RegisterUser registUser) {
		this.registUser = registUser;
	}
	
	public String regist(){
		System.out.println(registUser.getUserName());
		System.out.println(registUser.getPassword());
		System.out.println(registUser.getRePassword());
		if(registUser.getUserName().equals("") || registUser.getPassword().equals(""))
			return "input";

		if(JDBCon.insertDate(registUser.getUserName(), registUser.getPassword(), registUser.getRePassword()))
			return "success";
		else
			return "input";
			
		

	}
}
