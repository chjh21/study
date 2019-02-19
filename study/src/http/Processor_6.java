package http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Set;

public class Processor_6 extends Thread{
	private Socket socket;
	 
    public Processor_6(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
    	try {
    	InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line = null;

		HttpRequest_3 request = new HttpRequest_3();
		line = br.readLine();
		request.setMethod(line.split(" ")[0]);
		request.setUri(line.split(" ")[1]);
		request.setProtocal(line.split(" ")[2]);

		while ((line = br.readLine()) != null) {
			if (line.length() == 0) {
				break;
			}
			request.getHeader().put(line.split(": ")[0], line.split(": ")[1]);
		}

		if (request.getContentLength() > 0) {
			char[] params = new char[request.getContentLength()];
			br.read(params);
			String message = new String(params);
			request.setMessage(message);
		}

		String[] params;
		if (request.getMethod().equals("GET")) {
			params = request.getUri().split("\\?")[1].split("&");
			request.setUri(request.getUri().split("\\?")[0]);
		} else {
			params = request.getMessage().split("&");
		}

		for (String param : params) {
			request.getParameter().put(param.split("=")[0], param.split("=")[1]);
		}

		System.out.println(request);

		PrintWriter printer = new PrintWriter(socket.getOutputStream());

		HttpResponse_4 response = new HttpResponse_4(request);
		ServiceConfig_6 serviceConfig = new ServiceConfig_6();
		String className = serviceConfig.getMappingClass(request.getUri());
		Class clz = Class.forName(className);
		HelloService_6 service = (HelloService_6) clz.newInstance();
		service.doService(request, response);
		
		printer.print(response.getRequest().getProtocal() + " ");
		printer.println(response.getResponseCode().getCode());
		Set<String> headerKeySet = response.getHeader().keySet();
		Iterator<String> headerIterator = headerKeySet.iterator();
		while (headerIterator.hasNext()) {
			String headerKey = headerIterator.next();
			printer.println(headerKey + ": " + response.getHeader().get(headerKey));
		}
		printer.println();
		printer.println(response.getMessage());
		printer.flush();

		br.close();
		isr.close();
		is.close();
    	}catch(Exception e){
    		System.out.println(e.getMessage()+" 아이콘은 처리안해..");
    	}
    }
    
}
