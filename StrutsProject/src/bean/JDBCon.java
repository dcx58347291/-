package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class JDBCon {

	public static Connection getConnection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");			
		}catch (Exception e1) {
			System.out.print("Error loading Mysql Driver!");
			e1.printStackTrace();
		}
		try{
			String url="jdbc:mysql://localhost:3306/userdb";//tickets是数据库名
			String user="root";//用户名
			String password="xiaoliu1997";//密码
			cn=DriverManager.getConnection(url,user,password);
			return cn;

		}catch(SQLException e1){
			System.out.print(e1.toString());
			return null;
		}
	}
	
	
	public static boolean checkLogin(String userName,String password){
		try{

			Connection conn=getConnection();
			Statement stmt=conn.createStatement();

			String sql="select * from userinfo where UserNo='" + userName+"' and Password='" +password+"'";

			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				JDBCon.closeResultSet(rs);
				JDBCon.closeConnection(conn);
				return true;
			}else{
				JDBCon.closeResultSet(rs);
				JDBCon.closeConnection(conn);
				return false;
			}
			
		}catch(Exception ex){
	        ex.printStackTrace();
	        return false;
	    }
	}
	
	
	public static boolean insertDate(String userName, String password,String repassword){
		try{
			if(!password.equals(repassword))
				return false;
			
			int rs;
			String sql = "insert into userinfo(UserNo,Password)"+"values(?,?)";
			Connection conn = getConnection();
			System.out.println(conn);
			PreparedStatement pStatement = conn.prepareStatement(sql);
			System.out.println(pStatement);
			pStatement.setString(1,userName);
			pStatement.setString(2,password);			
			rs = pStatement.executeUpdate();
			JDBCon.closeStatement(pStatement);
			JDBCon.closeConnection(conn);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	} 
	
	public static boolean inserTickets(String Name,String Sex,String StartCity,
												String EndCity,String Date,String Id){
		try{
			int rs;
			String sql = "insert into bookinfo(Name,Sex,StartCity,EndCity,Date,Id)"+"values(?,?,?,?,?,?)";
			Connection conn = getConnection();
			System.out.println(conn);
			PreparedStatement pStatement = conn.prepareStatement(sql);
			System.out.println(pStatement);
			pStatement.setString(1,Name);
			pStatement.setString(2,Sex);	
			pStatement.setString(3,StartCity);
			pStatement.setString(4,EndCity);
			pStatement.setString(5,Date);
			pStatement.setString(6,Id);
			rs = pStatement.executeUpdate();
			JDBCon.closeStatement(pStatement);
			JDBCon.closeConnection(conn);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}		
	}
	
	
	public static Vector<Book> queryTickets(String UserName){
		try{
			Connection conn=getConnection();
			Statement stmt=conn.createStatement();
			String sql="select * from bookinfo where Name='"+UserName+"'";
			ResultSet rs=stmt.executeQuery(sql);
			Vector<Book> data=new Vector<Book>();
			while(rs.next()){
				Book book=new Book();
				book.setName(rs.getString(1));
				book.setSex(rs.getString(2));
				book.setStartCity(rs.getString(3));
				book.setEndCity(rs.getString(4));
				book.setDate(rs.getString(5));
				book.setId(rs.getString(6));
				data.add(book);
				
				//JDBCon.closeResultSet(rs);
				//JDBCon.closeConnection(conn);
			}
			return data;
		}catch(SQLException ex){
	        ex.printStackTrace();
	        return null;
	    }
	}
	
	

	/**
	 * 关闭连接
	 * 
	 * @param dbConnection
	 *            Connection
	 */
	public static void closeConnection(Connection dbConnection) {
		try {
			if (dbConnection != null && (!dbConnection.isClosed())) {
				dbConnection.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

	}

	/**
	 * 关闭结果集
	 */
	public static void closeResultSet(ResultSet res) {
		try {
			if (res != null) {
				res.close();
				res = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *关闭语句
	 */

	public static void closeStatement(PreparedStatement pStatement) {
		try {
			if (pStatement != null) {
				pStatement.close();
				pStatement = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
}
