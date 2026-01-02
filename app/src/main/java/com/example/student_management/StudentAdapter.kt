package com.example.student_management

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.student_management.model.Student

class StudentAdapter(
    private val students: List<Student>,
    private val onRowClick: (Int) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTv: TextView = itemView.findViewById(R.id.student_row_name)
        val idTv: TextView = itemView.findViewById(R.id.student_row_id)
        val checkBox: CheckBox = itemView.findViewById(R.id.student_row_check)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_list_row, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.nameTv.text = student.name
        holder.idTv.text = "ID: ${student.id}"

        holder.checkBox.setOnCheckedChangeListener(null)
        holder.checkBox.isChecked = student.isChecked
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            student.isChecked = isChecked
        }

        holder.itemView.setOnClickListener {
            onRowClick(position)
        }
    }

    override fun getItemCount(): Int = students.size
}
