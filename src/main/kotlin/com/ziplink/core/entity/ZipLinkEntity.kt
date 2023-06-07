package com.ziplink.core.entity

import jakarta.persistence.Access
import jakarta.persistence.AccessType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "zip_link")
class ZipLinkEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="short_url")
        val shortUrl: Long?,
        @Column(name="full_url")
        val fullUrl: String
)
