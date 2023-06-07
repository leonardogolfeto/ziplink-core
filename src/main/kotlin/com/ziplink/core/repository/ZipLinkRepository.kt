package com.ziplink.core.repository

import com.ziplink.core.entity.ZipLinkEntity
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository


@Repository
interface ZipLinkRepository : JpaRepository<ZipLinkEntity, String>
