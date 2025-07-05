package SimpleMusicApp.Repository;

import SimpleMusicApp.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepositoryImpl extends JpaRepository<Comment, Long> {
}
