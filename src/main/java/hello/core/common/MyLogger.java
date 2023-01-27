package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String msg){
        System.out.printf("[%s] [%s] [%s]\r\n",uuid,requestURL,msg);
    }
    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.printf("uuid = [%s] request scope bean init "+this+"\r\n",uuid);
    }
    @PreDestroy
    public void destroy(){
        System.out.printf("uuid = [%s] request scope bean close "+this+"\r\n",uuid);
    }
}
