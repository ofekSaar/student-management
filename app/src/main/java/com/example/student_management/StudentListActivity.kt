package com.example.student_management

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.student_management.databinding.ActivityStudentListBinding
import com.example.student_management.model.Model

class StudentListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentListBinding
    private var adapter: StudentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.studentsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentAdapter(Model.students) { position ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("student_position", position)
            startActivity(intent)
        }
        binding.studentsRecyclerView.adapter = adapter

        binding.addStudentFab.setOnClickListener {
            val intent = Intent(this, NewStudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
    }
}