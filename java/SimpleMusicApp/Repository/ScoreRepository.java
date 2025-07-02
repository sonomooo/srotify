package SimpleMusicApp.Repository;

import SimpleMusicApp.domain.Score;
import SimpleMusicApp.service.ScoreService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    Score findByScoreName(String scoreName);


}
