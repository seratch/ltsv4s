# LTSV4S

LTSV Parser implementation in Scala

## What's LTSV?

http://ltsv.org/

## Usage

### sbt settings

Add ltsv4s to dependencies.

```scala
// if you want to use latest version
// resolvers += "sonatype releases" at "http://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "com.github.seratch" %% "ltsv4s" % "[0.2,)"
```

### Example

```scala
import com.github.seratch.ltsv4s._

val log: Map[String, String] = LTSV.parseLine("field1:value1\tfield2:value2")
val line: String = LTSV.dump(log)

val logs: List[Map[String, String]] = LTSV.parseLines("field1:value1\tfield2:value2\nfield1:value1\tfield2:value2")
val lines: List[String] = LTSV.dump(logs)
```

In lenient mode, the parser will allow any character in a field value, apart from tab and newline chars.

```scala
val ltsv: Map[String, String] = LTSV.parseLine("name:クリス\tage:28", lenient=true)
ltsv.size should equal(2)
ltsv("name") should equal("クリス")
```

## License

Copyright 2013 Kazuhiro Sera

Apache License, Version 2.0

http://www.apache.org/licenses/LICENSE-2.0.html

