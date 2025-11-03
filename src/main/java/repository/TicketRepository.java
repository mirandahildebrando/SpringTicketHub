package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brando_miranda.SpringTicketHub.entity.Ticket;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository <Ticket, Long> {


    Optional<Ticket> findFirstByEventAndStatus(Long eventId, Status status);
}
