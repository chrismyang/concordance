package concordance.sentences

case class Word(rawWord: String) {
  private val isAbbreviation = Word.IsAbbreviationRegex.pattern.matcher(rawWord).matches
  def isPossibleSentenceEnd: Boolean = Word.IsPossibleSentenceEndRegex.pattern.matcher(rawWord).matches
  def isPossibleSentenceStart: Boolean = Word.IsPossibleSentenceStartRegex.pattern.matcher(rawWord).matches

  val canonicalForm: String = {
    val fullyTrimmed = if (isAbbreviation) {
      rawWord match {
        case Word.AbbreviationTrimRegex(trimmed) => trimmed
      }
    } else {
      rawWord match {
        case Word.TrimAllPunctuationRegex(trimmed) => trimmed
      }
    }
    fullyTrimmed.toLowerCase
  }
}

object Word {
  // Abbreviation contains at least one dot inside the word.
  private val IsAbbreviationRegex = """^.*[a-zA-Z]\.[a-zA-Z].*$""".r
  // Sentence has to end with ., ! or ?.
  private val IsPossibleSentenceEndRegex = """^.*[\.?!]$""".r
  // Sentence has to start with a capital letter (after skipping punctuation).
  private val IsPossibleSentenceStartRegex = """^[A-Z].*$""".r
  // For non-abbreviation word, we can trim all punctuation chars.
  private val TrimAllPunctuationRegex = """^(.*?)\p{P}*$""".r
  // For abbreviations, we have to leave the terminal dot if it's present.
  private val AbbreviationTrimRegex = """^(.*?\.?)\p{P}*$""".r
}
