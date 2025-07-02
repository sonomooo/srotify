package SimpleMusicApp.service;

import SimpleMusicApp.domain.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//MusicService는 api연결을 통해서 음악을 가져오도록 한다.
//저장이 아닌 조회! 따라서 DB 및 Repository의 활용이 필요없다.
@Service
public class MusicService {

    @Autowired
    SpotifyApiService spotifyApiService;

    public Music findMusic(String musicName, String apiKey) {

        Music key = spotifyApiService.searchMusic(apiKey, musicName);

        System.out.println(key.getMusicName());

        return key;
    }
}
