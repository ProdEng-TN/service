package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.PCComponentEntity;
import ro.unibuc.hello.data.PCComponentRepository;
import ro.unibuc.hello.dto.PCComponentDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;

@Component
public class PCComponentService {
    @Autowired
    private PCComponentRepository pcComponentRepository;

    public PCComponentDTO getComp(String name) throws EntityNotFoundException {
        PCComponentEntity entity = pcComponentRepository.findByName(name);
        if(entity == null){
            throw new EntityNotFoundException(name);
        }
        return new PCComponentDTO(entity.name, entity.description, entity.category);
    }

    public boolean addComp(PCComponentDTO pcComponentDTO){
        PCComponentEntity entity = new PCComponentEntity(pcComponentDTO.getName(), pcComponentDTO.getDescription(), pcComponentDTO.getCategory());
        pcComponentRepository.save(entity);
        return true;
    }

    public boolean deleteComp(String name){
        pcComponentRepository.deleteByName(name);
        return true;
    }
}
