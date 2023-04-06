package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getComp")
    @ResponseBody
    public PCComponentDTO getComp(@RequestParam(name="name", required=true, defaultValue = "Ryzen") String name) throws EntityNotFoundException {
        return pcComponentService.getComp(name);
    }

    @PostMapping("/addComp")
    @ResponseBody
    public boolean addComp(@RequestParam(name="name", required = true) String name, @RequestParam(name="description", required = true) String description, @RequestParam(name="category", required = true) String category){
        return pcComponentService.addComp(new PCComponentDTO(name, description, category));
    }

    @DeleteMapping("/deleteComp")
    @ResponseBody
    public boolean addComp(@RequestParam(name="name", required = true) String name){
        return pcComponentService.deleteComp(name);
    }
}
