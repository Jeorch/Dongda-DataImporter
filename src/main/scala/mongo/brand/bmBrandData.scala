package mongo.brand

import com.mongodb.casbah.Imports._

/**
  * Created by jeorch on 17-12-16.
  */
trait bmBrandData {
    implicit val m2d : Map[String, String] => DBObject = { map =>
        val _id = new ObjectId(map.get("brand_id").getOrElse(""))
        DBObject("_id" -> _id,
            "brand_name" -> map.get("品牌名").getOrElse(""),
            "brand_tag" -> map.get("品牌标识").getOrElse(""),
            "about_brand" -> map.get("关于").getOrElse("")
        )
    }
}
