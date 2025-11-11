package br.com.lfernando.consumer_service.rabbitmq.consumers;

import lombok.extern.log4j.Log4j2;
import org.rabbitmq.constants.RabbitMQConstants;
import org.rabbitmq.dtos.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;

@Log4j2
@Component
public class ProductConsumer {

    private static final Logger log = LoggerFactory.getLogger(ProductConsumer.class);

    //@RabbitListener(queues = RabbitMQConstants.RK_PRODUCT_LOG)
    //public void consumerLog(ProductDTO dto) throws Exception {
        //log.info("Received message: " + dto.toString() );
    //    log.info("Consumer received a message: " + dto );
   // }

    @RabbitListener(queues = RabbitMQConstants.RK_PRODUCT_LOG)
    public void debug(org.springframework.amqp.core.Message message) {
        System.out.println("contentType: " + message.getMessageProperties().getContentType());
        System.out.println("__TypeId__: " + message.getMessageProperties().getHeaders().get("__TypeId__"));
        System.out.println("body as UTF-8: " + new String(message.getBody(), StandardCharsets.UTF_8));
        System.out.println("body bytes (hex):");
        byte[] body = message.getBody();
        for (int i = 0; i < Math.min(100, body.length); i++) {
            System.out.printf("%02X ", body[i]);
        }
        System.out.println();
    }

}
