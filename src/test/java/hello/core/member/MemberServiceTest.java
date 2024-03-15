package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    
    
    // 각각의 테스트를 실행하기 전에 무조건 실행되는 것
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService;
    }
    
    
    @Test
    public void join_test() throws Exception{
    //given
        Member member = new Member(1L,"memberTest1",Grade.VIP);
    //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

    //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
    
}
