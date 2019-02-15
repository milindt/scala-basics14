

import data.Data._


books.groupBy(_.author)
.foreach(println)


books.groupBy(_.basePrice)
  .foreach(println)


books.sortBy(b => (b.author, b.basePrice))
.foreach(println)