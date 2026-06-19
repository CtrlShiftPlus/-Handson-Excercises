
class Book
{
    int BookId;
    String BookName;
    String author;

    public Book(int pid,String pname,String cat)
    {
        this.BookId=pid;
        this.BookName=pname;
        this.author=cat;
    }
    public String display()
    {
        return "Book ID:"+BookId+"\nBook Name:"+BookName+"\nauthor:"+author;
    }
}

class Searching{
    public static Book linearSearch(Book[] Books,int key)
    {
        for(Book Book:Books)
        {
            if(Book.BookId==key)
            {
                return Book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] Books,int key)
    {
        int left=0;
        int right=Books.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(Books[mid].BookId==key)
            {
                return Books[mid];
            }
            else if(Books[mid].BookId<key)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return null;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Book[] Books={
            new Book(1,"The Racketeer","John Grisham"),
            new Book(2, "Pelican Brief", "John Grisham"),
            new Book(3,"Dancing Girls", "Margaret Atwood"),
            new Book(4,"Sherlock Holmes","Arthur Conan Doyle"),
            new Book(5,"Pride and Prejudice","Jane Austen")
        };
        Book res=Searching.linearSearch(Books,1);
        if(res==null)
        {
            System.out.println("Book not found");
        }
        else
        {
            System.out.println("Linear Seach Result:"+res.display());
        }
        Book res2=Searching.binarySearch(Books,3);
        if(res==null)
        {
            System.out.println("Book not found");
        }
        else
        {
            System.out.println("Binary Seach Result:"+res2.display());
        }
    }
}



