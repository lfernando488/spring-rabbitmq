package br.com.lfernando.consumer_service.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;

@Configuration
public class RabbitListenerConfigurerImpl implements RabbitListenerConfigurer {

    private final DefaultMessageHandlerMethodFactory messageHandlerMethodFactory;

    @Autowired
    public RabbitListenerConfigurerImpl(DefaultMessageHandlerMethodFactory messageHandlerMethodFactory) {
        this.messageHandlerMethodFactory = messageHandlerMethodFactory;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory);
    }
}
