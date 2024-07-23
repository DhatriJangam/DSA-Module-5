import java.util.Scanner;

public class MovieDatabase {
    private MovieBST bst;

    public MovieDatabase() {
        bst = new MovieBST();
    }

    public void addMovie(Movie movie) {
        bst.insert(movie);
    }

    public void deleteMovie(String title) {
        bst.delete(title);
    }

    public void searchMovie(String title) {
        Movie movie = bst.search(title);
        if (movie != null) {
            System.out.println(movie);
        } else {
            System.out.println("Movie not found.");
        }
    }

    public void listAllMovies() {
        bst.listAll();
    }

    public static void main(String[] args) {
        MovieDatabase db = new MovieDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Movie");
            System.out.println("2. Delete Movie");
            System.out.println("3. Search Movie");
            System.out.println("4. List All Movies");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter rating: ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine();  
                    db.addMovie(new Movie(title, director, year, rating));
                    break;
                case 2:
                    System.out.print("Enter title to delete: ");
                    String deleteTitle = scanner.nextLine();
                    db.deleteMovie(deleteTitle);
                    break;
                case 3:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    db.searchMovie(searchTitle);
                    break;
                case 4:
                    db.listAllMovies();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
