provider "aws" {
  region  = "us-east-1"

}
resource "aws_dynamodb_table" "dynamodb_user"{
  name = "celer-user"
  billing_mode = "PAY_PER_REQUEST"
  hash_key = "id"
  range_key = "login"


  attribute{
    name = "id"
    type = "S"
  }
  attribute{
    name = "login"
    type = "S"
  }

}



resource "aws_lambda_function" "create_user" {
  filename      = var.jar_path
  function_name = "create_user"
  role          = aws_iam_role.iam_for_lambda.arn
  handler       = "${var.package}CreateUser::handleRequest"
  runtime       = var.java_runtime
}