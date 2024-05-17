package com.KaliteGuvence.KaliteGuvence;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    private ModelRepos modelRepos;

    public ModelService(ModelRepos modelRepos){
        this.modelRepos=modelRepos;
    }

    public List<Model> getAllList(){
        return modelRepos.findAll();
    }

    public Model save(Model model){
        return modelRepos.save(model);
    }

}
