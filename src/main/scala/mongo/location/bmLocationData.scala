package mongo.location

import com.mongodb.casbah.Imports.{DBObject, ObjectId}

/**
  * Created by jeorch on 17-12-18.
  */
trait bmLocationData {
    implicit val m2d : Map[String, String] => DBObject = { map =>
        val _id = new ObjectId(map.get("location_id").getOrElse(""))
        DBObject("_id" -> _id,
            "location" -> map.get("场地位置").getOrElse(""),
            "friendliness" -> map.get("场地友好性").getOrElse(""),
            "location_images" -> map.get("场地图片").getOrElse("")
        )
    }
}
