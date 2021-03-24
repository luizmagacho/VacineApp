package br.dev.magacho.fullStackWeek.resources;


import br.dev.magacho.fullStackWeek.domain.PriorityGroup;
import br.dev.magacho.fullStackWeek.repository.PriorityGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prioritygroups")
public class PriorityGroupResource {

    @Autowired
    private PriorityGroupRepository priorityGroupRepository;

    @GetMapping
    public List<PriorityGroup> findAll(){
        return priorityGroupRepository.findAll();
    }

    @PostMapping
    public PriorityGroup registerPriorityGroup(@RequestBody PriorityGroup priorityGroup){
        return priorityGroupRepository.save(priorityGroup);
    }

    @PutMapping("{id}")
    public PriorityGroup update(@PathVariable("id") Long id, @RequestBody PriorityGroup priorityGroup){
        return priorityGroupRepository.findById(id).map(
                record -> {
                    record.setName(priorityGroup.getName());
                    record.setDescription(priorityGroup.getDescription());
                    return priorityGroupRepository.save(record);
                }).orElse(null);
    }

    @GetMapping("/{id")
    public PriorityGroup getPriorityGroupById(@PathVariable Long id){
        return priorityGroupRepository.findById(id).orElse(null);
    }
}
