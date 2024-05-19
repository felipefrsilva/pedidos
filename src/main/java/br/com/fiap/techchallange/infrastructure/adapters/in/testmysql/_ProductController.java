package br.com.fiap.techchallange.infrastructure.adapters.in.testmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/mysql/product")
public class _ProductController {
    private final _ProductRepository repository;

    @Autowired
    public _ProductController(_ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewProduct(@RequestParam String name, @RequestParam String description) {
        _Product prd = new _Product();
        prd.setName(name);
        prd.setDescription(description);
        repository.save(prd);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<_Product> getAllProducts() {
        return repository.findAll();
    }
}
