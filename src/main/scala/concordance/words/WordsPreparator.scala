package concordance.words

trait WordsPreparator extends (String => Seq[String])

object WordsPreparator {
  def apply(): WordsPreparator = new OmitEmptyWords(new TrimNonsentencePunctuation(new SplitByWhitespace))
}