package guo.kotlinweather.domain.model

/**
 * 作者：author
 * 时间：2018/4/13:23:45
 * 说明：
 */

data class ForecastList(val id:Long, val city: String, val country: String,
                        val dailyForecast: List<Forecast>){
    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int) = dailyForecast[position]
}

data class Forecast(val id: Long, val date: Long, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)