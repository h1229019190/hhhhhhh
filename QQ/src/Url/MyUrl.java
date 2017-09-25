package Url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class MyUrl {
public static void main(String[] args) {
	try {
		Socket socket=new Socket("117.136.0.191",10001);
		OutputStream os=socket.getOutputStream();
		PrintWriter pw= new PrintWriter(os,true);
		BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
//		pw.println("GET/HTTP/1.1");
//		pw.println("Host:"+"BDQN.com"+":80");
//		pw.println();
//		pw.close();
		StringBuilder sb=new StringBuilder(8096);
		
			if(in.ready()) {
				int i =0;
				while(i !=-1) {
					i= in.read();
					sb.append((char)i);
				}
				
			
		}
		System.out.println(sb.toString());
		socket.close();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
}
