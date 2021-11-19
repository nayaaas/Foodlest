package com.naya.foodlest.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naya.foodlest.Model.Recipes
import com.bumptech.glide.Glide
import com.naya.foodlest.DetailActivity
import com.naya.foodlest.databinding.ItemFoodBinding

class FoodAdapter(private val listFood : ArrayList<Recipes>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){
//    fingsi inner class karna class ga boleh dlm class jadi class foodviewholdernya bakal jadi sub class

    inner class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.FoodViewHolder {
        //inflate buat nempel layout
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodAdapter.FoodViewHolder, position: Int) {
        //gabungin layoutnya sama datanya
        // fungsi position untuk nge get data mana yg diurutin secara berurutan dan sesuai
        //kalo ga pake[position] dipake biar layoutnya gak random posisinya
        with(holder){
            with(listFood[position]){
                Glide.with(holder.itemView.context).load(pictures).into(binding.ivItemRecipe)
                binding.tvItemNameRecipe.text = name
                binding.tvItemMenu.text = category
                binding.tvNumberRecipe.text = number

                val mContext = holder.itemView.context
                holder.itemView.setOnClickListener{
                    val dataSend = Recipes(
                            name = listFood[position].name,
                            category = listFood[position].category,
                            description = listFood[position].description,
                            ingredients = listFood[position].ingredients,
                            instructions = listFood[position].instructions,
                            pictures = listFood[position].pictures,
                            number = listFood[position].number,
                            calories = listFood[position].calories,
                            carbo = listFood[position].carbo,
                            protein = listFood[position].protein,
                    )
                    val intentToDetail = Intent(mContext, DetailActivity::class.java)
                    intentToDetail.putExtra(DetailActivity.RECIPE_DATA, dataSend)
                    mContext.startActivity(intentToDetail)
                }
            }
        }
    }

    override fun getItemCount(): Int=listFood.size

}