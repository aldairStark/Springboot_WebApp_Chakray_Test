package com.aldair.exam.springboot.webapp.springboot_web.Servicios;


import org.springframework.stereotype.Service;

import com.aldair.exam.springboot.webapp.springboot_web.Repository.UserRepository;
import com.aldair.exam.springboot.webapp.springboot_web.Utils.AES256;
import com.aldair.exam.springboot.webapp.springboot_web.Models.User;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.DeleteUserResponseDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.LoginRequestDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.LoginResponseDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UpdateResponseDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UpdateUserDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UserRequestDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UserResponseDto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;


@Service
public class UserService {

    private final UserRepository repository;
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public UserResponseDto CreateUser(UserRequestDto request){

                ValidateUniqueTax_Id(request.getTax_Id());

                UUID id = UUID.randomUUID();
                String created_at = GeneradorZonaMadagascar();
                String encrypPassword = AES256.Encrypt(request.getPassword());
                User user = new User(
                                        id,
request.getEmail(),
request.getName(),
request.getPhone(),
encrypPassword,
request.getTax_Id(),
created_at,
request.getAddresses()

                );
 User saveUser =repository.save(user);

return RespuestaMapeadaUser(user);
    }
    /* public List<User> getUsers(String sortedBy){

    List<User> users = repository.findAll();
        if(sortedBy == null || sortedBy.isBlank()){
            return users;
        }
        switch(sortedBy){
            case "Email":
                users.sort(Comparator.comparing(User::getEmail));
                break;
            case "Name":
                users.sort(Comparator.comparing(User::getName));
                break;
            case "Phone":
                users.sort(Comparator.comparing(User::getPhone));
                break;
            case "Tax_Id":
                users.sort(Comparator.comparing(User::getTax_Id));
                break;
            case "Created_at":
                users.sort(Comparator.comparing(User::getCreated_at));
                break;
            case "Id":
                users.sort(Comparator.comparing(User::getId));
                break;
            default: throw new IllegalArgumentException("Invalid sortedby field");

        }
        return users;

    }
 */
    public List<UserResponseDto> getUsers(String sortedBy,String filter){
{ 

    List<User> users = repository.findAll();
    if(filter != null && !filter.isBlank()){
        users=FiltroParametros(users,filter);

    } 
    
    if(sortedBy != null && !sortedBy.isBlank()){
            users=FiltroOrdenadorOfFields(users,sortedBy);
        }
       
        return users.stream().map(this::RespuestaMapeadaUser).toList();

        }
    }
    public UpdateResponseDto UpdateUser(UUID id, UpdateUserDto request){
       
       System.out.println("ID recibido en el servicio: " + id);
              
      
        User user = repository.findAll().stream().filter(u->u.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        if(request.getName() != null){
                user.setName(request.getName());
        }
         if(request.getPhone() != null){
                user.setPhone(request.getPhone());
        }
         if(request.getPassword() != null){
                user.setPhone(AES256.Encrypt(request.getPassword()));
        }
        UserResponseDto response =  RespuestaMapeadaUser(user);
        
        return new UpdateResponseDto( 
            GeneradorZonaMadagascar().toString(),
            "Update User",
            user.getTax_Id().toString(),
            response );
 
    
    }
   //Delete User
    public DeleteUserResponseDto DeleteUser(UUID id){

         User user = repository.findAll().stream().filter(u->u.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        boolean eliminado = repository.findAll().removeIf(u->u.getId().equals(id));

        if(!eliminado){
            throw new IllegalArgumentException("Usuario No eliminado");
        }
          UserResponseDto response =  RespuestaMapeadaUser(user);
        
        return new DeleteUserResponseDto( 
            GeneradorZonaMadagascar().toString(),
            "Ok 200 delete user",
            user.getTax_Id().toString(),
            response );

    }
    
    //Servicio de Login
    public LoginResponseDto Login(LoginRequestDto request){
        User user = repository.findAll().stream().filter(u->u.getTax_Id().equals(request.getTaxtId())).findFirst().orElseThrow(()-> new IllegalArgumentException("Usuario no encontrado"));

        String encryptedPass = AES256.Encrypt(request.getPassword());
        if (!user.getPassword().equals(encryptedPass)) {
            throw new IllegalArgumentException("Password incorrecto");
        }

      

        return new LoginResponseDto(
              GeneradorZonaMadagascar().toString(),
              "OK 200 login exitoso",
              user.getTax_Id(),
              UUID.randomUUID().toString());
    }
    
    
    /////////////***************************HELPERS***************************** */
    
    
    
    //este es el filtro de los parametros
    private List<User> FiltroParametros(List<User> users, String filter){
            //la url viene con + esto a su vez devu3elve un error por lo que debemos poner un espacio
            String[] parts = filter.split(" ");

        if(parts.length != 3){
                    throw new IllegalArgumentException("formato no valido para el filtro");
        }
           String field = parts[0];
           String operador = parts[1];
           String value =parts[2];
           
           //retornamos la cadena evaluar con break point
           return users.stream().filter(user -> matches(user,field,operador,value)).toList();
}
            //vamos a crear una funcion de match de valores
     private boolean matches(User user, String field, String operador, String value){
                        String fieldValue;
                switch(field){
                            case"Name":
                            fieldValue = user.getName();
                            break;
                             case"Email":
                            fieldValue = user.getEmail();
                            break;
                             case"Phone":
                            fieldValue = user.getPhone();
                            break;
                             case"Tax_Id":
                            fieldValue = user.getTax_Id();
                            break;
                            default:throw new IllegalArgumentException("Valor incorrecto en el match");
                }
                return FiltroOperador(fieldValue,operador,value);
            }
     private boolean FiltroOperador(String fileValue, String operador,String value){

            //Aqui viene la evaluacion de co, ew, sw, eq
        switch(operador){
                
            case "co":
                return fileValue.contains(value);
            case "ew":
                 return fileValue.endsWith(value);
            case "sw":
                   return fileValue.startsWith(value);
            case "eq":
                 return fileValue.equals(value);
            default:
                throw new IllegalArgumentException("Operador Invalido");
            }

        }
     private List<User> FiltroOrdenadorOfFields(List<User> users,String sortedBy){
            switch(sortedBy){
                    case "Name":
                        users.sort(Comparator.comparing(User::getName));
                        break;
                    case "Email":
                        users.sort(Comparator.comparing(User::getEmail));
                        break;
                    case "Phone":
                        users.sort(Comparator.comparing(User::getPhone));
                        break;
                    case "Tax_Id":
                        users.sort(Comparator.comparing(User::getTax_Id));
                        break;
                    case "Created_at":
                        users.sort(Comparator.comparing(User::getCreated_at));
                        break;
                    case "Id":
                        users.sort(Comparator.comparing(User::getId));
                        break;
                    default: throw new IllegalArgumentException("Campo para Ordenar Invalido");

            }
            return users;
        }
     
     
     private void ValidateUniqueTax_Id(String taxtId){
        boolean exist = repository.findAll().stream().anyMatch(u->u.getTax_Id().equals(taxtId));
        if(exist){
                throw new IllegalArgumentException("RFC existe en base de datos");
        }
     }
     private String GeneradorZonaMadagascar(){
        ZoneId zone = ZoneId.of("Indian/Antananarivo");
        LocalDateTime now = LocalDateTime.now(zone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return now.format(formatter);
     }
     private UserResponseDto RespuestaMapeadaUser(User user){
        return new UserResponseDto(

            user.getId(),
            user.getEmail(),
            user.getName(),
            user.getPhone(),
            user.getTax_Id(),
            user.getCreated_at(),
            user.getAddresses()
        );
    }

}


