package com.example.assignmnet_4_lesson_5_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import kotlinx.android.synthetic.main.shopping_category.*

class ShoppingCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_category)

    checkIntent()
    val categories = ArrayList<ProductCategory>()
    categories.add(ProductCategory("Electronics", R.drawable.img_electronics))
    categories.add(ProductCategory("Clothing", R.drawable.img_cloth))
    categories.add(ProductCategory("Beauty", R.drawable.img_beuaty))
    categories.add(ProductCategory("Food", R.drawable.img_food))

    val gridView = findViewById<GridView>(R.id.category_grid) as GridView
    val customAdaptor = CategoryConnector(this, categories)


    gridView.adapter = customAdaptor


    gridView.setOnItemClickListener { adapterView, parent, position, l ->
        Toast.makeText(this, "you choose " + categories.get(position).category + "shopping category ", Toast.LENGTH_LONG).show()

    }
}

private fun checkIntent(){
    val shoppingCategoryIntent =   intent
    val output = shoppingCategoryIntent.getStringExtra("username");
    username.text ="wellcom "+ output
}
}