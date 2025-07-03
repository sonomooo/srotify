package SimpleMusicApp.service;

import SimpleMusicApp.DTO.SpotifySearchResponse;
import SimpleMusicApp.DTO.SpotifyTokenResponse;
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
        System.out.println("토큰 호출완료");

        SpotifyTokenResponse response = webClient
                .post()
                .uri("/api/token")
                .header("Content-Type","application/x-www-form-urlencoded")
                .body(BodyInserters
                        .fromFormData("grant_type","client_credentials")
                        .with("client_secret", clientSecret)
                        .with("client_id",clientId)
                )
                .retrieve()
                .bodyToMono(SpotifyTokenResponse.class)
                .block();

        return response.getAccess_token();

    }

    public SpotifySearchResponse searchMusic(String oneHourToken, String musicName) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("api.spotify.com")
                        .path("/v1/search")
                        .queryParam("q", musicName)
                        .queryParam("type", "track")
                        .build())
                .header("Authorization", "Bearer " + oneHourToken)
                .retrieve()
                .bodyToMono(SpotifySearchResponse.class)
                .block();
    }
}
