
import java.util.*;

class Library {

  String bookName;
  String author;

  Library() {
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 83 * hash + Objects.hashCode(this.bookName);
    hash = 83 * hash + Objects.hashCode(this.author);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Library other = (Library) obj;
    if (!Objects.equals(this.bookName, other.bookName)) {
      return false;
    }
    if (!Objects.equals(this.author, other.author)) {
      return false;
    }
    return true;
  }

  Library(String bookName, String author) {
    this.bookName = bookName;
    this.author = author;
  }

  public HashMap<Integer, Library> createLibraryMap(String booksInLibrary) {
    HashMap<Integer, Library> lib = new HashMap<>();
    for (String i : booksInLibrary.split("\\|")) {
      String[] bookInfo = i.split(",");
      Library tmp = new Library(bookInfo[1], bookInfo[2]);
      lib.put(Integer.parseInt(bookInfo[0]), tmp);
    }

    return lib;
  }

  public HashMap<Integer, Integer> createUserMap(String borrowedUsers) {
    HashMap<Integer, Integer> borrowings = new HashMap<>();
    for (String i : borrowedUsers.split("\\|")) {
      int book = Integer.parseInt(i.split(",")[0]);
      int user = Integer.parseInt(i.split(",")[1]);
      borrowings.put(book, user);
    }
    return borrowings;
  }

  public String getQuery(String booksInLibrary, String borrowedUsers, String query) {
    HashMap<Integer, Library> library = createLibraryMap(booksInLibrary);
    HashMap<Integer, Integer> borrowings = createUserMap(borrowedUsers);
    String result = "";
    switch (query.charAt(0)) {
      case '1':
        int bookID = Integer.parseInt(query.split(",")[1]);
        if (borrowings.keySet().contains(bookID)) {
          int user = borrowings.get(bookID);
          return String.format("No Stock\nIt is owned by %s\n", user);
        } else
          return String.format("It is available\nAuthor is %s\n", library.get(bookID).author);
      case '2':
        int userID = Integer.parseInt(query.split(",")[1]);
        for (int key : borrowings.keySet()) {
          if (borrowings.get(key) == userID) {
            Library tmp = library.get(key);
            result += String.format("%d %s\n", key, tmp.bookName);
          }
        }
        return result;

      case '3':
        String bname = query.split(",")[1];
        int in = 0, out = 0;
        for (int key : library.keySet()) {
          if (library.get(key).bookName.equals(bname)) {
            if (borrowings.keySet().contains(key))
              out++;
            else
              in++;
          }
        }
        return String.format("%d out\n%d in\n", out, in);

      case '4':
        String author = query.split(",")[1];
        for (int bId : library.keySet()) {
          if (library.get(bId).author.equals(author)) {
            result += String.format("%s\n", library.get(bId).bookName);
          }
        }
        return result;

      case '5':
        String key = query.split(",")[1];
        for (int bId : library.keySet()) {
          Library tmp = library.get(bId);
          if (tmp.bookName.toLowerCase().contains(key.toLowerCase())) {
            result += String.format("%d %s\n", bId, tmp.bookName);
          }
        }
        return result;

      default:
        return null;
    }

  }

}

public class hashMap {
  public static void main(String[] args) {
    Library lib = new Library();
    String booksInLibrary = "125,C programming,Brian W. Kernighan|546,Java programming,James Gosling|897,Data Structure,Adam Drozdek|265,Data Structure,Adam Drozdek|234,The Java Language Specification,James Gosling";
    String borrowedUsers = "125,101|564,102|546,103|897,104|785,101";
    String query1 = "1,546", query2 = "2,546", query3 = "3,Data Structure", query4 = "4,James Gosling",
        query5 = "5,java";
    System.out.println(lib.getQuery(booksInLibrary, borrowedUsers, query1));
    System.out.println(lib.getQuery(booksInLibrary, borrowedUsers, query2));
    System.out.println(lib.getQuery(booksInLibrary, borrowedUsers, query3));
    System.out.println(lib.getQuery(booksInLibrary, borrowedUsers, query4));
    System.out.println(lib.getQuery(booksInLibrary, borrowedUsers, query5));
  }
}
