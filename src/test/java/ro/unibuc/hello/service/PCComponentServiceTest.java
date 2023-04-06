package ro.unibuc.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.unibuc.hello.data.PCComponentEntity;
import ro.unibuc.hello.data.PCComponentRepository;
import ro.unibuc.hello.dto.PCComponentDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PCComponentServiceTest {
    @Mock
    PCComponentRepository muckpcComponentRepository;

    @InjectMocks
    PCComponentService pcComponentService = new PCComponentService();

    @Test
    void test_findByName_returnsPCComponent() {
        // Arrange
        String name = "GTX";
        String description = "Nvidia GTX GPU";
        String category = "GPU";
        PCComponentEntity pcComponentEntity = new PCComponentEntity(name, description, category);

        when(muckpcComponentRepository.findByName(name)).thenReturn(pcComponentEntity);

        // Act
        PCComponentDTO pcComponentDTO = pcComponentService.getComp(name);

        // Assert
        Assertions.assertEquals(description, pcComponentDTO.getDescription());
        Assertions.assertEquals(category, pcComponentDTO.getCategory());
    }

    @Test
    void test_findByName_throwsEntityNotFoundException(){
        // Arrange
        String name = "test_name";

        when(muckpcComponentRepository.findByName(name)).thenReturn(null);

        try {
            // Act
            PCComponentEntity pcComponentEntity = muckpcComponentRepository.findByName(name);
        } catch (Exception ex) {
            // Assert
            Assertions.assertEquals(ex.getClass(), EntityNotFoundException.class);
            Assertions.assertEquals(ex.getMessage(), "Entity: test_name was not found");
        }
    }
}
