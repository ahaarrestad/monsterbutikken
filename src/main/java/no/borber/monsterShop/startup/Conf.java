package no.borber.monsterShop.startup;

import no.borber.monsterShop.application.basket.BasketApplicationService;
import no.borber.monsterShop.application.order.OrderApplicationService;
import no.borber.monsterShop.eventStore.EventStore;
import no.borber.monsterShop.projections.BasketProjection;
import no.borber.monsterShop.projections.OrderProjection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conf {
    private final EventStore eventStore;

    public Conf() {
        this.eventStore = new EventStore();
    }

    @Bean
    public BasketApplicationService createBasketApplicationService() {
        return new BasketApplicationService(eventStore);
    }

    @Bean
    public OrderApplicationService createOrderApplicationService() {
        return new OrderApplicationService(eventStore);
    }

    @Bean
    public BasketProjection createBasketProjection() {
        return new BasketProjection(eventStore);
    }

    @Bean
    public OrderProjection createOrderProjection(){
        return new OrderProjection(eventStore);
    }
}

