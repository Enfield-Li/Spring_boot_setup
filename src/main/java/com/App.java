package com;
import java.util.Optional;

import com.address.Address;
import com.address.AddressRepository;
import com.user.User;
import com.user.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext configContext = SpringApplication.run(App.class, args);

		AddressRepository addressRepo = configContext.getBean(AddressRepository.class);
		UserRepository userRepo = configContext.getBean(UserRepository.class);

		User newUser = new User("uesr one");
		Address newAddress = new Address("user one street");
		addressRepo.save(newAddress);
		
		newUser.setAddress(newAddress);	
		userRepo.save(newUser);

		Optional<User> userInfo = userRepo.findById(2L);
		Optional<Address> addressInfo = addressRepo.findById(1L);

		if (userInfo.isPresent() && addressInfo.isPresent()) {
			log.info("userInfo: " + userInfo.get().getName() + " lives in " + userInfo.get().getAddress().getStreet());
			log.info("addressInfo: " + addressInfo.get().getStreet());

			System.out.println("addressInfo: " + addressInfo.get().getStreet());
		}

	}
}
