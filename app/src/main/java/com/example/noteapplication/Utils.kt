package com.example.noteapplication

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily


fun Context.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun View.visible() {

}
fun ShapeableImageView.setCornerRadius(
    topRight: Float = 0f,
    topLeft: Float = 0f,
    bottomRight: Float = 0f,
    bottomLeft: Float = 0f
) {
    this.shapeAppearanceModel = this.shapeAppearanceModel
        .toBuilder()
        .setTopLeftCorner(CornerFamily.ROUNDED, topLeft)
        .setTopRightCorner(CornerFamily.ROUNDED, topRight)
        .setBottomLeftCorner(CornerFamily.ROUNDED, bottomLeft)
        .setBottomRightCorner(CornerFamily.ROUNDED, bottomRight)
        .build()
}




//Примеры:
/* fun setupViews() {
    val count = 100
    var sum = "$count сом"
    var sumExtension = count.toString().toSom()
}

fun View.toGone() {
    this.visibility = View.GONE
}

tv_name.visibility = View.GONE
tv_name.toGone()

fun showToast1(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}
 */