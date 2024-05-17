package com.KaliteGuvence.KaliteGuvence;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("models")
public class ModelController {


    private ModelService modelService;

    public ModelController(ModelService modelService){
        this.modelService=modelService;
    }

    @GetMapping
    public List<Model> getAllList(){
        return modelService.getAllList();
    }

    @PostMapping
    public Model saveModel(@RequestBody Model model){
        return modelService.save(model);
    }


}
