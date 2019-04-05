package com.example.rawda.prettychat.data.models;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Date;
import java.util.Objects;

public class PremiumUser extends User {
    private Double creditCardNumber;
    // TODO add advertisements
    public PremiumUser(long _id, String fName, String lName, String email, String userName,
                       String password, Date birthDate, String phone_number, String address,
                       byte[] photo, Double creditCardNumber) {
        super(_id, fName, lName, email, userName, password, birthDate, phone_number, address, photo);
        this.creditCardNumber = creditCardNumber;
    }

    public PremiumUser(Double creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public PremiumUser() {
        creditCardNumber = 0.0;
    }

    public Double getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Double creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PremiumUser)) return false;
        if (!super.equals(o)) return false;
        PremiumUser that = (PremiumUser) o;
        return Objects.equals(getCreditCardNumber(), that.getCreditCardNumber());
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getCreditCardNumber());
    }

    @Override
    public String toString() {
        return "PremiumUser{" +
                super.toString() +
                "creditCardNumber=" + creditCardNumber +
                '}';
    }
}
