package com.example.rua;

import com.example.rua.model.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RuaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuaApplication.class, args);
	}

}
