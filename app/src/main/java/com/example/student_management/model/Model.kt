package com.example.student_management.model

object Model {
    // An empty list initially
    val students: MutableList<Student> = ArrayList()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun removeStudent(pos: Int) {
        if (pos in students.indices) {
            students.removeAt(pos)
        }
    }

    fun updateStudent(pos: Int, updatedStudent: Student) {
        if (pos in students.indices) {
            students[pos] = updatedStudent
        }
    }
}