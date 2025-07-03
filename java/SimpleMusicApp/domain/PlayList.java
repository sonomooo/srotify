package SimpleMusicApp.domain;

import SimpleMusicApp.DTO.MusicSampleInfo;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

    //식별자
    private Long id;

    //기본 스펙
    private String name;
    private String coverImageUrl;

    //멤버와 연결
    @ManyToOne
    private Member member;

    //음악 리스트
    @ManyToMany
    private List<MusicSampleInfo> musics = new ArrayList<>();

}
