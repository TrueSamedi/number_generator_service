package i.novus.llc.number_generator_service.controller;

import i.novus.llc.number_generator_service.service.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("number")
@RequiredArgsConstructor
public class NumberController {

    private final NumberService numberService;

    @GetMapping("/next")
    public String getNextNumber() {
        return numberService.getNextNumber();
    }

    @GetMapping("/random")
    public String getRandomNumber() {
        return numberService.getRandomNumber();
    }

}
