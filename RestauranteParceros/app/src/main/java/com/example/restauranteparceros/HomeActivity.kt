package com.example.restauranteparceros

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
import com.example.restauranteparceros.ui.acerca.HomeViewModel
import com.example.restauranteparceros.ui.Comidas
import com.google.firebase.firestore.FirebaseFirestore

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                this.finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun getMenu(){
        val db = FirebaseFirestore.getInstance()

        db.collection("carta").get()
            .addOnSuccessListener {
                for(doc in it.documents){
                    val descripcion = doc.getString("Descripcion")
                    val nombre= doc.getString("Nombre")
                    val tipo= doc.getString("Tipo")
                    val img= doc.getString("Img")
                    val precio= doc.get("Precio").toString().toDouble()

                    /*Log.d("nombre", nombre!!)
                    Log.d("Descripcion", descripcion!!)
                    Log.d("Imagen", img!!)
                    Log.d("Tipo", tipo!!)
                    Log.d("Precio", precio.toString())*/

                    val comida = Comidas(tipo, nombre, descripcion, img, precio)
                    comidasEnBD.add(comida)
                }

                homeViewModel.comidasEnBD = comidasEnBD

                homeViewModel.setEntradas()
                homeViewModel.setPlatos()
                homeViewModel.setPostres()
                homeViewModel.setBebidas()

                val hola= homeViewModel.comidasEnBD
                for (comida in hola){
                    Log.d("nombre", comida.nombre!!)
                    Log.d("Descripcion", comida.descripcion!!)
                    Log.d("Imagen", comida.img!!)
                    Log.d("Tipo", comida.tipo!!)
                    Log.d("Precio", comida.precio.toString())
                }

            }.addOnFailureListener { exception ->
                Toast.makeText(baseContext,"No se cargó la carta", Toast.LENGTH_SHORT).show()
                Log.w("Malo", "Error getting documents: ", exception)
            }
    }
}
