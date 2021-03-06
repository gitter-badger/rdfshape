package controllers

import play.api._
import play.api.mvc._
import es.weso.shex.Schema
import buildinfo._
// import rdfBuildinfo.{ BuildInfo => RDFBuildInfo }

// We use traits instead of objects to be able to test them
// More info: https://www.playframework.com/documentation/2.3.x/ScalaTestingWithScalaTest
trait Application {
  this: Controller =>

  lazy val name = "RDFShape" 
  lazy val shexcalaName = BuildInfo.name + "(" + BuildInfo.version + ")" 

  def index = Action {
    Ok(views.html.index())
  }

  def about = Action {
    Ok(views.html.about(name + "|" + shexcalaName)(ValidationForm()))
  }

  def help = Action {
    Ok(views.html.help()(ValidationForm()))
  }
    
}

object Application extends Controller with Application
