package concordance.sentences

import org.mockito.Mockito._
import org.scalatest._
import org.scalatest.mock.MockitoSugar

class SentencesFinderTest extends FlatSpec with Matchers with BeforeAndAfter with MockitoSugar {

  val finder = new SentencesFinder()
  val sentenceEnd = mock[Word]
  val sentenceStart = mock[Word]
  val regularWord = mock[Word]

  before {
    when(sentenceEnd.isPossibleSentenceStart).thenReturn(false)
    when(sentenceEnd.isPossibleSentenceEnd).thenReturn(true)

    when(sentenceStart.isPossibleSentenceStart).thenReturn(true)
    when(sentenceStart.isPossibleSentenceEnd).thenReturn(false)

    when(regularWord.isPossibleSentenceStart).thenReturn(false)
    when(regularWord.isPossibleSentenceEnd).thenReturn(false)
  }

  it should "break where first word can be sentence end and second can be sentence start" in {
    finder(Seq(sentenceEnd, sentenceStart)) should be (Seq(Seq(sentenceEnd), Seq(sentenceStart)))
  }

  it should "not break where where second word cannot be sentence start" in {
    finder(Seq(sentenceEnd, regularWord)) should be (Seq(Seq(sentenceEnd, regularWord)))
  }

  it should "not break where where first word cannot be sentence end" in {
    finder(Seq(regularWord, sentenceStart)) should be (Seq(Seq(regularWord, sentenceStart)))
  }

  it should "return empty sentence if no words present" in {
    finder(Seq()) should be (Seq(Seq()))
  }

}
