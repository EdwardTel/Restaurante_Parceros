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

        val textSeleccionado = getString(R.string.fragment_ordenes_tv_estado_seleccionado)
        val textNoSeleccionado = getString(R.string.fragment_ordenes_tv_estado_no_seleccionado)

        tvCheckEntradas.setTextColor(colorNoSelection)
        tvCheckEntradas.text= textNoSeleccionado

        tvCheckPlatos.setTextColor(colorNoSelection)
        tvCheckPlatos.text= textNoSeleccionado

        tvCheckPostres.setTextColor(colorNoSelection)
        tvCheckPostres.text= textNoSeleccionado

        tvCheckBebidas.setTextColor(colorNoSelection)
        tvCheckBebidas.text= textNoSeleccionado

        //#36D99A color para los seleccionados

        if(cuentaViewModel.listaPedidos.size > 0){
            for(pedido in cuentaViewModel.listaPedidos){
                if(pedido.tipo == "Entrada"){
                    tvCheckEntradas.setTextColor(colorSelection)
                    tvCheckEntradas.text= textSeleccionado
                }

                if(pedido.tipo=="Plato"){
                    tvCheckPlatos.setTextColor(colorSelection)
                    tvCheckPlatos.text= textSeleccionado
                }

                if(pedido.tipo == "Postre"){
                    tvCheckPostres.setTextColor(colorSelection)
                    tvCheckPostres.text= textSeleccionado
                }

                if(pedido.tipo == "Bebida"){
                    tvCheckBebidas.setTextColor(colorSelection)
                    tvCheckBebidas.text= textSeleccionado
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