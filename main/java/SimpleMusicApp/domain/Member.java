package SimpleMusicApp.domain;

import SimpleMusicApp.DTO.MusicSampleInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    //private List<MusicSampleInfo> playlists = new ArrayList<>();


}