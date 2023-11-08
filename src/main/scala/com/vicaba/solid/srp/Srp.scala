package com.vicaba.solid.srp

class MysqlDriver {
  def query(query: String): Int = ???
}

case class User(name: String, email: String)

case class Request(body: String) // body is JSON
case class Response(status: String) // status is HTTP status code

// VIOLATING SRP
// User controller violating SRP
class UserControllerViolationSrp {

  def create(request: String): Response = {
    val user = validateJson(request)
    val query =
      s"INSERT INTO users (name, email) VALUES (${user.name}, ${user.email})"
    val driver = new MysqlDriver
    val result = driver.query(query)
    Response(s"User created with id: $result")
  }

  private def validateJson(json: String): User =
    ??? // parse json and return User
}

// RESPECTING SRP
// User controller respecting SRP

class MysqlUserRepository(mysqlDriver: MysqlDriver) {
  def insert(user: User): Int = {
    val query =
      s"INSERT INTO users (name, email) VALUES (${user.name}, ${user.email})"
    mysqlDriver.query(query)
  }
}

// Controller has the reponsibility of handling HTTP requests and responses
class UserController(userRepository: MysqlUserRepository) {

  def create(request: Request): Response = {
    val result = userRepository.insert(validateJson(request.body))
    Response(s"User created with id: $result")
  }

  private def validateJson(json: String): User =
    ??? // parse json and return User
}
