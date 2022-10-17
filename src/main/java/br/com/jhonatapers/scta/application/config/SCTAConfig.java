package br.com.jhonatapers.scta.application.config;

import br.com.jhonatapers.scta.domain.repository.IAeroportoRepository;
import br.com.jhonatapers.scta.domain.repository.IAeroviaRepository;
import br.com.jhonatapers.scta.domain.repository.IPlanoDeVooRepository;
import br.com.jhonatapers.scta.domain.repository.IRotaRepository;
import br.com.jhonatapers.scta.domain.repository.ISlotHorarioRepository;
import br.com.jhonatapers.scta.domain.service.AeroportoService;
import br.com.jhonatapers.scta.domain.service.AeroviaService;
import br.com.jhonatapers.scta.domain.service.PlanoDeVooService;
import br.com.jhonatapers.scta.domain.service.RotasService;
import br.com.jhonatapers.scta.domain.service.SlotHorarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SCTAConfig {

    @Bean
    public RotasService rotasService(AeroviaService aeroviaService, IRotaRepository rotaRepository, AeroportoService aeroportoService) {
        return new RotasService(aeroviaService, rotaRepository, aeroportoService);
    }

    @Bean
    public SlotHorarioService slotHorarioService(ISlotHorarioRepository slotHorarioRepository) {
        return new SlotHorarioService(slotHorarioRepository);
    }

    @Bean
    public AeroviaService aeroviaService(IAeroviaRepository aeroviaRepository, SlotHorarioService slotHorarioService) {
        return new AeroviaService(aeroviaRepository, slotHorarioService);
    }

    @Bean
    public AeroportoService aeroportoService(IAeroportoRepository aeroportoRepository) {
        return new AeroportoService(aeroportoRepository);
    }

    @Bean
    public PlanoDeVooService planoDeVooService(IPlanoDeVooRepository planoDeVooRepository,
                                               RotasService rotasService,
                                               AeroviaService aeroviaService) {
        return new PlanoDeVooService(planoDeVooRepository, rotasService, aeroviaService);
    }
}
