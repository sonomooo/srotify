package SimpleMusicApp.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(MusicException.class)
    public CustomErrorResponse handleException(MusicException m,
                                               HttpServletRequest httpServletRequest
                                               ){
        log.error("errorCode : {}, url {}, message : {}",
                m.getMessage(),httpServletRequest.getRequestURI(),m.getCause());
        return CustomErrorResponse.builder().build();
    }
}
