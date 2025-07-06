package SimpleMusicApp.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class MusicException extends RuntimeException {


    private CustomErrorCode customErrorCode;
    private String detailMessage;

    public MusicException(CustomErrorCode customErrorCode){
        super(customErrorCode.getStatusMessage());
        this.customErrorCode = customErrorCode;
        this.detailMessage = customErrorCode.getStatusMessage();
    }



}
