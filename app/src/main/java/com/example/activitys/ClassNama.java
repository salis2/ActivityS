package com.example.activitys;

import androidx.appcompat.app.AppCompatActivity;

public class ClassNama extends AppCompatActivity {
    private String Nama;

    //inisialisasi objek
    public ClassNama(String nama)
    {
        this.Nama = nama;
    }

    //membuat method getName untuk mengembalikan nilai ke variabel Nama
    public String getName()
    {
        return this.Nama;
    }
}
