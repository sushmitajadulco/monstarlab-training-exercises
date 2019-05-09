package comjadulco.jasper_exercise_2.repository;

import comjadulco.jasper_exercise_2.model.Inmate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface InmateRepository extends JpaRepository<Inmate, Long> {


    Collection<Inmate> findBySex(Long sex);

        @Query(value = "SELECT * FROM inmate_profile i " +
                "            INNER JOIN system_codes s " +
                "            ON s.id = i.nationality AND i.nationality<>1905 " +
                "            AND i.nationality is not null", nativeQuery = true)
    Collection<Inmate> findAllForeigners();
}
