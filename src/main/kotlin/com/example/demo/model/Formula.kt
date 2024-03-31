package com.example.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "formulas")
data class Formula (
    @Id
    val id: String?,
    val name: String,
    val status: String,
    val categories: List<String>,
    val automotiveFlag: String,
)