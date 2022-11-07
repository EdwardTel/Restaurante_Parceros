package com.example.restauranteparceros.ui.cuenta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restauranteparceros.databinding.FragmentCuentaBinding

class CuentaFragment : Fragment() {

    private var _binding: FragmentCuentaBinding? = null
    private val binding get() = _binding!!

    private lateinit var cuentaAdapter: CuentaAdapter
    private lateinit var cuentaViewModel: CuentaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCuentaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        cuentaViewModel =
            ViewModelProvider(requireActivity()).get(CuentaViewModel::class.java)
        /*for(a in cuentaViewModel.listaPedidos){
            Log.d("Detail", a.nombre!!)
            Log.d("Detail", a.cantidad.toString())
            Log.d("Detail", a.precio.toString())
        }*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var totalItems: Int = 0
        var totalPagar: Double = 0.0

        for (pedido in cuentaViewModel.listaPedidos){
            totalItems = totalItems + pedido.cantidad!!
            totalPagar = totalPagar + pedido.precio!!
        }

        binding.recyclerViewCuenta.setHasFixedSize(true)
        binding.recyclerViewCuenta.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        cuentaAdapter = CuentaAdapter(cuentaViewModel.listaPedidos)
        binding.recyclerViewCuenta.adapter = cuentaAdapter
        binding.cuentaTvItems.text = totalItems.toString()
        binding.cuentaTvTotal.text = totalPagar.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}