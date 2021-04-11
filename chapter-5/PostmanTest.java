@RunWith(Arquillian.class)
public class PostmanTest {
	@Postman
	@ArquillianResource
	RestPopulator populator;

	@Test
	public void should_get_messages() {
		populator.forServer("example.com", 8080)
				.usingDataSets("message.json").execute();
		// Testing part
	}
}