package chalkboard.me.cdc.producer.infrastructure.datasource.pizza;
import chalkboard.me.cdc.producer.domain.entity.pizza.PizzaRepository;
import chalkboard.me.cdc.producer.model.Pizza;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class PizzaDatasource implements PizzaRepository {
  private final PizzaMapper pizzaMapper;

  public Pizza findPizza(Integer rid) {
    PizzaDto dto = pizzaMapper.findPizza(rid);
    if(Objects.isNull(dto)) return null;

    return dto.toEntity();
  }

  @Override
  public Integer addPizza(Pizza pizza) {
    PizzaDto dto = PizzaDto.valueOf(pizza);
    pizzaMapper.addPizza(dto);
    return dto.getId();
  }
}
