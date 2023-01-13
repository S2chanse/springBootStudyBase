package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인")
    void vipDiscount() {
        int result = discountPolicy.discount(new Member(1L,"A", Grade.VIP),10000);
        Assertions.assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("일반 고객")
    public void dummy() {
        int result = discountPolicy.discount(new Member(1L,"A", Grade.BASIC),10000);
        Assertions.assertThat(result).isEqualTo(0);
    }
}