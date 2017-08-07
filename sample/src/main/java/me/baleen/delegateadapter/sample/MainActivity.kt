package me.baleen.delegateadapter.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import me.baleen.delegateadapter.sample.adapter.SimpleListAdapter1

class MainActivity : AppCompatActivity() {

    private var simpleAdapter: SimpleListAdapter1? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            startActivity(Intent(this, SimpleType1Activity::class.java))
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            startActivity(Intent(this, SimpleType2Activity::class.java))
        }
    }
}
