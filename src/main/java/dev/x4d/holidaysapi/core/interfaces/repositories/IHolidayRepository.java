package dev.x4d.holidaysapi.core.interfaces.repositories;

import dev.x4d.holidaysapi.core.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHolidayRepository extends JpaRepository<Holiday, Integer> {

}
