class App {
  public static void main(String[] args) {





 Book myBook = new Book("https://www.gutenberg.org/cache/epub/84/pg84.txt");
 int myBookwords=myBook.wordCount();
   System.out.println(myBook.translateWord(myBook.bookText()));
   System.out.println("There are "+myBookwords+" words in Frankenstein, or a Modern Prometheus");
 

   Book Sosbook = new Book("https://www.gutenberg.org/cache/epub/11/pg11.txt");
int Sosbookwords=Sosbook.wordCount();
 System.out.println(Sosbook.translateWord(Sosbook.bookText()));
 System.out.println("There are "+Sosbookwords+" words in Alice's adventures in Wonderland");
System.out.println(myBook.translateSentence("I can now speak in Pig-Latin. I can translate words and sentences for the students at Foothill High School."));
  }
}

