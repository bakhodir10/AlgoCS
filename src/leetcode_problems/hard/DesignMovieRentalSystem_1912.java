package leetcode_problems.hard;

import java.util.*;

public class DesignMovieRentalSystem_1912 {

    private record ShopMovie(int shop, int movie) {
    }

    private record Movie(int shop, int movie, int price) {
    }

    // Map<{shop, movie}, price>
    private final Map<ShopMovie, Integer> prices;
    // Map<movie, TreeSet<{price, shop, movie}>>
    private final Map<Integer, TreeSet<Movie>> unrented;
    // TreeSet<{price, shop, movie}>
    private final Set<Movie> rented;

    public DesignMovieRentalSystem_1912(int n, int[][] entries) {
        this.prices = new HashMap<>();
        this.unrented = new HashMap<>();
        this.rented = new TreeSet<>((a, b) -> {
            if (a.price != b.price) return a.price - b.price;
            if (a.shop != b.shop) return a.shop - b.shop;
            else return a.movie - b.movie;
        });

        for (int[] entry : entries) {
            int shop = entry[0];
            int movie = entry[1];
            int price = entry[2];

            this.prices.put(new ShopMovie(shop, movie), price);
            this.unrented.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                if (a.price != b.price) return a.price - b.price;
                if (a.shop != b.shop) return a.shop - b.shop;
                else return a.movie - b.movie;
            })).add(new Movie(shop, movie, price));
        }
    }

    // Time complexity: O(1)
    // Memory complexity: O(n)
    public List<Integer> search(int movie) {
        // Get TreeSet<{price, shop, movie}> from Map<movie, TreeSet<{shop, movie, price}>>
        Set<Movie> cheapest5Copies = unrented.get(movie);
        if (cheapest5Copies == null || cheapest5Copies.isEmpty()) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Iterator<Movie> it = cheapest5Copies.iterator();

        while (it.hasNext() && result.size() < 5) result.add(it.next().shop);
        return result;
    }

    // Time complexity: O(logn)
    // Memory complexity: O(n)
    public void rent(int shop, int movie) {
        // Get price from Map<{shop, movie}, price>
        // Add to TreeSet<{shop, movie, price}> => rented movies
        // Delete from Map<movie, TreeSet<{shop, movie, price}>> => unrented
        int price = prices.get(new ShopMovie(shop, movie));
        Movie m = new Movie(shop, movie, price);
        rented.add(m);
        Set<Movie> movies = unrented.get(movie);
        movies.remove(m);
    }

    // Time complexity: O(logn)
    // Memory complexity: O(n)
    public void drop(int shop, int movie) {
        // Get price from Map<{shop, movie}, price> => price table
        // Delete from TreeSet<{shop, movie, price}> => rented movies
        // Add to Map<movie, TreeSet<{shop, movie, price}>>  => availableMovies
        int price = prices.get(new ShopMovie(shop, movie));
        Movie m = new Movie(shop, movie, price);
        rented.remove(m);
        Set<Movie> movies = unrented.get(movie);
        movies.add(m);
    }

    // Time complexity: O(1)
    // Memory complexity: O(n)
    public List<List<Integer>> report() {
        // TreeSet<{shop, movie, price}>
        Iterator<Movie> it = rented.iterator();
        List<List<Integer>> result = new ArrayList<>();
        while (it.hasNext() && result.size() < 5) {
            Movie m = it.next();
            result.add(Arrays.asList(m.shop, m.movie));
        }
        return result;
    }
}
