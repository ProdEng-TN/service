package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PCComponentRepository extends MongoRepository<PCComponentEntity, String> {
    PCComponentEntity findByName(String name);
    PCComponentEntity deleteByName(String name);
}
