package SimpleMusicApp.service;

import SimpleMusicApp.domain.Music;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SpotifyApiService {

    @Value("${spotify.client-id}")
    private String clientId;

    @Value("${spotify.client-secret}")
    private String clientSecret;


    private final WebClient webClient;

    public SpotifyApiService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://accounts.spotify.com")
                .build();
    }

    public String getSpotifyToken(){
        System.out.println("호출완료");

        return webClient
                .post()
                .uri("/api/token")
                .header("Content-Type","application/x-www-form-urlencoded")
                .body(BodyInserters
                        .fromFormData("grant_type","client_credentials")
                        .with("client_secret", clientSecret)
                        .with("client_id",clientId)
                )
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public Music searchMusic(String oneHourToken, String musicName) {

        return webClient.get()
                .uri("https://api.spotify.com/v1/albums/"+musicName)
                .header("Authorization:","Bearer Token " +oneHourToken)
                .retrieve()
                .bodyToMono(Music.class)
                .block();
    }


}
