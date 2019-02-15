import data.AliceData


val bookText = AliceData.bookText
val stopWordText = AliceData.stopWordText
val stopWords = stopWordText
  .split(AliceData.stopWordRegex)
  .toSet;

var wordToOccurances = Map[String, Int]();

val wordsWithCount = bookText.split(AliceData.bookRegex)
  .toList
  .filterNot(w => stopWords(w))
  .foldLeft(wordToOccurances)((acc, word) => {

    acc.updated(word, acc.getOrElse(word, 0) + 1)
/*
    if (acc.contains(word)) {
      acc.mapValues(x => x + 1).toMap
    } else {
      Map(word -> word.length) ++ acc
    }*/
  }
  )

wordsWithCount.toSeq.sortBy(_._2)
  .reverse.take(10)


wordsWithCount.toSeq.sortBy(-_._2)
  .reverse
  .take(10)
  .foreach(i=>print(i))



