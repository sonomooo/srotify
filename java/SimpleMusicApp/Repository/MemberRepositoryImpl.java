package SimpleMusicApp.Repository;

import SimpleMusicApp.domain.LoginRequest;
import SimpleMusicApp.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepositoryImpl extends JpaRepository<Member,Long> {

    void save(LoginRequest loginRequest);

    LoginRequest deleteByloginId(String loginRequest);

    Member findByloginId(String loginRequest);

    LoginRequest findById(LoginRequest loginRequest);

}
