package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // MemberRepository 추상에만 의존하면 됨! 구체 클래스에 대해서 몰라도 된다!
    private final MemberRepository memberRepository;

    // MemberServieImpl 입장에서는 어떤 memberRepository 객체가 들어올지 모름
    // 다형성에 의해서 MemberRepository 인테페이스를 상속받은 다양한 객체가 들어올 수 있음
    // 어떤 객체가 주입 될지는 오직 AppConfig에서 결정된다.
    // MemverServiceImpl은 이제부터 의존관계에 대한 고민은 외부에 맡기고, 실행에만 집중하면 됨!!

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 싱글톤 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
