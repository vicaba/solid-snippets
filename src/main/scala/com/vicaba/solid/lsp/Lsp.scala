package com.vicaba.solid.lsp

case class User(name: String, email: String)
val dummyUser = User("Dummy", "dummy@email.hey")

// Not using LSP
object NotUsingLsp {
  trait UserRepository {
    def insert(user: User): Int
    def read(id: Int): User
  }

  class MysqlUserRepository extends UserRepository {
    def insert(user: User): Int = ???
    def read(id: Int): User = ???
  }

  class MongoDbUserRepository extends UserRepository {
    def insert(user: User): Int = ???
    def read(id: Int): User = throw new Exception("This Mongo doesn't support read")
  }

  class MyController(userRepository: UserRepository) {
    userRepository.read(1)
    userRepository.insert(dummyUser) // 1. Will the insert work?
    // 2. If the injected repository is a MysqlUserRepository: we are good!
    // 3. If the injected repository is a MongoDbUserRepository: exception.
    // 4. Same interface, but: sometimes it works, sometimes it doesn't...
  }

}

// Using LSP
object UsingLsP {
  // 1. We can seggregating interfaces, so we have more flexibility in the composition
  trait WriteUserRepository {
    def insert(user: User): Int
  }

  trait ReadUserRepository {
    def read(id: Int): User
  }

  class MysqlUserRepository extends WriteUserRepository with ReadUserRepository {
    def insert(user: User): Int = ???
    def read(id: Int): User = ???
  }

  class MongoDbUserRepository extends WriteUserRepository {
    def insert(user: User): Int = ???
  }

  class MyController(
    readUserRepository: ReadUserRepository,
    writeUserRepository: WriteUserRepository
  ) {
    readUserRepository.read(1)
    writeUserRepository.insert(dummyUser)
    // 2. We are seggregating interfaces, so we have more flexibility in the composition
  }

  // 3. Or we can use intersection types! Here, the only valid implementation is Mysql
  class AnotherMyController(readAndWriteUserRepository: ReadUserRepository & WriteUserRepository) {
    readAndWriteUserRepository.read(1)
    readAndWriteUserRepository.insert(dummyUser)
  }
}
