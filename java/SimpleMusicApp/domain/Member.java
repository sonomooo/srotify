package SimpleMusicApp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    private Long id;

    @Column
    String loginId;

    @Column(nullable = false)
    private String password;

    @Column
    private String name;
}