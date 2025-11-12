package ro.pub.cs.systems.eim.practicaltest01var07

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class PracticalTest01Var07MainActivity : AppCompatActivity() {
    private val random = Random()

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var07_main)

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        input3 = findViewById(R.id.input3)
        input4 = findViewById(R.id.input4)

        // save the state
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("input1")) {
                input1.setText(savedInstanceState.getString("input1"))
            } else {
                input1.setText("")
            }
            if (savedInstanceState.containsKey("input2")) {
                input2.setText(savedInstanceState.getString("input2"))
            } else {
                input2.setText("")
            }
            if (savedInstanceState.containsKey("input3")) {
                input3.setText(savedInstanceState.getString("input3"))
            } else {
                input3.setText("")
            }
            if (savedInstanceState.containsKey("input4")) {
                input4.setText(savedInstanceState.getString("input4"))
            } else {
                input4.setText("")
            }
        } else {
            input1.setText("")
            input2.setText("")
            input3.setText("")
            input4.setText("")
        }

        val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val message = result.data?.getStringExtra("result")
                if (message != null)
                    Toast.makeText(this, "result = " + message, Toast.LENGTH_LONG).show()
            }
            else if (result.resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "The activity returned with result CANCELED", Toast.LENGTH_LONG).show()
            }
        }

        // generate random numbers when clicking on Random Button
        val generateRandomNumbersButton = findViewById<Button>(R.id.random_button)
        generateRandomNumbersButton.setOnClickListener {
            if (input1.text.toString().toFloatOrNull() == null) {
                val nr = random.nextFloat(0.0F, 10.0F)
                input1.setText(nr.toString())
            }
            if (input2.text.toString().toFloatOrNull() == null) {
                val nr = random.nextFloat(0.0F, 10.0F)
                input2.setText(nr.toString())
            }
            if (input3.text.toString().toFloatOrNull() == null) {
                val nr = random.nextFloat(0.0F, 10.0F)
                input3.setText(nr.toString())
            }
            if (input4.text.toString().toFloatOrNull() == null) {
                val nr = random.nextFloat(0.0F, 10.0F)
                input4.setText(nr.toString())
            }
        }

        // go to next activity
        val navigateToSecondaryActivityButton = findViewById<Button>(R.id.set_button)
        navigateToSecondaryActivityButton.setOnClickListener {
            if (input1.text.toString().toFloatOrNull() != null &&
                input2.text.toString().toFloatOrNull() != null &&
                input3.text.toString().toFloatOrNull() != null &&
                input4.text.toString().toFloatOrNull() != null) {
                val intent = Intent(this, PracticalTest01Var07SecondaryActivity::class.java)
                intent.putExtra("input1", input1.text.toString().toFloatOrNull())
                intent.putExtra("input2", input2.text.toString().toFloatOrNull())
                intent.putExtra("input3", input3.text.toString().toFloatOrNull())
                intent.putExtra("input4", input4.text.toString().toFloatOrNull())
                activityResultsLauncher.launch(intent)
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("input1", input1.text.toString())
        outState.putString("input2", input2.text.toString())
        outState.putString("input3", input3.text.toString())
        outState.putString("input4", input4.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey("input1")) {
            input1.setText(savedInstanceState.getString("input1"))
        } else {
            input1.setText("")
        }
        if (savedInstanceState.containsKey("input2")) {
            input2.setText(savedInstanceState.getString("input2"))
        } else {
            input2.setText("")
        }
        if (savedInstanceState.containsKey("input3")) {
            input3.setText(savedInstanceState.getString("input3"))
        } else {
            input3.setText("")
        }
        if (savedInstanceState.containsKey("input4")) {
            input4.setText(savedInstanceState.getString("input4"))
        } else {
            input4.setText("")
        }
    }
}