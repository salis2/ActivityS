package com.example.activitys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //Deklarasi variabel dengan jenis data context
    Context mContext;

    //Deklarasi variabel dengan jenis data Layout inflater
    LayoutInflater inflater;

    //Deklarasi variabel dengan jenis data arrayList
    private ArrayList<ClassNama> arrayList;

    //Membuat konstruktor ListViewadapter
    public ListViewAdapter(Context context){
        //memberi nilai mContext dengan context
        mContext = context;

        //Mengatur Layoutinflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //Memberikan nilai arrayList dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //menambahkan semua element ke arrayList
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }

    //Membuat class untuk mendeklarasikan tempat untuk meletakkan isi kedalam ListView
    public class ViewHolder {
        //mendeklarasikan variabel dengan jenis TextView
        TextView name;
    }


    @Override
    //fungsi getCount() mengembalikan jumlah item yang akan ditampilkan dalam List
    public int getCount() {
        //Mengembalikan nilai berupa jumlah data dari array data
        return Home_Activity.classNamaArrayList.size();
    }

    @Override
    //Fungsi ini digunakan untuk mendapatkan data item yang terkait dengan posisi tertentu dalam kumpulan data
    //untuk mendapatkan data yang sesuai dari lokasi tertentu dalam pengumpulan data item.
    public Object getItem(int i) {
        //mengembalikan nilai berupa objek dari array data
        return Home_Activity.classNamaArrayList.get(i);
    }

    @Override
    //Fungsi mengembalikan "nilai" dari posisi item ke adaptor.
    public long getItemId(int i) {
        return i;
    }

    @Override
    //Fungsi ini secara otomatis dipanggil ketika tampilan item List untuk ditampilkan atau akan ditampilkan
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variabel dengan jenis variabel data ViewHolder
        final ViewHolder holder;

        //membuat kondisi apakah view null atau tidak
        if(view == null) {
            //membuat objek View holder
            holder = new ViewHolder();

            //mengatur Layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview, null);

            //set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama);

            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain.
            view.setTag(holder);
        }else{
            //mengatur holder untuk mengembalikan nilai dari view tag.
            holder = (ViewHolder) view.getTag();
        }
        //set item ke TextViews
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());

        //mengembalikan nilai ke variabel view
        return view;
    }
}
