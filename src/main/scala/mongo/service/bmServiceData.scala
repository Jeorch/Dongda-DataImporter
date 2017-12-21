package mongo.service

import com.mongodb.casbah.Imports.{DBObject, ObjectId}

/**
  * Created by jeorch on 17-12-18.
  */
trait bmServiceData {
    implicit val m2d : Map[String, String] => DBObject = { map =>
        val _id = new ObjectId(map.get("service_id").getOrElse(""))
        DBObject("_id" -> _id,
            "service_type" -> map.get("service_type").getOrElse(""),
            "service_tags" -> map.get("服务Tags").getOrElse(""),
            "operation" -> map.get("运营之力").getOrElse(""),
            "service_leaf" -> map.get("服务Leaf").getOrElse(""),
            "min_age" -> map.get("最小年龄").map(x => if (x == "") 2.0 else x.toDouble.asInstanceOf[Number]).getOrElse((2.0).asInstanceOf[Number]),
            "max_age" -> map.get("最大年龄").map(x => if (x == "") 12.0 else x.toDouble.asInstanceOf[Number]).getOrElse((12.0).asInstanceOf[Number]),
            "class_max_stu" -> map.get("满班人数").map(x => if (x == "") -1 else x.toInt.asInstanceOf[Number]).getOrElse((-1).asInstanceOf[Number]),
            "teacher_num" -> map.get("老师数量").map(x => if (x == "") -1 else x.toInt.asInstanceOf[Number]).getOrElse((-1).asInstanceOf[Number]),
            "punchline" -> map.get("一句话吸睛").getOrElse(""),
            "description" -> map.get("描述").getOrElse(""),
            "service_images" -> map.get("服务图片").getOrElse("")
        )
    }
}
