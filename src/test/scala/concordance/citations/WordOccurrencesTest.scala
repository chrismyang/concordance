package concordance.citations

import org.scalatest._

class WordOccurrencesTest extends FlatSpec with Matchers {

  val aSentenceNumber = 5

  "enumerate" should "return empty list for 0 occurrences" in {
    WordOccurrences(aSentenceNumber, 0).enumerate should be (Seq())
  }

  "enumerate" should "return number of sentence for one occurrence" in {
    WordOccurrences(aSentenceNumber, 1).enumerate should be (Seq(aSentenceNumber))
  }

  "enumerate" should "return repeat the sentence number given number of times " in {
    WordOccurrences(aSentenceNumber, 3).enumerate should be (Seq(aSentenceNumber, aSentenceNumber, aSentenceNumber))
  }

}
