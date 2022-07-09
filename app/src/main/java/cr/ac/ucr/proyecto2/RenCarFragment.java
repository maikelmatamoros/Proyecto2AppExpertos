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
import cr.ac.ucr.proyecto2.model.RentCars;
import cr.ac.ucr.proyecto2.ui.ListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRenCarBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        Button searchRentCarBtn = (Button) root.findViewById(R.id.searchHotelBtn);
        searchRentCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Spinner carType = (Spinner) root.findViewById(R.id.carTypeSpinner);
                Spinner province = (Spinner) root.findViewById(R.id.provinceSpinner);
                Toast.makeText(getActivity(), "Cargando datos, por favor espere...", Toast.LENGTH_SHORT).show();
                Call<ArrayList<RentCars>> call= ApiAdapter.getApiService().getRecRentCars(carType.getSelectedItem().toString(), province.getSelectedItem().toString());
                call.enqueue(new Callback<ArrayList<RentCars>>() {
                    @Override
                    public void onResponse(Call<ArrayList<RentCars>> call, Response<ArrayList<RentCars>> response) {
                        if (response.isSuccessful()){
                            rentCars=response.body();

                            RentCarsListAdapter adapter=new RentCarsListAdapter(rentCars,getContext());
                            RecyclerView listaRentCars= (RecyclerView) getActivity().findViewById(R.id.recyclerViewHotels);
                            listaRentCars.setLayoutManager(new LinearLayoutManager(getContext()));
                            listaRentCars.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<RentCars>> call, Throwable t) {
                        Toast.makeText(getContext(), "No hay resultados para su búsqueda. Por favor cambie sus criterios de búsqueda.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return root;
    }

}