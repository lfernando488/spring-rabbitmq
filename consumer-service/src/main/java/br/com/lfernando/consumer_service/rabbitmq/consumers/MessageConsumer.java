package br.com.lfernando.consumer_service.rabbitmq.consumers;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MessageConsumer {

    private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    @RabbitListener(queues = {"product.log"})
    public void consumerLog(String message) {
        log.info("Consumer received a message: "+ message );
    }

}
