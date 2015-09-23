package concordance.citations

import org.mockito.Mockito._
import org.scalatest._
import org.scalatest.mock.MockitoSugar

class CitationsIndexerTest extends FlatSpec with Matchers with BeforeAndAfter with MockitoSugar {

  var wordCounter: WordCounter = _
  var occurrencesCollector: OccurrencesCollector = _
  var occurrencesMerger: OccurrencesMerger = _
  var indexer: CitationsIndexer = _

  val aCount = 5
  val aWord = "foo"
  val aMergedOccurrences = mock[Map[String, Seq[WordOccurrences]]]
  val anOccurrencesList = mock[Seq[(String, WordOccurrences)]]

  before {
    wordCounter = mock[WordCounter]
    occurrencesCollector = mock[OccurrencesCollector]
    occurrencesMerger = mock[OccurrencesMerger]
    indexer = new CitationsIndexer(wordCounter, occurrencesCollector, occurrencesMerger)
  }

  "buildIndex" should "pass words counts from word counter through occurrences collector to occurrences merger" in {
    val words = Seq(aWord)
    val wordCounts = Map(aWord -> aCount)

    when(wordCounter(words)).thenReturn(wordCounts)
    when(occurrencesCollector.collect(Seq(wordCounts))).thenReturn(anOccurrencesList)
    when(occurrencesMerger.merge(anOccurrencesList)).thenReturn(aMergedOccurrences)

    indexer.buildIndex(Seq(words)) should be (aMergedOccurrences)
  }

}
