package com.example.restauranteparceros.ui.categorias

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restauranteparceros.R
import com.example.restauranteparceros.databinding.FragmentPlatosBinding
import com.example.restauranteparceros.ui.Comidas
import com.example.restauranteparceros.ui.acerca.HomeViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EntradasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlatosFragment : Fragment() {

    private var _binding: FragmentPlatosBinding? = null
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var listaPlatos : MutableList<Comidas>
    private lateinit var platosAdapter: PlatosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlatosBinding.inflate(inflater, container,false)
        val root: View = binding.root

        listaPlatos = mutableListOf()

        val homeViewModel =
            ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        homeViewModel.platos.observe(viewLifecycleOwner){
            for(comida in it){
                Log.d("nombre", comida.nombre!!)
                listaPlatos.add(comida)
            }
        }
        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewPlatos.setHasFixedSize(true)
        binding.recyclerViewPlatos.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        platosAdapter = PlatosAdapter(listaPlatos)
        binding.recyclerViewPlatos.adapter = platosAdapter

        platosAdapter.onItemClick = {

            val bundle = Bundle()
            bundle.putString("tipo", it.tipo)
            bundle.putString("nombre", it.nombre)
            bundle.putString("descripcion", it.descripcion)
            bundle.putString("img", it.img)
            bundle.putDouble("precio", it.precio!!)
            findNavController().navigate(R.id.action_platos_to_detail, bundle)

            /*val i = Intent(requireContext(), DetailActivity::class.java)
            i.putExtra("comida", it)
            startActivity(i)*/
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EntradasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EntradasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}