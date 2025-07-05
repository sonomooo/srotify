package SimpleMusicApp.service;

import SimpleMusicApp.DTO.YoutubeMusicBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class YoutubeGetMusicService {

    @Autowired
    WebClient webClient;

    @Value("${youtube.apikey}")
    private String youtubeApiKey;

    public YoutubeMusicBox getYoutubeMusic(String songName){

        System.out.println(youtubeApiKey);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("www.googleapis.com")
                .path("/youtube/v3/search")
                                .queryParam("part","snippet")
                        .queryParam("q",songName)
                        .queryParam("type","video")
                        .queryParam("key", youtubeApiKey)
                                .queryParam("videoCategoryId",10)
                        .build()
                )
                .header("Authorization", "Bearer " +youtubeApiKey)
                .retrieve()
                .bodyToMono(YoutubeMusicBox.class)
                .block();
    }
}
