package mx.unam.aragon.ico.te.apiRestBiblioteca.controladores;

import mx.unam.aragon.ico.te.apiRestBiblioteca.modelo.Libro;
import org.springframework.boot.micrometer.metrics.autoconfigure.MetricsProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaRestController {
    //hash simulating
    HashMap<Integer, Libro> librosDB;

    public BibliotecaRestController(){
        librosDB = new HashMap<>();
        librosDB.put(1,new Libro(1,"Proyect Hail Mary", "autor1","edit 1",
                "p@g.com", 11, "sci fi"));
        librosDB.put(2,new Libro(1,"The Martian", "autor 1","edit 2",
                "t@g.com", 43, "sci fi"));
        librosDB.put(3,new Libro(1,"ready player one", "autor 2","edit 3",
                "r@g.com", 12, "fantasy"));
    }

    @GetMapping("/ping/")
    public String ping(){
        return "pong";
    }
    /*
    @GetMapping("/")
    public HashMap<Integer, Libro> getTodas(){
        return librosDB;
    }
    */
    @GetMapping("/")
    public ResponseEntity<HashMap<Integer, Libro>> getTodas(){
        return new ResponseEntity<>(librosDB, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Libro getLibro(@PathVariable int id){
        return librosDB.get(id);
    }

    @PostMapping("/")
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro){
        int id = 1;
        while (librosDB.containsKey(id))id++;
        libro.setId(id);
        librosDB.put(id, libro);
        //return libro;
        return ResponseEntity.created(null).body(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        librosDB.replace(id,libro);
        return librosDB.get(id);
    }
}
