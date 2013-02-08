package com.github.seratch.ltsv4s

object LTSV {

  def parse(str: String): List[Map[String, String]] = LTSVParser.parse(str)

  def dump(values: List[Map[String, String]]): List[String] = {
    values.map { _.map { case (k, v) => k + ":" + v }.mkString("\t") }
  }

}

