package example

import org.scalajs.dom.document
import org.scalajs.dom.raw.HTMLElement
import typings.cytoscape.cytoscapeStrings
import typings.cytoscape.mod.{apply => cytoscape, _}

object CytoscapeHelloWorld {
  def main(args: Array[String]): Unit = {
    val cy: Core = cytoscape(CytoscapeOptions()
      .setContainer(document.getElementById("cy").asInstanceOf[HTMLElement])
      .setElementsVarargs(
        ElementDefinition(NodeDataDefinition().setId("a")),
        ElementDefinition(NodeDataDefinition().setId("b")),
        ElementDefinition(EdgeDataDefinition("a", "b"))))
    for (i <- 0 until 10) {
      val source = s"node$i"
      cy.add(ElementDefinition(NodeDataDefinition().setId(source)))
      cy.add(ElementDefinition(EdgeDataDefinition(source, if (i % 2 == 0) "a" else "b")))
    }
    cy.layout(CircleLayoutOptions(true, cytoscapeStrings.circle, false, 0)).run()
  }
}
