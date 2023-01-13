package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        memberService.join(new Member(1L,"A", Grade.VIP));

        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);
        Order order = orderService.createOrder(1L,"item A",20000);
        System.out.format("%s \r\n",order.toString());
        System.out.format("%d",order.calculatePrice());
    }
}
