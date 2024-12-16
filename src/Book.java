import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.URL;

public class Book
{

  
/*private String bookText;
public Book(String link)
{
readBook(link);
}
private void readBook(String link)
{
try 
{
URL url=new URL(link);
Scanner s=new Scanner (url.openStream());

while (s.hasNext())
{
String text=s.nextLine();
bookText+=translateSentence(text);
}
}
catch(IOException ex)
{
ex.printStackTrace();
}
}
*/






  public int endPunctuation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {

    return word.length()-1;
    //int words=0;
  }
 
  public String pigLatin(String word)
  {
  String vowels="aeiou";
  String first=word.substring(0,1);
  String second;
  if (word.length()==1) 
  {
    second="";
  }
else second=word.substring(1,2);

  if (vowels.indexOf(first)>=0)
  {
     return word + "yay";
  }

  else if(vowels.indexOf(second)>=0)
  {
    return word.substring(1)+first+"ay";
  }
  else 
  {
    return word.substring(2)+first+second+"ay";
  }

  }


public int puncuationalClose(String word)
{

return word.length()-1;
}

  int words=0;

  public String translateWord(String word)    //to share with class
  {
    
    String vowels = "aeiou";
    String second ="";
    String first="";
    String punctuation ="!?.,;:";
String puncuationalClose = "";
boolean quotedTwice = false;
boolean staringquote = false;
boolean endquote=false;
boolean capitals=false;
String convertedWord2="";
if (word==null){
  return "";
}
 
  if(word.length()>=4){
    if(word.substring(word.length()-3).equals("...")){
      puncuationalClose=word.substring(word.length()-4);
      word=word.substring(0,word.length()-4);
    }
    }
  
 



if(word.length()>0){
  if(word.substring(0,1).equals("\"")&& word.substring(word.length()-1).equals("\"")&&word.length()>2){
quotedTwice=true;
word=word.substring(1,word.length()-2);
  }
if(word.substring(0,1).equals("\"")){
staringquote=true;
word=word.substring(0,word.length()-1);
}

if(punctuation.indexOf(word.substring(puncuationalClose(word)))>=0 && word.length()>0)
{
  puncuationalClose=word.substring(word.length()-1);
  word=word.substring(0,word.length()-1);
}
}
if(word.length()>0){
  if(word.substring(0,1).equals(word.substring(0,1).toUpperCase())){
    capitals=true;
  }
}
   if (word!=""){
    words++;
  }

if(capitals==true&&word.length()==1){
  convertedWord2=pigLatin(word);
}
if(capitals==true&&word.length()>1){
  convertedWord2=word.substring(1,2).toUpperCase()+word.substring(2,word.length())+word.substring(0,1).toLowerCase()+"ay";
}
if(capitals==false&&word.length()>0){
  convertedWord2=pigLatin(word);
}
if(quotedTwice)
{
return "\"" + convertedWord2+puncuationalClose+"\"";
}
else if (endquote){
  return convertedWord2 + puncuationalClose;
}
else if(staringquote){
return "\""+convertedWord2+puncuationalClose;

}
else {
  return convertedWord2 + puncuationalClose;
  
} 

}

/* 
  public String translateWord2(String word){
    String punctuation ="!?.,;:";
String puncuationalClose ="";
boolean quotedTwice = false;
boolean capitals=false;
String convertedWord2="";
  
if(punctuation.indexOf(word.substring(puncuationalClose(word)))>=0){
{
puncuationalClose=word.substring(word.length()-1);
word=word.substring(0,word.length()-1);
}
*/
  





  


 public String translateSentence(String sentence){
  {
int i =0;
    String retSentence = "";
while(sentence.indexOf(" ",i)>-1){

   String word=sentence.substring(i, sentence.indexOf(" ",i));
   i= sentence.indexOf(" ",i);
    String result = translateWord(word);
    i++;
    retSentence+=result+" ";
    
}
retSentence += translateWord(sentence.substring(i));

    return retSentence;
  }
  }


private String THEbook;
public Book(String link)
{
  
readBook(link);
}
private void readBook(String link){
boolean read=false;

try 
{
URL url=new URL(link);
Scanner s=new Scanner (url.openStream());

while (s.hasNext())
{
String text=s.nextLine();
if(text.indexOf("*** END")>-1)read=false;
if(read){
text=translateSentence(text);
THEbook+=text;
}
if(text.indexOf("*** START")>-1)read=true;

}
}
catch(IOException ex)
{
ex.printStackTrace();
}
}

 public String bookText(){
    return THEbook;
  }
  public int wordCount(){
    return words;
  }
  public void toTXT(String filename){
try{
String book=this.THEbook;
PrintWriter out=new PrintWriter(filename+".txt");
out.println(book);
out.close();
 }
  catch(FileNotFoundException e){
  System.out.println(e);
  }
}
}
