package br.com.jhonatapers.scta.application.config;

import br.com.jhonatapers.scta.domain.repository.IRotaRepository;
import br.com.jhonatapers.scta.domain.service.AeroviaService;
import br.com.jhonatapers.scta.domain.service.RotasService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SCTAConfig {

    @Bean
    public RotasService rotasService(AeroviaService aeroviaService, IRotaRepository rotaRepository) {
        return new RotasService(aeroviaService, rotaRepository);
    }
}
