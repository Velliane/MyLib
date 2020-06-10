package com.menard.mylib.controller.activity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.menard.mylib.R
import com.menard.mylib.controller.fragment.HomeFragment
import com.menard.mylib.controller.fragment.ListsFragment
import com.menard.mylib.injections.Injection
import com.menard.mylib.utils.*
import com.menard.mylib.view_model.BookViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener,
    BottomNavigationView.OnNavigationItemSelectedListener,
    NavigationView.OnNavigationItemSelectedListener {

    /** BottomNavigationView */
    private lateinit var bottomNavView: BottomNavigationView
    /** Adding button */
    private lateinit var addMenuFab: FloatingActionButton
    private lateinit var addFab: FloatingActionButton
    private lateinit var addByIsbnFab: FloatingActionButton
    /** Toolbar */
    private lateinit var toolbar: Toolbar
    /** Drawer Menu */
    private lateinit var drawerMenu: NavigationView
    /** Drawer Layout */
    private lateinit var drawerLayout: DrawerLayout
    /** BookViewModel */
    private lateinit var bookViewModel: BookViewModel



    private var isRotate: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavView = findViewById(R.id.activity_main_bottom_navigation)
        addMenuFab = findViewById(R.id.main_add_btn)
        addFab = findViewById(R.id.main_add_manually)
        addByIsbnFab = findViewById(R.id.main_add_by_isbn)
        toolbar = findViewById(R.id.main_toolbar)
        drawerMenu = findViewById(R.id.main_drawer)
        drawerLayout = findViewById(R.id.main_drawer_layout)

        addMenuFab.setOnClickListener(this)
        addFab.setOnClickListener(this)
        addByIsbnFab.setOnClickListener(this)

        //-- Hide addFab and addByIsbnFab --//
        init(addFab)
        init(addByIsbnFab)

        configureToolbar()
        configureBottomNavigationView()
        configureDrawerLayout()
        //configureNavigationView()
        configureViewModel()
    }

    /** Open an AlertDialog to select a category for added book*/
    private fun selectCategory(){
        val builder = AlertDialog.Builder(this)
        val alertDialog = builder.create()
        builder.setTitle("Ajouter manuellement")
            .setMessage("Please select a category")
            .setNegativeButton("Livre") { dialog, which ->
                startAddBookActivity(0, EXTRA_BOOK)
            }
            .setNeutralButton("Roman graphique") { dialog, which ->
                startAddBookActivity(0, EXTRA_GRAPHIC)
            }
            .setPositiveButton("Annuler") { dialog, which ->
                alertDialog.dismiss()
            }
            .show()
    }

    /** Open an AlertDialog to find à book by his ISBN*/
    private fun addBookByIsbn(){
        val editText = EditText(this)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Isbn")
            .setView(editText)
            .setPositiveButton("Rechercher") { dialog, which ->
                startAddBookActivity(editText.text.toString().toInt(), "")
            }
            .setNegativeButton("Annuler") { dialog, which ->
            }
            .create().show()
    }

    /** Start AddBookActivity */
    private fun startAddBookActivity(isbn: Int, category:String){
        val intent = Intent(this, AddBookActivity::class.java)
        intent.putExtra(EXTRA_BOOK_ISBN, isbn)
        intent.putExtra(EXTRA_TYPE_BOOK, category)
        startActivity(intent)
    }


    fun getAllBooks(){
        //bookViewModel.getBooks().observe(this, )
    }

    //-- CLICK ACTIONS --//
    override fun onClick(v: View?) {
        when (v) {
            addMenuFab -> {
                isRotate = rotateFab(v, !isRotate)
                if (isRotate) {
                    showIn(addFab)
                    showIn(addByIsbnFab)
                } else {
                    showOut(addFab)
                    showOut(addByIsbnFab)
                }
            }
            addFab -> { selectCategory() }
            addByIsbnFab -> { addBookByIsbn() }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_home -> {
                val fragment = HomeFragment.newInstance()
                addFragment(fragment)
                return true
            }
            R.id.action_lists -> {
                val fragment = ListsFragment.newInstance()
                addFragment(fragment)
                return true
            }
        }
        return false
    }

    //-- FRAGMENT --//
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()

    }

    //-- CONFIGURATION --//
    private fun configureToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun configureBottomNavigationView() {
        bottomNavView.setOnNavigationItemSelectedListener(this)
        bottomNavView.selectedItemId = R.id.action_home
    }

    private fun configureDrawerLayout() {
        val toogle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.main_drawer_open,
            R.string.main_drawer_close
        )
        toogle.drawerArrowDrawable.color = resources.getColor(R.color.colorAccent)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
    }
//    private fun configureNavigationView(){
//        TODO()
//    }

    private fun configureViewModel(){
        val viewModelFactory = Injection.provideViewModelFactory(this)
        bookViewModel = ViewModelProviders.of(this, viewModelFactory).get(BookViewModel::class.java)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }


}
