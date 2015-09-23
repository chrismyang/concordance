package concordance.citations

class OccurrencesCollector {

  def collect(sentencesWordCounts: Seq[Map[String, Int]]): Seq[(String, WordOccurrences)] =
    sentencesWordCounts.zipWithIndex.flatMap(Function.tupled(occurrencesInSentence))

  private def occurrencesInSentence(sentenceWordCounts: Map[String, Int], sentenceNumber: Int) =
    sentenceWordCounts.map({
      case (word, wordCount) =>
        word -> WordOccurrences(sentenceNumber, wordCount)
    })

}
