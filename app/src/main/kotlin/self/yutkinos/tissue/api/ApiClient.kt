package self.yutkinos.tissue.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.internal.bind.DateTypeAdapter
import kotlinx.android.synthetic.activity_main.textView
import retrofit.RestAdapter
import retrofit.android.AndroidLog
import retrofit.converter.GsonConverter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import self.yutkinos.tissue.entity.WeatherEntity
import java.util.*

/**
 * Created by yuuta on 15/07/18.
 */

object  ApiClient{

    private final val TAG: String = ApiClient.javaClass.getSimpleName()

    private final val END_POINT: String = "http://api.openweathermap.org"

    private val gson: Gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(javaClass<Date>(), DateTypeAdapter())
            .create()

    private val adapter: RestAdapter = RestAdapter.Builder()
            .setEndpoint(END_POINT)
            .setConverter(GsonConverter(gson))
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setLog(AndroidLog(TAG + ":=NETWORK="))
            .build()


    fun getWeatherApi(): WeatherApi{
        return  adapter.create(javaClass<WeatherApi>())
    }

}