package concordance

object App {

  val concordanceCalculator = ConcordanceCalculator()

  def main(args: Array[String]) = {
    val text = io.Source.stdin.mkString
    val concordance = concordanceCalculator.calculateConcordance(text)
    PrettyPrinter.printConcordance(concordance)
  }

}
