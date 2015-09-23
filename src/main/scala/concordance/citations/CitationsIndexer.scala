package concordance.citations

class CitationsIndexer(wordCounter: WordCounter, occurrencesCollector: OccurrencesCollector, occurrencesMerger: OccurrencesMerger) {

  def buildIndex(sentences: Seq[Seq[String]]): Map[String, Seq[WordOccurrences]] = {
    val sentencesWordCounts = sentences.map(wordCounter(_))
    val wordsOccurences = occurrencesCollector.collect(sentencesWordCounts)
    occurrencesMerger.merge(wordsOccurences)
  }

}

object CitationsIndexer {
  def apply(): CitationsIndexer = new CitationsIndexer(new WordCounter, new OccurrencesCollector, new OccurrencesMerger)
}