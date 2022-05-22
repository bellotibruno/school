package com.belloti.myapplication.Model;

import java.io.Serializable;

public class Register implements Serializable {

    private Long id;
    private String nameRegister;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRegister() {
        return nameRegister;
    }

    public void setNameRegister(String nameRegister) {
        this.nameRegister = nameRegister;
    }
}
