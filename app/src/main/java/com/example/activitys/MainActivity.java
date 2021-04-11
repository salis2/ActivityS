package com.example.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk edittext
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen buttton pada layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button di layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);

        //Menbuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Menyimpan input user di edittext kedalam variabel nama
                nama = edemail.getText().toString();

                //Menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();


                //Membuat variabel Toast dan membuat toast dengan menambahkan variabel nama dan password
                //Toast t = Toast.makeText(getApplicationContext(),"email anda: "+nama+" dan password anda: "+password+"", Toast.LENGTH_LONG);
                //Menampilkan toast
                //t.show();

                //Mengeset email dan password yang benar
                String email = "admin@mail.com";
                String pass = "123";

                //Mengecek apakah isi dari email dan password sudah sama dengan email dan password yang sudah di set
                if(nama.equals(email) && password.equals(pass)){
                    //Membuat variabel Toast dan menampilkan pesan "Login Sukses"
                    Toast t = Toast.makeText(getApplicationContext(),"Login Sukses", Toast.LENGTH_LONG);
                    //Menampilkan Toast
                    t.show();

                    //Membuat objek Bundle
                    Bundle b = new Bundle();

                    //Memasukan value dari variabel nama dengan kunci "a" dan dimasukan kedalam bundle
                    b.putString("a", nama.trim());

                    //Memasukan value dari variabel password dengan kunci "b" dan dimasukan kedalam bundle
                    b.putString("b", password.trim());

                    //Membuat objek intent berpindah activity dari mainactivity ke activityHasil
                    //Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                    //Membuat objek intent berpindah activity dari mainactivity ke Home_activity
                    Intent i = new Intent(getApplicationContext(), Home_Activity.class);

                    //Memasukan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                    i.putExtras(b);

                    //Berpindah ke ActivityHasil
                    startActivity(i);

                } else{
                    //Membuat variabel Toast dan membuat toast dan menampilakn pesan "Login Gagal"
                    Toast t = Toast.makeText(getApplicationContext(),"Login Gagal", Toast.LENGTH_LONG);
                    //Menampilkan Toast
                    t.show();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        //membuat kondisi jika yang dipilih adalah id mnDaftar
        if(item.getItemId() == R.id.mnDaftar){
            //Method untuk memanggil activity "DaftarActovity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}