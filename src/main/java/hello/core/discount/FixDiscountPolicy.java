package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
  private int discountFixAmount = 1000; // DiscountPolicy를 구현한 구현체. 회원에 따른 할인 가격을 반환함.
  
  @Override
  public int discount(Member member,int price) {
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    } else {
      return 0;
    }
  }

}