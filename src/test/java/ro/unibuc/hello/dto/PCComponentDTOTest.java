package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PCComponentDTOTest {
    PCComponentDTO pcComponentDTO = new PCComponentDTO("Ryzen", "AMD Ryzen CPU" ,"CPU");

    @Test
    public void test_getName() {
        Assertions.assertSame("Ryzen", pcComponentDTO.getName());
    }

    @Test
    public void test_getDescription() {
        Assertions.assertSame("AMD Ryzen CPU", pcComponentDTO.getDescription());
    }

    @Test
    public void test_getCategory() {
        Assertions.assertSame("CPU", pcComponentDTO.getCategory());
    }

    @Test
    public void test_setName() {
        pcComponentDTO.setName("GTX");
        Assertions.assertSame("GTX", pcComponentDTO.getName());
    }

    @Test
    public void test_setDescription() {
        pcComponentDTO.setDescription("Nvidia GTX GPU");
        Assertions.assertSame("Nvidia GTX GPU", pcComponentDTO.getDescription());
    }

    @Test
    public void test_setCategory() {
        pcComponentDTO.setCategory("GPU");
        Assertions.assertSame("GPU", pcComponentDTO.getCategory());
    }

    @Test
    public void test_ConstructorWithoutParams() {
        PCComponentDTO pcComponentDTO = new PCComponentDTO();
        Assertions.assertSame(null, pcComponentDTO.getName());
    }
}
