package com.example.student_management

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.student_management.databinding.ActivityNewStudentBinding
import com.example.student_management.model.Model
import com.example.student_management.model.Student

class NewStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val id = binding.idEt.text.toString()
            val phone = binding.phoneEt.text.toString()
            val address = binding.addressEt.text.toString()

            if (name.isNotEmpty() && id.isNotEmpty()) {
                val newStudent = Student(name, id, phone, address, false)
                Model.addStudent(newStudent)
                finish() // Close activity and go back
            } else {
                Toast.makeText(this, "Please enter Name and ID", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cancelButton.setOnClickListener { finish() }
    }
}