package lt.vilius.fizzbuzzfourthhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import java.lang.Math.abs
import java.lang.Math.random

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var adapter: ArrayAdapter<String>
    lateinit var bonusButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bonusButton = findViewById(R.id.button)
        listView = findViewById(R.id.listViewHere)

        var fizzBuzzArray: Array<String?> = arrayOfNulls(100)
        val randomValueLow: Int = (-50..50).random()
        val randomValueHigh: Int = (50..150).random()
        val randomArraySize = when {
            randomValueLow <= 1 -> (abs(randomValueLow) + randomValueHigh + 1)
            randomValueLow > 0 -> ((randomValueHigh - randomValueLow) + 1)
            else -> 0
        }
        var fizzBuzzArrayRandom: Array<String?> = arrayOfNulls(randomArraySize)

        fizzBuzzArray = fillArray(fizzBuzzArray, 1, 100)

        fizzBuzzArrayRandom = fillArray(fizzBuzzArrayRandom, randomValueLow, randomValueHigh)

        printListView(fizzBuzzArray)

        clickBonusButton(fizzBuzzArrayRandom, randomValueLow, randomValueHigh)
    }

    private fun printListView(fizzBuzzArray: Array<String?>) {

        adapter = ArrayAdapter(
            this, android.R.layout.simple_expandable_list_item_1, fizzBuzzArray
        )
        listView.adapter = adapter
    }

    private fun clickBonusButton(
        fizzBuzzArrayRandom: Array<String?>,
        randomValueLow: Int,
        randomValueHigh: Int
    ) {
        bonusButton.setOnClickListener {
            val intent = Intent(this, BonusActivity::class.java)
            intent.putExtra("passingArray", fizzBuzzArrayRandom)
            intent.putExtra("minValue", randomValueLow)
            intent.putExtra("maxValue", randomValueHigh)
            startActivity(intent)
        }
    }

    private fun fillArray(
        array: Array<String?>,
        lowerBound: Int,
        higherBound: Int
    ): Array<String?> {
        for (i in array.indices) {
            if ((i + lowerBound) % 3 == 0 && (i + lowerBound) % 5 == 0)
                array[i] = "FIZZBUZZ"
            else if ((i + lowerBound) % 3 == 0)
                array[i] = "FIZZ"
            else if ((i + lowerBound) % 5 == 0)
                array[i] = "BUZZ"
            else
                array[i] = (i + lowerBound).toString()
        }
        return array
    }
}