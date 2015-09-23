package concordance

import concordance.citations.{CitationsIndexer, WordOccurrences}
import concordance.sentences.SentencesAnalyzer
import org.mockito.Mockito._
import org.scalatest._
import org.scalatest.mock.MockitoSugar

class ConcordanceCalculatorTest extends FlatSpec with Matchers with BeforeAndAfter with MockitoSugar {

  var indexer: CitationsIndexer = _
  var analyzer: SentencesAnalyzer = _
  var calculator: ConcordanceCalculator = _

  before {
    indexer = mock[CitationsIndexer]
    analyzer = mock[SentencesAnalyzer]
    calculator = new ConcordanceCalculator(analyzer, indexer)
  }

  val aText = "some text"
  val aSentences = mock[Seq[Seq[String]]]
  val anIndex = mock[Map[String, Seq[WordOccurrences]]]

  "calculateConcordance" should "build index based on analyzed sentences" in {
    when(analyzer.analyze(aText)).thenReturn(aSentences)
    when(indexer.buildIndex(aSentences)).thenReturn(anIndex)

    calculator.calculateConcordance(aText) should be (anIndex)
  }

}
