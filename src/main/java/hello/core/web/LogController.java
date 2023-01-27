package hello.core.web;

import hello.core.common.MyLogger;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogController {

    private final LpogDemoService logDemoService;
    private final   ObjectProvider<MyLogger> myLoggerObjectProvider;

    public LogController(LpogDemoService logDemoService, ObjectProvider<MyLogger> myLoggerObjectProvider) {
        this.logDemoService = logDemoService;
        this.myLoggerObjectProvider = myLoggerObjectProvider;
    }

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest httpServletRequest){
        String url = httpServletRequest.getRequestURL().toString();
        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.setRequestURL(url);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "200";
    }
}
