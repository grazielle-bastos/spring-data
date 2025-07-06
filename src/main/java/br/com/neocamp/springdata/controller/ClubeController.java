package br.com.neocamp.springdata.controller;

import br.com.neocamp.springdata.dto.AtletaResponseDTO;
import br.com.neocamp.springdata.dto.CadastroAtletaDTO;
import br.com.neocamp.springdata.dto.CadastroTimeDTO;
import br.com.neocamp.springdata.dto.TimeResponseDTO;
import br.com.neocamp.springdata.service.ClubeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clube")
public class ClubeController {


    private final ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    // POST /clube/times - cadastrar time
    @PostMapping("/times")
    public ResponseEntity<TimeResponseDTO> cadastrarTimes(@RequestBody CadastroTimeDTO timeDTO) {
        TimeResponseDTO response = clubeService.cadastrarTime(timeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /clube/times - listar todos os times
    @GetMapping("/times")
    public ResponseEntity<List<TimeResponseDTO>> listarTimes() {
        List<TimeResponseDTO> lista = clubeService.listarTimes();
        return ResponseEntity.ok(lista);
    }

    // POST /clube/atletas - cadastrar atleta
    @PostMapping("/atletas")
    public ResponseEntity<?> cadastrarAtleta(@RequestBody CadastroAtletaDTO dto) {
        AtletaResponseDTO response = clubeService.cadastrarAtleta(dto);
        if (response == null) {
            return ResponseEntity.badRequest().body("Time não encontrado");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /clube/atletas - listar todos os atletas
    @GetMapping("/atletas")
    public ResponseEntity<List<AtletaResponseDTO>> listarAtletas() {
        List<AtletaResponseDTO> lista = clubeService.listarAtletas();
        return ResponseEntity.ok(lista);
    }
}
