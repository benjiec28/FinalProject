package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {
    private int streetNo;
    private String street;
    private String city;
    public Province province;
    private String postalCode;

    public enum Province {
        AB,
        BC,
        MB,
        NB,
        NL,
        NS,
        ON,
        PEI,
        QC,
        SK
    }


}
