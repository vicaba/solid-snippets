package com.vicaba.solid.dip

class User
class MongoDbDriver

def toUser(request: String): User = ???

// Not using Dependency Inversion Principle
object ViolatingDip {
  class MysqlUserRepository {
    def insert(mysqlConnection: String, user: User): Boolean = ???
  }

  class UserController(userRepository: MysqlUserRepository) {
    def create(request: String): String =
      userRepository.insert("mysql...", toUser(request)).toString()
  }
}

// Using Dependency Inversion Principle
object UsingDip {
  trait UserRepository {
    def insert(user: User): Boolean
  }

  class MysqlUserRepository(mysqlConnection: String) extends UserRepository {
    def insert(user: User): Boolean = ???
  }

  class MongoDbUserRepository(mongoDbDriver: MongoDbDriver) extends UserRepository {
    def insert(user: User): Boolean = ???
  }

  class UserController(userRepository: UserRepository) {
    def create(request: String): String =
      userRepository.insert(toUser(request)).toString()
  }
}
