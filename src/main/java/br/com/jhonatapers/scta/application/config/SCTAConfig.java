package br.com.jhonatapers.scta.application.config;

import br.com.jhonatapers.scta.domain.repository.IAeroportoRepository;
import br.com.jhonatapers.scta.domain.repository.IAeroviaRepository;
import br.com.jhonatapers.scta.domain.repository.IRotaRepository;
import br.com.jhonatapers.scta.domain.service.AeroportoService;
import br.com.jhonatapers.scta.domain.service.AeroviaService;
import br.com.jhonatapers.scta.domain.service.RotasService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SCTAConfig {

    @Bean
    public RotasService rotasService(AeroviaService aeroviaService, IRotaRepository rotaRepository, AeroportoService aeroportoService) {
        return new RotasService(aeroviaService, rotaRepository, aeroportoService);
    }

    @Bean
    public AeroviaService aeroviaService(IAeroviaRepository aeroviaRepository) {
        return new AeroviaService(aeroviaRepository);
    }

    @Bean
    public AeroportoService aeroportoService(IAeroportoRepository aeroportoRepository) {
        return new AeroportoService(aeroportoRepository);
    }
}
