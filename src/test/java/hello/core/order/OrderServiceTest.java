package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void 주문_test() throws Exception{
        Long memberId = 1L;
        Member member = new Member(memberId,"testMember", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(),"testItem",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
