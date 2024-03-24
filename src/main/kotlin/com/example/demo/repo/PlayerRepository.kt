package com.example.demo.repo

import com.example.demo.model.Player
import org.springframework.data.mongodb.repository.MongoRepository

interface PlayerRepository : MongoRepository<Player, String>
