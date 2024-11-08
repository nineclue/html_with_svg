import org.scalajs.dom
import scalatags.JsDom.all.*
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.Element

object JSMain:
  def words =
    div(
      Seq("안녕?", "여러분", "만나서", "반가워요").map(div(_))
    )

  val eSize = modifier(
    width := "800px",
    height := "800px"
  )

  def logo =
    img(
      position := "absolute",
      top := "0",
      left := "0",
      eSize,
      src := "./scala-js-logo.png"
    )

  def svgs =
    import scalatags.JsDom.svgTags.*
    import scalatags.JsDom.svgAttrs.*
    svg(
      id := "svg",
      position := "absolute",
      top := "0",
      left := "0",
      eSize,
      circle(cx := "100", cy := "100", r := "50", fill := "orange")
    )

  def combo =
    div(
      id := "container",
      position := "relative",
      eSize,
      border := "1px solid black",
      logo,
      svgs
    )

  def mouseHandler(con: Element, s: Element)(e: MouseEvent) =
    import scalatags.JsDom.svgTags.*
    import scalatags.JsDom.svgAttrs.*
    val rect = con.getBoundingClientRect()
    // println(s"Mouse Clicked! ${e.clientX - rect.left}, ${e.clientY - rect.top}")
    s.appendChild(
      circle(
        cx := e.clientX - rect.left,
        cy := e.clientY - rect.top,
        r := "10",
        fill := "tomato"
      ).render
    )

  def main(as: Array[String]): Unit =
    println("안녕? 여러분!")
    // dom.document.body.appendChild(words.render)
    dom.document.body.appendChild(combo.render)
    val con = dom.document.getElementById("container")
    val svg = dom.document.getElementById("svg")
    con.addEventListener("mousedown", e => mouseHandler(con, svg)(e))
