package com.example.admin.week4day1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.week4day1.modal.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by  Admin on 11/27/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private static final String TAG = "ContactAdapter";

    List<Contact> contactList = new ArrayList<>();


    public ContactAdapter(List<Contact> contactList) {
        this.contactList = contactList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_contacts, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
final Contact contact = contactList.get(position);
if(contact!= null){
holder.showFirstName.setText(contact.getFirstName());
}
holder.showFirstName.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), ContactEdit.class);
        intent.putExtra("firstname", contact.getFirstName());
        intent.putExtra("lastname", contact.getLastName());
        intent.putExtra("mobile", contact.getMobileNumber());
        intent.putExtra("home", contact.getHomeNumber());
        intent.putExtra("id", contact.getId());

        view.getContext().startActivity(intent);


    }
});
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView showFirstName;

        public ViewHolder(View itemView) {
            super(itemView);
            showFirstName = itemView.findViewById(R.id.contactsList);


        }
    }
}
