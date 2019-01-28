package http;

import java.util.HashMap;
import java.util.Map;


public class HttpRequest_3 {	private String method;
    private String uri;
    private String protocal;
    private String message;
    private Map<String,String> header = new HashMap<String, String>();
    private Map<String, String> parameter = new HashMap<String, String>();
 
    public int getContentLength() {
        try{
            return Integer.parseInt(header.get("Content-Length"));
        } catch (Exception e) {
            return 0;
        }
    }
 
    public String getMethod() {
        return method;
    }
 
    public void setMethod(String method) {
        this.method = method;
    }
 
    public String getUri() {
        return uri;
    }
 
    public void setUri(String uri) {
        this.uri = uri;
    }
 
    public String getProtocal() {
        return protocal;
    }
 
    public void setProtocal(String protocal) {
        this.protocal = protocal;
    }
 
    public Map<String, String> getHeader() {
        return header;
    }
 
    public void setHeader(Map<String, String> header) {
        this.header = header;
    }
 
    public Map<String, String> getParameter() {
        return parameter;
    }
 
    public void setParameter(Map<String, String> parameter) {
        this.parameter = parameter;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", uri='" + uri + '\'' +
                ", protocal='" + protocal + '\'' +
                ", message='" + message + '\'' +
                ", header=" + header +
                ", parameter=" + parameter +
                '}';
    }
}
