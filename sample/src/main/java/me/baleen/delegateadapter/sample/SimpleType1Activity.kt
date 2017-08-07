package me.baleen.delegateadapter.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import me.baleen.delegateadapter.sample.adapter.SimpleListAdapter1
import me.baleen.delegateadapter.sample.model.ImageModel
import me.baleen.delegateadapter.sample.model.TextModel

class SimpleType1Activity : AppCompatActivity() {

    private var simpleAdapter: SimpleListAdapter1? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_type_1)

        simpleAdapter = SimpleListAdapter1(this, arrayListOf())

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = simpleAdapter

        simpleAdapter?.items = listOf(
                TextModel("Text1"),
                ImageModel(R.mipmap.ic_launcher),
                TextModel("Text2"),
                TextModel("Text3"),
                TextModel("Text4"),
                TextModel("Text5"),
                ImageModel(R.mipmap.ic_launcher),
                TextModel("Text6")
        )
        simpleAdapter?.notifyDataSetChanged()
    }
}
