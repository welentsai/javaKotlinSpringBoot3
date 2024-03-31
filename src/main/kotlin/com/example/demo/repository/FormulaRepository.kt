package com.example.demo.repository

import com.example.demo.model.Formula
import com.example.demo.repository.custom.CustomFormulaRepository
import org.springframework.data.mongodb.repository.MongoRepository

interface FormulaRepository : MongoRepository<Formula, String>, CustomFormulaRepository {
    fun findAllBy(status: String): List<Formula>
}