package hello.core.order;

public class OrderServiceImpl implements OderService{
      
      private final MemberRepository memberRepository = new MemberRepository();
      private final DiscountPolicy discountPolicy = new DiscountPolicy();
      
      // Override 설정해야함
      
}