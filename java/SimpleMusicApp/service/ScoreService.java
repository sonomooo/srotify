package SimpleMusicApp.service;

import SimpleMusicApp.Repository.ScoreRepository;
import SimpleMusicApp.domain.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    //악보 찾기 기능 -> 악보를 모두 찾을 수 있게 해줌 리스트?
    public Score findScore(Score score){
      return scoreRepository.findByScoreName(score.getScoreName());
    }

    //악보 불러오기 기능
    public String getScore(Score score){
        Score wantScore = scoreRepository.findByScoreName(score.getScoreName());
        return wantScore.getScoreContext();
    }

}
