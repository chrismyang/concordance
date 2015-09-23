package concordance.citations

class WordCounter {
  def apply(sentence: Seq[String]): Map[String, Int] = sentence.groupBy(identity).mapValues(_.length)
}
