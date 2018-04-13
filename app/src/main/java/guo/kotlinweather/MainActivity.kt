package guo.kotlinweather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import guo.kotlinweather.domain.model.ForecastList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() ,ToolbarManager{

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar();
        forecastList.layoutManager = LinearLayoutManager(this)

        attachToScroll(forecastList)
    }

    override fun onResume() {
        super.onResume()
        loadRecyclerView()
    }

    fun loadRecyclerView() = async(UI) {
        val result = bg {

        }
        //updateUI(result.await())

    }

    private fun updateUI(weekForecast: ForecastList){
        val adapter = ForecastListAdapter(weekForecast){
            startActivity<DetailActivity>()
        }
        forecastList.adapter = adapter
        toolbarTitle = "${weekForecast.city} (${weekForecast.country})"
    }


}

