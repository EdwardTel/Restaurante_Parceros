package com.example.restauranteparceros.ui.cuenta

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.restauranteparceros.databinding.FragmentCuentaBinding

class CuentaFragment : Fragment() {

    private var _binding: FragmentCuentaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCuentaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val cuentaViewModel =
            ViewModelProvider(requireActivity()).get(CuentaViewModel::class.java)

        var tvNombre = binding.cuentaTvNombre
        var tvCantidad = binding.cuentaTvCantidad
        var tvPrecio = binding.cuentaTvPrecio
        var listaNombres: MutableList<String?> = mutableListOf()

        cuentaViewModel.pedidos.observe(viewLifecycleOwner) {

            Toast.makeText(context,"Hola ViewModel", Toast.LENGTH_SHORT).show()

            //var listaNombres: MutableList<String?> = mutableListOf()
            var listaCantidades: MutableList<String?> = mutableListOf()
            var listaPrecios: MutableList<String> = mutableListOf()

            if(it.isNullOrEmpty()){
                Log.d("Observer", "Hola if")

                tvNombre.text = ""
                tvCantidad.text = ""
                tvPrecio.text = ""
            }
            else{
                for(pedido in it){
                    listaNombres.add(pedido.nombre+"\n")
                }

                tvNombre.text = listaNombres.toString()

            }
            //tvNombre.text = listaNombres[0]
        }

        for(a in cuentaViewModel.listaPedidos){
            Log.d("Detail", a.nombre!!)
            Log.d("Detail", a.cantidad.toString())
            Log.d("Detail", a.precio.toString())
        }

        //tvNombre.text = listaNombres[0]

        //binding.textSlideshow.text = cuentaViewModel.pedidosEntradas.toString()




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}