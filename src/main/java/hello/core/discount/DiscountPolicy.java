package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     * 
     * @param member 고객
     * @param price  총 지불액
     * @return 할인 된 총 지불액
     */
    int discount(Member member,int price);
}
