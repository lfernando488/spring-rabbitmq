package br.com.lfernando.producer_service.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.lfernando.producer_service.configs.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static br.com.lfernando.producer_service.configs.RabbitMQConfig.RK_PRODUCT_LOG;

@Log4j2
@Service
public class MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageService.class);
    private final RabbitTemplate rabbitTemplate;

    public MessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produce(String message){
        log.info("Received message " + message);
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
    }

}
