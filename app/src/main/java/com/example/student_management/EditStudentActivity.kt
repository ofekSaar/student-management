package com.example.student_management

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.student_management.databinding.ActivityEditStudentBinding
import com.example.student_management.model.Model
import com.example.student_management.model.Student

class EditStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditStudentBinding
    private var studentPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentPosition = intent.getIntExtra("student_position", -1)

        if (studentPosition != -1 && studentPosition < Model.students.size) {
            val student = Model.students[studentPosition]
            binding.editNameEt.setText(student.name)
            binding.editIdEt.setText(student.id)
            binding.editPhoneEt.setText(student.phone)
            binding.editAddressEt.setText(student.address)
            binding.editCheckbox.isChecked = student.isChecked
        }

        binding.updateBtn.setOnClickListener {
            val name = binding.editNameEt.text.toString()
            val id = binding.editIdEt.text.toString()
            val phone = binding.editPhoneEt.text.toString()
            val address = binding.editAddressEt.text.toString()
            val isChecked = binding.editCheckbox.isChecked

            val updatedStudent = Student(name, id, phone, address, isChecked)
            Model.updateStudent(studentPosition, updatedStudent)
            finish()
        }

        binding.deleteBtn.setOnClickListener {
            Model.removeStudent(studentPosition)
            finish()
        }

        binding.cancelBtn.setOnClickListener { finish() }
    }
}