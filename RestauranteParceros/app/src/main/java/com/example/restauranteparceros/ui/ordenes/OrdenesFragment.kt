package com.example.restauranteparceros.ui.ordenes

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.restauranteparceros.R
import com.example.restauranteparceros.databinding.FragmentOrdenesBinding
import com.example.restauranteparceros.ui.cuenta.CuentaViewModel

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
        _binding = FragmentOrdenesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val cuentaViewModel = ViewModelProvider(requireActivity()).get(CuentaViewModel::class.java)
        
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

        val tvCheckEntradas = binding.fragmentOrdenesTvChkEntradas
        val tvCheckPlatos = binding.fragmentOrdenesTvChkPlatos
        val tvCheckPostres= binding.fragmentOrdenesTvChkPostres
        val tvCheckBebidas = binding.fragmentOrdenesTvChkBebidas

        val colorNoSelection = Color.parseColor("#853BD9")
        val colorSelection = Color.parseColor("#36D99A")

        tvCheckEntradas.setTextColor(colorNoSelection)
        tvCheckEntradas.text= "Sin seleccionar"

        tvCheckPlatos.setTextColor(colorNoSelection)
        tvCheckPlatos.text= "Sin seleccionar"

        tvCheckPostres.setTextColor(colorNoSelection)
        tvCheckPostres.text= "Sin seleccionar"

        tvCheckBebidas.setTextColor(colorNoSelection)
        tvCheckBebidas.text= "Sin seleccionar"

        //#36D99A color para los seleccionados

        if(cuentaViewModel.listaPedidos.size > 0){
            for(pedido in cuentaViewModel.listaPedidos){
                if(pedido.tipo == "Entrada"){
                    tvCheckEntradas.setTextColor(colorSelection)
                    tvCheckEntradas.text= "Seleccionado"
                }

                if(pedido.tipo=="Plato"){
                    tvCheckPlatos.setTextColor(colorSelection)
                    tvCheckPlatos.text= "Seleccionado"
                }

                if(pedido.tipo == "Postre"){
                    tvCheckPostres.setTextColor(colorSelection)
                    tvCheckPostres.text= "Seleccionado"
                }

                if(pedido.tipo == "Bebida"){
                    tvCheckBebidas.setTextColor(colorSelection)
                    tvCheckBebidas.text= "Seleccionado"
                }
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}