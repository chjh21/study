package http;

public enum ResponseCode_4 {
	OK("200 OK"), InternalServerError("500 Internal Server Error"), MethodNotAllowd("405 Method Not Allowd");
	 
    final private String code;
 
    public String getCode() {
        return code;
    }
 
    private ResponseCode_4(String code) {
        this.code = code;
    }
}
