package http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer_5 {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		ServiceConfig_8 serviceConfig = new ServiceConfig_8();
		serviceConfig.initServices();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		while(true) {
            Socket socket =  server.accept();
            System.out.println("요청이 들어왔습니다 " + new Date());
//            Processor_5 processor = new Processor_5(socket);
//            Processor_6 processor = new Processor_6(socket);
            Processor_8 processor = new Processor_8(socket);
            executorService.execute(processor);
        }
//		serviceConfig.destoryService();
	}
	
}
