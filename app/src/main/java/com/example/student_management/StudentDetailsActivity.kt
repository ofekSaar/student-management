package com.example.student_management

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.student_management.databinding.ActivityStudentDetailsBinding
import com.example.student_management.model.Model

class StudentDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentDetailsBinding
    private var studentPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentPosition = intent.getIntExtra("student_position", -1)

        binding.editBtn.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("student_position", studentPosition)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        if (studentPosition != -1 && studentPosition < Model.students.size) {
            val student = Model.students[studentPosition]
            binding.nameTv.text = "Name: ${student.name}"
            binding.idTv.text = "ID: ${student.id}"
            binding.phoneTv.text = "Phone: ${student.phone}"
            binding.addressTv.text = "Address: ${student.address}"
            binding.checkStatusTv.text = if(student.isChecked) "Checked: Yes" else "Checked: No"
        } else {
            finish()
        }
    }
}