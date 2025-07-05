package SimpleMusicApp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private Long id;
    private String loginId;
    private String name;
    private String password;

}
