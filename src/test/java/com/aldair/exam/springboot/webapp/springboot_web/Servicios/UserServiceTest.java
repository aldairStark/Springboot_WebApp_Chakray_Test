package com.aldair.exam.springboot.webapp.springboot_web.Servicios;
import com.aldair.exam.springboot.webapp.springboot_web.Models.User;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.DeleteUserResponseDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UpdateResponseDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UpdateUserDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UserRequestDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UserResponseDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.aldair.exam.springboot.webapp.springboot_web.Repository.UserRepository;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
     void shouldReturnEmptyListWhenNoUsersExist(){
                    when(userRepository.findAll()).thenReturn(List.of());
       
            List<UserResponseDto> result = userService.getUsers(null,null);       
            assertTrue(result.isEmpty());

            verify(userRepository,times(1)).findAll();
    }
    @Test 
     void shouldCreateUserSuccessfully(){
       
        // ARRANGE
        UserRequestDto request = new UserRequestDto();
        request.setName("Jose Aldair");
        request.setEmail("aldair@hotmail.com");
        request.setPassword("123456");
        request.setTax_Id("XXXQAAA12");
        request.setPhone("1234567890");
        request.setAddresses(List.of());

        User savedUser = new User();
        savedUser.setName("Jose Aldair");
        savedUser.setEmail("aldair@hotmail.com");

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

        // ACT
        UserResponseDto response = userService.CreateUser(request);

        // ASSERT
        verify(userRepository, times(1)).save(userCaptor.capture());

        User capturedUser = userCaptor.getValue();

        // Validar datos mapeados
        assertEquals("Jose Aldair", capturedUser.getName());
        assertEquals("aldair@hotmail.com", capturedUser.getEmail());

        // Validar que se generó ID y fecha
        assertNotNull(capturedUser.getId());
        assertNotNull(capturedUser.getCreated_at());

        // Validar que contraseña no es texto plano
        assertNotEquals("123456", capturedUser.getPassword());

        // Validar respuesta
        assertNotNull(response);
        assertEquals("Jose Aldair", response.getName());
}    
    @Test
     void shouldUpdateUserSuccessfully(){
      
       UUID userId = UUID.randomUUID();
   

    User existingUser = new User(
            userId,
            "antiguo@test.com",
            "Antiguo Name",
            "1234567890",
            "contraseñaencriptada",
            "XXXX000000",
            "2026-01-01",
            List.of()
    );

    when(userRepository.findAll())
            .thenReturn(List.of(existingUser));

    UpdateUserDto request = new UpdateUserDto();
    request.setName("Nuevo Name");
    request.setPhone("9999999999");

  
    UpdateResponseDto response =
            userService.UpdateUser(userId, request);

    
    assertNotNull(response);
    assertEquals("Update User", response.getMessage());

    assertEquals("Nuevo Name", existingUser.getName());
    assertEquals("9999999999", existingUser.getPhone());

    verify(userRepository, times(1)).findAll();
    }
    @Test
     void shouldThrowExceptionWhenUserNotfoundOnUpdate(){
        when(userRepository.findAll())
            .thenReturn(List.of()); 

    UpdateUserDto request = new UpdateUserDto();
    request.setName("Nuevo Name");

    UUID randomId = UUID.randomUUID();

    RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> userService.UpdateUser(randomId, request)
    );

    assertEquals("No existe usuario", exception.getMessage());

    verify(userRepository, times(1)).findAll();
    }      
     @Test
     void shouldDeleteUserSuccessfully(){
         UUID userId = UUID.randomUUID();

    User existingUser = new User(
            userId,
            "aldair@test.com",
            "Aldair",
            "1234567890",
            "contraseñaencriptada",
            "XXXQAAA12",
            "2026-01-01",
            List.of()
    );

    when(userRepository.findAll())
            .thenReturn(List.of(existingUser));

  
    doNothing().when(userRepository).delete(existingUser);
   
    DeleteUserResponseDto response =
            userService.DeleteUser(userId);

   
    assertNotNull(response);
    assertEquals("User deleted successfully", response.getMessage());

    verify(userRepository, times(1)).findAll();
    verify(userRepository, times(1)).delete(existingUser);
     }
     @Test
     void shouldThrowExceptionWhenUserNotFoundOnDelete(){
      
             when(userRepository.findAll())
                        .thenReturn(List.of()); 

             UUID randomId = UUID.randomUUID();

            RuntimeException exception = assertThrows(
                    RuntimeException.class,
                         () -> userService.DeleteUser(randomId));

        assertEquals("User not found", exception.getMessage());

    verify(userRepository, times(1)).findAll();

    verify(userRepository, never()).delete(any(User.class));
     }
}
