package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Rent;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentController {

    List<Rent> rents = new ArrayList<Rent>();

    public RentController() {
    }

    public boolean returnRent(Rent rent) {
        if (rent != null && rent.getReturnedAt() == null) {
            rent.setReturnedAt(new Date());
            Integer index = rents.indexOf(rent);
            if (index >= 0) {
                rents.set(index, rent);
                return true;
            }
        }
        return false;
    }

    public Rent find(User user, Object item) {
        for (Rent rent: rents) {
            if (rent.getUser().equals(user) && rent.getItem().equals(item) && rent.getReturnedAt() == null) {
                return rent;
            }
        }
        return null;
    }

    public boolean add(Rent rent) {
        if (rent != null) {
            return rents.add(rent);
        }
        return false;
    }
}
