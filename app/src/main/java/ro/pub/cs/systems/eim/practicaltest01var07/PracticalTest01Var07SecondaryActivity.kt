package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var07SecondaryActivity : AppCompatActivity() {
    private lateinit var input1: TextView
    private lateinit var input2: TextView
    private lateinit var input3: TextView
    private lateinit var input4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var07_secondary)

        input1 = findViewById(R.id.input21)
        input2 = findViewById(R.id.input22)
        input3 = findViewById(R.id.input23)
        input4 = findViewById(R.id.input24)

        val in1 = intent.getFloatExtra("input1", 0.0F)
        val in2 = intent.getFloatExtra("input2", 0.0F)
        val in3 = intent.getFloatExtra("input3", 0.0F)
        val in4 = intent.getFloatExtra("input4", 0.0F)

        input1.text = in1.toString()
        input2.text = in2.toString()
        input3.text = in3.toString()
        input4.text = in4.toString()

        val sum_button = findViewById<Button>(R.id.sum_button)
        sum_button.setOnClickListener {
            val intent = Intent()
            val sum = in1 + in2 + in3 + in4
            intent.putExtra("result", sum.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

        val prod_button = findViewById<Button>(R.id.product_button)
        prod_button.setOnClickListener {
            val intent = Intent()
            val prod = in1 * in2 * in3 * in4
            intent.putExtra("result", prod.toString())
            // leave activity
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}