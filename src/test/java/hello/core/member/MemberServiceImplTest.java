package hello.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {
/*    private  MemberRepository memberRepository;
    private final MemberService memberService;*/
    @Test
    void join() {
        //given
        Member member = new Member(1L,"A",Grade.VIP);
        //when
        /*memberService.join(member);
        memberService.join(new Member(2L,"B",Grade.VIP));
        Member result = memberService.findMember(2L);*/
        //then
        //Assertions.assertThat(member).isEqualTo(result);
    }
}