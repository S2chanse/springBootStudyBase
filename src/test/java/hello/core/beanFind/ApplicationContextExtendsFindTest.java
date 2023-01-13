package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입 조회 시, 자식이 중복이면 에러가 발생한다.")
    void findBeanByParentTypeDuplicate() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,()->applicationContext.getBean(DiscountPolicy.class));
    }
    @Test
    @DisplayName("부모 타입 조회 시, 자식이 중복이면 이름을 지정한다.")
    void findBeanByParentTypeBeanName() {

        DiscountPolicy rateDiscountPolicy=applicationContext.getBean("rateDiscountPolicy",DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);

    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubName() {
        DiscountPolicy rateDiscountPolicy=applicationContext.getBean(RateDiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 전체 조회하기")
    void findBeanByParentType() {
        Map<String,DiscountPolicy> dataStore= applicationContext.getBeansOfType(DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(dataStore.size()).isEqualTo(2);
        for (String s : dataStore.keySet()) {
            System.out.println("key = "+s+", object = "+applicationContext.getBean(s));
        }
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void findAllBeanByObjectType() {
        Map<String,Object> dataStore= applicationContext.getBeansOfType(Object.class);
        for (String s : dataStore.keySet()) {
            System.out.println("key = "+s+", object = "+applicationContext.getBean(s));
        }
    }

    @Configuration
    static class TestConfig{
        @Bean
        DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }

        @Bean
        DiscountPolicy fixedDiscountPolicy(){
            return  new FixDiscountPolicy();
        }
    }
}
