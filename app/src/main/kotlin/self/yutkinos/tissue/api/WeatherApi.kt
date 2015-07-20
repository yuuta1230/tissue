package self.yutkinos.tissue.api

import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable
import self.yutkinos.tissue.entity.WeatherEntity

/**
 * Created by yuuta on 15/07/18.
 */

public trait  WeatherApi {

    [GET("/data/2.5/{name}")]
    fun get([Path("name")] name: String, [Query("q")] q : String): Observable<WeatherEntity>

}