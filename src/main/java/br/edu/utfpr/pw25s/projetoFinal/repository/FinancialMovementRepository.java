package br.edu.utfpr.pw25s.projetoFinal.repository;

import br.edu.utfpr.pw25s.projetoFinal.enums.MovementType;
import br.edu.utfpr.pw25s.projetoFinal.model.FinancialMovement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialMovementRepository extends JpaRepository<FinancialMovement, Long> {

    List<FinancialMovement> findAllByAccountUserUsername(String username);

    @Query("SELECT fm FROM FinancialMovement fm " +
        "WHERE fm.account.user.username = :username " +
        "AND fm.type = :movementType " +
        "ORDER BY fm.date DESC")
    Page<FinancialMovement> findAllByAccountUserUsernameAndTypeOrderByDateDesc(
        @Param("username") String username,
        @Param("movementType") MovementType movementType,
        Pageable pageable
    );
    List<FinancialMovement> findAllByAccountId(Long id);

}
