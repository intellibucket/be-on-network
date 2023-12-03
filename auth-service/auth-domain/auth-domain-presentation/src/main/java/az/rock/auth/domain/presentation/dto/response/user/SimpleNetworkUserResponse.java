package az.rock.auth.domain.presentation.dto.response.user;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public class SimpleNetworkUserResponse {
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String title;
    private List<String> hashtags;
    private BigInteger mutualConnectionCount;
}
