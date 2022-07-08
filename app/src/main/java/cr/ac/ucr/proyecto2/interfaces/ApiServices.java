package cr.ac.ucr.proyecto2.interfaces;

import cr.ac.ucr.proyecto2.model.RentCars;

import java.util.ArrayList;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiServices {

    /**/
    @GET("getRentCars.php")
    public Call<List<RentCars>> getRentCars();

    @GET("getRecRentCars.php")
    public Call<ArrayList<RentCars>> getRecRentCars(@Query("carType") String carType, @Query("province") String province);

}
