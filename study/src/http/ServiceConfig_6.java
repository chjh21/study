package http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
 
public class ServiceConfig_6 {
    private static final String CONFIG_PATH = "D:/Workspace/git/meta_study/study/src/http/service.properties";
    private static Map<String, String> mappingConfig;
 
    public ServiceConfig_6() {
 
        if (mappingConfig == null) {
             mappingConfig = new HashMap();
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream(new File(CONFIG_PATH)));
                Iterator it = properties.keySet().iterator();
                while(it.hasNext()) {
                    String key = (String) it.next();
                    mappingConfig.put(key, properties.getProperty(key));
                }
            } catch (IOException e) {
               throw new RuntimeException("service properties 파일을 찾을수 없습니다", e);
            }
        }
    }
 
    public String getMappingClass(String url) {
        return mappingConfig.get(url);
    }
    
//    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//    	 
//    	ServiceConfig_6 config = new ServiceConfig_6();
//        System.out.println(config.getMappingClass("/hello"));
//     
//        Class clz = Class.forName(config.getMappingClass("/hello"));
//        Object retobj = clz.newInstance();
//        System.out.println(retobj);
//    }
 
}