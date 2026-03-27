package mx.unam.aragon.ico.te.BD.controladores;
import mx.unam.aragon.ico.te.BD.entidades.Libro;
import mx.unam.aragon.ico.te.BD.services.BiblioServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class ControladorPrincipal {

    private final BiblioServ service;

    public ControladorPrincipal(BiblioServ service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Libro> create( @RequestBody Libro nuevoLibro) {
        return new ResponseEntity<>(service.save(nuevoLibro), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> update(@PathVariable Long id,  @RequestBody Libro libroActualizado) {
        return ResponseEntity.ok(service.update(id, libroActualizado));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Libro> patch(@PathVariable Long id, @RequestBody Libro datosParciales) {
        return ResponseEntity.ok(service.patch(id, datosParciales));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
