package SimpleMusicApp.controller;

import SimpleMusicApp.domain.Score;
import SimpleMusicApp.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/youtube")
public class YoutubeController {

    @Autowired
    YoutubeService youtubeService;

    @GetMapping("/getYoutubeScore")
    public Score getYoutubeScore(@RequestParam String songName){
        return youtubeService.getYoutubeScore(songName);
    }


}
