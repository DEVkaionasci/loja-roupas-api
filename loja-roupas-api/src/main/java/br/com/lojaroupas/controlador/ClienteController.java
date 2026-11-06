package br.com.lojaroupas.controlador;

import br.com.lojaroupas.dto.ClienteRequestDTO;
import br.com.lojaroupas.dto.ClienteResponseDTO;
import br.com.lojaroupas.servico.ClienteService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService servico;

    public ClienteController(ClienteService servico) {
        this.servico = servico;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(
            @Valid @RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.criar(dto));
    }

    @GetMapping
    public List<ClienteResponseDTO> listar() {
        return servico.listar();
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO buscar(@PathVariable Long id) {
        return servico.buscar(id);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ClienteRequestDTO dto) {
        return servico.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        servico.remover(id);
        return ResponseEntity.noContent().build();
    }
}
