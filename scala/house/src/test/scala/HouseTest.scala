import org.scalatest.{Matchers, FlatSpec}

class HouseTest extends FlatSpec with Matchers {
  it should "produce chapter 1" in {
    val expected = List("This is the house that Jack built.")

    House.chapter(1) should equal(expected)
  }

  it should "produce chapter 2" in {
    val expected = List("This is the malt"
      , "that lay in the house that Jack built.")

    House.chapter(2) should equal(expected)
  }

  it should "produce chapter 3" in {
    val expected = List("This is the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built.")

    House.chapter(3) should equal(expected)
  }

  it should "produce chapter 12" in {
    val expected = List("This is the horse and the hound and the horn"
      , "that belonged to the farmer sowing his corn"
      , "that kept the rooster that crowed in the morn"
      , "that woke the priest all shaven and shorn"
      , "that married the man all tattered and torn"
      , "that kissed the maiden all forlorn"
      , "that milked the cow with the crumpled horn"
      , "that tossed the dog"
      , "that worried the cat"
      , "that killed the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built.")

    House.chapter(12) should equal(expected)
  }

  it should "produce a rhyme" in {
    val expected = List("This is the house that Jack built."
      , ""
      , "This is the malt"
      , "that lay in the house that Jack built."
      , ""
      , "This is the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built."
      , ""
      , "This is the cat"
      , "that killed the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built."
      , ""
      , "This is the dog"
      , "that worried the cat"
      , "that killed the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built."
      , ""
      , "This is the cow with the crumpled horn"
      , "that tossed the dog"
      , "that worried the cat"
      , "that killed the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built."
      , ""
      , "This is the maiden all forlorn"
      , "that milked the cow with the crumpled horn"
      , "that tossed the dog"
      , "that worried the cat"
      , "that killed the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built."
      , ""
      , "This is the man all tattered and torn"
      , "that kissed the maiden all forlorn"
      , "that milked the cow with the crumpled horn"
      , "that tossed the dog"
      , "that worried the cat"
      , "that killed the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built."
      , ""
      , "This is the priest all shaven and shorn"
      , "that married the man all tattered and torn"
      , "that kissed the maiden all forlorn"
      , "that milked the cow with the crumpled horn"
      , "that tossed the dog"
      , "that worried the cat"
      , "that killed the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built."
      , ""
      , "This is the rooster that crowed in the morn"
      , "that woke the priest all shaven and shorn"
      , "that married the man all tattered and torn"
      , "that kissed the maiden all forlorn"
      , "that milked the cow with the crumpled horn"
      , "that tossed the dog"
      , "that worried the cat"
      , "that killed the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built."
      , ""
      , "This is the farmer sowing his corn"
      , "that kept the rooster that crowed in the morn"
      , "that woke the priest all shaven and shorn"
      , "that married the man all tattered and torn"
      , "that kissed the maiden all forlorn"
      , "that milked the cow with the crumpled horn"
      , "that tossed the dog"
      , "that worried the cat"
      , "that killed the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built."
      , ""
      , "This is the horse and the hound and the horn"
      , "that belonged to the farmer sowing his corn"
      , "that kept the rooster that crowed in the morn"
      , "that woke the priest all shaven and shorn"
      , "that married the man all tattered and torn"
      , "that kissed the maiden all forlorn"
      , "that milked the cow with the crumpled horn"
      , "that tossed the dog"
      , "that worried the cat"
      , "that killed the rat"
      , "that ate the malt"
      , "that lay in the house that Jack built.\n\n")
      .mkString("\n")

    House.rhyme should equal(expected)
  }
}
