// import smithy4s.codegen.Smithy4sCodegenPlugin

ThisBuild / scalaVersion := "3.5.2"

enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "scalatags" % "0.13.1"
)
scalaJSUseMainModuleInitializer := true
