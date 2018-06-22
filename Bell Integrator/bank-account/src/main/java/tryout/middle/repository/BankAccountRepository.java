package tryout.middle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tryout.middle.domain.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
