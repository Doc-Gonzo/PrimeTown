package at.mathias_schaller.PrimeTown.repository;

import at.mathias_schaller.PrimeTown.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {


}