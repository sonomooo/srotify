package SimpleMusicApp.service;

import SimpleMusicApp.domain.Score;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class YoutubeService {

    @Value("${youtube.apikey}")
    private String apikey;


    private final WebClient webClient;

    public YoutubeService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://www.googleapis.com/youtube/v3")
                .build();
    }

    public Score getYoutubeScore(String songName){

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("part", "snippet")
                        .queryParam("q", songName + " guitarTab")
                        .queryParam("type", "video")
                        .queryParam("maxResults", 5)
                        .queryParam("key", apikey)
                        .build()
                )
                .retrieve()
                .bodyToMono(Score.class)
                .block();
    }

        /*return webClient
                .get()
                .uri("/search?key="+apikey+"q="+songname)
                .retrieve()
                .bodyToMono(Score.class)
                .block();
    }*/

}
