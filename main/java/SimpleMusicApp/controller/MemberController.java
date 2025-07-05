package SimpleMusicApp.controller;

import SimpleMusicApp.domain.LoginRequest;
import SimpleMusicApp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        boolean success = memberService.login(request);
        if (success) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }

    @PostMapping("/create")
    public void create(@RequestBody LoginRequest loginRequest){
        memberService.registerMember(loginRequest);
    }

    @GetMapping("/read")
    public void read(@RequestBody LoginRequest loginRequest){

        memberService.readMember(loginRequest);

    }

    @PostMapping("/update")
    public void update(LoginRequest loginRequest,
                       @PathVariable String username,
                       @PathVariable String userPassword){
        memberService.updateMember(loginRequest,username,userPassword); // 참조값을 넘긴다.!!
    }

    @PostMapping("/delete")
    public void delete(LoginRequest loginRequest){
        memberService.deleteMember(loginRequest);
    }

}