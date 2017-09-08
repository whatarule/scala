
scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest"  % "3.0.1"  % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
)

doctestTestFramework := DoctestTestFramework.ScalaTest



