package com.example.furniturekart.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturekart.Activity.FullScreenProductActivity
import com.example.furniturekart.Model.CartModel
import com.example.furniturekart.Model.ProductDetailModel
import com.example.furniturekart.Model.WishlistModel
import com.example.furniturekart.R
import com.github.chrisbanes.photoview.PhotoView
import com.squareup.picasso.Picasso
import nl.dionsegijn.steppertouch.OnStepCallback
import nl.dionsegijn.steppertouch.StepperTouch

class CartAdapter(var context: Context, var list: List<CartModel>): RecyclerView.Adapter<MyView4>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView4 {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.cart_design, parent, false)
        return MyView4(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView4, position: Int) {
        holder.pbrand.setText(list.get(position).p_brand)
        holder.pname.setText(list.get(position).p_name)
        holder.pprice.setText(list.get(position).p_mrp.toString())
        var c_id = list.get(position).c_id
        Picasso.get().load(list.get(position).p_image).into(holder.pimage)
        

        //COUNTER
        holder.stepperTouch.minValue = 0
        holder.stepperTouch.minValue = 10
        holder.stepperTouch.sideTapEnabled = true
       holder.stepperTouch.addStepCallback(object : OnStepCallback {
            override fun onStep(value: Int, positive: Boolean) {
                Toast.makeText(context, value.toString(), Toast.LENGTH_SHORT).show()
            }
        })
///
    }
}
    class MyView4(Itemview: View) : RecyclerView.ViewHolder(Itemview) {
        var pimage: ImageView = Itemview.findViewById(R.id.pimage)
        var pbrand: TextView = Itemview.findViewById(R.id.pbrand)
        var pname: TextView = Itemview.findViewById(R.id.pname)
        var pprice: TextView = Itemview.findViewById(R.id.pprice)
///
        var stepperTouch = Itemview.findViewById<StepperTouch>(R.id.stepperTouch)
///
    }