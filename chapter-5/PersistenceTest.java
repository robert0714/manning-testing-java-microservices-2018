@RunWith(Arquillian.class)
public class PersistenceTest {
    @Test
public void shouldInsertAMovie() {
  Movie insertedMovie = movieRepository.insert(movie);
  assertThat(insertedMovie.getId(), notNullValue());
  //You can add more assertions here
}

@Test
public void shouldFindAllMovies() {
  movieRepository.insert(movie);
  List<Movie>; movies = movieRepository.findAllMovies();
  assertThat(movies, hasSize(1));
}
}
