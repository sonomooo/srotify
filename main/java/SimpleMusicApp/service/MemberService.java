package SimpleMusicApp.service;

import SimpleMusicApp.Repository.MemberRepositoryImpl;
import SimpleMusicApp.domain.LoginRequest;
import SimpleMusicApp.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepositoryImpl memberRepository;

    //member찾기 repository에서 대조
    public void registerMember(LoginRequest loginRequest) {

        Member member = new Member();
        member.setId(loginRequest.getId());
        member.setLoginId(loginRequest.getLoginId());
        member.setName(loginRequest.getName());
        member.setPassword(loginRequest.getPassword());
        memberRepository.save(member);

    }

    public Member readMember(LoginRequest loginRequest) {

        return memberRepository.findByloginId(loginRequest.getLoginId());

    }

    public void updateMember(LoginRequest loginRequest,
                             String username,
                             String userPassword) {

        LoginRequest member = memberRepository.findById(loginRequest);

        member.setName(username);
        member.setPassword(userPassword);

        memberRepository.save(member);
    }

    public void deleteMember(LoginRequest loginRequest) {

        memberRepository.deleteById(Long.valueOf(loginRequest.getLoginId()));

    }

    public boolean login(LoginRequest request) {

        System.out.println("호출되었습니다.");
        Member member = memberRepository.findByloginId(request.getLoginId());

        if (member == null) {
            System.out.println("등록되지 않은 회원입니다.");
            return false;
        }

        if (!member.getLoginId().equals(request.getLoginId())) {
            System.out.println("이름이 일치하지 않습니다.");
            return false;
        }

        return member.getPassword().equals(request.getPassword());
    }
}
