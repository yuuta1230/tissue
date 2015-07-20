package self.yutkinos.tissue

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.util.Log
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.internal.bind.DateTypeAdapter
import retrofit.RestAdapter
import retrofit.android.AndroidLog
import retrofit.converter.GsonConverter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import self.yutkinos.tissue.api.WeatherApi
import self.yutkinos.tissue.entity.WeatherEntity
import java.util.*
import kotlinx.android.synthetic.activity_main.*
import self.yutkinos.tissue.api.ApiClient

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiClient.getWeatherApi()
                .get("weather","Tokyo,jp")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    entity -> textView.setText(entity.weather.get(0).main)
                })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item!!.getItemId()

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        private final val TAG: String = MainActivity().javaClass.getSimpleName()
    }
}
