package mongo.refactor

import com.mongodb.casbah.Imports.{DBObject, ObjectId}
import play.api.libs.json.JsValue
import play.api.libs.json.Json.toJson
/**
  * Created by jeorch on 17-12-19.
  */
trait bmRefactorLocData {
    implicit val m2d_loc : Map[String, JsValue] => DBObject = { js_map =>
        val _id = new ObjectId(js_map.get("_id").get.asOpt[String].getOrElse(new ObjectId().toString))
        DBObject("_id" -> _id,
            "location" -> js_map.get("location").get.asOpt[String].getOrElse(""),
            "friendliness" -> js_map.get("friendliness").get.asOpt[String].getOrElse(""),
            "location_images" -> js_map.get("location_images").get.asOpt[String].getOrElse("")
        )
    }

    implicit val d2m_loc : DBObject => Map[String, JsValue] = { obj =>

        Map(
            "_id" -> toJson(obj.get("_id").asInstanceOf[ObjectId].toString),
            "location" -> toJson(obj.get("location").asInstanceOf[String]),
            "friendliness" -> toJson(obj.get("friendliness").asInstanceOf[String]),
            "location_images" -> toJson(obj.get("location_images").asInstanceOf[String])
        )
    }
}
