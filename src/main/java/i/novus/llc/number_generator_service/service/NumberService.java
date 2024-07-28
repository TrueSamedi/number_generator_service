package i.novus.llc.number_generator_service.service;

import i.novus.llc.number_generator_service.entity.CarNumber;
import i.novus.llc.number_generator_service.generator.GeneratorCarNumbers;
import i.novus.llc.number_generator_service.repository.NumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NumberService {

    private final NumberRepository numberRepository;
    private final GeneratorCarNumbers generatorCarNumbers;
    private List<String> listOfCarNumbers = new LinkedList<>();

    public String getNextNumber() {
        String numberString = listOfCarNumbers.get(0);
        listOfCarNumbers.remove(0);
        return saveCarNumber(numberString);
    }

    public String getRandomNumber() {
        String numberString = generatorCarNumbers.generateRandomCarNumber();
        return saveCarNumber(numberString);
    }

    @Async("executor")
    @Scheduled(cron = "${hash.cron}")
    public void generateBatch() {
        if (listOfCarNumbers.size() < 300){
            while (listOfCarNumbers.size()<1000){
                listOfCarNumbers.add(generatorCarNumbers.generateCarNumber());
            }
        }
    }

    private String saveCarNumber(String numberString) {
        CarNumber carNumber = new CarNumber();
        carNumber.setNumber(numberString);
        numberRepository.save(carNumber);
        return numberString;
    }

}
