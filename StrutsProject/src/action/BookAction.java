package action;
import bean.Book;
import bean.JDBCon;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;;


public class BookAction extends ActionSupport {
	Book book;
	private List<Book> bookList; //�����û��б�
	ActionContext ac=ActionContext.getContext();

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	@SuppressWarnings("unchecked")
	public String execute( )throws Exception{
		if(JDBCon.inserTickets(book.getName(),book.getSex(),book.getStartCity(),book.getEndCity(),book.getDate(),book.getId())){			
			
			bookList=JDBCon.queryTickets((String)ac.getSession().get("UserName"));	
			System.out.println("booklist的值"+bookList);
			ac.getSession().put("bookList", bookList);
			
			return "success";
		}
		else
			return "input";
		
	}
	
	public void validate()
	{
		if(book.getName()==null || book.getName().equals("") )
			this.addFieldError("Name","用户名不能为空");
		
		if(!book.getName().equals(ac.getSession().get("UserName")))
			this.addFieldError("NameError", "用户名与姓名需要一致");
		
		if(book.getSex()==null || book.getSex().equals(""))
			this.addFieldError("Sex","性别不能为空");
	
		if(book.getStartCity()==null || book.getStartCity().equals(""))
			this.addFieldError("StartCity","始发城市不能为空");
		
		if(book.getEndCity()==null || book.getEndCity().equals(""))
			this.addFieldError("EndCity","目的城市不能为空");

		if(book.getId()==null || book.getId().equals(""))
			this.addFieldError("Id","身份证不能为空");
		else if(!(book.getId().length()==18))
			this.addFieldError("IdError", "身份证长度需为18");
			
	}



}
