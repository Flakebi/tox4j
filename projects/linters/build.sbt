organization  := "im.tox"
name          := "linters"
scalaVersion  := "2.11.6"

// Build dependencies.
libraryDependencies ++= Seq(
  "org.brianmckenna" %% "wartremover" % "0.13"
)

// Test dependencies.
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4"
) map (_ % Test)

// Scala macros.
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)

// Enable the plugins we want.
sbt.tox4j.lint.Checkstyle.moduleSettings
sbt.tox4j.lint.Scalastyle.moduleSettings
