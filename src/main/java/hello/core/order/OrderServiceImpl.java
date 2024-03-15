package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
      
      
      // 구체적인 것이 아닌 추상적인 것인 인터페이스에 의존함! 
      private final MemberRepository memberRepository;
      
      private final DiscountPolicy discountPolicy;
      
      
      // orderServiceImpl의 입장에서는 
      public OrderServiceImpl(MemberRepository memberRepository,DiscountPolicy discountPolicy)
      {
            this.memberRepository = memberRepository;
            this.discountPolicy = discountPolicy;
      }
      
      @Override
      public Order createOrder(Long memberId, String itemName, int itemPrice) {
            Member member = memberRepository.findById(memberId);
            int discountPrice = discountPolicy.discount(member,itemPrice);
            return new Order(memberId,itemName,itemPrice,discountPrice);
      }

      
}