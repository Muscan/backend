package clinic.backend.middlewares;

import clinic.backend.exceptions.ConflictException;
import clinic.backend.responses.ErrorResponsePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorMiddleware {
    private final Logger logger = LoggerFactory.getLogger(ErrorMiddleware.class);

    @ExceptionHandler(ConflictException.class)
    public final ResponseEntity<ErrorResponsePayload> handleConflictException(ConflictException e) {
        this.logger.error("Conflict error", e);
        ErrorResponsePayload errorResponsePayload = new ErrorResponsePayload(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponsePayload);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponsePayload> handleInternalServerError(Exception e) {
        this.logger.error("Internal server error", e);
        ErrorResponsePayload errorResponsePayload = new ErrorResponsePayload(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponsePayload);
    }
}
