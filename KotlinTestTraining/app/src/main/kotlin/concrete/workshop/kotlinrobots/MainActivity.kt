package concrete.workshop.kotlinrobots

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var root: View
    private lateinit var text: TextView
    private lateinit var firstNumber: EditText
    private lateinit var secondNumber: EditText
    private lateinit var sum: Button
    private val chekcer by lazy { CheckerProvider.getChecker() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        root = findViewById(R.id.root)
        text = findViewById(R.id.text)
        firstNumber = findViewById(R.id.firstNumber)
        secondNumber = findViewById(R.id.secondNumber)
        sum = findViewById(R.id.sum)

        sum.setOnClickListener(this::onClick)
    }

    fun onClick(view: View) {
        val text: String = if (areTextsIntegers())
            "Sum total ${chekcer.sum(firstNumber.getTextAsInt(), secondNumber.getTextAsInt())}"
        else
            "Ow, tá errado isso ai!"
        Snackbar.make(root, text, Snackbar.LENGTH_INDEFINITE).show()
    }

    private fun areTextsIntegers() =
            chekcer.isInteger(firstNumber.text.toString()) && chekcer.isInteger(secondNumber.text.toString())

}

private fun EditText.getTextAsInt(): Int {
    return this.text.toString().toInt()
}
