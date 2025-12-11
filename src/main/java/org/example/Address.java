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
    private Province province;
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

    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode.length() != 6) {
            return false;
        }

        String idxChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String idxDigit = "1234567890";

        for (int i = 0; i < postalCode.length(); i++) {
            if (i % 2 == 0 && postalCode.contains(idxChar)) {
                return true;
            }

            if (i % 2 == 1 && postalCode.contains(idxDigit)) {
                return true;
            }
        }

        return false;
    }

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }
}
