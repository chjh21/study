package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer_3 {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		 
		Socket socket =  server.accept();
		 
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		 
		String line = null;
		Integer contentLength = null;
		 
		HttpRequest_3 request = new HttpRequest_3();
		line = br.readLine();
		request.setMethod(line.split(" ")[0]);
		request.setUri(line.split(" ")[1]);
		request.setProtocal(line.split(" ")[2]);
		 
		while( (line = br.readLine()) !=null) {
		    if(line.length() == 0) {
		        break;
		    }
		    request.getHeader().put(line.split(": ")[0], line.split(": ")[1]);
		}
		
		if(request.getContentLength() > 0) {
		     char[] params = new char[request.getContentLength()];
		     br.read(params);
		     String message = new String(params);
		     request.setMessage(message);
		 }
		
		String[] params;
		if(request.getMethod().equals("GET")) {
		    params = request.getUri().split("\\?")[1].split("&");
		} else {
		    params = request.getMessage().split("&");
		}
		 
		for(String param : params) {
		    request.getParameter().put(param.split("=")[0],param.split("=")[1]);
		}
		 
		System.out.println(request);
		
		br.close();
        isr.close();
        is.close();
	}

}
