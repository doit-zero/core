package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
      // 구체적인 것이 아닌 추상적인 것인 인터페이스에 의존함! 
      private final MemberRepository memberRepository;
      private final DiscountPolicy discountPolicy;

      public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
            this.memberRepository = memberRepository;
            this.discountPolicy = discountPolicy;
      }

      @Override
      public Order createOrder(Long memberId, String itemName, int itemPrice) {
            Member member = memberRepository.findById(memberId);
            int discountPrice = discountPolicy.discount(member,itemPrice);
            return new Order(memberId,itemName,itemPrice,discountPrice);
      }

      // 싱글톤 테스트 용도
      public MemberRepository getMemberRepository(){
            return memberRepository;
      }

}