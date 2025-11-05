package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brando_miranda.SpringTicketHub.entity.Ticket;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository <Ticket, Long> {

    Ticket findByUniqueCode(UUID uniqueCode);


}
