package com.example.noteapplication.ui.create.color_sheet

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapplication.ColorType
import com.example.noteapplication.R
import com.example.noteapplication.base.BaseAdapter
import com.example.noteapplication.base.BaseViewHolder
import com.example.noteapplication.setCornerRadius
import kotlinx.android.synthetic.main.item_color.view.*
import kotlinx.android.synthetic.main.item_project.view.*

class ColorBottomSheetAdapter: BaseAdapter() {

    val colorArray = listOf<Int>(30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ColorBottomSheetViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return colorArray.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        setupColorBottomSheetViewHolder(holder as ColorBottomSheetViewHolder, position)
    }

    private fun setupColorBottomSheetViewHolder(holder: ColorBottomSheetViewHolder, position: Int){
        val color = colorArray[position]
        holder.bind(color)
    }
}

class ColorBottomSheetViewHolder(itemView: View): BaseViewHolder(itemView){
    fun bind(item: Int) {
        val radius = itemView.context.resources.getDimension(R.dimen.dp_25)
        itemView.view_color.setBackgroundColor(ColorType.getProjectColorType(item))

        itemView.view_color.setCornerRadius(
            topLeft = radius,
            topRight = radius,
            bottomRight = radius,
            bottomLeft = radius
        )
    }
}

interface ClickListener {
    fun onItemClick(item: Int)
}