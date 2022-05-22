package com.belloti.myapplication.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.belloti.myapplication.Model.Register;

import java.util.ArrayList;
import java.util.List;



public class RegisterDAO implements IRegisterDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public RegisterDAO(Context context) {
        DbHelper db = new DbHelper( context );
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean save(Register register) {

        ContentValues cv = new ContentValues();
        cv.put("nome", register.getNameRegister());

        try {
            escreve.insert(DbHelper.TABELA_TAREFAS, null, cv );
            Log.i("INFO", "Registro salvo com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao salvar registro " + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public List<Register> listar() {

        List<Register> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Register tarefa = new Register();

            Long id = c.getLong( c.getColumnIndex("id") );
            String nomeTarefa = c.getString( c.getColumnIndex("nome") );

            tarefa.setId( id );
            tarefa.setNameRegister( nomeTarefa );

            tarefas.add( tarefa );
            Log.i("tarefaDao", tarefa.getNameRegister() );
        }

        return tarefas;

    }
}
