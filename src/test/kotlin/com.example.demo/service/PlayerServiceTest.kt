package com.example.demo.service

import com.example.demo.model.Player
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlayerServiceTest(@Autowired val playerService: PlayerService) {
    @Test
    fun `save player service`() {
        val player = Player(id = "123", name = "John Doe", score = 100)
        playerService.savePlayer(player)
        Assertions.assertThat(playerService.getPlayerById("123")).isEqualTo(player)
    }

}