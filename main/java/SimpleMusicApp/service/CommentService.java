package SimpleMusicApp.service;

import SimpleMusicApp.Repository.CommentRepositoryImpl;
import SimpleMusicApp.Repository.PostRepositoryImpl;
import SimpleMusicApp.domain.Comment;
import SimpleMusicApp.domain.Member;
import SimpleMusicApp.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    PostRepositoryImpl postRepository;

    CommentRepositoryImpl commentRepository;


    public void createComment(Member member, String content, Long postId) {
        Post post = postRepository.findPostById(postId);

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setAuthor(member.getLoginId());  // 작성자 정보 연결
        comment.setPost(post);

        commentRepository.save(comment);
    }

}
