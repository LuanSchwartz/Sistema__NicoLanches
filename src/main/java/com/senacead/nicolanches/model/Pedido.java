

package com.senacead.nicolanches.model;

<<<<<<< HEAD
import lombok.Data;

@Data
public class Pedido {

    
    private int id;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Integer id;
>>>>>>> 3b9ef4c (sistema final)
    private String nome;
    private Double valor;
}
