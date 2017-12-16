name := "demo1216"

version := "0.1"

scalaVersion := "2.12.4"

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
    "com.pharbers" % "auth-token" % "0.1",
    "com.pharbers" % "encrypt" % "0.1",
    "com.pharbers" % "mongodb-connect" % "0.1",
    "com.pharbers" % "mongodb-driver" % "0.1",
    "com.pharbers" % "pharbers-cli-traits" % "0.1",
    "com.pharbers" % "pharbers-modules" % "0.1",
    "net.sourceforge.jexcelapi" % "jxl" % "2.6.12",
    "org.mongodb" % "casbah_2.11" % "3.1.1"
)