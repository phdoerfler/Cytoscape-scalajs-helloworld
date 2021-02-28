name := "cytoscape-scalajs-helloworld"
scalaVersion := "2.13.5"

enablePlugins(ScalaJSPlugin)
// This is an application with a main method
scalaJSUseMainModuleInitializer := true

// this and ~fastOptJS::webpack allows to use scalajs-bundler to fetch our npmDependencies and run npm / yarn for us
webpackBundlingMode := BundlingMode.LibraryAndApplication()
enablePlugins(ScalablyTypedConverterPlugin)
Compile / npmDependencies ++= Seq(
  "cytoscape" -> "3.18.1",
  "@types/cytoscape" -> "3.14.12"
)

// Optional performance and convenience settings
Global / onChangedBuildSource := ReloadOnSourceChanges
scalaJSLinkerConfig ~= (_.withSourceMap(false))
Global / stQuiet := true
sources in (Compile, doc) := Nil
publishArtifact in (Compile, packageDoc) := false