package clinic.backend.responses;

import clinic.backend.enums.Severity;

public class ErrorResponsePayload extends BaseResponsePayload {
    public ErrorResponsePayload(String message) {
        super(message, Severity.ERROR);
    }
}