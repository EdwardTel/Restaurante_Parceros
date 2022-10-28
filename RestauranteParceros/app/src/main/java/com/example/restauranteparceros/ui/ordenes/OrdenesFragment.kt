package com.example.restauranteparceros.ui.ordenes

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}