package mx.unam.aragon.ico.te.BD.services;

import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.BD.entidades.Libro;
import mx.unam.aragon.ico.te.BD.repositorios.BiblioRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiblioServ {
    private final BiblioRepo repository;

    public BiblioServ(BiblioRepo repository) {
        this.repository = repository;
    }

    public List<Libro> findAll() {
        return repository.findAll();
    }

    public Libro findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado con ID: " + id));
    }

    public Libro save(Libro nuevoLibro) {
        return repository.save(nuevoLibro);
    }

    public Libro update(Long id, Libro libroActualizado) {
        Libro existente = findById(id);
        existente.setTitulo(libroActualizado.getTitulo());
        existente.setAutor(libroActualizado.getAutor());
        existente.setEditorial(libroActualizado.getEditorial());
        existente.setCorreoElectronicoEditorial(libroActualizado.getCorreoElectronicoEditorial());
        existente.setPrecio((int) libroActualizado.getPrecio());
        existente.setGenero(libroActualizado.getGenero());
        return repository.save(existente);
    }

    public Libro patch(Long id, Libro datosParciales) {
        Libro existente = findById(id);
        if (datosParciales.getTitulo() != null) existente.setTitulo(datosParciales.getTitulo());
        if (datosParciales.getAutor() != null) existente.setAutor(datosParciales.getAutor());
        if (datosParciales.getEditorial() != null) existente.setEditorial(datosParciales.getEditorial());
        if (datosParciales.getCorreoElectronicoEditorial() != null) existente.setCorreoElectronicoEditorial(datosParciales
                .getCorreoElectronicoEditorial());
        if (datosParciales.getPrecio() != null) existente.setPrecio(datosParciales.getPrecio());
        if (datosParciales.getGenero() != null) existente.setGenero(datosParciales.getGenero());
        return repository.save(existente);
    }

    public void delete(Long id) {
        Libro existente = findById(id);
        repository.delete(existente);
    }
}
