package lt.vilius.fizzbuzzfourthhomework

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class BonusActivity : AppCompatActivity() {
    lateinit var listViewBonus: ListView
    lateinit var buttonBonus: Button
    lateinit var adapter: ArrayAdapter<String>
    lateinit var textViewMin: TextView
    lateinit var textViewMax: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bonus)
        buttonBonus = findViewById(R.id.buttonBonus)
        listViewBonus = findViewById(R.id.listViewBonus)
        textViewMin = findViewById(R.id.textView)
        textViewMax = findViewById(R.id.textView2)

        val data: Array<String?> = intent.extras!!.getStringArray("passingArray") as Array<String?>
        val dataMin: Int = intent.extras!!.getInt("minValue")
        val dataMax: Int = intent.extras!!.getInt("maxValue")

        setTextToMinAndMax(dataMin, dataMax)

        printListView(data)

        clickButton()
    }

    private fun setTextToMinAndMax(dataMin: Int, dataMax: Int) {
        textViewMin.setText("min val: $dataMin")
        textViewMax.setText("max val: $dataMax")
    }

    private fun printListView(data: Array<String?>) {
        adapter = ArrayAdapter(
            this, android.R.layout.simple_expandable_list_item_1, data
        )
        listViewBonus.adapter = adapter
    }

    private fun clickButton() {
        buttonBonus.setOnClickListener {
            finish()
        }
    }
}