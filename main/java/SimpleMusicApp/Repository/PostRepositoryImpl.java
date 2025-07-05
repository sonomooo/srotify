package SimpleMusicApp.Repository;

import SimpleMusicApp.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryImpl extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.id = :id")
    Post findPostById(@Param("id") Long id);





}
