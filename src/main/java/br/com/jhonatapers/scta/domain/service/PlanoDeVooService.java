package br.com.jhonatapers.scta.domain.service;

import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;
import br.com.jhonatapers.scta.domain.repository.IPlanoDeVooRepository;

public class PlanoDeVooService {

    private IPlanoDeVooRepository repository;

    private RotasService rotasService;

    private AeroviaService aeroviaService;

    private PlanoDeVoo criar(PlanoDeVoo planoDeVoo) {
        PlanoDeVoo _planoDeVoo = buscar(planoDeVoo.getId());

        if (_planoDeVoo == null)
            return repository.save(planoDeVoo);
        else
            return _planoDeVoo;
    }

    private void remover(PlanoDeVoo planoDeVoo) {
        repository.remove(planoDeVoo);
    }

    public PlanoDeVoo buscar(long id) {
        return repository.findById(id);
    }

    public boolean verificar(PlanoDeVoo planoDeVoo) {

        return true;
    }

    public void cancelar(PlanoDeVoo planoDeVoo) {

        planoDeVoo.getRota().getAerovias().forEach(aerovia -> {
            aeroviaService.desocuparSlotHorario(aerovia, planoDeVoo.getAltitude(), planoDeVoo.getData(), planoDeVoo.getVelocidadeCruzeiro());
        });

        repository.remove(planoDeVoo);
    }

    public void autorizar(PlanoDeVoo planoDeVoo) {

    }

}
