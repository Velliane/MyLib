package com.menard.mylib.add_edit_book

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import com.menard.mylib.R
import com.menard.mylib.model.Book
import com.menard.mylib.utils.EXTRA_BOOK
import com.menard.mylib.utils.EXTRA_BOOK_ISBN
import com.menard.mylib.utils.EXTRA_TYPE_BOOK
import com.menard.mylib.utils.injections.Injection
import com.menard.mylib.view_model.AddEditBookViewModel
import kotlinx.android.synthetic.main.activity_add_book.*
import kotlin.properties.Delegates

class AddBookActivity : AppCompatActivity(), View.OnClickListener {

    /** Extras from intent */
    private var isbnExtra by Delegates.notNull<Int>()
    private lateinit var categoryExtra: String
    /** EditText */
    private lateinit var title: TextInputEditText
    private lateinit var author: TextInputEditText
    private lateinit var graphic: TextInputEditText
    private lateinit var isbn: TextInputEditText
    private lateinit var nbrPages: TextInputEditText
    /** Spinner */
    private lateinit var style: Spinner
    private lateinit var category: Spinner
    /** ViewModel */
    private lateinit var addEditViewModel: AddEditBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        isbnExtra = intent.getIntExtra(EXTRA_BOOK_ISBN, 0)
        categoryExtra = intent.getStringExtra(EXTRA_TYPE_BOOK)

        title = findViewById(R.id.edit_title)
        author = findViewById(R.id.edit_author)
        graphic = findViewById(R.id.edit_graphic)
        isbn = findViewById(R.id.edit_isbn)
        nbrPages = findViewById(R.id.edit_nbr_pages)
        style = findViewById(R.id.edit_style)
        category = findViewById(R.id.edit_category)

        add_book_save_btn.setOnClickListener(this)
        val viewModelFactory = Injection.provideViewModelFactory(this)
        addEditViewModel = ViewModelProvider(this, viewModelFactory).get(AddEditBookViewModel::class.java)

        initView()

    }


    private fun initView(){
        if(isbnExtra == 0){
            if(categoryExtra == EXTRA_BOOK) {
                graphic.visibility = View.GONE
            }
        }else{
            TODO("find by isbn")
        }
    }

    override fun onClick(v: View?) {
        when(v){
            add_book_save_btn -> {
                val book = Book(1, 121, "Premier livre", null, null, null, "Roman", null, null, null, null)
                addEditViewModel.insertBook(book)
            }
        }
    }
}
