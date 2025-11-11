package br.com.lfernando.producer_service.services;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.rabbitmq.dtos.ProductDTO;
import org.rabbitmq.constants.RabbitMQConstants;

@Log4j2
@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final RabbitTemplate rabbitTemplate;

    public ProductService (RabbitTemplate rabbitTemplate)
    {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void createproduct(ProductDTO productDTO){
        log.info("Sending a message to exchage " + productDTO.toString());
        rabbitTemplate.convertAndSend(RabbitMQConstants.EXG_NAME_MARKETPLACE, RabbitMQConstants.RK_PRODUCT_LOG, productDTO);
    }

    @PostConstruct
    public void debugTemplate() {
        System.out.println("RabbitTemplate class: " + rabbitTemplate.getClass().getName());
        System.out.println("MessageConverter: " + rabbitTemplate.getMessageConverter());
    }

}
