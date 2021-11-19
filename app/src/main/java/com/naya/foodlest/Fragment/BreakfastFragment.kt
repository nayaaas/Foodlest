package com.naya.foodlest.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.naya.foodlest.Adapter.FoodAdapter
import com.naya.foodlest.Model.DataRecipes
import com.naya.foodlest.Model.Recipes
import com.naya.foodlest.databinding.FragmentBreakfastBinding

class BreakfastFragment : Fragment() {
    //lateinit = inisialisasinya entaran
    private lateinit var breakfastBinding: FragmentBreakfastBinding
    private var list : ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        breakfastBinding = FragmentBreakfastBinding.inflate(inflater, container, false)

        return breakfastBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataBreakfast)
        breakfastBinding.rvBreakfast.apply{
            setHasFixedSize(true)
            //fungsi biar size ga berubah
            layoutManager = GridLayoutManager(context,2)
            val foodAdapter = FoodAdapter(list)
            adapter = foodAdapter
        }
    }
}