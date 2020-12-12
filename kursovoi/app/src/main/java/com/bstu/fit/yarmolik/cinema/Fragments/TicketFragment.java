package com.bstu.fit.yarmolik.cinema.Fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bstu.fit.yarmolik.cinema.Adapters.TicketAdapter;
import com.bstu.fit.yarmolik.cinema.CheckInternetConnection;
import com.bstu.fit.yarmolik.cinema.Login;
import com.bstu.fit.yarmolik.cinema.ModelAdapter.TicketModel;
import com.bstu.fit.yarmolik.cinema.ModelAdapter.TicketStaticModel;
import com.bstu.fit.yarmolik.cinema.R;
import com.bstu.fit.yarmolik.cinema.Remote.IMyApi;
import com.bstu.fit.yarmolik.cinema.Remote.RetrofitClient;
import com.bstu.fit.yarmolik.cinema.Responces.UserTicket;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketFragment extends Fragment {
    CheckInternetConnection checkInternetConnection;
    private ConstraintLayout constraintLayout;
    private RecyclerView recyclerView;
    private IMyApi iMyApi;
    public boolean checkInternetState;
    private TicketAdapter ticketAdapter;
    private ArrayList<TicketModel> ticketModels;
    private ArrayList<TicketStaticModel> ticketStaticModels;
    private ArrayList<String> nameFilm,dateSeance,idSeance,timeSeance,cinema,hall,filmId,endTime,places;
    private boolean status=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket, container, false);
        init(view);
        try {
                if (Login.userRoleId == 1) {
                    constraintLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    loadUserTicketsInfo(Login.userId);
                } else if (Login.userRoleId == 3) {
                    constraintLayout.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
        }
        catch (Exception ex){
            Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }

        return view;
    }
    private void init(View view){
        constraintLayout=view.findViewById(R.id.ticketsConstraintLayoutNot);
        recyclerView=view.findViewById(R.id.recyclerTicketView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        iMyApi= RetrofitClient.getInstance().create(IMyApi.class);
        nameFilm=new ArrayList<>();
        idSeance=new ArrayList<>();
        dateSeance=new ArrayList<>();
        ticketModels=new ArrayList<>();
        ticketStaticModels =new ArrayList<>();
        timeSeance=new ArrayList<>();
        cinema=new ArrayList<>();
        hall=new ArrayList<>();
        filmId=new ArrayList<>();
        endTime=new ArrayList<>();
        checkInternetConnection=new CheckInternetConnection();
        places=new ArrayList<>();
    }
    private void loadUserTicketsInfo(String id){
        Call<List<UserTicket>> call=iMyApi.getTickets(id);
        call.enqueue(new Callback<List<UserTicket>>() {
            @Override
            public void onResponse(Call<List<UserTicket>> call, Response<List<UserTicket>> response) {
                if(!response.body().toString().equals("[]") || !response.body().toString().equals("")){
                    status=true;
                    for(UserTicket userTicket: response.body()){
                        nameFilm.add(userTicket.getName());
                        idSeance.add(userTicket.getSeanceId());
                        dateSeance.add(userTicket.getDate());
                        timeSeance.add(userTicket.getTime());
                        cinema.add(userTicket.getCinema());
                        hall.add(userTicket.getHall());
                        filmId.add(userTicket.getFilmId());
                        endTime.add(userTicket.getEndTime());
                    }
                    for(int i=0;i<nameFilm.size();i++){
                        try{
                        ticketModels.add(new TicketModel(nameFilm.get(i),
                                idSeance.get(i),
                                dateSeance.get(i),
                                timeSeance.get(i),
                                cinema.get(i),
                                hall.get(i),
                                filmId.get(i),
                                endTime.get(i)));
                        }
                        catch (Exception ex){
                            Toast.makeText(getContext(),ex.getMessage()+" Exception",Toast.LENGTH_SHORT).show();
                        }
                    }
                    if(ticketModels.size()==0){
                        constraintLayout.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                    }
                    else {
                        ticketAdapter = new TicketAdapter(ticketModels, TicketFragment.this);
                        recyclerView.setAdapter(ticketAdapter);
                    }
                }
                else{
                    status=false;
                }
            }

            @Override
            public void onFailure(Call<List<UserTicket>> call, Throwable t) {
                constraintLayout.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            }
        });
    }
}
