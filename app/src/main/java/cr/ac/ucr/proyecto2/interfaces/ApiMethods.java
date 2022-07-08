package cr.ac.ucr.proyecto2.interfaces;

import cr.ac.ucr.proyecto2.model.RentCars;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiMethods {

    /**/
    @GET("getRentCars.php")
    public Call<List<RentCars>> getRentCars();

    @POST("getRecRentCars.php")
    public Call<List<RentCars>> getRecRentCars(@Field("carType") String carType, @Field("province") String province);

}
