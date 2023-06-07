package com.ziplink.core.controller

import com.ziplink.core.repository.ZipLinkRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@DirtiesContext
@AutoConfigureMockMvc
internal class ZipLinkIntegrationTest @Autowired constructor(
        val mockMvc: MockMvc,
        val repository: ZipLinkRepository
) {

    @Test
    fun `should create a new ziplink and expect be redirected`() {
        mockMvc
                .post("http://localhost:8888/?fullUrl=https://roadmap.sh")
                .andExpect { status { isCreated() } }

        val ziplink = repository.findAll()[0].shortUrl

        assertThat(ziplink)
                .isEqualTo(1L)

        mockMvc
                .get(String.format("http://localhost:8888/%s", ziplink))
                .andExpect { status { is3xxRedirection() } }
    }

    @Test
    fun `should not redirect when ziplink not exists`() {
        val ziplink = 2L

        mockMvc
                .get(String.format("http://localhost:8888/%s", ziplink))
                .andExpect { status { isNotFound() } }
    }

}