# ltsv4s: LTSV parser for Scala

## What's LTSV?

http://ltsv.org/

## Usage

### sbt settings

Add ltsv4s to dependencies.

```scala
libraryDependencies += "com.github.seratch" %% "ltsv4s" % "0.1.0"
```

### Example

```scala
import com.github.seratch.ltsv4s._

val logs: List[Map[String, String]] = LTSV.parse("field1:value1\tfield2:value2\tfield3:value3")
val str = LTSV.dump(logs)
```

## TODO

- Stream

## License

Apache License, Version 2.0

http://www.apache.org/licenses/LICENSE-2.0.html

