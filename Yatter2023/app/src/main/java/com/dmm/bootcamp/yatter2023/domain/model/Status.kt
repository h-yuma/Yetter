package com.dmm.bootcamp.yatter2023.domain.model

import com.dmm.bootcamp.yatter2023.common.ddd.Entity
import java.util.Date

class Status(
  id: StatusId,
  val account: Account,
  val content: String,
  val createAt: String,
  val attachmentMediaList: List<Media>
) : Entity<StatusId>(id)
