package SimpleMusicApp.exception;

public enum CustomErrorCode {

    MUSIC_NOT_FOUND("음악이 존재하지 않습니다.");

    private final String statusMessage;
    CustomErrorCode(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    public String getStatusMessage() {
        return statusMessage;
    }


}
