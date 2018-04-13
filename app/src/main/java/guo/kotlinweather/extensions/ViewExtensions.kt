package guo.kotlinweather.extensions

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * 作者：author
 * 时间：2018/4/13:23:13
 * 说明：
 */
val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(value) = setTextColor(value)

fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}
fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}