import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.trabalhoex04.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMatrix = findViewById<TextView>(R.id.tv_matrix)
        val btnStart = findViewById<Button>(R.id.btn_start)

        btnStart.setOnClickListener {
            val matrix = Array(12) { IntArray(13) { Random.nextInt(1, 100) } }
            val resultMatrix = matrix.map { row ->
                val max = row.maxOrNull() ?: 1
                row.map { it / max.toDouble() }.toDoubleArray()
            }

            tvMatrix.text = resultMatrix.joinToString("\n") { it.joinToString(" ") }
        }
    }
}
