package guo.kotlinweather

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import guo.kotlinweather.domain.model.Forecast
import guo.kotlinweather.domain.model.ForecastList
import guo.kotlinweather.extensions.ctx
import guo.kotlinweather.extensions.toDateString
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * 作者：author
 * 时间：2018/4/14:0:25
 * 说明：
 */
class ForecastListAdapter(private val weekForecast: ForecastList ,
      private val itemclick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(View.inflate(parent.ctx,R.layout.item_forecast,null),itemclick)
    }

    override fun getItemCount() = weekForecast.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }


    class ViewHolder(view: View , private val itemclick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view){
        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.get().load(iconUrl).into(itemView.icon)
                itemView.date.text = date.toDateString()
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener{itemclick(this)}
            }
        }
    }

}