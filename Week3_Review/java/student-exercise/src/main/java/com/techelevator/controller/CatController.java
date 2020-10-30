package com.techelevator.controller;

import com.techelevator.model.*;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CatController {

    private CatCardDAO catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @GetMapping("/api/cards/random")
    public CatCard getRandomCatCard() {
        CatCard result = new CatCard();
        CatFact fact = catFactService.getFact();
        result.setCatFact(fact.getText());
        CatPic pic = catPicService.getPic();
        result.setImgUrl(pic.getFile());
        return result;
    }

    @GetMapping("/api/cards")
    public List<CatCard> getAllCards() {
        return catCardDao.list();
    }

    @GetMapping("api/cards/{id}")
    public CatCard getCard(@PathVariable long id) {
        return catCardDao.get(id);
    }

    @PostMapping("/api/cards")
    public boolean saveCard(@Valid @RequestBody CatCard catCard){
        return catCardDao.save(catCard);
    }

    @PutMapping("/api/cards/{id}")
    public boolean updateCard(@Valid @RequestBody CatCard catCard, @PathVariable long id) throws CatCardNotFoundException {
        return catCardDao.update(id, catCard);
    }

    @DeleteMapping("/api/cards/{id}")
    public boolean deleteCard(@PathVariable long id) throws CatCardNotFoundException {
        return catCardDao.delete(id);
    }
}
