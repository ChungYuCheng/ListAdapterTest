package com.example.listadaptertest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class OneLineItemDecoration(val context: Context): RecyclerView.ItemDecoration() {
    private val dividerHeight = 20

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.top = dividerHeight
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        //分隔線顏色
        val dividerPaint = Paint().apply {
            color = context.resources.getColor(R.color.black)
        }

        val dividerLeft = 30
        val dividerRight = 30

        for (i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            //畫1px的分隔線
            c.drawRect((parent.paddingLeft + dividerLeft).toFloat(),
                (view.bottom + dividerHeight -1 ).toFloat(),
                (parent.width - parent.paddingRight - dividerRight).toFloat(),
                (view.bottom + dividerHeight ).toFloat(),
                dividerPaint)
        }
    }
}