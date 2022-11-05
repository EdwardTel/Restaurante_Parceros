package com.example.restauranteparceros.ui.ordenes

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.restauranteparceros.R
import com.example.restauranteparceros.databinding.FragmentOrdenesBinding

class OrdenesFragment : Fragment() {

    private var _binding: FragmentOrdenesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ordenesViewModel =
            ViewModelProvider(this).get(OrdenesViewModel::class.java)

        _binding = FragmentOrdenesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textGallery
        ordenesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentBtnEntradas.setOnClickListener{
            findNavController().navigate(R.id.action_nav_ordenes_to_entradas)
        }

        binding.fragmentBtnPlatos.setOnClickListener{
            findNavController().navigate(R.id.action_nav_ordenes_to_platos)
        }

        binding.fragmentBtnPostres.setOnClickListener{
            findNavController().navigate(R.id.action_nav_ordenes_to_postres)
        }

        binding.fragmentBtnBebidas.setOnClickListener{
            findNavController().navigate(R.id.action_nav_ordenes_to_bebidas)
        }

        val checkEntradas = binding.fragmentOrdenesTvChkEntradas
        val checkPlatos = binding.fragmentOrdenesTvChkPlatos
        val checkPostres= binding.fragmentOrdenesTvChkPostres
        val checkBebidas = binding.fragmentOrdenesTvChkBebidas

        //#36D99A color para los seleccionados

        if(checkEntradas.text.isNullOrEmpty()){
            checkEntradas.setTextColor(Color.parseColor("#853BD9"))
            checkEntradas.text= "Sin seleccionar"
        }

        if(checkPlatos.text.isNullOrEmpty()){
            checkPlatos.setTextColor(Color.parseColor("#853BD9"))
            checkPlatos.text= "Sin seleccionar"
        }

        if(checkPostres.text.isNullOrEmpty()){
            checkPostres.setTextColor(Color.parseColor("#853BD9"))
            checkPostres.text= "Sin seleccionar"
        }

        if(checkBebidas.text.isNullOrEmpty()){
            checkBebidas.setTextColor(Color.parseColor("#853BD9"))
            checkBebidas.text= "Sin seleccionar"
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}