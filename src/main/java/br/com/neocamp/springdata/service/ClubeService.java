package br.com.neocamp.springdata.service;

import br.com.neocamp.springdata.dto.AtletaResponseDTO;
import br.com.neocamp.springdata.dto.CadastroAtletaDTO;
import br.com.neocamp.springdata.dto.CadastroTimeDTO;
import br.com.neocamp.springdata.dto.TimeResponseDTO;
import br.com.neocamp.springdata.entities.AtletasEntities;
import br.com.neocamp.springdata.entities.TimesEntities;
import br.com.neocamp.springdata.repository.AtletasRepository;
import br.com.neocamp.springdata.repository.TimesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubeService {

    private final TimesRepository timesRepository;

    private final AtletasRepository atletasRepository;

    public ClubeService(TimesRepository timesRepository, AtletasRepository atletasRepository) {
        this.timesRepository = timesRepository;
        this.atletasRepository = atletasRepository;
    }

    // Cadastrar um novo time
    @Transactional
    public TimeResponseDTO cadastrarTime(CadastroTimeDTO timeDTO) {
        if (timeDTO.getClube() == null || timeDTO.getClube().isEmpty()) {
            return null;
        }
        TimesEntities novoTime = new TimesEntities(timeDTO.getClube(), timeDTO.getPais(), timeDTO.getFundacao());
        TimesEntities timeSalvo = timesRepository.save(novoTime);
        return new TimeResponseDTO(timeSalvo.getClube(), timeSalvo.getPais());
    }

    // Cadastrar um novo atleta
    @Transactional
    public AtletaResponseDTO cadastrarAtleta(CadastroAtletaDTO dto) {
        TimesEntities time = timesRepository.findById(dto.getTimeId()).orElse(null);
        if (time == null) {
            // Simples: retorna null se não encontrar o time
            return null;
        }
        AtletasEntities atleta = new AtletasEntities(dto.getNome(), dto.getPosicao(), time);
        AtletasEntities salvo = atletasRepository.save(atleta);
        return new AtletaResponseDTO(salvo.getId(), salvo.getNome(), salvo.getPosicao(), salvo.getTime().getClube());
    }

    // Listar todos os atletas
    public List<AtletaResponseDTO> listarAtletas() {
        List<AtletasEntities> atletas = atletasRepository.findAll();
        return atletas.stream()
                .map(a -> new AtletaResponseDTO(a.getId(), a.getNome(), a.getPosicao(), a.getTime().getClube()))
                .collect(Collectors.toList());
    }

    // Listar todos os times
    public List<TimeResponseDTO> listarTimes() {
        List<TimesEntities> times = timesRepository.findAll();
        return times.stream()
                .map(t -> new TimeResponseDTO(t.getClube(), t.getPais()))
                .collect(Collectors.toList());
    }

}
