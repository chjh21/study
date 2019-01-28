package http;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class HttpClient_1 {

	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket();
        socket.connect(new InetSocketAddress("www.google.com", 80));
 
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        Scanner scanner = new Scanner(socket.getInputStream());
 
        writer.println("GET / HTTP/1.1");
        writer.println("Host: www.google.com");
        writer.println();
 
        writer.flush();
 
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
 
        scanner.close();
        writer.close();
        socket.close();

	}

}
