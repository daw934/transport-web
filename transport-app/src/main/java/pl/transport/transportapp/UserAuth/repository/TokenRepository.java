package pl.transport.transportapp.UserAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.transport.transportapp.UserAuth.VerificationToken;
@Repository
public interface TokenRepository extends JpaRepository<VerificationToken, Long> {
        VerificationToken findByToken(String token);
}
