package com.example.demo.service

import com.example.demo.model.Player
import com.example.demo.repo.PlayerRepository
import org.springframework.stereotype.Service

@Service
class PlayerService(private val playerRepository: PlayerRepository) {
    fun savePlayer(player: Player): Player {
        return playerRepository.save(player)
    }

    fun getPlayerById(id: String): Player? {
        return playerRepository.findById(id).orElse(null)
    }

    // Other methods for CRUD operations
}
