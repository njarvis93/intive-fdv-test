package com.example.mvvmposts.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmposts.utils.extension.getParentActivity
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import java.net.URL
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide




@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?: View.VISIBLE})
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?:""})
    }
}

@BindingAdapter("mutableImage")
fun setMutableImage(view: ImageView, image: MutableLiveData<String>?){
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && image!=null){
        image.observe(parentActivity, Observer { value ->
            Glide.with(view.context)
                .load(value).apply(RequestOptions().circleCrop())
                .into(view)
        })
    }
}