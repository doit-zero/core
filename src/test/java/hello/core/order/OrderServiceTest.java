package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
   
   // 각각의 테스트를 실행하기 전에 무조건 실행되는 것
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService;
        OrderService orderService = appConfig.orderService;
    }
    @Test
    public void 주문_test() throws Exception{
        Long memberId = 1L;
        Member member = new Member(memberId,"testMember", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(),"testItem",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
