package com.example.rawda.prettychat.data.models;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Date;
import java.util.Objects;

public class PremiumUser extends User {
    private Double creditCardNumber;
    public PremiumUser(long _id, String fname, String lname, String email, String userName, String password, Date birthDate, String phone_number, String address) {
        super(_id, fname, lname, email, userName, password, birthDate, phone_number, address);
    }

    public PremiumUser(String fname, String lname, String email, String userName, String password, Date birthDate, String phone_number, String address) {
        super(fname, lname, email, userName, password, birthDate, phone_number, address);
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
        PremiumUser that = (PremiumUser) o;
        return Objects.equals(getCreditCardNumber(), that.getCreditCardNumber());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(getCreditCardNumber());
    }
}
