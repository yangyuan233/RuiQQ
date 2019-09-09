package com.train.ruiq.util;

import java.sql.*;

public class JdbcUtil {

	//1.加载驱动，只做一次，可以放在静态代码块里
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//工具类
	//2.取连接的方法
	public static Connection getConnection(){
		String url="jdbc:mysql://localhost:3306/ruiq?useSSL=false&serverTimezone=UTC";
		Connection con=null;
		try{
			con= DriverManager.getConnection(url,"root","123456");
		}catch (SQLException e){
			e.printStackTrace();
		}
		return con;
	}


	//3.结果集处理,所有结构表的结果集通用
	//通过结果集元数据获得结果集结构
	public static void printResultSet(ResultSet rs) {
		if(rs!=null) {
			ResultSetMetaData rm;
			int num=0;
			try {
				rm = rs.getMetaData();
				num=rm.getColumnCount();
				StringBuffer sb=new StringBuffer();
				for(int i=1;i<=num;i++) {
					int size=rm.getColumnDisplaySize(i);
					String colval=rm.getColumnName(i);
					if(colval==null) {
						colval="null";
					}
					int b=(size-colval.length())/2;
					if(b>0) {
						for(int j=0;j<b;j++)
							sb.append(" ");
						sb.append(colval);
						for(int j=0;j<b;j++)
							sb.append(" ");
						if((size-colval.length())%2!=0) {
							sb.append(" ");
						}
					}
					else {
						sb.append(colval.substring(0, size));
					}
				}
				sb.append("\n");
				while (rs.next()) {
					for(int i=0;i<num;i++) {
						int size=rm.getColumnDisplaySize(i);
						String val=rs.getString(i);
						if(val==null)
							val="null";
						int b=(size-val.length())/2;
						if(b>0) {
							for(int j=0;j<b;j++)
								sb.append(" ");
							sb.append(val);
							for(int j=0;j<b;j++)
								sb.append(" ");
							if(size-val.length()%2!=0)
								sb.append(" ");

						}else
							sb.append(val.substring(0, size));
					}
					sb.append("\n");
				}
				System.out.println(sb.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	//4.释放资源
	public static void release(Connection con,Statement stmt,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
