package com.example.demo.controller

import com.example.demo.model.Player
import com.example.demo.service.PlayerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class HtmlController(private val playerService: PlayerService) {

    @GetMapping("/kotlin")
    fun blog(): String {
        return "hello from kotlin"
    }

    @GetMapping("/player")
    fun getPlayer(): Player? {
        val player = Player(id = "123", name = "John Doe", score = 100)
//        val saveResult = playerService.savePlayer(player)
        return playerService.getPlayerById("456")
    }
}