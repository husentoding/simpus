package com.example.user.simpus;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import database.DBHelper;
import database.JurusanDAO;
import database.MahasiswaDAO;
import database.SiswaDAO;
import database.UniversitasDAO;
import model.Mahasiswa;
import model.Siswa;

public class LoginActivity extends AppCompatActivity {

    SQLiteDatabase database;
    DBHelper db;
    UniversitasDAO universitasDAO;
    JurusanDAO jurusanDAO;
    SiswaDAO siswaDAO;
    MahasiswaDAO mahasiswaDAO;
    public String currentUserEmail;
    List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();
    List<Siswa> siswaList = new ArrayList<Siswa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //database
        db = new DBHelper(this);
        mahasiswaDAO = new MahasiswaDAO(this);
        siswaDAO = new SiswaDAO(this);

        //insert
        mahasiswaDAO.createMahasiswa("lol@gmail.com", "lol1", "oki", "Telkom");

        //read
        mahasiswaList = mahasiswaDAO.getAllMahasiswa();
        siswaList = siswaDAO.getAllSiswa();

        final EditText etEmail = (EditText) findViewById(R.id.textEmail);
        final EditText etPassword= (EditText) findViewById(R.id.textPassword);
        final Button bLogin = (Button) findViewById(R.id.loginButton);
        final TextView textRegister= (TextView) findViewById(R.id.textviewRegister);

        private final String emailUser = etEmail.getText().toString();
        private final String password = etPassword.getText().toString();

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailUser == null) || (password == null){
                    if ((etEmail.getText().toString()=="admin") && (etPassword.getText().toString()=="admin")) {
                        currentUserEmail = etEmail.getText().toString();
                        Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                        LoginActivity.this.startActivity(loginIntent);
                    }
                    else if ((etEmail.getText().toString()==mahasiswaDAO.getMahasiswa(etEmail.getText().toString())) && (etPassword.getText().toString()!="admin")) {

                    }

                }else{
                    Snackbar.make(v, "Fill the Email and Password", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent= new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });


    }
}
