package concordance

import concordance.citations.WordOccurrences

object PrettyPrinter {

  def printConcordance(citationsIndex: Map[String, Seq[WordOccurrences]]): Unit = {
    citationsIndex.toSeq.sortBy(_._1).foreach(Function.tupled(printWordCitations))
  }

  private def printWordCitations(word: String, citations: Seq[WordOccurrences]) = {
    val enumeratedCitations = citations.sortBy(_.sentence).flatMap(_.enumerate)
    val count = enumeratedCitations.length

    val citationsString = enumeratedCitations.mkString(",")
    println(s"${word}\t{${count}:${citationsString}}")
  }

}
