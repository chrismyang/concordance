package concordance.citations

case class WordOccurrences(sentence: Int, count: Int) {
  def enumerate: Seq[Int] = Seq.fill(count)(sentence)
}
