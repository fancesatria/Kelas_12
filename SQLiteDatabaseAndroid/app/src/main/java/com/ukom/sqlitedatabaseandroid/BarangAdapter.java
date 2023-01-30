package com.ukom.sqlitedatabaseandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder>{

    Context context;
    List<BarangModel> barangModelList;//

    public BarangAdapter(Context context, List<BarangModel> barangModelList) {
        this.context = context;
        this.barangModelList = barangModelList;//ambil data dr model yg dimasukkan kedalam type list
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);//memasukkan data kedalam item barang
        return new ViewHolder(v);
    }

    @Override//ONBIND = MASUKIN DATA
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tbarang.setText(barangModelList.get(position).getBarang());
        holder.tstok.setText(barangModelList.get(position).getStok());
        holder.tharga.setText(barangModelList.get(position).getHarga());

        holder.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, holder.option);//ini context bukan this krn ini akan dipanggil di mainactivity
                popupMenu.inflate(/*lokasi menunya dimna?*/ R.menu.menu);

                //AMBIL VALUE DR MENU
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch(menuItem.getItemId()){
                            case R.id.edit:
                                ((MainActivity)context).selectwhere(barangModelList.get(position).getIdbarang());
                            break;

                            case R.id.hapus:
                            //CALL FUNC FROM ACTIVITY
                                ((MainActivity)context).deletedata(barangModelList.get(position).getIdbarang());
                            break;

                        }
                        return false;
                    }
                });
                popupMenu.show();//tampilkan popupmenu
            }
        });
    }

    @Override
    public int getItemCount() {
        return barangModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tbarang, tstok, tharga, option;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tbarang = itemView.findViewById(R.id.txtbarang);
            tstok = itemView.findViewById(R.id.txtstok);
            tharga = itemView.findViewById(R.id.txtharga);
            option = itemView.findViewById(R.id.option);
        }
    }
}
