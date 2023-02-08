package hello.core.web;

import hello.core.common.MyLogger;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LpogDemoService {
    private final MyLogger myLogger;

    public LpogDemoService(MyLogger myLogger) {
        this.myLogger = myLogger;
    }

    public void logic(String testId) {
        myLogger.log("service id = "+testId);
    }
}
