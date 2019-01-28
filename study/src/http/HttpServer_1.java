package http;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer_1 {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(9999);
		Socket socket =  server.accept();
        Scanner scanner = new Scanner(socket.getInputStream());
        PrintWriter printer = new PrintWriter(socket.getOutputStream());
 
        while(scanner.hasNextLine()) {
            String result = scanner.nextLine();
            System.out.println(result);
            if(result.length() == 0) {
                break;
            }
        }
 
        String result = "Success Message";
 
        printer.println("HTTP/1.1 200 OK");
        printer.println("Content-Type: text/html");
        printer.println("Content-Length: " + result.length());
        printer.println();
        printer.println(result);
        printer.flush();
  
        printer.close();
        scanner.close();
	}

}
