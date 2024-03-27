package clinic.backend;

import clinic.backend.dtos.requests.CreateRoleRequestDto;
import clinic.backend.dtos.responses.RoleResponseDto;
import clinic.backend.exceptions.ConflictException;
import clinic.backend.mappers.RoleMapper;
import clinic.backend.models.RoleModel;
import clinic.backend.repositories.RoleRepository;
import clinic.backend.services.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class RoleServiceTest {
    @Mock
    private RoleMapper roleMapper;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createRoleSuccess() {
        // Arrange
        CreateRoleRequestDto requestDto = new CreateRoleRequestDto();
        requestDto.setName("Admin");

        RoleModel roleModel = new RoleModel(); // Assume this is a model instance
        roleModel.setName("Admin");

        RoleResponseDto responseDto = new RoleResponseDto(); // Assume this is properly instantiated

        when(roleRepository.findByName(anyString())).thenReturn(Optional.empty());
        when(roleMapper.toModel(any(CreateRoleRequestDto.class))).thenReturn(roleModel);
        when(roleRepository.save(any(RoleModel.class))).thenReturn(roleModel);
        when(roleMapper.toDto(any(RoleModel.class))).thenReturn(responseDto);

        // Act
        RoleResponseDto createdRole = roleService.create(requestDto);

        // Assert
        verify(roleRepository, times(1)).save(any(RoleModel.class));
        // Further assertions can be added to check the correctness of the response
    }

    @Test
    void createRoleConflict() {
        // Arrange
        CreateRoleRequestDto requestDto = new CreateRoleRequestDto();
        requestDto.setName("Admin");

        RoleModel existingRole = new RoleModel(); // Assume this is a model instance
        existingRole.setName("Admin");

        when(roleRepository.findByName(anyString())).thenReturn(Optional.of(existingRole));

        // Act & Assert
        assertThrows(ConflictException.class, () -> roleService.create(requestDto));
    }
}