package com.github.seratch.ltsv4s

/*
;; ABNF <https://tools.ietf.org/html/rfc5234>

ltsv = *(record NL) [record]
record = [field *(TAB field)]
field = label ":" field-value
label = 1*lbyte
field-value = *fbyte

TAB = %x09
NL = [%x0D] %x0A
lbyte = %x30-39 / %x41-5A / %x61-7A / "_" / "." / "-" ;; [0-9A-Za-z_.-]
fbyte = %x01-08 / %x0B / %x0C / %x0E-FF
*/
import scala.util.parsing.combinator.RegexParsers

/**
 * Parser configuration
 * 
 * @param lenient Allow a wider range of characters in field values than the LTSV spec
 */
case class LTSVParserConfig(lenient: Boolean = false)

class LTSVParser(config: LTSVParserConfig) extends RegexParsers {

  override def skipWhitespace = false

  def ltsv = repsep(record, nl)
  def record = repsep(field, tab) ^^ { _.toMap }
  def field = label ~ ":" ~ fieldValue ^^ { case k ~ ":" ~ v => (k, v) }
  def label = "[0-9A-Za-z_\\.-]+".r
  def fieldValue = {
    if (config.lenient) """[^\t\r\n]*""".r
    else """[\u000B\u000C\u0001-\u0008\u000E-\u00FF]*""".r
  }
  def tab = '\t'
  def nl = opt('\r') <~ '\n'

  def parse(input: String): List[Map[String, String]] = parseAll(ltsv, input).getOrElse {
    throw new IllegalArgumentException("Failed to parse ltsv: " + 
      (if (input.size > 1000) "\"" + input.take(1000) + "..." + "\"" else "\"" + input + "\""))
  }

}

object LTSVParser {
  def parse(input: String, lenient: Boolean = false): List[Map[String, String]] = 
    new LTSVParser(LTSVParserConfig(lenient)).parse(input)
}
