package concordance.words

import org.mockito.Mockito._
import org.scalatest._
import org.scalatest.mock.MockitoSugar

class TrimNonsentencePunctuationTest extends FlatSpec with Matchers with BeforeAndAfter with MockitoSugar {

  var underlying: WordsPreparator = _
  var preparator: TrimNonsentencePunctuation = _

  val aText = "Foo bar"
  val aWord = "Word"

  before {
    underlying = mock[WordsPreparator]
    preparator = new TrimNonsentencePunctuation(underlying)
  }

  it should "delegate to underlying preparator" in {
    val aWords = Seq(aWord)

    when(underlying(aText)).thenReturn(aWords)

    preparator(aText) should be (aWords)
  }

  it should "remove punctuation from word beginning" in {
    val words = Seq(".(something")

    when(underlying(aText)).thenReturn(words)

    preparator(aText) should be (Seq("something"))
  }

  it should "remove punctuation from word end" in {
    val words = Seq("something()")

    when(underlying(aText)).thenReturn(words)

    preparator(aText) should be (Seq("something"))
  }

  it should "leave ., ?, and ! at word end" in {
    val sentenceEndingWord: String = "something?!."
    val words = Seq(sentenceEndingWord)

    when(underlying(aText)).thenReturn(words)

    preparator(aText) should be (Seq(sentenceEndingWord))
  }

  it should "leave punctuation inside word" in {
    val punctuatedWord: String = "some-thi.ng"
    val words = Seq(punctuatedWord)

    when(underlying(aText)).thenReturn(words)

    preparator(aText) should be (Seq(punctuatedWord))
  }

  it should "remove punctuation in each word" in {
    val words = Seq(".one", "another)")

    when(underlying(aText)).thenReturn(words)

    preparator(aText) should be (Seq("one", "another"))
  }

 }
