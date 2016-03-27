package com.mingge.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.net.HttpURLConnection;


public class HttpConnectionUtil {
	public static String get(String url) throws IOException{
		return post(url,null);
	}
	public static String post(String url,Map<String,Object> param) throws IOException{
		HttpURLConnection connection=null;
			try {
				URL u=new URL(url);	
					connection=(HttpURLConnection) u.openConnection();
					StringBuffer sBuffer=null;
					if (param!=null) {
						sBuffer=new StringBuffer();
						connection.setDoOutput(true);
						OutputStream outputStream=connection.getOutputStream();
						BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream));
						 for(Map.Entry s:param.entrySet()){
			                    sBuffer.append(s.getKey()).append("=").append(s.getValue()).append("&");
			                }
						  //将参数通过输出流写入
			                writer.write(sBuffer.deleteCharAt(sBuffer.toString().length()-1).toString());
			                writer.close();//一定要关闭,不然可能出现参数不全的错误
			                sBuffer=null;
					}
				connection.connect();//建立连接
				sBuffer=new StringBuffer();
	            //获取连接状态码
	            int recode=connection.getResponseCode();
	            BufferedReader reader=null;
	            if(recode==200){
	                //Returns an input stream that reads from this open connection
	                //从连接中获取输入流
	                InputStream in=connection.getInputStream();
	                //对输入流进行封装
	                reader=new BufferedReader(new InputStreamReader(in));
	                String str=null;
	                sBuffer=new StringBuffer();
	                //从输入流中读取数据
	                while((str=reader.readLine())!=null){
	                	sBuffer.append(str).append(System.getProperty("line.separator"));
	                }
	                //关闭输入流
	                reader.close();
	                if (sBuffer.toString().length() == 0) {
	                    return null;
	                }
	                return sBuffer.toString().substring(0,
	                		sBuffer.toString().length() - System.getProperty("line.separator").length());
	            }
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
	            if(connection!=null)//关闭连接
	                connection.disconnect();
	        }
			return null;
	}
}
