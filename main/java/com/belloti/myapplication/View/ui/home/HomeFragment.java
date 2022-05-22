package com.belloti.myapplication.View.ui.home;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.belloti.myapplication.Helper.RegisterDAO;
import com.belloti.myapplication.Model.Register;
import com.belloti.myapplication.R;

public class HomeFragment extends Fragment {
    private TextInputEditText editRegister;
    private Button save;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        editRegister = view.findViewById(R.id.textRegister);
        save = view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveConfigure();
            }
        });

        return view;
    }
    private void saveConfigure() {
            RegisterDAO registerDAO = new RegisterDAO(getActivity());

            String nameRegister = editRegister.getText().toString();
            if (!nameRegister.isEmpty()) {
                Register register = new Register();
                register.setNameRegister(nameRegister);

                if (registerDAO.save(register)) {
                    Toast.makeText(getActivity(),
                            "Salvo com Sucesso!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(),
                            "Erro ao salvar !",
                            Toast.LENGTH_SHORT).show();
                }

            }

    }


}