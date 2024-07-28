package i.novus.llc.number_generator_service.generator;

import i.novus.llc.number_generator_service.repository.NumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GeneratorCarNumbers {

    private static final StringBuilder lettersForNumber = new StringBuilder("АВЕКМНОРСТУХ");
    private static final String regionNumber = new String(" 116 RUS");
    private final NumberRepository numberRepository;
    private static char firstLetter = 'А';
    private static char secondLetter = 'А';
    private static char thirdLetter = 'А';
    private static int idxFirstLetter = 0;
    private static int idxSecondLetter = 0;
    private static int idxThirdLetter = 0;
    private static int firstNumber = 0;
    private static int secondNumber = 0;
    private static int thirdNumber = 0;

    public String generateRandomCarNumber() {
        String carNumber = new String();
        do {
            carNumber = generateRandomLetter() +
                    generateRandomNumber() + generateRandomNumber() + generateRandomNumber() +
                    generateRandomLetter() + generateRandomLetter() +
                    regionNumber;
        } while (numberRepository.findCarNumberByNumber(carNumber) != null);
        return carNumber;
    }

    public String generateCarNumber() {
        String carNumber = new String();
        do {
            carNumber = String.valueOf(firstLetter) +
                    firstNumber + secondNumber + thirdNumber +
                    secondLetter + thirdLetter +
                    regionNumber;
            if (numberRepository.findCarNumberByNumber(carNumber) != null)
                incrementCarNumber();
        } while (numberRepository.findCarNumberByNumber(carNumber) != null);
        incrementCarNumber();
        return carNumber;
    }

    private String generateRandomNumber() {
        return String.valueOf((int) Math.floor(Math.random() * 10));
    }

    private String generateRandomLetter() {
        return String.valueOf(lettersForNumber.charAt((int) Math.floor(Math.random() * 12)));
    }

    private void incrementCarNumber() {
        if (thirdNumber == 9) {
            System.out.println(2);
            if (secondNumber == 9) {
                if (firstNumber == 9) {
                    if (thirdLetter == 'Х') {
                        if (secondLetter == 'Х') {
                            firstLetter = lettersForNumber.charAt(increment(idxFirstLetter, 12));
                        }
                        secondLetter = lettersForNumber.charAt(increment(idxSecondLetter, 12));
                    }
                    thirdLetter = lettersForNumber.charAt(increment(idxThirdLetter, 12));
                }
                firstNumber = increment(firstNumber, 10);
            }
            secondNumber = increment(secondNumber, 10);
        }
        thirdNumber = increment(thirdNumber, 10);
    }

    private int increment(int number, int base) {
        return ++number % base;
    }

}
