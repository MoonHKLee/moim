package lee.moonhyuk.moim.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findFoodByName(String name);
}
