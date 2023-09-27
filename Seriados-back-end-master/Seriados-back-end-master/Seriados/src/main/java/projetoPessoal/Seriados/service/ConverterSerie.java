package projetoPessoal.Seriados.service;

import org.springframework.stereotype.Service;
import projetoPessoal.Seriados.dto.SerieResponseDTO;
import projetoPessoal.Seriados.entity.Serie;

@Service
public class ConverterSerie {
    public Serie dtoToSerie(SerieResponseDTO dto) {
        if (dto != null) {
            Serie entity = new Serie(dto.id(),dto.title(),dto.image(), dto.level(), dto.description());
            return entity;
        }
        throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
    }

    public SerieResponseDTO serieToDto(Serie entity) {
        if (entity != null) {
            SerieResponseDTO dto = new SerieResponseDTO(entity.getId(), entity.getTitle(), entity.getImage(), entity.getLevel(), entity.getDescription());
            return dto;
        }
        throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
    }
}
