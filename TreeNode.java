class TreeNode {
    Movie movie;
    TreeNode left, right;

    TreeNode(Movie movie) {
        this.movie = movie;
        this.left = null;
        this.right = null;
    }
}

public class MovieBST {
    private TreeNode root;

    public MovieBST() {
        root = null;
    }

    // Insert movie into BST
    public void insert(Movie movie) {
        root = insertRec(root, movie);
    }

    private TreeNode insertRec(TreeNode root, Movie movie) {
        if (root == null) {
            root = new TreeNode(movie);
            return root;
        }
        int cmp = movie.getTitle().compareTo(root.movie.getTitle());
        if (cmp < 0) {
            root.left = insertRec(root.left, movie);
        } else if (cmp > 0) {
            root.right = insertRec(root.right, movie);
        }
        return root;
    }

    // Delete movie from BST
    public void delete(String title) {
        root = deleteRec(root, title);
    }

    private TreeNode deleteRec(TreeNode root, String title) {
        if (root == null) {
            return null;
        }
        int cmp = title.compareTo(root.movie.getTitle());
        if (cmp < 0) {
            root.left = deleteRec(root.left, title);
        } else if (cmp > 0) {
            root.right = deleteRec(root.right, title);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.movie = minValue(root.right);
            root.right = deleteRec(root.right, root.movie.getTitle());
        }
        return root;
    }

    private Movie minValue(TreeNode root) {
        Movie minValue = root.movie;
        while (root.left != null) {
            minValue = root.left.movie;
            root = root.left;
        }
        return minValue;
    }

    // Search movie by title
    public Movie search(String title) {
        return searchRec(root, title);
    }

    private Movie searchRec(TreeNode root, String title) {
        if (root == null) {
            return null;
        }
        int cmp = title.compareTo(root.movie.getTitle());
        if (cmp < 0) {
            return searchRec(root.left, title);
        } else if (cmp > 0) {
            return searchRec(root.right, title);
        } else {
            return root.movie;
        }
    }

    // List all movies
    public void listAll() {
        listAllRec(root);
    }

    private void listAllRec(TreeNode root) {
        if (root != null) {
            listAllRec(root.left);
            System.out.println(root.movie);
            listAllRec(root.right);
        }
    }
          }
