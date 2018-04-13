package guo.kotlinweather.extensions

import java.text.DateFormat
import java.util.*

/**
 * 作者：author
 * 时间：2018/4/14:0:50
 * 说明：
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String{
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}