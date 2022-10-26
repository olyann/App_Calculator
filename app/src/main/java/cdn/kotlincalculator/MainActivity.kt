package cdn.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        num0.setOnClickListener { appendVal("0", false) }

        num1.setOnClickListener { appendVal("1", false) }

        num2.setOnClickListener { appendVal("2", false) }

        num3.setOnClickListener { appendVal("3", false) }

        num4.setOnClickListener { appendVal("4", false) }

        num5.setOnClickListener { appendVal("5", false) }

        num6.setOnClickListener { appendVal("6", false) }

        num7.setOnClickListener { appendVal("7", false) }

        num8.setOnClickListener { appendVal("8", false) }

        num9.setOnClickListener { appendVal("9", false) }

        numDot.setOnClickListener { appendVal(".", false) }

        //Operators
        clear.setOnClickListener { appendVal("", true) }

        startBracket.setOnClickListener { appendVal(" ( ", false) }

        closeBracket.setOnClickListener { appendVal(" ) ", false) }

        actionDivide.setOnClickListener { appendVal(" / ", false) }

        actionMultiply.setOnClickListener { appendVal(" * ", false) }

        actionMinus.setOnClickListener { appendVal(" - ", false) }

        actionAdd.setOnClickListener { appendVal(" + ", false) }

        textButton.setOnClickListener{ }

        actionEquals.setOnClickListener {
            try {

                val expression = ExpressionBuilder(placeholder.text.toString()).build()
                val resultat = expression.evaluate()
                val longResult = resultat.toLong()
                if (resultat == longResult.toDouble()) {

                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
                    answer.text = longResult.toString()
                }
                else
                    answer.text = resultat.toString()

            }
            catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show();

                Log.d("", "Message: ${e.message}")
            }

        }



    }


    fun appendVal(string: String, isClear: Boolean) {
        if (isClear) {
            placeholder.text = ""
            answer.text = ""
//            placeholder.append(string)
        } else {
            placeholder.append(string)
        }
    }


}
