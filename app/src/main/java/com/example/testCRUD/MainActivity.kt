package com.example.testCRUD

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testCRUD.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //In Kotlin `var` is used to declare a mutable variable. On the other hand
    //`internal` means a variable is visible within a given module.
    internal var dbHelper = DatabaseHelper(this)

    /**
     * Let's create a function to show Toast message
     */
    fun showToast(text: String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show()
    }

    /**
     * Let's create a function to show an alert dialog with data dialog.
     */
    fun showDialog(title: String, Message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    /**
     * Let's override our onCreate method.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.insertBtn.setOnClickListener {
            try {
                dbHelper.insertData(
                    binding.nameTxt.text.toString(),
                    binding.galaxyTxt.text.toString(),
                    binding.typeTxt.text.toString()
                )
                binding.nameTxt.setText("")
                binding.galaxyTxt.setText("")
                binding.typeTxt.setText("")
                binding.idTxt.setText("")
            } catch (e: Exception) {
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
        binding.updateBtn.setOnClickListener {
            try {
                val isUpdate = dbHelper.updateData(
                    binding.idTxt.text.toString(),
                    binding.nameTxt.text.toString(),
                    binding.galaxyTxt.text.toString(),
                    binding.typeTxt.text.toString()
                )
                if (isUpdate == true)
                    showToast("Data Updated Successfully")
                else
                    showToast("Data Not Updated")
            } catch (e: Exception) {
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
        binding.deleteBtn.setOnClickListener {
            try {
                dbHelper.deleteData(binding.idTxt.text.toString())
            } catch (e: Exception) {
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
        binding.viewBtn.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.allData
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }

                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n")
                    buffer.append("NAME :" + res.getString(1) + "\n")
                    buffer.append("GALAXY :" + res.getString(2) + "\n")
                    buffer.append("TYPE :" + res.getString(3) + "\n\n")
                }
                showDialog("Data Listing", buffer.toString())
            }
        )
    }
}
//end