package com.belloti.myapplication.View.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.belloti.myapplication.Controller.Adapter.RegisterAdapter;
import com.belloti.myapplication.Helper.RegisterDAO;
import com.belloti.myapplication.Model.Register;
import com.belloti.myapplication.R;
import com.belloti.myapplication.View.RequesterActivity;

import java.util.ArrayList;
import java.util.List;

public class RegisterFragment extends Fragment {
    RecyclerView recyclerView;
    private RegisterAdapter registerAdapter;
    private List<Register> listRegister = new ArrayList<>();
    private  Button button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        RegisterDAO registerDAO = new RegisterDAO(getActivity());
        listRegister = registerDAO.listar();

        registerAdapter = new RegisterAdapter(listRegister);

        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(registerAdapter);

        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RequesterActivity.class));
            }
        });

        return view;
    }
}