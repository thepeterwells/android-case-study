package com.target.targetcasestudy.data

data class Deal(
  var id: Int,
  var title: String,
  var aisle: String,
  var description: String,
  var imageUrl: String,
  var regularPrice: Price?
)