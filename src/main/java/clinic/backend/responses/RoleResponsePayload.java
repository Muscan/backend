package clinic.backend.responses;

import clinic.backend.dtos.responses.RoleResponseDto;
import clinic.backend.enums.Severity;


public class RoleResponsePayload extends BaseResponsePayload {
    private final RoleResponseDto role;

    public RoleResponsePayload(String message, Severity severity, RoleResponseDto role) {
        super(message, severity);
        this.role = role;
    }

    public static RoleResponsePayload success(String message, RoleResponseDto role) {
        return new RoleResponsePayload(message, Severity.SUCCESS, role);
    }
}
