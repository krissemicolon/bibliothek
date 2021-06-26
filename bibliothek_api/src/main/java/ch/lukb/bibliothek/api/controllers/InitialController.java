package ch.lukb.bibliothek.api.controllers;

import ch.lukb.bibliothek.api.misc.InitialLoad;
import ch.lukb.bibliothek.api.scheme.Borrow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {

    private InitialLoad initialLoad;

    public InitialController(InitialLoad initialLoad) {
        this.initialLoad = initialLoad;
    }

    @GetMapping("/initial")
    public Borrow initialMapping() {
        return initialLoad.initialLoad();
    }
}