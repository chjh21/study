package http;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse_4 {
	private HttpRequest_3 request;
    private ResponseCode_4 responseCode;
    private Map<String, String> header;
    private String message;
 
    public HttpResponse_4(HttpRequest_3 request) {
        this.request = request;
        header = new HashMap<String, String>();
    }
 
    public ResponseCode_4 getResponseCode() {
        return responseCode;
    }
 
    public void setResponseCode(ResponseCode_4 responseCode) {
        this.responseCode = responseCode;
    }
 
    public Map<String, String> getHeader() {
        return header;
    }
 
    public void setHeader(Map<String, String> header) {
        this.header = header;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public HttpRequest_3 getRequest() {
        return request;
    }
 
    public void setRequest(HttpRequest_3 request) {
        this.request = request;
    }
 
    @Override
    public String toString() {
        return "HttpResponse{" +
                "request=" + request +
                ", responseCode=" + responseCode +
                ", header=" + header +
                ", message='" + message + '\'' +
                '}';
    }
}
