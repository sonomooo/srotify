package SimpleMusicApp.controller;

import SimpleMusicApp.domain.Score;
import SimpleMusicApp.service.ScoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {

    ScoreService scoreService;

    //악보 조회 기능
    @PostMapping("/findScore")
    public String findScore(@RequestParam Score scoreName){
        scoreService.findScore(scoreName);
        return scoreName.getScoreName();
    }

    //악보 꺼내오기 기능
    @PostMapping("/getScore")
    public String getScore(@RequestParam Score scoreName){
       return scoreService.getScore(scoreName);

    }



}
