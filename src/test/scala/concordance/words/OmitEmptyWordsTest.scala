package concordance.words

import org.mockito.Mockito._
import org.scalatest._
import org.scalatest.mock.MockitoSugar

class OmitEmptyWordsTest extends FlatSpec with Matchers with BeforeAndAfter with MockitoSugar {

  var underlying: WordsPreparator = mock[WordsPreparator]
  var preparator: OmitEmptyWords = new OmitEmptyWords(underlying)

  val aText = "Foo bar"
  val aWord = "Word"

  it should "delegate to underlying preparator" in {
    val aWords = Seq(aWord)

    when(underlying(aText)).thenReturn(aWords)

    preparator(aText) should be (aWords)
  }

  it should "omit empty words" in {
    val words = Seq("", aWord, "")

    when(underlying(aText)).thenReturn(words)

    preparator(aText) should be (Seq(aWord))
  }

 }
