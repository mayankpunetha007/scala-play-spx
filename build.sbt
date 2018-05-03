val ver = "1.0"

val commonSettings = Seq(
  version := ver,
  organization := "org.yourpit",
  resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
  resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/" ,
  scalaVersion := "2.12.6"
)

lazy val util = (project in file("framework")).settings(
  commonSettings,
  name := "framework",
  libraryDependencies ++= Seq("org.reflections" % "reflections" % "0.9.10" ),
  scalaSource in Compile := baseDirectory.value / "src/main/scala/",
  javaSource in Compile := baseDirectory.value / "src/main/java/"
).enablePlugins(PlayScala)


lazy val core = (project in file("web")).settings(
  commonSettings,
  name := "web",
  libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice),
  scalaSource in Compile := baseDirectory.value / "app",
  javaSource in Compile := baseDirectory.value / "app"
).enablePlugins(PlayScala).dependsOn(util)