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

        char idx0 = postalCode.charAt(0);
        String idx0Value = String.valueOf(idx0);
        char idx1 = postalCode.charAt(1);
        String idx1Value = String.valueOf(idx0);
        char idx2 = postalCode.charAt(2);
        String idx2Value = String.valueOf(idx0);
        char idx3 = postalCode.charAt(3);
        String idx3Value = String.valueOf(idx0);
        char idx4 = postalCode.charAt(4);
        String idx4Value = String.valueOf(idx0);
        char idx5 = postalCode.charAt(5);
        String idx5Value = String.valueOf(idx0);

        if (idx0Value.contains(idxChar) || idx2Value.contains(idxChar) || idx4Value.contains(idxChar) || idx1Value.contains(idxDigit) || idx3Value.contains(idxDigit) || idx5Value.contains(idxDigit)) {
            return true;
        }

        return false;
    }

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode) == true) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode;
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }
}
