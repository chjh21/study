package http;

public class HelloService_7 extends HttpService_7{

	@Override
	public void doGet(HttpRequest_3 request, HttpResponse_4 response) {
		response.setResponseCode(ResponseCode_4.OK);
        response.getHeader().put("Content-Type", "text/html");
        response.setMessage("Hello World");
	}

}
