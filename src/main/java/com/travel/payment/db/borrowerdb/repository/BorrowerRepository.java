package com.travel.payment.db.borrowerdb.repository;

import com.travel.payment.db.borrowerdb.model.BorrowerModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BorrowerRepository extends JpaRepository<BorrowerModel, Integer> {
//    @Modifying
//    @Query(value="update tbl_borrower set balance = :balance where id = :id", nativeQuery = true)
//    void updateBalance(@Param("balance") Integer balance, @Param("id") Integer id);

    BorrowerModel findByIdUser(Integer idUser);

}
