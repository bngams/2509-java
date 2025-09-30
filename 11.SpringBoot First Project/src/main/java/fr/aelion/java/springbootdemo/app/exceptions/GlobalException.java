package fr.aelion.java.springbootdemo.app.exceptions;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public abstract class GlobalException extends Exception {

    protected final ApiErrorCode ERROR_CODE;

    // msg falculatif
    public GlobalException(ApiErrorCode error_code) {
        super(error_code.getMsg()); // message generique du error code
        this.ERROR_CODE = error_code;
        this.logError();
    }

    public GlobalException(ApiErrorCode error_code, String msg) {
        super(msg);
        this.ERROR_CODE = error_code;
        this.logError();
    }

    private void logError() {
        log.error(this.ERROR_CODE.getCode() + " - " + this.getMessage());
    }

    /**
     * Convert current exception to an ApiError object (useful for client side)
     * @return ApiError
     */
    public ApiError toApiError() {
        return new ApiError(this.ERROR_CODE.getCode(), this.getMessage());
    }
}
