package integrationtests;

public class CommentsPersistenceTest {
	@ClassRule
	public static InMemoryMongoDb inMemoryMongoDb = 
					newInMemoryMongoDbRule().build();
	@Rule
	public MongoDbRule embeddedMongoDbRule = newMongoDbRule().
								defaultEmbeddedMongoDb("test");

	@Test
	@UsingDataSet(locations = "initialData.json")
	@ShouldMatchDataSet(location = "expectedData.json")
	public void shouldInsertComment() {
	}
}