package json

sealed trait Json

case class Numeric(num: Double) extends Json
case class StringType(string: String) extends Json
abstract class JsonBoolean(val boolean: Boolean) extends Json
case class Object(objectVal: Map[String, Json]) extends Json
case class ListObject(list: List[Json]) extends Json
case object JsonTrue extends JsonBoolean(true)
case object JsonFalse extends JsonBoolean(false)
case object JsonNull extends Json