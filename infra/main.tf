provider "aws" {
  region  = "us-east-1"

}
resource "aws_dynamodb_table" "dynamodb_user"{
  name = "celer-user"
  billing_mode = "PAY_PER_REQUEST"
  hash_key = "id"
  attribute{
    name = "id"
    type = "S"
  }
}



resource "aws_lambda_function" "create_user" {
  filename      = var.jar_path
  function_name = "create_user"
  role          = aws_iam_role.lambda-role.arn
  handler       = "${var.package}CreateUser::handleRequest"
  runtime       = var.java_runtime
  timeout       = 60
  memory_size   = 1024
}

resource "aws_lambda_function" "get_user" {
  filename      = var.jar_path
  function_name = "get_user"
  role          = aws_iam_role.lambda-role.arn
  handler       = "${var.package}GetUser::handleRequest"
  runtime       = var.java_runtime
  timeout       = 60
  memory_size   = 1024
}