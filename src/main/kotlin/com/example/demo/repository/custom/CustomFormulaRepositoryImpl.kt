package com.example.demo.repository.custom

import com.example.demo.model.Formula
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.and
import org.springframework.stereotype.Repository

open class CustomFormulaRepositoryImpl (private val mongoTemplate: MongoTemplate) : CustomFormulaRepository  {
    override fun findFormulaByCriteria(status: String, automotiveFlag: String?, categories: List<String>?, name: String? ): List<Formula>? {
        println("criteria: status = %s, automotiveFlag = %s".format(status, automotiveFlag))
        val query = Query()
        val criteria = Criteria()

        status?.let {
            criteria.and("status").`is`(status)
        }

        automotiveFlag?.let {
            criteria.and("automotiveFlag").`is`(automotiveFlag)
        }

        name?.let {
            criteria.and("name").regex(".*$name.*")
        }

        if (categories != null) {
            if(categories.size!! > 0 ) {
                criteria.and("categories").`in`(categories)
            }
        }

        println(criteria.toString())
        query.addCriteria(criteria)
        println(query.toString())
        return mongoTemplate.find(query, Formula::class.java)
    }


}