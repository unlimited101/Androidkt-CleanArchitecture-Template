package de.flocksserver.androidkt_cleanarchitecture_template.model

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView
import de.flocksserver.androidkt_cleanarchitecture_template.R

/**
 * Created by marcel on 8/30/17.
 */
class ItemView(context: Context, private val name: String?) : TextView(context){

    var clicked: Boolean = false

    init {
        setStyle()
    }

    private fun setStyle() {
        text = name
        setTypeface(Typeface.SANS_SERIF, Typeface.BOLD)
        setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
        textAlignment = View.TEXT_ALIGNMENT_CENTER
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        setStyle()
    }
}