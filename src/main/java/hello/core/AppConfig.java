package hello.core;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class AppConfig {
      
      // MemberServieImpl 구현체가 생성될 때, MemberRepository 상속받은 repository 구현체를 주입함
      public MemberService memberService(){
            return new MemberServiceImpl(new MemoryMemberRepository());
      }
      
     public OrderServie orderService(){
           return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
     }
}