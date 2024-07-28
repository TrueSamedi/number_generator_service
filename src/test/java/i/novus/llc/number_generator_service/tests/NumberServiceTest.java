package i.novus.llc.number_generator_service.tests;

import i.novus.llc.number_generator_service.entity.CarNumber;
import i.novus.llc.number_generator_service.generator.GeneratorCarNumbers;
import i.novus.llc.number_generator_service.repository.NumberRepository;
import i.novus.llc.number_generator_service.service.NumberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NumberServiceTest {

    @Mock
    private NumberRepository numberRepository;
    @Mock
    private GeneratorCarNumbers generatorCarNumbers;

    @InjectMocks
    private NumberService numberService;

    @Test
    public void testGenerateRandomNumber() {
        when(numberRepository.save(new CarNumber())).thenReturn(null);
        numberService.getRandomNumber();
        verify(numberRepository).save(any());
    }

}
