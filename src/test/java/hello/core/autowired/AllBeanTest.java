package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class, AutoAppConfig.class);
        DiscountService discountService = ac.getBean(DiscountService.class);

        Member member = new Member(1L,"joon",Grade.VIP);
        int discountPrice = discountService.discount(member,2000,"fixDiscountPolicy");
        assertThat(discountPrice).isEqualTo(1000);

        int discountPrice2 = discountService.discount(member,2000,"rateDiscountPolicy");
        assertThat(discountPrice2).isEqualTo(200);

    }
    static class DiscountService{
        private Map<String,DiscountPolicy> policyMap;
        private List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
        }

        public int discount(Member member, int price, String randomDiscountPolicy) {
            // 조회된 빈들의 MAP과 LIST를 응용해서 쓸 수 있음!
            DiscountPolicy discountPolicy = policyMap.get(randomDiscountPolicy);
            return discountPolicy.discount(member,price);
        }
    }
}
