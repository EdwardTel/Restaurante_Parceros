package com.example.restauranteparceros

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.restauranteparceros.databinding.ActivityHomeBinding
import com.example.restauranteparceros.ui.home.HomeViewModel
import com.example.restauranteparceros.ui.ordenes.Comidas
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var comidasEnBD : MutableList<Comidas>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarHome.toolbar)

        binding.appBarHome.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        comidasEnBD = mutableListOf()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_ordenes, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        getMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    private fun getMenu(){
        var db = FirebaseFirestore.getInstance()

        db.collection("carta")
            .addSnapshotListener{ query, error ->
                Toast.makeText(baseContext,"exito al conectar FireStore", Toast.LENGTH_SHORT).show()
                if(error!= null){
                    Toast.makeText(baseContext,"Falla al cargar el menú", Toast.LENGTH_SHORT).show()
                }

                for(document in query!!){
                    val descripcion = document.getString("Descripcion")
                    val nombre = document.getString("Nombre")
                    val tipo = document.getString("Tipo")
                    val precio = document.get("Precio")

                    val comida = Comidas(tipo,nombre,descripcion, precio.toString().toDouble())

                    comidasEnBD.add(comida)

                }

                homeViewModel.comidasEnBD = comidasEnBD
                homeViewModel.setEntradas()

                var hola =homeViewModel.comidasEnBD

                for (comida in hola){
                    Log.d("nombre", comida.nombre!!)
                    Log.d("Descripcion", comida.descripcion!!)
                    Log.d("Tipo", comida.tipo!!)
                    Log.d("Precio", comida.precio.toString())
                }

                //Toast.makeText(baseContext,"Cargado al viewModel", Toast.LENGTH_SHORT).show()
            }
            /*.get()
            .addOnSuccessListener{
                Toast.makeText(baseContext,"exito al conectar FireStore", Toast.LENGTH_SHORT).show()

                for(document in it){
                    val descripcion = document.getString("Descripcion")
                    val nombre = document.getString("Nombre")
                    val tipo = document.getString("Tipo")
                    val precio = document.get("Precio")

                    val comida = Comidas(tipo,nombre,descripcion, precio.toString().toDouble())

                    comidasEnBD.add(comida)
                }
                homeViewModel.distribuirComidas(comidasEnBD)
                Toast.makeText(baseContext,"Cargado al viewModel", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener { exception ->
                Toast.makeText(baseContext,"Falla al cargar el menú", Toast.LENGTH_SHORT).show()
            }*/
    }
}