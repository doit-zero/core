package hello.core.order;

public interface OrderService{
      // OrderService 의 역할은 멤버아이디,아이템이름,아이템 가격을 받아서 주문을 생성하는 것임
     Order createOrder(Long memberId,String itemName, int itemPrice);
}