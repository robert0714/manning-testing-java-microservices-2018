@RunWith(Arquillian.class)
public class DbUnitTest {

  @DbUnit
  @ArquillianResource
  RdbmsPopulator rdbmsPopulator;

  @Test
  public void should_find_all_persons() {
    rdbmsPopulator.forUri(URI.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"))
        .withDriver(Driver.class)
        .withUsername("sa")
        .withPassword("")
        .usingDataSet("test.json")
        .execute();

    // Testing part

    rdbmsPopulator.forUri(URI.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"))
        .withDriver(Driver.class)
        .withUsername("sa")
        .withPassword("")
        .usingDataSet("test.json")
        .clean();
  }
}

