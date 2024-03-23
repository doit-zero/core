package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {
    @Test
    void prototypeBeanFind() throws Exception{
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("prototypeBean1 생성 전 확인 ");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean2 생성 전 확인 ");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        ac.close();
    }
    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        void init(){
            System.out.println("싱글톤 초기화");
        }
        @PreDestroy
        void destroy(){
            System.out.println("싱글톤 소멸");
        }
    }
}
