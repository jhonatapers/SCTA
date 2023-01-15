package br.pucrs.projarc.flightplan.application.config;

import br.pucrs.projarc.flightplan.adapter.rabbitmq.PlanoDeVooReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FLIGHT_PLAN_EXCHANGE = "flight-plan-exchange";
    public static final String FLIGHT_PLAN_QUEUE_NAME = "flight-plan";

    @Bean
    public Queue queue() {
        return new Queue(FLIGHT_PLAN_QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(FLIGHT_PLAN_EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("flight-plan.#");
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(FLIGHT_PLAN_QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(PlanoDeVooReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage"); }
}
