variable "jar_path"{
  type = string
  default = "../build/libs/celer-all.jar"
}

variable "java_runtime" {
  type = string
  default = "java11"
}

variable "package" {
  type = string
  default = "com.yore.celes.lambda."
}