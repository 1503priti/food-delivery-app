package com.elisha.userinfo;

import com.elisha.userinfo.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserInformationApplication.class, args);
		User user = new User();
	}


}
