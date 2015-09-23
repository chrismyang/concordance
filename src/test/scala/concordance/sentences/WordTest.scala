package concordance.sentences

import org.scalatest._

class WordTest extends FlatSpec with Matchers {

  "isPossibleSentenceStart" should "return false if word starts with small letter" in {
    val aWord = Word("word")
    aWord.isPossibleSentenceStart should be (false)
  }

  "isPossibleSentenceStart" should "return true if word starts with big letter" in {
    val aWord = Word("Word")
    aWord.isPossibleSentenceStart should be (true)
  }

  "isPossibleSentenceEnd" should "return false if word ends with a letter" in {
    val aWord = Word("word")
    aWord.isPossibleSentenceEnd should be (false)
  }

  "isPossibleSentenceEnd" should "return true if word ends with a dot" in {
    val aWord = Word("word.")
    aWord.isPossibleSentenceEnd should be (true)
  }

  "canonicalForm" should "remove dot from non-abbreviation" in {
    val aWord = Word("word.")
    aWord.canonicalForm should be ("word")
  }

  "canonicalForm" should "not remove dot from abbreviation" in {
    val aText = "e.g."
    val aWord = Word(aText)
    aWord.canonicalForm should be (aText)
  }

  "canonicalForm" should "remove additional dots from abbreviation" in {
    val aWord = Word("e.g....")
    aWord.canonicalForm should be("e.g.")
  }

  "canonicalForm" should "lowercase the word" in {
    val aWord = Word("CamelCaseWord")
    aWord.canonicalForm should be("camelcaseword")
  }

}
