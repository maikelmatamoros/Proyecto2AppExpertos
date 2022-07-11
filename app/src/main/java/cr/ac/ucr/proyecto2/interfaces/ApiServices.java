package cr.ac.ucr.proyecto2.interfaces;

import cr.ac.ucr.proyecto2.model.Atractivo;
import cr.ac.ucr.proyecto2.model.Detalles;
import cr.ac.ucr.proyecto2.model.Hotels;
import cr.ac.ucr.proyecto2.model.RentCars;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiServices {

    /*Rent a Cars*/
    @GET("getRentCars.php")
    public Call<List<RentCars>> getRentCars();

    @GET("getRecRentCars.php")
    public Call<ArrayList<RentCars>> getRecRentCars(@Query("carType") String carType, @Query("province") String province);

    /*Hotels*/
    @GET("getHotels.php")
    public Call<List<Hotels>> getHotels();

    @GET("getRecHotels.php")
    public Call<ArrayList<Hotels>> getRecHotels(@Query("hotelType") String hotelType, @Query("zone") String zone);

    @GET("euclidesAtractivos.php")
    Call<ArrayList<Atractivo>> getRecomendation(@Query("presupuesto") String presupuesto,
                                                       @Query("tipoTurismo") String tipoTurismo,
                                                       @Query("tipoAmbiente") String tipoAmbiente,
                                                       @Query("estrellas") String estrellas);
    @GET("getAtractivoPorId.php")
    Call<ArrayList<Detalles>> getAtractivoPorId(@Query("id") String id);

}
