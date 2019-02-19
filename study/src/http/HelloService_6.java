package http;

public class HelloService_6 implements Service_6{

	@Override
	public void doService(HttpRequest_3 request, HttpResponse_4 response) {
		response.setResponseCode(ResponseCode_4.OK);
        response.getHeader().put("Content-Type", "text/html");
        response.setMessage("Hello World");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
