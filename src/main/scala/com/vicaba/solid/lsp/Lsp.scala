package com.vicaba.solid.lsp

trait UserRepository {
  def insert(user: User): Int
  def read(id: Int): User
}

case class User(name: String, email: String)

// VIOLATING LSP
class MysqlUserRepository extends UserRepository {
  def insert(user: User): Int =
    // inserts User into Database
    ???
  def read(id: Int): User =
    // reads User from Database
    ???
}

class MongoDbUserRepository extends UserRepository {
  def insert(user: User): Int =
    // inserts User into Database
    ???
  def read(id: Int): User = throw new Exception("Not implemented")
}

// RESPECTING LSP
trait WriteUserRepository {
  def insert(user: User): Int
}
trait ReadUserRepository {
  def read(id: Int): User
}

class MysqlUserRepositoryLsp extends WriteUserRepository with ReadUserRepository {
  // inserts User into Database
  def insert(user: User): Int = ???
  // reads User from Database
  def read(id: Int): User = ???
}

class MongoDbUserRepositoryLsp extends WriteUserRepository {
  // inserts User into Database
  def insert(user: User): Int = ???
}
