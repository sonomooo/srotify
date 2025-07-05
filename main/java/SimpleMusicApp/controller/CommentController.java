package SimpleMusicApp.controller;

import SimpleMusicApp.DTO.CommentRequest;
import SimpleMusicApp.domain.Member;
import SimpleMusicApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    //유저가 댓글을 다는 기능 > 유저 정보와 댓글 정보가 필요
    /*public void createUserComment(Member member,
                            Comment comment){

        commentService.createComment(member);
        commentService.createComment(comment);

    } */

    @PostMapping("/createComments")
    public ResponseEntity<?> createComment(@RequestBody CommentRequest request,
                                           @AuthenticationPrincipal Member member) {
        commentService.createComment(member, request.getContent(), request.getPostId());
        return ResponseEntity.ok("댓글 작성 완료");
    }

}
