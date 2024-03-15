package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
  // DiscountPolicy의 역할은 회원에 따른 할인 값을 반환하는 것.
  int discount(Member member, int price);
  
}