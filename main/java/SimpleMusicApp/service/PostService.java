package SimpleMusicApp.service;

import SimpleMusicApp.DTO.PostDTO;
import SimpleMusicApp.Repository.PostRepositoryImpl;
import SimpleMusicApp.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepositoryImpl postRepository;

    public void LinkMusicPost(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        postRepository.save(post);
    }

}
