package concordance.citations

import org.scalatest._

class WordCounterTest extends FlatSpec with Matchers {

  val counter = new WordCounter()

  val aWord = "Word"
  val anAnotherWord = "Another"

  it should "return single word as one occurrence" in {
    counter(Seq(aWord)) should be (Map(aWord -> 1))
  }

  it should "count multiple occurrences of a word" in {
    counter(Seq(aWord, aWord)) should be (Map(aWord -> 2))
  }

  it should "different words separately" in {
    counter(Seq(aWord, aWord, anAnotherWord)) should be (Map(aWord -> 2, anAnotherWord -> 1))
  }

}
