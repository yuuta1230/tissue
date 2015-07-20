package self.yutkinos.tissue.entity

import com.google.android.gms.maps.model.LatLng
import kotlin.properties.Delegates


/**
 * Created by yuuta on 15/07/18.
 */

/**
{"coord":{"lon":139,"lat":35},
"sys":{"country":"JP","sunrise":1369769524,"sunset":1369821049},
"weather":[{"id":804,"main":"clouds","description":"overcast clouds","icon":"04n"}],
"main":{"temp":289.5,"humidity":89,"pressure":1013,"temp_min":287.04,"temp_max":292.04},
"wind":{"speed":7.31,"deg":187.002},
"rain":{"3h":0},
"clouds":{"all":92},
"dt":1369824698,
"id":1851632,
"name":"Shuzenji",
"cod":200}
 */

public class WeatherEntity{

    public var base: String = ""
    public var weather: List<Weather> = listOf()

//    data class Weather(var id: Int,
//                       var main: String,
//                       var description: String,
//                       var icon: String,
//                       var name: String,
//                       var coord: LatLng,
//                       var temp: Double,
//                       var temp_max: Double,
//                       var temp_min: Double,
//                       var humidity: Double,
//                       var pressure: Int,
//                       var wind_speed: Double,
//                       var wind_deg: Double)
    data class Weather(var id:Integer,
                       var main: String,
                       var description: String,
                       var icon: String)

}