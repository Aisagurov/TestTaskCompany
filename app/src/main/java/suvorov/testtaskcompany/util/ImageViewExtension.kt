package suvorov.testtaskcompany.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import suvorov.testtaskcompany.R
import suvorov.testtaskcompany.util.Constants.BASE_URL

fun ImageView.loadImage(uri: String) {
    Glide.with(this)
        .load(BASE_URL + uri)
        .placeholder(R.drawable.place_holder_image)
        .error(R.drawable.no_image)
        .into(this)
}