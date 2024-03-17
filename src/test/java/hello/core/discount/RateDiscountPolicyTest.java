package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    // 정말 10% 할인이 되는지 테스트 하기 위함임
     DiscountPolicy discountPolicy = new RateDiscountPolicy();

     @Test
     @DisplayName("VIP고객이 10%할인 가격 할인을 받는지 확인")
     public void vip_o_test() throws Exception{
        Member member = new Member(1L,"test",Grade.VIP);
        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(1000);
     }
    // 성공 테스트도 중요하지만 꼭 실패 테스트도 만들어야한다.
    @Test
    @DisplayName("Basic 고객은 할인은 못 받는지 확인")
    public void vip_x_test() throws Exception{
    //given
        Member member = new Member(2L,"test2",Grade.BASIC);
    //when
        int discount = discountPolicy.discount(member,1000);
    //then
        assertThat(discount).isEqualTo(0);
    }
}