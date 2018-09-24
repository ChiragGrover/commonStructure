package skycap.com.driver.go4er.views.bindings

import android.databinding.BindingAdapter
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatRatingBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.request.ImageRequest
import skycap.com.driver.go4er.R

class CustomBindings {

    companion object {

        @BindingAdapter("error", "isValid", "isErrorShown")
        @JvmStatic
        fun setError(editText: EditText, errorMessage: String, isValid: Boolean, isErrorShown: Boolean) {
            if (errorMessage != "") {
                if (isErrorShown && !isValid) {
                    editText.error = errorMessage
                }
            }
        }

        @BindingAdapter("android:visibility")
        @JvmStatic
        fun setVisibility(view: View, value: Boolean?) {
            view.visibility = if (value!!) View.VISIBLE else View.GONE
        }


        @BindingAdapter("url")
        @JvmStatic
        fun bindSimpleDraweeView(view: SimpleDraweeView, url: String) {

//            val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
//                    .setResizeOptions(ResizeOptions(250, 250))
//                    .build()

            val builder = Fresco.newDraweeControllerBuilder()
                    .setImageRequest(ImageRequest.fromUri(Uri.parse(url)))
                    .setOldController(view.controller)

            view.controller = builder.build()
        }

        @BindingAdapter("linearLayoutManager")
        @JvmStatic
        fun setLinearLayoutManager(recyclerView: RecyclerView, direction: String) = when (direction) {
            "HORIZONTAL" -> recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            else -> recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
        }

        @BindingAdapter("placeholder")
        @JvmStatic
        fun setSimpleDraweePlaceholder(simpleDraweeView: SimpleDraweeView, drawableRes: Int){
            simpleDraweeView.hierarchy.setPlaceholderImage(drawableRes)
        }
        @BindingAdapter("android:setRatingView")
        @JvmStatic
        fun setRatingBarView(ratingBar: AppCompatRatingBar, rating: Float){
            val stars: LayerDrawable = ratingBar.progressDrawable as LayerDrawable
            stars.getDrawable(0).setColorFilter(ContextCompat.getColor(ratingBar.context, R.color.star_half_empty_color), PorterDuff.Mode.SRC_ATOP)
            stars.getDrawable(1).setColorFilter(ContextCompat.getColor(ratingBar.context, R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP)
            stars.getDrawable(2).setColorFilter(ContextCompat.getColor(ratingBar.context, R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP)
        }
    }
}