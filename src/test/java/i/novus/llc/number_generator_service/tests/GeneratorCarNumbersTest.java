package i.novus.llc.number_generator_service.tests;

import i.novus.llc.number_generator_service.generator.GeneratorCarNumbers;
import i.novus.llc.number_generator_service.repository.NumberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GeneratorCarNumbersTest {

    private String result = new String();
    @Mock
    private NumberRepository numberRepository;

    @InjectMocks
    private GeneratorCarNumbers generatorCarNumbers;

    @Test
    public void testGenerateRandomCarNumber() {
        when(numberRepository.findCarNumberByNumber(anyString())).thenReturn(any());
        result = generatorCarNumbers.generateRandomCarNumber();
        assert (result.length() == 14);
    }

    @Test
    public void testGenerateCarNumber() {
        when(numberRepository.findCarNumberByNumber(anyString())).thenReturn(any());
        result = generatorCarNumbers.generateCarNumber();
        assert (result.length() == 14);
    }

}
