package concordance.citations

class OccurrencesMerger {
  def merge(wordsOccurences: Seq[(String, WordOccurrences)]): Map[String, Seq[WordOccurrences]] =
    wordsOccurences.groupBy(_._1).mapValues(_.map(_._2))
}
