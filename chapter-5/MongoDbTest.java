@RunWith(Arquillian.class) 
public class MongoDbTest {
	
	@MongoDb
	@ArquillianResource
	NoSqlPopulator populator;

	@Test
	public void should_populate_mongodb() {
		populator.forServer("localhost", 27017)
					.withStorage("test")
					.usingDataSet("books.json")
					.execute();
		
		// Testing part
		
		populator.forServer(hostIp, port).withStorage("test").clean();
	}
}