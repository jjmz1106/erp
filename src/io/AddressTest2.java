package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Conn;

public class AddressTest2 {

	public void exePath(String path) {
        List<Map<String,String>>abrList=new ArrayList<>();
         File f=new File(path);
         try {
            FileInputStream fi=new FileInputStream(f);
            InputStreamReader ips=new InputStreamReader(fi,"MS949");
            BufferedReader br=new BufferedReader(ips);
            StringBuffer sb= new StringBuffer();
            String str=null;
            while((str=br.readLine())!=null) {
               sb.append(str+"<>");
            }
            String key="DONG_CODE\r\n" + "SIDO\r\n" + "GUGUN\r\n" + "DONG_NAME\r\n" + "LEE_NAME\r\n" + "IS_MNT\r\n"
    				+ "JIBUN\r\n" + "SUB_JIBUN\r\n" + "ROAD_CODE\r\n" + "ROAD_NAME\r\n" + "IS_BASE\r\n" + "BUILD_NUM\r\n"
    				+ "SUB_BUILD_NUM\r\n" + "BUILDING_NAME\r\n" + "DETAIL_BUILDING_NAME\r\n" + "ADDR_CODE";
            String[] keys=key.split("\r\n");
            String[] address=sb.toString().split("<>");
            for(int i=0;i<address.length;i++) {
               Map<String,String> adrMap=new HashMap<>();
               String[]values=address[i].split("\\|");
               for(int j=0;j<keys.length;j++) {
                  adrMap.put(keys[j],values[j]);
               }
               abrList.add(adrMap);
            }
            String sql="insert into address(";
            String value=" values(";
            for(String k:keys) {
               sql += k+",";
               value += "?,";
            }
            sql=sql.substring(0,(sql.length()-1)) + ")\r\n";
            value=value.substring(0,(value.length()-1)) +")";
            sql+= value;
            Connection con= Conn.open();
            PreparedStatement ps=con.prepareStatement(sql);
            for(Map<String,String>row:abrList) {
               for(int i=0;i<keys.length;i++) {
                  ps.setString((i+1), row.get(keys[i]));
               }
               ps.executeUpdate();
            }
            con.commit();
            
               
            
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         } catch (SQLException e) {
            e.printStackTrace();
         }
         for(Map<String,String>map:abrList) {
            System.out.println(map);
         }

      
      
      
      
      
   
}
}
