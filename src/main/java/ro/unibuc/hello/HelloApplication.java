package ro.unibuc.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ro.unibuc.hello.data.InformationEntity;
import ro.unibuc.hello.data.InformationRepository;
import ro.unibuc.hello.data.PCComponentEntity;
import ro.unibuc.hello.data.PCComponentRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = InformationRepository.class)
public class HelloApplication {

	@Autowired
	private InformationRepository informationRepository;
	@Autowired
	private PCComponentRepository pcComponentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	@PostConstruct
	public void runAfterObjectCreated() {
		informationRepository.deleteAll();
		informationRepository.save(new InformationEntity("Overview",
				"This is an example of using a data storage engine running separately from our applications server"));

		PCComponentEntity pcComponentEntity1 = new PCComponentEntity("Ryzen", "AMD Ryzen CPU", "CPU");
		PCComponentEntity pcComponentEntity2 = new PCComponentEntity("GTX", "Nvidia GTX GPU", "GPU");

		pcComponentRepository.deleteAll();
		pcComponentRepository.save(pcComponentEntity1);
		pcComponentRepository.save(pcComponentEntity2);
		pcComponentRepository.save(new PCComponentEntity("Fury", "Kingston Fury RAM", "RAM"));
		pcComponentRepository.save(new PCComponentEntity("980", "Samsung 980 SSD", "SSD"));
	}

}
