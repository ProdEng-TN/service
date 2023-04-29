package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.unibuc.hello.dto.PCComponentDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.PCComponentService;

@Controller
public class PCComponentController {
    @Autowired
    private PCComponentService pcComponentService;

    @Autowired
    MeterRegistry metricsRegistry;

    @GetMapping("/getComp")
    @ResponseBody
    @Timed(value = "component.getComp.time", description = "Time taken to return component")
    @Counted(value = "component.getComp.count", description = "Times components were returned")
    public PCComponentDTO getComp(@RequestParam(name="name", required=true, defaultValue = "Ryzen") String name) throws EntityNotFoundException {
        return pcComponentService.getComp(name);
    }

    @PostMapping("/addComp")
    @ResponseBody
    @Timed(value = "component.addComp.time", description = "Time taken to add a component")
    @Counted(value = "component.addComp.count", description = "Times a component was added")
    public boolean addComp(@RequestParam(name="name", required = true) String name, @RequestParam(name="description", required = true) String description, @RequestParam(name="category", required = true) String category){
        return pcComponentService.addComp(new PCComponentDTO(name, description, category));
    }

    @DeleteMapping("/deleteComp")
    @ResponseBody
    @Timed(value = "component.deleteComp.time", description = "Time taken to delete a component")
    @Counted(value = "component.deleteComp.count", description = "Times a component was deleted")
    public boolean addComp(@RequestParam(name="name", required = true) String name){
        return pcComponentService.deleteComp(name);
    }
}
