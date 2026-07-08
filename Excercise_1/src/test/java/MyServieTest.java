import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testExternalApi() {

        ExternalApi api = Mockito.mock(ExternalApi.class);

        when(api.getData()).thenReturn("Mock Data");

        MyService service = new MyService(api);

        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }
}