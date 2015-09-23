package concordance.citations

import org.scalatest._

class OccurrencesCollectorTest extends FlatSpec with Matchers {

  val collector = new OccurrencesCollector()

  val aFirstWord = "word"
  val aSecondWord = "another"

  "collect" should "return occurrences for all words" in {
    val aFirstOccurrences: WordOccurrences = WordOccurrences(0, 1)
    val aSecondOccurrences: WordOccurrences = WordOccurrences(0, 5)

    val occurrences = Seq(
      Map(aFirstWord -> aFirstOccurrences.count, aSecondWord -> aSecondOccurrences.count))
    val expected = Seq(
      aFirstWord -> aFirstOccurrences,
      aSecondWord -> aSecondOccurrences)

    collector.collect(occurrences) should be (expected)
  }

  "collect" should "add sentence number to each occurrences" in {
    val aFirstCount = 1
    val aSecondCount = 5

    val occurrences = Seq(
      Map(aFirstWord -> aFirstCount),
      Map(aFirstWord -> aSecondCount))
    val expected = Seq(
      aFirstWord -> WordOccurrences(0, aFirstCount),
      aFirstWord -> WordOccurrences(1, aSecondCount))

    collector.collect(occurrences) should be (expected)
  }


 }
