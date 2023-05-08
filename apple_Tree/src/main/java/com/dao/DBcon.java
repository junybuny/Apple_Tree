package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBcon {
    

	//이렇게하면 Connection형 dbConn을 반환해준다.
//	//dbConn에 파이프라인을 넣을건데 그 파이프라인이 Connection이다.
private static Connection con; // DB연결자를 담을 수 있는 변수
	
	//메서드
    //static을 써서 이미 메모리상에 있어 받기만하면되니 get을 써줘야함
	public static Connection getConnection() { 
		
//         //연결할때 try-catch는 반드시 써야함. / NULL일 경우 연결되지않은 상태
//		if(dbConn == null) {
			
			String driver = "org.mariadb.jdbc.Driver";
		    Connection con = null;
		   
		
		try {
            Class.forName(driver);
            con = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3306/apple_tree",
                    "root",
                    "1234");
            
            if( con != null ) {	
                System.out.println("DB 접속 성공");
            }
            
        } catch (ClassNotFoundException e) { 
            System.out.println("드라이버 로드 실패");
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
//		}
		
		return con; //처음부터 여기까지가 DB연결자
	}
	
	
	//DB를 사용하면 끝내는 애가 있어야한다.
	public static void close() {
		
		if(con != null) { // null이 아니면 연결되어 있는 상태
			
			try {
				
				if(!con.isClosed()) { //만약에 dbConn이 닫혀있지 않으면
					con.close(); // 닫아줘라
				}
				
			} catch (Exception e) {
 
				System.out.println(e.toString());
			}
		} //닫으면 찌꺼기가 반드시 남기 때문에 dbConn=null;을 한다 안하면 아답터 오류가 뜬다.
		
		con=null; //이걸 안하면 두번째 연결부터 오류가 뜬다.
		
		//파이프라인이 연결되어 있는 상태에서 연결을 끊게 되면 스트림 안에 쓰레기값이 남게된다.
		//두번 째 연결 시 쓰레기값으로 인해 adapter 오류 발생
		//그래서 연결 종료 시 항상 초기화를 진행해야 한다.
	}
}