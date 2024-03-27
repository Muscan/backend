package clinic.backend.services;

import clinic.backend.dtos.requests.CreateRoleRequestDto;
import clinic.backend.dtos.responses.RoleResponseDto;
import clinic.backend.exceptions.ConflictException;
import clinic.backend.mappers.RoleMapper;
import clinic.backend.models.RoleModel;
import clinic.backend.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleMapper roleMapper;

    private final RoleRepository roleRepository;

    private final Logger logger = LoggerFactory.getLogger(RoleService.class);

    public RoleResponseDto create(CreateRoleRequestDto createRoleRequestDto)
    {
        String name = createRoleRequestDto.getName();

        this.logger.info("Attempt to create Role with name: {}", name);

        if(this.roleRepository.findByName(name).isPresent()) {
            throw new ConflictException("There is already a Role with the name: " + name);
        }

        RoleModel roleModel = this.roleMapper.toModel(createRoleRequestDto);

        RoleModel createdRoleModel = this.roleRepository.save(roleModel);

        return this.roleMapper.toDto(createdRoleModel);
    }
}
