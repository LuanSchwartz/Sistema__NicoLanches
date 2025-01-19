

<<<<<<< HEAD
package com.senacead.nicolanches.model;

import lombok.Data;

@Data
public class Cliente {

    private int id;
=======

package com.senacead.nicolanches.model;

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
@Table(name="Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Integer id;
>>>>>>> 3b9ef4c (sistema final)
    private String nome;
    private String cpf;
    private String telefone;
    
}
