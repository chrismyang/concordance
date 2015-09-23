package concordance.citations

import org.scalatest._

class OccurrencesMergerTest extends FlatSpec with Matchers {

  val merger = new OccurrencesMerger()

  val aFirstWord = "word"
  val aSecondWord = "another"
  val aFirstOccurrences: WordOccurrences = WordOccurrences(5, 1)
  val aSecondOccurrences: WordOccurrences = WordOccurrences(3, 5)

  "merge" should "return all occurrences" in {
    val occurrences = Seq(aFirstWord -> aFirstOccurrences, aSecondWord -> aSecondOccurrences)

    val expected = Map(aFirstWord -> Seq(aFirstOccurrences), aSecondWord -> Seq(aSecondOccurrences))
    merger.merge(occurrences) should be (expected)
  }

  "merge" should "merge occurrences of the same word" in {
    val occurrences = Seq(aFirstWord -> aFirstOccurrences, aFirstWord -> aSecondOccurrences)

    val expected = Map(aFirstWord -> Seq(aFirstOccurrences, aSecondOccurrences))
    merger.merge(occurrences) should be (expected)
  }

 }
