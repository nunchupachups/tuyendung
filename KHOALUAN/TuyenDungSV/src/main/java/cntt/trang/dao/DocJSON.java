package cntt.trang.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DocJSON {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public static int insertTinhThanh(String maTinhThanh, String tenTinhThanh, String type) throws SQLException {
		int flag= -1;
		String query = "insert into TinhThanh(MaTinhThanh,TenTinhThanh,Type) values(?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, maTinhThanh);
			ps.setNString(2, tenTinhThanh);
			ps.setNString(3, type);
			
			flag= ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}	
		}
		return flag;
	}
	
	public static int insertQuanHuyen(String maQuanHuyen, String tenQuanHuyen, String type,String pathWithType, String maTinhThanh) throws SQLException {
		int flag= -1;
		String query = "insert into QuanHuyen(MaQuanHuyen,TenQuanHuyen,Type, path_with_type, MaTinhThanh) values(?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, maQuanHuyen);
			ps.setNString(2, tenQuanHuyen);
			ps.setNString(3, type);
			ps.setNString(4, pathWithType);
			ps.setNString(5, maTinhThanh);
			
			flag= ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}	
		}
		return flag;
	}
	
	public static int insertXaPhuong(String maXaPhuong, String tenXaPhuong, String type,String pathWithType, String maQuanHuyen) throws SQLException {
		int flag= -1;
		String query = "insert into XaPhuong(MaXaPhuong,TenXaPhuong,Type,path_with_type, MaQuanHuyen) values(?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, maXaPhuong);
			ps.setNString(2, tenXaPhuong);
			ps.setNString(3, type);
			ps.setNString(4, pathWithType);
			ps.setNString(5, maQuanHuyen);
			
			flag= ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}	
		}
		return flag;
	}
	
	
	public static void main(String[] args) throws SQLException {
		JSONParser jsonParser = new JSONParser();
////tinh thanh
//        try (
//        	FileReader reader = new FileReader("C:\\Users\\Admin\\Desktop\\KHOALUAN\\TuyenDungSV\\src\\main\\webapp\\json\\tinh_tp.json")) {
//            // Read JSON file
//            Object obj = jsonParser.parse(reader);
//
//            JSONObject userList = (JSONObject) obj;
//            Set<String> keys=userList.keySet();
//            Iterator<String> keyIt=keys.iterator();
//            while(keyIt.hasNext()) {
//            	JSONObject hi= (JSONObject)userList.get(keyIt.next());
//                String code=(String) hi.get("code");
//                String name=(String) hi.get("name");
//                String type=(String) hi.get("type");
//                insertTinhThanh(code, name, type);
//                System.out.println("ok");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        
//        quanhuyen
//        try (
//            	FileReader reader = new FileReader("C:\\Users\\Admin\\Desktop\\KHOALUAN\\TuyenDungSV\\src\\main\\webapp\\json\\quan_huyen.json")) {
//                // Read JSON file
//                Object obj = jsonParser.parse(reader);
//
//                JSONObject userList = (JSONObject) obj;
//                Set<String> keys=userList.keySet();
//                Iterator<String> keyIt=keys.iterator();
//                while(keyIt.hasNext()) {
//                	JSONObject hi= (JSONObject)userList.get(keyIt.next());
//                    String code=(String) hi.get("code");
//                    String name=(String) hi.get("name");
//                    String type=(String) hi.get("type");
//                    String parent_code=(String) hi.get("parent_code");
//                    String path_with_type=(String) hi.get("path_with_type");
//                    insertQuanHuyen(code, name, type, path_with_type, parent_code);
//                    System.out.println("ok");
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        xaphuong
        try {
        	FileReader reader1 = new FileReader("C:\\Users\\Admin\\Desktop\\KHOALUAN\\TuyenDungSV\\src\\main\\webapp\\json\\quan_huyen.json");
              // Read JSON file
              Object obj1 = jsonParser.parse(reader1);

              JSONObject listQuanHuyen = (JSONObject) obj1;
              Iterator<String> keysQuanHuyen=listQuanHuyen.keySet().iterator();
              while(keysQuanHuyen.hasNext()) {
            	  FileReader reader = new FileReader("C:\\Users\\Admin\\Desktop\\KHOALUAN\\TuyenDungSV\\src\\main\\webapp\\json\\xaphuong\\"+keysQuanHuyen.next()+".json");
                  // Read JSON file
                  Object obj = jsonParser.parse(reader);

                  JSONObject list = (JSONObject) obj;
                  Set<String> keys=list.keySet();
                  Iterator<String> keyIt=keys.iterator();
                  while(keyIt.hasNext()) {
                  	JSONObject hi= (JSONObject)list.get(keyIt.next());
                      String code=(String) hi.get("code");
                      String name=(String) hi.get("name");
                      String type=(String) hi.get("type");
                      String path_with_type=(String) hi.get("path_with_type");
                      String parent_code=(String) hi.get("parent_code");
                      insertXaPhuong(code, name, type, path_with_type, parent_code);
                      System.out.println("ok");
                  }
              }
              
            	
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
	}	

}
