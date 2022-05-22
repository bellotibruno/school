package com.belloti.myapplication.Controller.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.belloti.myapplication.Model.Register;
import com.belloti.myapplication.R;

import java.util.List;

public class RegisterAdapter extends RecyclerView.Adapter<RegisterAdapter.MyViewHolder> {
    private List<Register> listRegister;

    public RegisterAdapter(List<Register> list) {
        this.listRegister = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_tarefa_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Register register = listRegister.get(position);
        holder.register.setText(register.getNameRegister());
        Log.i("registerAdapter", register.getNameRegister());

    }

    @Override
    public int getItemCount() {
        return this.listRegister.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView register;

        public MyViewHolder(View itemView) {
            super(itemView);

            register = itemView.findViewById(R.id.textRegister);

        }
    }

}
