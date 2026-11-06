package br.com.lojaroupas.controlador;
import br.com.lojaroupas.dto.ProdutoRequestDTO;
import br.com.lojaroupas.dto.ProdutoResponseDTO;
import br.com.lojaroupas.servico.ProdutoService;
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
@RequestMapping("/api/produtos")
public class ProdutoController {
 private final ProdutoService servico;
 public ProdutoController(ProdutoService servico) {
 this.servico = servico;
 }
 @PostMapping
 public ResponseEntity<ProdutoResponseDTO> criar(@Valid @RequestBody ProdutoRequestDTO dto) {
 return ResponseEntity.status(HttpStatus.CREATED).body(servico.criar(dto));
 }
 @GetMapping
 public List<ProdutoResponseDTO> listar() {
 return servico.listar();
 }
 @GetMapping("/{id}")
 public ProdutoResponseDTO buscar(@PathVariable Long id) {
 return servico.buscar(id);
 }
 @PutMapping("/{id}")
 public ProdutoResponseDTO atualizar(@PathVariable Long id,
 @Valid @RequestBody ProdutoRequestDTO dto) {
 return servico.atualizar(id, dto);
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> remover(@PathVariable Long id) {
 servico.remover(id);
 return ResponseEntity.noContent().build();
 }
}
