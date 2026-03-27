package mx.unam.aragon.ico.te.BD.repositorios;
import mx.unam.aragon.ico.te.BD.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiblioRepo extends JpaRepository<Libro, Long> {
}