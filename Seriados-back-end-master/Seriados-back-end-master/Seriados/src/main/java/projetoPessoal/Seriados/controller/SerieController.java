package projetoPessoal.Seriados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoPessoal.Seriados.dto.SerieResponseDTO;
import projetoPessoal.Seriados.service.ConverterSerie;
import projetoPessoal.Seriados.service.SerieService;
import projetoPessoal.Seriados.entity.Serie;
import projetoPessoal.Seriados.repository.SerieRepository;
import javax.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/Serie")
@CrossOrigin(origins="*",allowedHeaders = "*")
public class SerieController {

    @Autowired
    private SerieRepository repository;
    @Autowired
    private ConverterSerie converter;
    @Autowired
    private SerieService serieService;


    @PostMapping
    public ResponseEntity saveSerie(@RequestBody SerieResponseDTO dto){
        try {
            Serie entity = converter.dtoToSerie(dto);
            entity = serieService.save(entity);
            dto = converter.serieToDto(entity);
            return new ResponseEntity(dto, HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @GetMapping
    public ResponseEntity GetAll(){
        List<Serie> serieList= repository.findAll();
        return ResponseEntity.ok().body(serieList);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {

        try {
            Serie entity = serieService.findById(id);
            SerieResponseDTO dto = converter.serieToDto(entity);
            return ResponseEntity.ok().body(dto);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid SerieResponseDTO dto){
        try {
            dto.setId(id);
            Serie entity = converter.dtoToSerie(dto);
            entity = serieService.update(entity);
            dto = converter.serieToDto(entity);
            return ResponseEntity.ok().body(dto);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            serieService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }















}
