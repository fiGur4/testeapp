package co.tiagoaguiar.fitnesstracker

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.inputmethodservice.InputMethodService
import android.os.Bundle
import android.telecom.InCallService
import android.view.ContextMenu.ContextMenuInfo
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat
import androidx.recyclerview.widget.RecyclerView

class Activity_Imc : AppCompatActivity() {

    private lateinit var entradaPeso: EditText
    private lateinit var entradaAltura: EditText
    private lateinit var btn_enviar: Button

   // @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        entradaPeso = findViewById(R.id.edit_imc)
        entradaAltura = findViewById(R.id.edit_imc_altura)
        btn_enviar = findViewById(R.id.btn_send)


        btn_enviar.setOnClickListener {


            if (!verificar()) {
                Toast.makeText(
                    this,
                    R.string.fields_message,
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener

            }
            val peso = entradaPeso.text.toString().toInt()
            val altura = entradaAltura.text.toString().toInt()
            val resultado = Calc(peso, altura)
            val result = validarImc(resultado)

            val title = getString(R.string.imc_response, resultado)

            AlertDialog.Builder(this)   // criando o dialog com a class builder
                .setTitle(title)                     // setando o titlo do dialog
                .setMessage(result).setIcon(R.drawable.obesidade)
                .setView(R.layout.sample_my_view)
                .setPositiveButton(android.R.string.ok) { dialogInterface, which ->


                    /*
                     dialog.setPositiveButton("ok", object: DialogInterface.OnclickListener{

                     override fun onClick(dialog: DialogInterface?, wich: Int){

                     }
                     })
                    */
                }
                .create()
                .show()
        }
      val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

       service.hideSoftInputFromWindow(currentFocus?.windowToken,0)






















    } // ultima linha do codigo da funcao onCreate




private fun validarImc(check: Double): Int {
 when {
      check > 18.5  && check < 24.9 ->
          return R.string.normal
     check > 25.0 && check < 29.9 ->
         return R.string.imc_high_weight
     else ->
         return R.string.imc_severely_high_weight
 }

}
        private fun verificar(): Boolean {
        return (entradaPeso.text.toString().isNotEmpty()
            && !entradaPeso.text.toString().startsWith("0")
            && !entradaPeso.text.toString().startsWith(".")
            && entradaAltura.text.toString().isNotEmpty()
            && !entradaAltura.text.toString().startsWith(".")
            && !entradaAltura.text.toString().startsWith("0"))
}

        private fun Calc(peso: Int, altura: Int): Double {
             return peso / ((altura / 100.0) * (altura / 100.0))
            }



}// ultima linha do codigo da class MainActivitY












