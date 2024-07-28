package i.novus.llc.number_generator_service.repository;

import i.novus.llc.number_generator_service.entity.CarNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends JpaRepository<CarNumber, Long> {

    @Query("SELECT u FROM CarNumber u WHERE u.number = ?1")
    CarNumber findCarNumberByNumber(String number);
}
