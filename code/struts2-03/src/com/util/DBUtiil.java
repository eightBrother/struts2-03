package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.xml.registry.infomodel.Concept;

/*
 * 处理库的信息，地址，用户，密码，驱动等，
 * 
 * 
 */
public class DBUtiil {

	private String driver ="com.mysql.jdbc.Driver"; //驱动
	private String  username="Dev01"; //用户名
	private String  psw="dev01";//密码
	private String url ="jdbc:mysql://123.207.168.108:3306/jmcb";// 库的地址
	
	private Connection conn; //数据库链接
	private ResultSet rs; // 结果集
	private PreparedStatement ps; //sql语句预编译
	
	//构造方法，（每次创建DBUtil对象时执行的方法）
	public DBUtiil() {//加载驱动
		 try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated constructor stub
	}
	//获取链接
	public Connection getConnection(){
		
		try {
			conn = DriverManager.getConnection(url, username, psw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//关闭 conn ，rs，ps
	public void close(){
		try {
			if(conn!= null){
				conn.close();
			}
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//查询 (在对结果集处理完成后进行关闭)
	public ResultSet query(String sql,List<Object> options ){
		this.getConnection();
		try {
			ps =conn.prepareStatement(sql);
			if(options !=null){
				for (int i =0;i<options.size();i++){
					ps.setObject(i+1, options.get(i));
				}
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	//增，删，改完成后关闭，
	public void exec(String sql,List<Object> options){
		this.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if (options != null) {
				for (int i = 0; i < options.size(); i++) {
					ps.setObject(i + 1, options.get(i));
				}
			}
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			close();
		}
		
		
		
	}
}
