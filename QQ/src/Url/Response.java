package Url;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Response {
private static final int BUFFER_SIZE=1024;
Request request;
OutputStream output;
public Response(OutputStream output) {
	this.output=output;
	
}
public void setRequest(Request request) {
	this.request=request;
}
public void sendStaticResource() throws IOException {
	byte[] bytes=new byte[BUFFER_SIZE];
	Path path =Paths.get(System.getProperty("user.dir"),"webroot",request.getUri());
	System.out.println("Path"+path);
	if(Files.exists(path)) {
		 
		try(InputStream inputStream =Files.newInputStream(path)){
			int ch=inputStream.read(bytes,0,BUFFER_SIZE);
			String responseStr ="HTTP/1.1 200 OK\r\n"
					+"Content-Type: text/html\r\n"
					+"Content-Length: "+Files.size(path)+"\r\n\r\n";
			output.write(responseStr.getBytes());
			while(ch !=-1) {
				output.write(bytes, 0, ch);
				ch=inputStream.read(bytes,0,BUFFER_SIZE);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		}else {
			String errorMessage="HTTP/1.1 404 fILE Not Found\r\n"
					+"Content-Type:text/html\r\n"
					+"Content-Length:23\r\n"+"\r\n"
					+"<h1>File Not Found</h1>";
			output.write(errorMessage.getBytes());
		}
	}
}

