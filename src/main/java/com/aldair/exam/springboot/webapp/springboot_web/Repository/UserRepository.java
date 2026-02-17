package com.aldair.exam.springboot.webapp.springboot_web.Repository;
import org.springframework.stereotype.Repository;

import com.aldair.exam.springboot.webapp.springboot_web.Models.User;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Address;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import scala.Array;

@Repository
public class UserRepository {

private final List<User> users = new ArrayList<>();

public UserRepository(){
    //
    CargaInicialUsuarios();
}
    private void CargaInicialUsuarios(){

    List<Address> addresses = List.of(
        new Address(1L,"Direccion Trabajo", "Roma Sur ","Mx"),
        new Address(2L,"Direccion Casa", "sur 121, oriente 116 Juventino Rosas","Mx")
    );
 List<Address> addresses2 = List.of(
        new Address(1L,"Direccion Trabajo", "Contepec ","Mx"),
        new Address(2L,"Direccion Casa", "Agua caliente","Mx")
    );
     List<Address> addresses3 = List.of(
        new Address(1L,"Direccion Trabajo", "Atlacomulco Estado de México","Mx"),
        new Address(2L,"Direccion Casa", "El oro Estado de México","Mx")
    );
    User user1 =new User(
        UUID.randomUUID(),
        "gorilla@gmail.com",
        "Jose Aldair",
        "+52 5523448943",
        "Cosmo123*!",
        "AARR990101XXX",
        "15-02-2026",
        addresses
    );
      User user2 =new User(
        UUID.randomUUID(),
        "gorilla@gmail.com",
        "Casandro MONTIEL",
        "+52 5523448943",
        "Cosmo123*!",
        "AARR990101XXX",
        "15-02-2026",
        addresses2
    );
        User user3 =new User(
        UUID.randomUUID(),
        "gorilla@gmail.com",
        "Alejandra maldonado",
        "+52 5523448943",
        "Cosmo123*!",
        "AARR990101XXX",
        "15-02-2026",
        addresses3
    );
    users.add(user1);   
      users.add(user2);  
            users.add(user3);  
  }
    public List<User> findAll(){
    return users;
}
    public User save(User user){
        users.add(user);
        return user;
    }
    public void delete(User user){
        users.remove(user);
    }
}
