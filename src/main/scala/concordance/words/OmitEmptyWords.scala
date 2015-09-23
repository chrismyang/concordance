package concordance.words

class OmitEmptyWords(underlying: WordsPreparator) extends WordsPreparator {
  def apply(text: String): Seq[String] = underlying(text).filter(_.nonEmpty)
}
