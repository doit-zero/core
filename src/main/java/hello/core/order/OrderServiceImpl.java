package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
      // OderService의 역할은 할인 정책이 반영된 주문으로 반환하는 것
      private final MemberRepository memberRepository = new MemoryMemberRepository();
      private DiscountPolicy discountPolicy;

      @Override
      public Order createOrder(Long memberId, String itemName, int itemPrice) {
            Member member = memberRepository.findById(memberId);
            int discountPrice = discountPolicy.discount(member,itemPrice);
            return new Order(memberId,itemName,itemPrice,discountPrice);
      }

}