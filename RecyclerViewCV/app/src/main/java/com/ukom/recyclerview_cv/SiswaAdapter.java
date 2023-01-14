package com.ukom.recyclerview_cv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//ini adapter buat load data trs ditampilin ke view(sederhananya)
public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder>{
    Context context;//krn gk tau activty mana yg akan make ini(unknown actvty)
    //masukkan data dr modelnya
    private List<Siswa> siswaList;//ini ngambil file model

    //buat constructor utk request
    public SiswaAdapter(Context context, List<Siswa> siswaList) {
        this.context = context;
        this.siswaList = siswaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //biar keseluruhan item bisa tampil di recyclerview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_siswa, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //ini buat ngisi data 1 by 1, bcs datany byk
        Siswa siswa = siswaList.get(position);//ambil modelnya

        //panggil nama component dr view yg mau dimasukkan datanya
        holder.tvNama.setText(siswa.getNama());//ambil nama dr model siswa diatas
        holder.tvAlamat.setText(siswa.getAlamat());

        /*
        //AMBIL DATA MASING2 ITEM
        //onclick cardviewnya
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Nama : "+siswa.getNama()+"  Alamat : "+siswa.getAlamat(), Toast.LENGTH_SHORT).show();
            }
        });
        */

        //MENU OPTION
        holder.tvmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //POPUP MENU
                PopupMenu popup = new PopupMenu(context, holder.tvmenu);//manggil context, yg dipanggil holder.tvmenu
                popup.inflate(R.menu.menu_option);
                //MEMBUAT AKSI DR TIAP OPTION
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        //di switch sesuai menu optionnya
                        switch(menuItem.getItemId()){
                            case R.id.menusimpan:
                                Toast.makeText(context, "Simpan data "+siswa.getClass(), Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.menuhapus:
                                siswaList.remove(position);//hapus data dr variabel siswalist
                                //MEREFRESH RECYCLERVIEW
                                notifyDataSetChanged();
                                Toast.makeText(context, "Data "+siswa.getNama()+" berhasil dihapus", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popup.show();//menampilkan popup

            }
        });
    }

    @Override
    public int getItemCount() {
        return siswaList.size();//ambil jumlah data yg ada dr model
    }

    //biar itemmnya dikenali oleh adapter/java
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat, tvmenu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);//ini itemview krn ini akan dimskn ke recyclerview
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvmenu = itemView.findViewById(R.id.tvmenu);
        }
    }
}
