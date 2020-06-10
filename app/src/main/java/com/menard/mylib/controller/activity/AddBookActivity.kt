package com.menard.mylib.controller.activity

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.menard.mylib.R
import com.menard.mylib.utils.EXTRA_BOOK
import com.menard.mylib.utils.EXTRA_BOOK_ISBN
import com.menard.mylib.utils.EXTRA_TYPE_BOOK
import kotlin.properties.Delegates

class AddBookActivity : AppCompatActivity() {

    /** Extras from intent */
    private var isbnExtra by Delegates.notNull<Int>()
    private lateinit var categoryExtra: String
    /** EditText */
    private lateinit var title: EditText
    private lateinit var author: EditText
    private lateinit var graphic: EditText
    private lateinit var isbn: EditText
    private lateinit var nbrPages: EditText
    /** Spinner */
    private lateinit var style: Spinner
    private lateinit var category: Spinner

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
}
