package interceptor;
import java.util.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class BookInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		
		Map session=ai.getInvocationContext().getSession();

		String userName=(String)session.get("UserName");
		if(userName!=null){
			return ai.invoke();
		}else{ 
			ActionContext ac=ai.getInvocationContext();
			ac.put("errorMessage","用户未登录，请先登录。");
			return "login"; 
		}
		
	}

}
