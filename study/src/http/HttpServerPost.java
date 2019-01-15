package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServerPost {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(9999);
		Socket socket =  server.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
        String inputLine;
        Integer contentLength = null;
        
        while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			if(inputLine.startsWith("Content-Length: ")) {
                contentLength = Integer.parseInt(inputLine.replaceAll("Content-Length: ",""));
            }
            if(inputLine.length() == 0) {
                break;
            }
		}
        char[] params = new char[contentLength];
        in.read(params);
        System.out.println(params);
		
		in.close();
	}

}
