package SimpleMusicApp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Artist {

    @Id
    Long id;

    @Column
    String name;
}
