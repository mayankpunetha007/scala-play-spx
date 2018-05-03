logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.11")

TaskKey[Unit]("myTask") := (runMain in Compile).toTask(" framework.route.RouteFileGenerator").value