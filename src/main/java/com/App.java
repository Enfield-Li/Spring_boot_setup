package com;
import java.util.Optional;

import com.Person.Person;
import com.Person.PersonRepository;
import com.car.Car;
import com.car.CarRepository;
import com.owner.Owner;
import com.owner.OwnerRepository;

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

		PersonRepository personRepo = configContext.getBean(PersonRepository.class);

		Person newPerson = new Person("p1 firstName", "p1 lastName");
		personRepo.save(newPerson);	
		// personRepo.deleteAll();

		CarRepository carRepo = configContext.getBean(CarRepository.class);
		OwnerRepository ownerRepo = configContext.getBean(OwnerRepository.class);

		Car newCar = new Car("model S");
		carRepo.save(newCar);

		Owner newOwner = new Owner("owner One");
		newOwner.setCar(newCar);
		ownerRepo.save(newOwner);

		Optional<Car> carInfo = carRepo.findById(2L);
		Optional<Owner> ownerInfo = ownerRepo.findById(3L);

		if (carInfo.isPresent() && ownerInfo.isPresent()) {
			log.info(carInfo.get() + " owned by: " + carInfo.get().getOwner());
			log.info(ownerInfo.get() + " ownes a " + ownerInfo.get().getCar());
		}

	}
}
