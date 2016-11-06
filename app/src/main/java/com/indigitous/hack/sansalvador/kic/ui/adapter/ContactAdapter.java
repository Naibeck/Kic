package com.indigitous.hack.sansalvador.kic.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.indigitous.hack.sansalvador.kic.R;
import com.indigitous.hack.sansalvador.kic.model.Contact;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> mContacts;
    private Context mContext;

    public ContactAdapter(List<Contact> mContacts, Context mContext) {
        this.mContacts = mContacts;
        this.mContext = mContext;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.contactName.setText(mContacts.get(position).getContactName());
        holder.contactDesc.setText(mContacts.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_item_contact_list)
        TextView contactName;

        @BindView(R.id.tv_item_contact_desc)
        TextView contactDesc;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
