val ver = "1.0"

val commonSettings = Seq(
  organization := "com.yourpit",
  version := "1.0",
  organization := "org.yourpit",
  resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
  resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/" ,
  scalaVersion := "2.12.6"
)



lazy val util = (project in file("framework")).settings(
  commonSettings,
  name := "yourpit",
  libraryDependencies ++= Seq("org.reflections" % "reflections" % "0.9.10" )
).enablePlugins(PlayScala)

lazy val removeCacheTask = TaskKey[Unit]("removeCacheFile", "Deletes a cache file")
removeCacheTask := {
  import framework.route
  new RouteFileGenerator;
}

lazy val core = (project in file("yourpit")).settings(
  commonSettings,
  name := "framework",
  libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice),
  removeCacheSettings,
  compile in Compile <<= (compile in Compile).dependsOn(removeCacheTask)
).enablePlugins(PlayScala).dependsOn(util)
