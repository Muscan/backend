package clinic.backend.mappers;

import clinic.backend.dtos.requests.CreateRoleRequestDto;
import clinic.backend.dtos.responses.RoleResponseDto;
import clinic.backend.models.RoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "users", ignore = true)
    RoleModel toModel(CreateRoleRequestDto createRoleRequestDto);

    RoleResponseDto toDto(RoleModel roleModel);
}
