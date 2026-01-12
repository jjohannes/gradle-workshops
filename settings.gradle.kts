include(":model")
include(":engine")
include(":renderer")
include(":game")

project(":model").projectDir = file("jamcatch/model")
project(":engine").projectDir = file("jamcatch/engine")
project(":renderer").projectDir = file("jamcatch/renderer")
project(":game").projectDir = file("jamcatch/game")

// File("jamcatch").listFiles().filter { it.isDirectory }.forEach { dir ->
//     include(dir.name)
//     project(":${dir.name}").projectDir = dir
// }
