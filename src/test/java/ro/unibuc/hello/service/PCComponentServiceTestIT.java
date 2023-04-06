package ro.unibuc.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ro.unibuc.hello.data.PCComponentEntity;
import ro.unibuc.hello.data.PCComponentRepository;
import ro.unibuc.hello.dto.PCComponentDTO;

import static org.mockito.Mockito.when;

@SpringBootTest
@Tag("IT")
public class PCComponentServiceTestIT {
    @Autowired
    PCComponentRepository pcComponentRepository;

    @Autowired
    PCComponentService pcComponentService;

    @Test
    void test_findByName_returnDescription() {
        // Arrange
        String name = "GTX";
        String description = "Nvidia GTX GPU";

        // Act
        PCComponentDTO pcComponentDTO = pcComponentService.getComp(name);

        // Assert
        Assertions.assertEquals(description, pcComponentDTO.getDescription());
    }

    @Test
    void test_findByName_returnCategory() {
        // Arrange
        String name = "GTX";
        String category = "GPU";

        // Act
        PCComponentDTO pcComponentDTO = pcComponentService.getComp(name);

        // Assert
        Assertions.assertEquals(category, pcComponentDTO.getCategory());
    }
}
