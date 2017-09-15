package io.fdlessard.codebites.rabbitmq.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    @Version
    private long version;

    private String lastName;

    private String firstName;

    private String company;

    private BigDecimal accountBalance;

}
