package com.indigitous.hack.sansalvador.kic.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.indigitous.hack.sansalvador.kic.R;
import com.indigitous.hack.sansalvador.kic.model.Contact;
import com.indigitous.hack.sansalvador.kic.network.KicService;
import com.indigitous.hack.sansalvador.kic.ui.adapter.ContactAdapter;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Trainee-Dev on 11/6/2016.
 */
public class ContactFragment extends BaseFragment {

    @BindView(R.id.rv_contact_list)
    RecyclerView contactList;

    private ContactAdapter mContactAdapter;

    public static ContactFragment getInstance() {
        return new ContactFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_contact_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contactList.setHasFixedSize(true);
        getContact();
    }

    private void getContact() {
        Call<List<Contact>> contactCall = KicService.getApi()
                .getContact(String.valueOf(getPreferences().getToken().getId()));
        contactCall.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                mContactAdapter = new ContactAdapter(response.body(), getContext());
                contactList.setAdapter(mContactAdapter);
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_scan_qr:
                Toast.makeText(getContext(), "Will launch scan reader", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
