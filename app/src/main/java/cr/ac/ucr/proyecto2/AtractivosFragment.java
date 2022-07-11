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

import cr.ac.ucr.proyecto2.adapters.AtractivosListAdapter;
import cr.ac.ucr.proyecto2.adapters.HotelsListAdapter;
import cr.ac.ucr.proyecto2.databinding.FragmentAtractivosBinding;
import cr.ac.ucr.proyecto2.databinding.FragmentHotelesBinding;
import cr.ac.ucr.proyecto2.interfaces.ApiAdapter;
import cr.ac.ucr.proyecto2.model.Atractivo;
import cr.ac.ucr.proyecto2.model.Hotels;
import cr.ac.ucr.proyecto2.ui.ListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AtractivosFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class AtractivosFragment extends Fragment {

    private ArrayList<Atractivo> atractivos;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private @NonNull
    FragmentAtractivosBinding binding;
    private List<list_atractivo_item> elements;
    private ListAdapter atractivosAdapter;

    // TODO: Rename and change types and number of parameters
    public static AtractivosFragment newInstance(String param1, String param2) {
        AtractivosFragment fragment = new AtractivosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AtractivosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAtractivosBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        Button searchAtractivosBtn = (Button) root.findViewById(R.id.searchAtractivosBtn);
        searchAtractivosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Spinner precio = (Spinner) root.findViewById(R.id.budgetSpinner);
                Spinner tipoLugar = (Spinner) root.findViewById(R.id.environmentTypeSpinner);
                Spinner tipoTurista = (Spinner) root.findViewById(R.id.typeTourismSpinner);
                Spinner estrellas = (Spinner) root.findViewById(R.id.starsSpinner);
                //Toast.makeText(getActivity(), precio.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Cargando datos, por favor espere...", Toast.LENGTH_SHORT).show();
                int precioVal = 0;
                if(precio.getSelectedItem().toString().equalsIgnoreCase("Menos de 10000")) precioVal = 1000;
                else if(precio.getSelectedItem().toString().equalsIgnoreCase("Más de 10000 y menos de 50000")) precioVal = 12000;
                else precioVal = 51000;
                Call<ArrayList<Atractivo>> call= ApiAdapter.getApiService().getRecomendation(String.valueOf(precioVal),
                        tipoTurista.getSelectedItem().toString(),
                        tipoLugar.getSelectedItem().toString(),
                        estrellas.getSelectedItem().toString());
                call.enqueue(new Callback<ArrayList<Atractivo>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Atractivo>> call, Response<ArrayList<Atractivo>> response) {
                        if (response.isSuccessful()){
                            atractivos=response.body();

                            AtractivosListAdapter adapter=new AtractivosListAdapter(atractivos,getContext());
                            RecyclerView listaAtractivos= (RecyclerView) getActivity().findViewById(R.id.recyclerViewAtractivos);
                            listaAtractivos.setLayoutManager(new LinearLayoutManager(getContext()));
                            listaAtractivos.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Atractivo>> call, Throwable t) {
                        Toast.makeText(getContext(), "No hay resultados para su búsqueda. Por favor cambie sus criterios de búsqueda.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return root;
    }
}