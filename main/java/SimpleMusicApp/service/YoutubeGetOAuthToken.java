package SimpleMusicApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class YoutubeGetOAuthToken {

    @Autowired
    public YoutubeGetOAuthToken(WebClient webClient) {
        this.webClient = webClient;
    }

    WebClient webClient;

    @Value("${youtube.ClientId}")
    private String youtubeClientID;

    @Value("${youtube.apikey}")
    private String youtubeApiKey;

    @Value("${clientID}")
    private String clientID;

    public String getOAuth() {

        String redirectUrl = "https://oauth.pstmn.io/v1/callback";
        String scope = "https://www.googleapis.com/auth/youtube.readonly";

        String authUrl = "https://accounts.google.com/o/oauth2/v2/auth"
                + "?client_id=" + youtubeClientID
                + "&redirect_uri=" + redirectUrl
                + "&response_type=code"
                + "&scope=" + URLEncoder.encode(scope, StandardCharsets.UTF_8)
                + "&access_type=offline"
                + "&prompt=consent";

        System.out.println("사용자에게 이 URL을 열도록 유도하세요:");
        System.out.println(authUrl);
        return clientID;
    }

    public String getAccessToken(String authCode) throws IOException, InterruptedException {
        String clientId = youtubeClientID;
        String clientSecret = youtubeClientID;
        String redirectUri = "https://yourapp.com/oauth2/callback"; // Postman이라면 그 주소

        HttpClient httpClient = HttpClient.newHttpClient();

        String requestBody = "code=" + URLEncoder.encode(authCode, StandardCharsets.UTF_8)
                + "&client_id=" + clientId
                + "&client_secret=" + clientSecret
                + "&redirect_uri=" + redirectUri
                + "&grant_type=authorization_code";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://oauth2.googleapis.com/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("응답: " + response.body());

        return response.body(); // 여기에 access_token, refresh_token 등이 JSON으로 포함됨
    }

}