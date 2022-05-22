package com.belloti.myapplication.Helper;

import com.belloti.myapplication.Model.Register;

import java.util.List;


public interface IRegisterDAO {

    public boolean save(Register register);
    public List<Register> listar();

}
