package br.com.lfernando.consumer_service.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class RabbitHandlerMethodConfig {

    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory(ObjectMapper objectMapper) {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(objectMapper); // usa o ObjectMapper do Spring (ou novo)
        factory.setMessageConverter(converter);
        return factory;
    }
}
