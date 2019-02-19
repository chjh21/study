package http;

public abstract class HttpService_7 implements Service_6 {
	@Override
	public void doService(HttpRequest_3 request, HttpResponse_4 response) {
		if(request.getMethod().equals("GET")) {
	        doGet(request, response);
	    } else if (request.getMethod().equals("POST")) {
	        doPost(request, response);
	    }
	}
	
	public void doGet(HttpRequest_3 request, HttpResponse_4 response) {
		System.out.println("GET Method Not Allowed");
        response.setResponseCode(ResponseCode_4.MethodNotAllowd);
    }
     
    public void doPost(HttpRequest_3 request, HttpResponse_4 response) {
    	System.out.println("Post Method Not Allowed");
        response.setResponseCode(ResponseCode_4.MethodNotAllowd);
    }
    
	@Override
	public void init() {
		
	}
	@Override
	public void destroy() {
		
	}
}
