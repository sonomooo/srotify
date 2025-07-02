package SimpleMusicApp.controller;

import SimpleMusicApp.DTO.PostDTO;
import SimpleMusicApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/post")
@RestController
public class PostController { //post 기본 화면 -> 음악 게시판 만들기

    @Autowired
    PostService postService;

    @PostMapping("/musicPost")
    public ResponseEntity<String> musicPost(@RequestBody PostDTO postDTO) {
        System.out.println("받은 제목: " + postDTO.getTitle());
        System.out.println("받은 내용: " + postDTO.getContent());
        postService.LinkMusicPost(postDTO);
        return ResponseEntity.ok("음악 포스트 연결 완료");
    }


}
