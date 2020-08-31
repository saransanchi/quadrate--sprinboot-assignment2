package net.code.java.projectmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List <product>listAll(){
        return repo.findAll();
    }
    public void save(product product){
        repo.save(product);
    }
    public product get(Long id){
        return repo.findById(id).get();
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
