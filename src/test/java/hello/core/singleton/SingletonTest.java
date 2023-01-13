package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1.조회 : 요청 시, 객체를 생성

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);
    }

    @Test
    void singletonServiceTest() {
       SingletonService singletonService1 =  SingletonService.getInstance();
       SingletonService singletonService2 =  SingletonService.getInstance();

       Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 활용한 스프링 컨테이너")
    void springContainer() {
        ApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);

        //1.조회 : 요청 시, 객체를 생성

        MemberService memberService1 = applicationContext.getBean("memberService",MemberService.class);
        MemberService memberService2 = applicationContext.getBean("memberService",MemberService.class);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
