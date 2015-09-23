package concordance.sentences

import concordance.words.WordsPreparator
import org.mockito.Mockito._
import org.scalatest._
import org.scalatest.mock.MockitoSugar

class SentencesAnalyzerTest extends FlatSpec with Matchers with BeforeAndAfter with MockitoSugar {

  var wordsPreparator: WordsPreparator = _
  var sentencesFinder: SentencesFinder = _
  var analyzer: SentencesAnalyzer = _

  val aText = "some text"
  val aFirstWord = "a"
  val aSecondWord = "b"
  val anAnotherWord = "x"

  before {
    wordsPreparator = mock[WordsPreparator]
    sentencesFinder = mock[SentencesFinder]
    analyzer = new SentencesAnalyzer(wordsPreparator, sentencesFinder)
  }

  "analyze" should "pass words from wordsPreparator to sentencesFinder" in {
    val aWordStrings = Seq(aFirstWord, aSecondWord)
    val aWords = Seq(Word(aFirstWord), Word(aSecondWord))
    val aSentencesWords = Seq(Seq(Word(anAnotherWord)))

    when(wordsPreparator.apply(aText)).thenReturn(aWordStrings)
    when(sentencesFinder.apply(aWords)).thenReturn(aSentencesWords)

    analyzer.analyze(aText) should be (Seq(Seq(anAnotherWord)))
  }

}
