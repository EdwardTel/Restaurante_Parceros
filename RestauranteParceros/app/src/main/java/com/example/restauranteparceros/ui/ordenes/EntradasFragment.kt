package com.example.restauranteparceros.ui.ordenes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restauranteparceros.R
import com.example.restauranteparceros.ui.home.HomeViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EntradasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EntradasFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyEntradasAdapter
    private lateinit var listaEntradas : MutableList<Comidas>
    private lateinit var tvPrueba: TextView

    //private lateinit var binding : FragmentEntradasBinding

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
    ): View? {
        listaEntradas = mutableListOf()
        val homeViewModel =
            ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        homeViewModel.entradas.observe(viewLifecycleOwner){

            for(comida in it){
                Log.d("nombre", comida.nombre!!)
                listaEntradas.add(comida)
            }

        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entradas, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvPrueba = requireView().findViewById(R.id.prueba)

        recyclerView = requireView().findViewById(R.id.recycler_view_entradas)
        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        myAdapter = MyEntradasAdapter(listaEntradas)
        recyclerView.adapter = myAdapter

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