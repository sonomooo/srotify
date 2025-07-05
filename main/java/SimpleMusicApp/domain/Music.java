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
public class Music {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String artist;
    private String album;
    private String albumImageUrl;
    private String previewUrl;
}
