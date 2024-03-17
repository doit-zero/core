package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextBasicFindTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanName_test() throws Exception{
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
    @Test
    @DisplayName("빈 타입만으로 조회")
    void findBeanType_test() throws Exception{
        MemberService memberService = applicationContext.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    // 그러나 구현체 타입을 조회하는 것은 좋지 않은 왜냐하면 구현체는 바뀔 수 있기 때문에 역할을 알 수 있는 인터페이스로 조회하는 것이 좋음
    @Test
    @DisplayName("구체 타입만으로 조회")
    void findBeanName2_test() throws Exception{
        MemberServiceImpl memberService = applicationContext.getBean(MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입만으로 조회")
    void findBeanByNameX(){
        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> applicationContext.getBean("xx",MemberService.class)
        );
    }
}
