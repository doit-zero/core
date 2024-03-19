package hello.core.singlton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {
    @Test
    @DisplayName("싱글톤 테스트! 두개의 객체가 다를까? 같을까?")
    void singleton_test() throws Exception{
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        assertThat(memberService1).isNotSameAs(memberService2);
        // 테스트가 성공함으로 두 개의 객체가 따로 생성되었음을 알 수 있음
    }

    @Test
    @DisplayName("싱글톤 컨테이너 테스트")
    void singletonTest_test() throws Exception{

       SingletonService singletonService1 = SingletonService.getInstance();
       SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 : " + singletonService1);
        System.out.println("singletonService2 : " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    public void _test() throws Exception{
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println(memberService1);
        System.out.println(memberService2);

        // 따로 설정한 것이 없는데도 스프링 컨테이너에
        assertThat(memberService1).isSameAs(memberService2);

    }
}
