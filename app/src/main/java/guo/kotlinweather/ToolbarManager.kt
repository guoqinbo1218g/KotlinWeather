package guo.kotlinweather

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import guo.kotlinweather.extensions.ctx
import guo.kotlinweather.extensions.slideEnter
import guo.kotlinweather.extensions.slideExit
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 作者：author
 * 时间：2018/4/13:22:53
 * 说明：
 */
interface ToolbarManager{
    val toolbar: Toolbar
    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar() {
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.action_settings -> toolbar.ctx.startActivity<SettingsActivity>()
                else -> App.instance.toast("Unknown option")
            }
            true

        }
    }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView ,dx: Int, dy: Int){
                if (dy > 0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
    }

}