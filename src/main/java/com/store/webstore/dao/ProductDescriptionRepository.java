package com.store.webstore.dao;

import com.store.webstore.model.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductDescriptionRepository extends JpaRepository<ProductDescription,Integer> {
    @Query(value = "select * from Product_Description p where p.PRODUCT_ID = ?1",nativeQuery = true)
    List<ProductDescription> findAllByProductId(int productId);


    @Transactional
    @Modifying
    @Query(value = "insert into Product_Description(ID,PRODUCT_DESCIPTION,PRODUCT_ID) values(?1,?3,?2)",nativeQuery = true)
    void addDesc(int id,int productId, String productDesciption);
}
