package clinic.backend.responses;

import clinic.backend.enums.Severity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponsePayload {
    private final String message;
    private final Severity severity;
    public String getSeverity() { return this.severity.name().toLowerCase();}
}
