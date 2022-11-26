package br.pucrs.projarc.flightplan.application.config;

import br.pucrs.projarc.flightplan.domain.repository.IPlanoDeVooRepository;
import br.pucrs.projarc.flightplan.domain.service.PlanoDeVooService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FlightPlanConfig {

    @Bean
    public PlanoDeVooService planoDeVooService(IPlanoDeVooRepository planoDeVooRepository) {
        return new PlanoDeVooService(planoDeVooRepository);
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        SimpleModule simpleModule = new SimpleModule();

        mapper.registerModule(simpleModule);

        return mapper;
    }
}
