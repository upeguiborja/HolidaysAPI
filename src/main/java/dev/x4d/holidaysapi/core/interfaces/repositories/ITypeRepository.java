package dev.x4d.holidaysapi.core.interfaces.repositories;

import dev.x4d.holidaysapi.core.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends JpaRepository<Type, Integer> {
}
