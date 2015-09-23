package concordance.words

class SplitByWhitespace extends WordsPreparator {
  def apply(text: String): Seq[String] = text.trim.split("\\s+")
}
