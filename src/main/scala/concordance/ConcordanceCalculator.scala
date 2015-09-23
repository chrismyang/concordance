package concordance

import concordance.citations.{CitationsIndexer, WordOccurrences}
import concordance.sentences.SentencesAnalyzer
import concordance.words.WordsPreparator

class ConcordanceCalculator(sentencesAnalyzer: SentencesAnalyzer, citationsIndexer: CitationsIndexer) {
  def calculateConcordance(text: String): Map[String, Seq[WordOccurrences]] =
    citationsIndexer.buildIndex(sentencesAnalyzer.analyze(text))
}

object ConcordanceCalculator {
  def apply(): ConcordanceCalculator = new ConcordanceCalculator(SentencesAnalyzer(WordsPreparator()), CitationsIndexer())
}