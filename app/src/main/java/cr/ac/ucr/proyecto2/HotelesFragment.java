package cr.ac.ucr.proyecto2;

import android.os.Bundle;

import androidx.annotation.NonNull;
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

import cr.ac.ucr.proyecto2.adapters.HotelsListAdapter;
import cr.ac.ucr.proyecto2.databinding.FragmentHotelesBinding;
import cr.ac.ucr.proyecto2.databinding.FragmentRenCarBinding;
import cr.ac.ucr.proyecto2.interfaces.ApiAdapter;
import cr.ac.ucr.proyecto2.model.Hotels;
import cr.ac.ucr.proyecto2.ui.ListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotelesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelesFragment extends Fragment {
    private ArrayList<Hotels> hotels;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private @NonNull FragmentHotelesBinding binding;
    private List<ListElement> elements;
    private ListAdapter rentCarAdapter;

    public HotelesFragment() {
        // Required empty public constructor
    }

    public static HotelesFragment newInstance(String param1, String param2) {
        HotelesFragment fragment = new HotelesFragment();
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
        binding = FragmentHotelesBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        Button searchHotelBtn = (Button) root.findViewById(R.id.searchHotelBtn);
        searchHotelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Spinner hotelType = (Spinner) root.findViewById(R.id.hotelTypeSpinner);
                Spinner zone = (Spinner) root.findViewById(R.id.touristicZoneSpinner);
                Toast.makeText(getActivity(), "Cargando datos, por favor espere...", Toast.LENGTH_SHORT).show();
                Call<ArrayList<Hotels>> call= ApiAdapter.getApiService().getRecHotels(hotelType.getSelectedItem().toString(), zone.getSelectedItem().toString());
                call.enqueue(new Callback<ArrayList<Hotels>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Hotels>> call, Response<ArrayList<Hotels>> response) {
                        if (response.isSuccessful()){
                            hotels=response.body();

                            HotelsListAdapter adapter=new HotelsListAdapter(hotels,getContext());
                            RecyclerView listaHotels= (RecyclerView) getActivity().findViewById(R.id.recyclerViewHotels);
                            listaHotels.setLayoutManager(new LinearLayoutManager(getContext()));
                            listaHotels.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Hotels>> call, Throwable t) {
                        Toast.makeText(getContext(), "No hay resultados para su búsqueda. Por favor cambie sus criterios de búsqueda.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return root;
    }
}