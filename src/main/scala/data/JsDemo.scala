package data

import play.api.libs.json._

object JsDemo {
  def transform(json: JsValue): JsValue =
    json match {
      case JsNumber(value) => JsNumber(value + value)
      case JsArray(value) => JsArray(value.map(v => transform(v)))
      case JsObject(value) => JsObject(value.view.mapValues(transform).toMap)
      case JsNull => JsString("EMPTY")
      case _ => json
    }
}