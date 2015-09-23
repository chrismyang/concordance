package concordance.words

import org.scalatest._

class SplitByWhitespaceTest extends FlatSpec with Matchers {

  val splitter = new SplitByWhitespace()

  it should "return single word as the only item" in {
    val aWord = "Word"
    splitter(aWord) should be (Seq(aWord))
  }

  it should "split words on spaces" in {
    val text = "Two words"
    splitter(text) should be (Seq("Two", "words"))
  }

  it should "split words on newlines" in {
    val text = "Two\nlines"
    splitter(text) should be (Seq("Two", "lines"))
  }

  it should "trim any whitespace" in {
    val text = "Two \n lines"
    splitter(text) should be (Seq("Two", "lines"))
  }

  it should "ignore whitespace on start" in {
    val text = "\n text"
    splitter(text) should be (Seq("text"))
  }

  it should "ignore whitespace on end" in {
    val text = "text \n"
    splitter(text) should be (Seq("text"))
  }

}
