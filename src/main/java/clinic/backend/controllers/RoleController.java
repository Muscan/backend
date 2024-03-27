package clinic.backend.controllers;

import clinic.backend.dtos.requests.CreateRoleRequestDto;
import clinic.backend.dtos.responses.RoleResponseDto;
import clinic.backend.responses.RoleResponsePayload;
import clinic.backend.services.RoleService;
import clinic.backend.utils.LocationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResponseDto> create(@RequestBody CreateRoleRequestDto createRoleRequestDto)
    {
        RoleResponseDto roleResponseDto = this.roleService.create(createRoleRequestDto);
        System.out.println(roleResponseDto);
        URI location = LocationUtils.getLocationUri(roleResponseDto.getId());
        return ResponseEntity.created(location).body(roleResponseDto);
    }
}
