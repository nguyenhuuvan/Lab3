package com.lab3.poly.lab3.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lab3.poly.lab3.R;
import com.lab3.poly.lab3.model.MyContact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder>{
    private Context context;
    private List<MyContact> myContact;

    public ContactAdapter(Context context, List<MyContact> myContact) {
        this.context = context;
        this.myContact = myContact;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        holder.tvname.setText(myContact.get(position).getName());
        holder.tvSDT.setText(myContact.get(position).getSdt());
        holder.img.setImageResource(myContact.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return myContact.size();
    }

    public class ContactHolder extends RecyclerView.ViewHolder{
        public TextView tvname;
        public TextView tvSDT;
        public ImageView img;
        public ContactHolder(View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tvName);
            tvSDT = itemView.findViewById(R.id.tvSDR);
            img = itemView.findViewById(R.id.imgAvatar);
        }
    }
}
