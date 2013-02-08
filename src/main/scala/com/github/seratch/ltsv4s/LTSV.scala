package com.github.seratch.ltsv4s

object LTSV {

  def parseLine(line: String): Map[String, String] = LTSVParser.parse(line).head

  def parseLines(lines: String): List[Map[String, String]] = LTSVParser.parse(lines)

  def dump(value: Map[String, String]): String = {
    value.map { case (k, v) => k + ":" + v }.mkString("\t")
  }

  def dump(values: List[Map[String, String]]): List[String] = {
    values.map { _.map { case (k, v) => k + ":" + v }.mkString("\t") }
  }

}

