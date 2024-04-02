package emsi.tp2.repository;

import emsi.tp2.entities.Product;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface productRepository extends JpaRepository <Product, Long>
{
    @Query("select p from Product p where :x<p.price and :y<p.quantity")
    List<Product> chercherProduits(@Param("x") double price ,@Param("y") int quantite);

}
