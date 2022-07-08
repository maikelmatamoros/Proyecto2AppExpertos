package cr.ac.ucr.proyecto2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cr.ac.ucr.proyecto2.adapters.RentCarsListAdapter;
import cr.ac.ucr.proyecto2.databinding.FragmentRenCarBinding;
import cr.ac.ucr.proyecto2.interfaces.ApiAdapter;
import cr.ac.ucr.proyecto2.interfaces.ApiServices;
import cr.ac.ucr.proyecto2.model.RentCars;
import cr.ac.ucr.proyecto2.ui.ListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RenCarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RenCarFragment extends Fragment{
    private ArrayList<RentCars> rentCars;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private FragmentRenCarBinding binding;
    private List<ListElement> elements;
    private ListAdapter rentCarAdapter;

    public RenCarFragment() {
        // Required empty public constructor
    }


    public static RenCarFragment newInstance(String param1, String param2) {
        RenCarFragment fragment = new RenCarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRenCarBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        Button searchRentCarBtn = (Button) root.findViewById(R.id.searchRentACarBtn);
        searchRentCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Spinner carType = (Spinner) root.findViewById(R.id.carTypeSpinner);
                Spinner province = (Spinner) root.findViewById(R.id.provinceSpinner);
                Toast.makeText(getActivity(), "Cargando Datos, por favor espere...", Toast.LENGTH_SHORT).show();
                Call<ArrayList<RentCars>> call= ApiAdapter.getApiService().getRecRentCars(carType.getSelectedItem().toString(), province.getSelectedItem().toString());
                call.enqueue(new Callback<ArrayList<RentCars>>() {
                    @Override
                    public void onResponse(Call<ArrayList<RentCars>> call, Response<ArrayList<RentCars>> response) {
                        if (response.isSuccessful()){
                            rentCars=response.body();

                            RentCarsListAdapter adapter=new RentCarsListAdapter(rentCars,getContext());
                            RecyclerView listaRentCars= (RecyclerView) getActivity().findViewById(R.id.recyclerViewRentCars);
                            listaRentCars.setLayoutManager(new LinearLayoutManager(getContext()));
                            listaRentCars.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<RentCars>> call, Throwable t) {
                        Toast.makeText(getContext(), "Ocurrió un error, trate más tarde", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return root;
    }


 /*   public void getRecRentCars(View root, String carType, String province) {
        Retrofit retrofit = new  Retrofit.Builder().baseUrl("localhost/PhpRest/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiServices getRecRentCars = retrofit.create(ApiServices.class);
        Call<List <RentCars>> call = getRecRentCars.getRecRentCars(carType, province);
        call.enqueue(new Callback<List<RentCars>>() {
            @Override
            public void onResponse(Call<List<RentCars>> call, Response<List<RentCars>> response) {
                if(response.isSuccessful()){
                    List<RentCars> listRentCars = response.body();
                    init(root,listRentCars);
                }

            }

            @Override
            public void onFailure(Call<List<RentCars>> call, Throwable t) {

            }
        });
    }
*/
/*    public void init(View root, List <RentCars> listRentCars){
        elements = new ArrayList<>();

        for (RentCars rentCar : listRentCars)
        {
            elements.add(new ListElement(rentCar.getNombre(), rentCar.getDescripcion(),rentCar.getTelefono(), rentCar.getSitioWeb(),rentCar.getImagen(),rentCar.getEstrellas()));
        }

        ListAdapter listAdapter =  new ListAdapter(elements, root.getContext());
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerViewRentCars);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(listAdapter);
        rentCarAdapter = listAdapter;

    }*/

}