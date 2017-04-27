import akka.actor.{Actor, ActorSystem, Props}

//a message
case class WhoToGreet(who: String)

//an actor
class Greeter extends Actor {

  override def receive = {
    case WhoToGreet(who) => println(s"Hello $who")
  }

}

object HelloAkkaScala extends App {

  val system = ActorSystem("Hello-Akka")

  val greeter = system.actorOf(Props[Greeter], "greeter")

  //send a message to our actor
  greeter ! WhoToGreet("Akka")

}
