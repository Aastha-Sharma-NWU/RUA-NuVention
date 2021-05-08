package com.example.rua.configuration;

import com.example.rua.model.Users;
import com.example.rua.repository.UserRepository;
import com.sun.tools.javac.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


@Configuration
public class UserConfiguration {

//    @Bean
//    CommandLineRunner CommandLineRunner(UserRepository repository){
//        return args -> {
//         Users Charlotte=new Users("Charlotte","password","8989898989",2, LocalDate.of(2021,05,01));
//         Users Cesar=new Users("Cesar","password1","8989898980",2,LocalDate.of(2021,05,01));
//         Users Janea=new Users("Jiang","password3","8989898982",2,LocalDate.of(2021,05,01));
//            repository.saveAll(List.of(Charlotte,Cesar,Janea));
//        };
//
//
//    }



}
//        userList.add(new Users(1L,"Charlotte","password","8989898989",2, LocalDate.of(2021,05,01)));
//        userList.add(new Users(2L,"Cesar","password1","8989898980",2,LocalDate.of(2021,05,01)));
//        userList.add(new Users(3L,"Janea","password2","8989898981",2,LocalDate.of(2021,05,01)));
//        userList.add(new Users(4L,"Jiang","password3","8989898982",2,LocalDate.of(2021,05,01)));
//        userList.add(new Users(5L,"Hongxu","password4","8989898983",2,LocalDate.of(2021,05,01)));