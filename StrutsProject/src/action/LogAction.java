package action;
import bean.*;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class LogAction {
	
	User users;

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
	
	public String execute( )throws Exception{
		
		
		return "success";
		
	}
	
	public String login(){
		/*
		if(users.getUserName().equals(""))
			return "input";
		else if(!users.getUserName().equals("admin"))
			return "input";
		if(users.getPassword().equals(""))
			return "input";
		else if(!users.getPassword().equals("000000"))
			return "input";
		
		return "success";
		 */
		
		Map<String, Object> m;
		m=ActionContext.getContext().getSession();
		/*System.out.println(users.getUserName());
		System.out.println(users.getPassword());*/
		if(JDBCon.checkLogin(users.getUserName(), users.getPassword())){
			m.put("UserName",users.getUserName());
			System.out.println(m.get("UserName"));
			return "success";
		}else{
			return "input";
		}
		
	}
	


}
