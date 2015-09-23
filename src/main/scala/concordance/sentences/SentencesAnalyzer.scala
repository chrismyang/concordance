package concordance.sentences

import concordance.words.WordsPreparator

class SentencesAnalyzer(wordsPreparator: WordsPreparator, sentencesFinder: SentencesFinder) {

  def analyze(text: String): Seq[Seq[String]] = {
    val words = wordsPreparator(text).map(Word(_))
    val sentences = sentencesFinder(words)
    sentences.map(_.map(_.canonicalForm))
  }
  
}

object SentencesAnalyzer {
  def apply(wordsPreparator: WordsPreparator) = new SentencesAnalyzer(wordsPreparator, new SentencesFinder)
}