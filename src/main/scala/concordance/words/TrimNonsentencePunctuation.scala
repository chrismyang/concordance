package concordance.words

class TrimNonsentencePunctuation(underlying: WordsPreparator) extends WordsPreparator {

  def apply(text: String): Seq[String] = underlying(text).map(trimNonsentencePunctuation)

  private def trimNonsentencePunctuation(word: String) = word match {
    case TrimNonsentencePunctuation.TrimNonsentencePunctuationRegex(trimmed) => trimmed
  }

}

object TrimNonsentencePunctuation {
  private val NonsentencePunctuationChars = """-=+\|@#$%^&*()`~\[\]{};:\'",<>\/""""
  private val TrimNonsentencePunctuationRegex = ("""^\p{P}*(.*?)[""" + NonsentencePunctuationChars + "]*$").r
}