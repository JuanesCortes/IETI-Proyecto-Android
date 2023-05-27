package eci.escuelaing.ieti_proyect

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import eci.escuelaing.ieti_proyect.network.ComponentService
import eci.escuelaing.ieti_proyect.repository.componentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val componentService = componentRepository.create()
        getJsonData(componentService)

    }

    fun getJsonData(componentService: ComponentService) {
        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                val response = componentService.getComponent()
                runOnUiThread{
                    val editText = findViewById<EditText>(R.id.imageView)
                    editText.setText(response.body().toString())
                }
            }
        }
    }
}