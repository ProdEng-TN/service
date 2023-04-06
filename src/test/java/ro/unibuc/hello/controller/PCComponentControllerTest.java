package ro.unibuc.hello.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.PCComponentService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PCComponentControllerTest {
    @Mock
    private PCComponentService pcComponentService;

    @InjectMocks
    private PCComponentController pcComponentController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(pcComponentController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void test_getPCComponentByName() throws Exception{
        // Arrange
        String name = "Ryzen";
        when(pcComponentController.getComp(any())).thenThrow(new EntityNotFoundException(name));

        // Act
        EntityNotFoundException exception = assertThrows(
                EntityNotFoundException.class,
                () -> pcComponentController.getComp(name));

        // Assert
        assertTrue(exception.getMessage().contains(name));
    }
}
