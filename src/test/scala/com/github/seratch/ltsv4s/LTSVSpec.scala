package com.github.seratch.ltsv4s

import org.scalatest._
import org.scalatest.matchers._

class LTSVSpec extends FlatSpec with ShouldMatchers {

  behavior of "TLSV"

  it should "work fine with LF" in {
    val ltsvList: List[Map[String, String]] = LTSV.parse("name:Alice\tage:19\n\tname:Bob\nname:Chris\tage:25")
    ltsvList.size should equal(3)
    LTSV.dump(ltsvList).mkString("\n") should equal("name:Alice\tage:19\nname:Bob\nname:Chris\tage:25")
  }

  it should "work fine with CRLF" in {
    val ltsvList: List[Map[String, String]] = LTSV.parse("name:Alice\tage:19\r\n\tname:Bob\nname:Chris\tage:25")
    ltsvList.size should equal(3)
    LTSV.dump(ltsvList).mkString("\n") should equal("name:Alice\tage:19\nname:Bob\nname:Chris\tage:25")
  }

}
