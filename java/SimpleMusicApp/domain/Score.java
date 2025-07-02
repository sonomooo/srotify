package SimpleMusicApp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Score {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String scoreName;

    @Column
    private String scoreContext;


}
