package projetoPessoal.Seriados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoPessoal.Seriados.entity.Serie;
import projetoPessoal.Seriados.repository.SerieRepository;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public boolean existById(Long id){
        return repository.existsById(id);
    }

    public Serie save(Serie serie) {
        return repository.save(serie);
    }
    public Serie findById(Integer id) {
        return repository.getById(Long.valueOf(id));
    }
    public Serie update(Serie serie) {
        return repository.save(serie);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }





}
